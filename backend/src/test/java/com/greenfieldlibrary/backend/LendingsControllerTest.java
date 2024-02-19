package com.greenfieldlibrary.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.greenfieldlibrary.backend.controllers.LendingsController;
import com.greenfieldlibrary.backend.controllers.LendingsResponse;
import com.greenfieldlibrary.backend.persistence.Lendings;
import com.greenfieldlibrary.backend.persistence.LendingsRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LendingsControllerTest {

    @Mock
    private LendingsRepository lendingRepository;

    @InjectMocks
    private LendingsController lendingsController;

    @BeforeEach
    public void setUp() {
        Lendings expectedLending = new Lendings(1, 1, "2024-02-18", "2024-02-25", "Test Status");
        when(LendingsRepository.findById(1)).thenReturn(Optional.of(expectedLending));
    }

    @Test
    public void testCreateLendingReturnsCreatedStatus() {

        Lendings newLending = new Lendings(1, 1, "2024-02-19", "2024-03-02", "Lending");

        when(LendingsRepository.save(newLending)).thenReturn(newLending);

        ResponseEntity<LendingsResponse> response = lendingsController.createLending(newLending);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newLending.getId(), response.getBody().getId());
        assertEquals(newLending.getMember(), response.getBody().getMember());
        assertEquals(newLending.getBook(), response.getBody().getBook());
        assertEquals(newLending.getDataLending(), response.getBody().getDataLending());
        assertEquals(newLending.getDataReturn(), response.getBody().getDataReturn());
        assertEquals(newLending.getStatus(), response.getBody().getStatus());
    }

    @Test
    public void testDeleteLendingReturnsNoContent() {
        int lendingIdToDelete = 1;

        when(lendingsRepository.existsById(lendingIdToDelete)).thenReturn(true);

        ResponseEntity<Void> response = lendingsController.deleteLending(lendingIdToDelete);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}