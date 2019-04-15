package test.java;

import main.java.Actor;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;


public class ActorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createActorWithNullFirstName() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("First Name shouldn't be empty.");
        Actor actor = new Actor(null,"LastName1", "Country1");
    }

    @Test
    public void createActorWithEmptyFirstName() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("First Name shouldn't be empty.");
        Actor actor = new Actor("","LastName1", "Country1");
    }

    @Test
    public void createActorWithNullLastName() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Last Name shouldn't be empty.");
        Actor actor = new Actor("FirstName1",null, "Country1");
    }

    @Test
    public void createActorWithEmptyLastName() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Last Name shouldn't be empty.");
        Actor actor = new Actor("FirstName1","", "Country1");
    }

    @Test
    public void createActorWithNullCountry() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Country shouldn't be null.");
        Actor actor = new Actor("FirstName1","LastName1", null);
    }

    @Test
    public void createActorWithValidValues() {
        Actor actor = new Actor("FirstName1","LastName1", "Country1");
        assertEquals("Incorrect FirstName: ","FirstName1",actor.getFirstName());
        assertEquals("Incorrect LastName: ","LastName1",actor.getLastName());
        assertEquals("Incorrect Country: ","Country1",actor.getCountry());
    }

    @Test
    public void updateActorWithValidFirstName() {
        Actor actor = new Actor("FirstName1","LastName1", "Country1");
        assertEquals("Incorrect FirstName: ","FirstName1",actor.getFirstName());
        assertEquals("Incorrect LastName: ","LastName1",actor.getLastName());
        assertEquals("Incorrect Country: ","Country1",actor.getCountry());
        actor.setFirstName(actor.getFirstName() + "-new");
        assertEquals("Incorrect FirstName: ","FirstName1-new",actor.getFirstName());
        assertEquals("Incorrect LastName: ","LastName1",actor.getLastName());
        assertEquals("Incorrect Country: ","Country1",actor.getCountry());
    }

    @Test
    public void updateActorWithValidLastName() {
        Actor actor = new Actor("FirstName1","LastName1", "Country1");
        assertEquals("Incorrect FirstName: ","FirstName1",actor.getFirstName());
        assertEquals("Incorrect LastName: ","LastName1",actor.getLastName());
        assertEquals("Incorrect Country: ","Country1",actor.getCountry());
        actor.setLastName(actor.getLastName() + "-new");
        assertEquals("Incorrect FirstName: ","FirstName1",actor.getFirstName());
        assertEquals("Incorrect LastName: ","LastName1-new",actor.getLastName());
        assertEquals("Incorrect Country: ","Country1",actor.getCountry());
    }

    @Test
    public void updateActorWithValidCountry() {
        Actor actor = new Actor("FirstName1","LastName1", "Country1");
        assertEquals("Incorrect FirstName: ","FirstName1",actor.getFirstName());
        assertEquals("Incorrect LastName: ","LastName1",actor.getLastName());
        assertEquals("Incorrect Country: ","Country1",actor.getCountry());
        actor.setCountry(actor.getCountry() + "-new");
        assertEquals("Incorrect FirstName: ","FirstName1",actor.getFirstName());
        assertEquals("Incorrect LastName: ","LastName1",actor.getLastName());
        assertEquals("Incorrect Country: ","Country1-new",actor.getCountry());
    }

    @Test
    public void checkToStringMethod() {
        Actor actor = new Actor("FirstName1", "LastName1", "Country1");
        String result = "FirstName1 LastName1 (Country1)";
        assertEquals("Incorrect Actor: ", result, actor.toString());
    }

    @Test
    public void checkEqualsMethodForTrueCase() {
        Actor actor = new Actor("FirstName1", "LastName1", "Country1");
        Actor actor1 = new Actor("FirstName1", "LastName1", "Country1");
        assertTrue(actor.equals(actor1));
    }

    @Test
    public void checkEqualsMethodForDifferentFirstName() {
        Actor actor = new Actor("FirstName1", "LastName1", "Country1");
        Actor actor1 = new Actor("FirstName2", "LastName1", "Country1");
        assertFalse(actor.equals(actor1));
    }

    @Test
    public void checkEqualsMethodForDifferentLastName() {
        Actor actor = new Actor("FirstName1", "LastName1", "Country1");
        Actor actor1 = new Actor("FirstName1", "LastName2", "Country1");
        assertFalse(actor.equals(actor1));
    }

    @Test
    public void checkEqualsMethodForDifferentCountry() {
        Actor actor = new Actor("FirstName1", "LastName1", "Country1");
        Actor actor1 = new Actor("FirstName1", "LastName1", "Country2");
        assertFalse(actor.equals(actor1));
    }

}
