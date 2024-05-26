import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private List<Item> create(Item... items) {
        return new ArrayList<Item>(Arrays.asList(items));
    }

    @Test
    void checkEveryBranch() {
        RuntimeException ex;
        ex=assertThrows(RuntimeException.class, ()-> SILab2.checkCart(null,0));

        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        assertTrue(SILab2.checkCart(new ArrayList<Item>(), 0));

        assertFalse(SILab2.checkCart(new ArrayList<Item>(), -100));

        ex=assertThrows(RuntimeException.class, ()-> SILab2.checkCart(create(new Item("",null,200,0.1f)),0));
        assertTrue(ex.getMessage().contains("No barcode!"));

        assertFalse(SILab2.checkCart(create(new Item(null,"0123456789",350,0.25f)),0));

        ex=assertThrows(RuntimeException.class, ()-> SILab2.checkCart(create(new Item("banana","0greska",350,0.1f)),0));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        assertFalse(SILab2.checkCart(create(new Item("banana","01234",200,-0.1f)),0));

    }

    @Test
    void checkMultipleCondition() {
        assertTrue(SILab2.checkCart(create(new Item("banana","0123456789",350,0.25f)),15000));

        assertFalse(SILab2.checkCart(create(new Item("apple","123456",350,0.1f)),10));

        assertFalse(SILab2.checkCart(create(new Item("banana","0756433",350,-1f)),10));

        assertFalse(SILab2.checkCart(create(new Item("strawberry","143252",200,0.1f)),10));

    }
}