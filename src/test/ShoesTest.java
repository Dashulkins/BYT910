mport org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class ShoesTest {
    Shoes testshoes;
@Before
    public void setUp() throws ShoeSizeException{
    testshoes = new Shoes("Shoe1",1,22.40,false,36);
}
@Test
    public void testGetShoeName(){
    Assert.assertEquals("Shoe1",testshoes.getName());
}
@Test
    public void testGetShoeId(){
    Assert.assertEquals(1,testshoes.getId());
}
@Test
    public void testGetShoePrice(){
    Assert.assertEquals(22.40,testshoes.getPrice(),0.02);
}
@Test
    public void testGetCustom(){
    Assert.assertEquals(false,testshoes.getCustom());
}
@Test
    public void testGetSize(){
    Assert.assertEquals(36,testshoes.getSize());
}
@Test
    public void testSetShoeName(){
    testshoes.setName("Shoe2");
    Assert.assertEquals("Shoe2",testshoes.getName());
}
@Test
    public void  testSetShoeId(){
    testshoes.setId(2);
    Assert.assertEquals(2,testshoes.getId());
}
@Test
    public void testSetShoePrice(){
        testshoes.setPrice(29.99);
        Assert.assertEquals(29.99,testshoes.getPrice(),0.02);
    }
@Test
    public void testSetShoeCustom(){
    testshoes.setCustom(true);
    Assert.assertTrue(testshoes.getCustom());
}
@Test
    public void testSetShoeSize() throws ShoeSizeException {
    boolean toosmall = false;
    boolean toobig = false;
    try {
        testshoes.setSize(32);
    } catch (ShoeSizeException ignored){
        toosmall = true;
    }
    Assert.assertTrue(toosmall);
    try {
        testshoes.setSize(49);
    } catch (ShoeSizeException ignored){
        toobig = true;
    }
    Assert.assertTrue(toobig);
    testshoes.setSize(38);
    Assert.assertEquals(38,testshoes.getSize());
}
@Test
    public void testChangeProductDetails()throws ShoeSizeException{
    testshoes.changeProductDetails("Shoe3",testshoes.getId(),23.50,testshoes.getCustom(),39);
    Assert.assertEquals("Shoe3",testshoes.getName());
    Assert.assertEquals(1,testshoes.getId());
    Assert.assertEquals(23.50,testshoes.getPrice(),0.02);
    Assert.assertEquals(false,testshoes.getCustom());
    Assert.assertEquals(39,testshoes.getSize());
}
@Test
    public void testListAllBestSellers(){
    Assert.assertTrue(testshoes.listAllBestSellers());
}
}
