package brankosaponjic.springbootmongodb.restcontroller;

import brankosaponjic.springbootmongodb.entity.Book;
import brankosaponjic.springbootmongodb.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Collection<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(value = "/{id}")
    public Optional<Book> getBookById(@PathVariable("id") int id) { return bookService.getBookById(id); }

    @PostMapping("/addNewBook")
    public Book postBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PostMapping("/addCollection")
    public Collection<Book> postCollectionOfBooks(@RequestBody Collection<Book> bookCollection) {
        return bookService.createBookCollection(bookCollection);
    }

    @DeleteMapping(value = "/{id}")
    public Optional<Book> deleteBookById(@PathVariable("id") int id) { return  bookService.deleteBookById(id); }

    @PutMapping(value = "/{id}")
    public Optional<Book> updateBook(@PathVariable("id") int id, @RequestBody Book newBook) { return bookService.updateBook(id,newBook);}
}
