package br.com.erudio.controller;

import br.com.erudio.model.Book;
import br.com.erudio.proxy.CambioProxy;
import br.com.erudio.repository.BookRepository;
import br.com.erudio.response.Cambio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

@Tag(name = "Book Service Endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @Autowired
    private CambioProxy proxy;

    @Operation(summary = "Find a specific Book")
    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {

        var optionalBook = repository.findById(id);
        if (!optionalBook.isPresent()) {
            throw new RuntimeException("Book Not Found");
        }
        var book = optionalBook.get();
        var cambio = proxy.getCambio(book.getPrice(), "USD", currency);
        var port = environment.getProperty("local.server.port");

        book.setEnvironment(
                "Book port: " + port +
                        " Cambio port: " + cambio.getEnvironment());
        book.setCurrency(currency);
        book.setPrice(cambio.getConvertedValue());
        return book;
    }

    /**
    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {

        var optionalBook = repository.findById(id);
        if (!optionalBook.isPresent()) {
            throw new RuntimeException("Book Not Found");
        }
        var book = optionalBook.get();

        HashMap<String, String> params = new HashMap<>();
        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);

        var response = new RestTemplate().
                getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}",
                        Cambio.class,
                        params);

        var cambio = response.getBody();

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(port);
        book.setCurrency(currency);
        book.setPrice(cambio.getConvertedValue());
        return book;
    } */

}
