
enum ActivityType {
    BREAKFAST,
    LUNCH,
    DINNER,
    MUSEUM,
    CRUISE
}
public class Activity{

    private String name;
    private double duration;
    private ActivityType activityType;
    private double cost;

    /**
     * Initiates Activity object
     * User must be able to specify at least the name, duration, type, and cost of an activity
     * @param name          Activity name
     * @param duration      Duration of the activity in hours
     * @param activityType  ActivityType
     * @param cost          Cost in dollars
     */
    public Activity(String name, double duration, ActivityType activityType, double cost) {

        this.name = name;
        this.duration = duration;
        this.activityType = activityType;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
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
}