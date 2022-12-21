import main.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class RoleTest {
Role testrole;

@Before
    public void setUp() throws Exception{
    testrole = new Role("administrator", 1, "change product details");
}

    @Test
    public void testGetName() {Assert.assertEquals("administrator", testrole.getName()); }

    @Test
    public void testGetAuthorities(){
        Assert.assertEquals( 1,testrole.getAuthorities());
    }
    @Test
    public void testGetDescription(){
        Assert.assertEquals("change product details",testrole.getDescription());
    }
    @Test
    public void testSetName(){
        testrole.setName("administrator");
        Assert.assertEquals("administrator", testrole.getName());
    }
    @Test
    public void setAuthorities(){
    testrole.setAuthorities(1);
    Assert.assertEquals(1,testrole.getAuthorities());
    }
    @Test
    public void testSetDescription(){
        testrole.setDescription("change product details");
        Assert.assertEquals("change product details",testrole.getDescription());
    }

}
