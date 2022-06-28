import org.junit.Test;

import static org.junit.Assert.*;

public class TripTest {

    // Scenario 1: Create a trip
    @Test
    public void testCreateTrip(){
        Trip t = new Trip("Paris2022", "2022/12/1", "2022/12/12", 1500);
        assertEquals("Paris2022", t.getName());
        assertEquals("2022/12/1", t.getStartDate());
        assertEquals("2022/12/12", t.getEndDate());
        assertEquals(1500, t.getBudget(), 0.05); //accurate within 5 cents
    }

    /* Scenario 2: Add a traveller to the trip
       Scenario 3: Add over 15 travelers to a trip (fail)
     */
    @Test
    public void testAddTraveller() {
        Trip t = new Trip("Paris2022", "2022/12/1", "2022/12/12", 1500);
        assertEquals(5, t.getNumTravellers());

        t.addTravellers(1);
        assertEquals(6, t.getNumTravellers());

        //attempt to have more than 15 travellers, confirm that function returns false and number doesn't change
        boolean success = t.addTravellers(10);
        assertFalse(success);
        assertEquals(6, t.getNumTravellers());
    }



//    Create a traveler and add it to the trip
//    Create an activity and add to the trip
//    Add a traveler to an activity
//    Try to add an activity that exceeds the trip budget (fail)
//    Add over 15 travelers to a trip (fail)
//    Print the schedule to a txt file


}
