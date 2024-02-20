package lendings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import com.greenfieldlibrary.backend.controllers.LendingController;
import com.greenfieldlibrary.backend.controllers.LendingsRequest;
import com.greenfieldlibrary.backend.controllers.LendingsResponse;
import com.greenfieldlibrary.backend.persistence.Books;
import com.greenfieldlibrary.backend.persistence.Lendings;
import com.greenfieldlibrary.backend.persistence.LendingsRepository;
import com.greenfieldlibrary.backend.persistence.Members;

public class LendingsIntegrationTest {

    @SpringBootTest
    public class LendingsControllerTest {

        @Mock
        private LendingsRepository lendingRepostitory;

        @InjectMocks
        private LendingController lendingsController;

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testCreateLending() {
            Books newBook = new Books();
            newBook.setIdBooks(1);
            Members newMember = new Members();
            newMember.setIdMember(1);
            Lendings newLending = new Lendings(1, newBook, newMember, "2024-02-18", "2024-02-24");

            when(this.lendingRepository.save(newLending)).thenReturn(newLending);

            ResponseEntity<LendingsResponse> response = lendingsController.createLending(newLending);

            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            assertEquals(newLending.getId(), response.getBody().getId());
            assertEquals(newLending.getMember(), response.getBody().getIdMember());
            assertEquals(newLending.getBook(), response.getBody().getIdBook());
            assertEquals(newLending.getDataLending(), response.getBody().getDataLending());
            assertEquals(newLending.getDataReturn(), response.getBody().getDataReturn());
            assertEquals(newLending.getStatus(), response.getBody().getStatus());
        }

        @Test
        public void testDeleteLendingReturnsNoContent() {
            int lendingIdToDelete = 1;

            when(lendingRepostitory.existsById(lendingIdToDelete)).thenReturn(true);

            ResponseEntity<Void> response = lendingsController.deleteLending(lendingIdToDelete);

            assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        }
    }
}
