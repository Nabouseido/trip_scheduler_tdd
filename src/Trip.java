import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.ListIterator;

public class Trip{

    final int MAX_TRAVELLERS = 15;
    final int MIN_TRAVELLERS = 5;

    private String name;
    private String startDate;
    private String endDate;
    private double budget;
    private ArrayList<Activity> activities = new ArrayList<Activity>();
    private HashSet<Traveller> travellers = new HashSet<Traveller>();

    private double totalCost = 0;

    /**
     * Initiates trip object
     * By default trip is created with minimum number of travellers
     * User can specify name, date range, and budget of a trip
     *
     * @param name      Name of the trip
     * @param startDate Start date of the trip
     * @param endDate   End date of the trip
     * @param budget    Trip budget in dollars
     */
    public Trip(String name, String startDate, String endDate, double budget) {

        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
         this.name = name;
    }

    public int getNumTravellers(){
        return travellers.size();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public boolean addActivity(Activity activity){
        //check whether adding this activity fits within the budget
        //assume all travellers on the trip are going to take part in this activity
        if (budget >= this.totalCost + (this.getNumTravellers() * activity.getCost())) {
            this.totalCost += (this.getNumTravellers() * activity.getCost());
            return this.activities.add(activity);
        }
        else{
            return false;
        }
    }

    public boolean addTraveller(Traveller traveller) {
        if(travellers.size() < MAX_TRAVELLERS){
            travellers.add(traveller);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", budget=" + budget +
                ", activities=" + activities +
                ", travellers=" + travellers +
                ", totalCost=" + totalCost +
                '}';
    }

    public String getFormattedItinerary() {
        return "Trip Itinerary:  " + name +
                "\n Start Date: '" + startDate +
                "\n End Date: '" + endDate +
                "\n Budget: $" + String.format("%.2f", budget) +
                "\n Activities: \n" + activities +
                "\n Travellers: \n" + travellers +
                "\n Total Cost $" + String.format("%.2f", totalCost);
    }



    public boolean generateTripSchedule(){

        if((this.getNumTravellers() > MAX_TRAVELLERS) ||
                (this.getNumTravellers() < MIN_TRAVELLERS)){
            System.out.println("Could not generate itinerary - invalid number of travellers");
            return false;
        }

        ArrayList<Activity> validActivities = new ArrayList<Activity>();
        boolean includesBreakfast = false;
        boolean includesDinner = false;

        for (Activity a : activities) {
            if (a.getStartTime().isAfter(LocalTime.of(8,59))
                && a.getEndTime().isBefore(LocalTime.of(22,1))) {

                validActivities.add(a);
                if (a.getActivityType() == ActivityType.BREAKFAST){
                    includesBreakfast = true;
                }
                else if ( a.getActivityType() == ActivityType.DINNER){
                    includesDinner = true;
                }
            }
        }

        if ((validActivities.size() < 3) || !includesBreakfast || !includesDinner){
            System.out.println("Could not create valid schedule - Insufficient valid activities");
            return false;
        }

        //sort valid activities
        Collections.sort(validActivities);

        //Add the earliest activity to schedule, if the start time of the next one is >= end time of the first, add it to the schedule
        //else exclude it and check next activity.
        ArrayList<Activity> schedule = new ArrayList<Activity>();
        schedule.add(validActivities.get(0));

        for( int i=1; i<validActivities.size(); i++){
            if(validActivities.get(i).getStartTime().isAfter(validActivities.get(i-1).getEndTime())){
                schedule.add(validActivities.get(i));
            }
        }

        //update activities list to the newly created schedule
        activities = schedule;

        // Creating an instance of file
        File file = new File("trip_itinerary.txt");

        try {
            Files.write(Paths.get("trip_itinerary.txt"), this.getFormattedItinerary().getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }


}