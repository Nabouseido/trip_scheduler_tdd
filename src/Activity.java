import java.time.LocalTime;

enum ActivityType {
    BREAKFAST,
    LUNCH,
    DINNER,
    MUSEUM,
    TOUR,
    OTHER
}
public class Activity implements Comparable<Activity>{

    private String name;
    private LocalTime startTime; //use 24hr clock, valid values 0 - 23
    private LocalTime endTime;
    private ActivityType activityType;
    private double cost;

    /**
     * Initiates Activity object
     * User must be able to specify at least the name, duration, type, and cost of an activity
     * @param name          Activity name
     * @param startTime     Start time hh:mm:ss
     * @param endTime       End time  hh:mm:ss
     * @param activityType  ActivityType
     * @param cost          Cost in dollars
     */
    public Activity(String name, LocalTime startTime, LocalTime endTime, ActivityType activityType, double cost) {

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityType = activityType;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "\n Activity Name: " + name + '\'' +
                "\n  Start Time: " + startTime +
                "\n  End Time: " + endTime +
                "\n  Activity Type: " + activityType +
                "\n  Cost: $" + String.format("%.2f", cost);
    }

    @Override
    public int compareTo(Activity o) {
        int compareValue = startTime.compareTo(o.startTime);
        if (compareValue == 0) {
            return endTime.compareTo(o.endTime);
        }
        return compareValue;
    }

//    @Override
//    public int compareTo(Activity o) {
//        int compareValue = startTime.compareTo(o.startTime);
//        if( compareValue == 0){
//            return Double.compare(this.endTime, o.endTime);
//        }
//        return compareValue;
//    }

}