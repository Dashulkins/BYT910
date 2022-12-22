import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomizationTest {
    Customization testcustom;

    @Before
    public void setUp() throws Exception {
        testcustom = new Customization("high top blue sneakers", true, "sneakers");
    }

    @Test
    public void testGetDesc() {
        Assert.assertEquals("high top blue sneakers", testcustom.getDescription());
    }

    @Test
    public void testGetImg() {
        Assert.assertTrue(testcustom.getImg());
    }

    @Test
    public void testGetType() {
        Assert.assertEquals("sneakers", testcustom.getCustomType());
    }

    @Test
    public void testSetDesc() {
        testcustom.setDescription("high platform green loafers");
        Assert.assertEquals("high platform green loafers", testcustom.getDescription());
    }

    @Test
    public void testSetImg() {
        testcustom.setImg(false);
        Assert.assertFalse(testcustom.getImg());
    }

    @Test
    public void testSetType() {
        testcustom.setCustomType("loafers");
        Assert.assertEquals("loafers", testcustom.getCustomType());
    }

    @Test
    public void testCreateCustomShoes() {
        Assert.assertTrue(testcustom.CreateCustomShoes());
    }
}
