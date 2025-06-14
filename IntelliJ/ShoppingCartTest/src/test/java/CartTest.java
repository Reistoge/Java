import Books.Book;
import org.junit.Test;
import service.ShoppingCart;

import static org.junit.Assert.assertEquals;

public class CartTest {




    @Test
    public void testAddGetTotal(){
        Book b1 = new Book("book1", 10,"1");
        Book b2 = new Book("book2", 20,"2");
        ShoppingCart cart = new ShoppingCart();
        cart.add(b1);
        cart.add(b2);
        assertEquals(20, cart.getTotal());



    }

}
