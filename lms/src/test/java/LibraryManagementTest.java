
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.org.lms.model.Book;
import com.org.lms.model.Inventory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class LibraryManagementTest {

    @Test
    public void givenBook_whenNotInInventory_thenAddToInventory() {
        Book book = new Book("Clean Code","Robert C. Martin",5);
        Inventory inventory = Inventory.getInventory();
        inventory.add(book);
        Optional<Book> foundBook = inventory.search(new Book("Clean Code","Robert C. Martin",1));
        Assertions.assertThat(foundBook.get().getTotalQuantity()).isEqualTo(5);
    }
}
