import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ShoesTest {
    Shoes testshoes;

    @Before
    public void setUp() throws ShoeSizeException {
        testshoes = new Shoes("Shoe1", 1, 22.40, false, Shoes.Size.Size_36, "link");
    }

    @Test
    public void testGetShoeName() {
        Assert.assertEquals("Shoe1", testshoes.getName());
    }

    @Test
    public void testGetShoeId() {
        Assert.assertEquals(1, testshoes.getId());
    }

    @Test
    public void testGetShoePrice() {
        Assert.assertEquals(22.40, testshoes.getPrice(), 0.02);
    }

    @Test
    public void testGetCustom() {
        Assert.assertFalse(testshoes.getCustom());
    }

    @Test
    public void testGetSize() {
        Assert.assertEquals(Shoes.Size.Size_36, testshoes.getSize());
    }

    @Test
    public void testGetImg() {
        Assert.assertEquals("link", testshoes.getImg());
    }

    @Test
    public void testSetImg() {
        testshoes.setImg("aaaaaa");
        Assert.assertEquals("aaaaaa", testshoes.getImg());
    }


    @Test
    public void testSetShoeName() {
        testshoes.setName("Shoe2");
        Assert.assertEquals("Shoe2", testshoes.getName());
    }

    @Test
    public void testSetShoeId() {
        testshoes.setId(2);
        Assert.assertEquals(2, testshoes.getId());
    }

    @Test
    public void testSetShoePrice() {
        testshoes.setPrice(29.99);
        Assert.assertEquals(29.99, testshoes.getPrice(), 0.02);
    }

    @Test
    public void testSetShoeCustom() {
        testshoes.setCustom(true);
        Assert.assertTrue(testshoes.getCustom());
    }

    @Test
    public void testSetShoeSize() throws ShoeSizeException {
        testshoes.setSize(Shoes.Size.Size_37);
        Assert.assertEquals(Shoes.Size.Size_37, testshoes.getSize());
    }

    @Test
    public void testChangeProductDetails() throws ShoeSizeException {
        testshoes.changeProductDetails("Shoe3", testshoes.getId(), 23.50, testshoes.getCustom(), Shoes.Size.Size_39);
        Assert.assertEquals("Shoe3", testshoes.getName());
        Assert.assertEquals(1, testshoes.getId());
        Assert.assertEquals(23.50, testshoes.getPrice(), 0.02);
        Assert.assertFalse(testshoes.getCustom());
        Assert.assertEquals(Shoes.Size.Size_39, testshoes.getSize());
    }

    @Test
    public void testListAllBestSellers() {
        Assert.assertTrue(testshoes.listAllBestSellers());
    }
}
