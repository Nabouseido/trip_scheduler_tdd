import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class TripTest {

    private Trip trip;

    @Before
    public void beforeFunction(){
        trip = new Trip("London2022", "2022/12/1", "2022/12/12", 1500);

        //add 5 travellers (minimum number for a valid trip)
        for (int i = 1; i<=5; i++){
            Traveller person = new Traveller(i, "Person"+i);
            trip.addTraveller(person);
        }

    }
    // Scenario 1: Create a trip
    @Test
    public void testCreateTrip(){
        assertEquals("London2022", trip.getName());
        assertEquals("2022/12/1", trip.getStartDate());
        assertEquals("2022/12/12", trip.getEndDate());
        assertEquals(1500, trip.getBudget(), 0.05); //accurate within 5 cents
    }

    /* Scenario 2: Create a traveller and add it to the trip
     */
    @Test
    public void testCreateTraveller() {
        Traveller john = new Traveller(123,"John Smith");

        boolean result = trip.addTraveller(john);
        assertEquals(6, trip.getNumTravellers());
        assertTrue(result);
    }

    /* Scenario 3: Create more than 15 travellers and attempt to add to the trip
     */
    @Test
    public void testAddTooManyTravellers() {
        //populate trip with an additional 10 travellers ( trip already has 5 by default)
        for (int i = 6; i<=15; i++){
            Traveller person = new Traveller(i, "Person"+i);
            trip.addTraveller(person);
        }
        assertEquals(15, trip.getNumTravellers());

        //attempt to add 16th traveller
        Traveller person = new Traveller(16, "Person16");
        boolean result = trip.addTraveller(person);

        assertEquals(15, trip.getNumTravellers());
        assertFalse(result);
    }

    /* Scenario 5: Create an activity and add to the trip
     */
    @Test
    public void testAddActivity() {
        //Test case 1: add an activity within the trip budget
        Activity a1 = new Activity("Hotel breakfast",LocalTime.of(9,0),LocalTime.of(10,0), ActivityType.BREAKFAST, 15);

        assertTrue(trip.addActivity(a1));
    }


    /*
    Scenario 6: Try to add an activity that exceeds the trip budget (fail)
     */
    @Test
    public void testAddActivityOverBudget() {
        Activity a = new Activity("Helicopter ride", LocalTime.of(13,0),LocalTime.of(15,0),  ActivityType.OTHER,500 );

        assertEquals(5, trip.getNumTravellers());
        assertEquals(1500, trip.getBudget(), 0.05);
        //note: implementation assumes activity added to trip applies to all travellers, activity cost is multiplied by number of travellers
        assertFalse(trip.addActivity(a));
    }

    /*
    Scenario 7: Print the schedule to a text file
     */
    @Test
    public void testPrintTripSchedule(){
        Activity a1 = new Activity("Breakfast", LocalTime.of(9,0),LocalTime.of(10,0), ActivityType.BREAKFAST,5);
        Activity a2 = new Activity("Dinner", LocalTime.of(20,30),LocalTime.of(22,0),  ActivityType.DINNER,15);
        Activity a3 = new Activity("Lunch", LocalTime.of(13,0),LocalTime.of(15,0), ActivityType.LUNCH,10 );
        Activity a4 = new Activity("Art Gallery",LocalTime.of(11,15),LocalTime.of(10,0), ActivityType.MUSEUM, 12);

        trip.addActivity(a1);
        trip.addActivity(a2);
        trip.addActivity(a3);
        trip.addActivity(a4);

        boolean result = trip.generateTripSchedule();
        assertTrue(result);

        //read in the generated file and confirm that it matches expected result file
        String expectedResult = "Expected";
        String actualResult = "Actual";

        try{
            expectedResult = Files.readString(Path.of("trip_itinerary_expected_output.txt"));
            actualResult = Files.readString(Path.of("trip_itinerary.txt"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expectedResult, actualResult);
    }








}
