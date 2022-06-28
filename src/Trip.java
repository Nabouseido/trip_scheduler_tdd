
public class Trip{

    final int MAX_TRAVELLERS = 15;
    final int MIN_TRAVELLERS = 5;

    private String name;
    private String startDate;
    private String endDate;
    private double budget;

    private int numTravellers = MIN_TRAVELLERS;

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
        return this.numTravellers;
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

    public boolean addTravellers(int additionalTravellers){
        if ( this.numTravellers + additionalTravellers <= MAX_TRAVELLERS){
            this.numTravellers += additionalTravellers;
            return true;
        }
        return false;
    }




}