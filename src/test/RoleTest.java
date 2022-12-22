import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoleTest {
    Role testRole;

    @Before
    public void setUp() {
        testRole = new Role("administrator", 1, "change product details");
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("administrator", testRole.getName());
    }

    @Test
    public void testGetAuthorities() {
        Assert.assertEquals(1, testRole.getAuthorities());
    }

    @Test
    public void testGetDescription() {
        Assert.assertEquals("change product details", testRole.getDescription());
    }

    @Test
    public void testSetName() {
        testRole.setName("administrator");
        Assert.assertEquals("administrator", testRole.getName());
    }

    @Test
    public void setAuthorities() {
        testRole.setAuthorities(2);
        Assert.assertEquals(2, testRole.getAuthorities());
    }

    @Test
    public void testSetDescription() {
        testRole.setDescription("another description");
        Assert.assertEquals("another description", testRole.getDescription());
    }

}
