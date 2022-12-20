import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class CustomShoesTest {
    CustomShoes testcustom;
    @Before
    public void setUp() throws Exception{
        testcustom = new CustomShoes("high top blue sneakers",true,"sneakers");
    }
    @Test
    public void testGetDesc(){
        Assert.assertEquals("high top blue sneakers",testcustom.getDescription());
    }
    @Test
    public void testGetImg(){
        Assert.assertEquals(true,testcustom.getImg());
    }
    @Test
    public void testGetType(){
        Assert.assertEquals("sneakers",testcustom.getCustom_type());
    }
    @Test
    public void testSetDesc(){
        testcustom.setDescription("high platform green loafers");
        Assert.assertEquals("high platform green loafers",testcustom.getDescription());
    }
    @Test
    public void testSetImg(){
        testcustom.setImg(false);
        Assert.assertEquals(false,testcustom.getImg());
    }
    @Test
    public void testSetType(){
        testcustom.setCustom_type("loafers");
        Assert.assertEquals("loafers",testcustom.getCustom_type());
    }
    @Test
    public void testCreateCustomShoes(){
        Assert.assertTrue(testcustom.CreateCustomShoes());
    }
}
