package com.greenfieldlibrary.backend.books;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BooksIntegrationTests {

    @Autowired
    private MockMvc api;

    @Test
    public void obtengo_la_lista_de_libros() {
        // api.perform(get("/api/books?query="Harry Potter"))
        // .andExpect(...);
    }
}
