
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.greenfieldlibrary.backend.controllers.BooksController;
import com.greenfieldlibrary.backend.persistence.Books;
import com.greenfieldlibrary.backend.persistence.BooksRepository;

@SpringBootTest
public class BooksControllerTest {

    @Mock
    private BooksRepository bookRepository;

    @InjectMocks
    private BooksController booksController;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testGetBookById() {

        when(bookRepository.findById(1))
                .thenReturn(Optional.of(new Book(1, "Test Title", "Test Author", "Test Isbn", "Test Status")));

        ResponseEntity<Books> response = booksController.getBookById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getIdBooks());
        assertEquals("Test Title", response.getBody().getTitle());
        assertEquals("Test Author", response.getBody().getAuthor());
        assertEquals("Test Isbn", response.getBody().getIsbn());
        assertEquals("Test Status", response.getBody().getStatus());
    }
}
