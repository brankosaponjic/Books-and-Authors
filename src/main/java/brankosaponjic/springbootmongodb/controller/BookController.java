package brankosaponjic.springbootmongodb.controller;

import brankosaponjic.springbootmongodb.entity.Book;
import brankosaponjic.springbootmongodb.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/allBooks")
    public String getAllBooks(Model model) {
        model.addAttribute("books", service.getBooks());
        return "all-books";
    }

    // method to get book form
    @GetMapping("/addBookForm")
    public String getBookForm(Model model) {
        Book theBook = new Book();
        model.addAttribute("book", theBook);
        return "book-form";
    }

    // method to add new book
    @PostMapping("/save")
    public String addBook(@ModelAttribute("book") Book newBook) {
        service.createBook(newBook);
        return "redirect:/allBooks";
    }

    // method to book edit form
    @GetMapping("/editBookForm")
    public String editBook(@RequestParam("bookId") int id, Model model) {
        Book book = service.getBookById(id).get();
        model.addAttribute("book", book);
        return "book-edit-form";
    }

    // method to edit book
    @PostMapping("/edit")
    public String editBook(@RequestParam("bookId") int id, @ModelAttribute("book") Book theBook) {
        service.updateBook(id, theBook);
        return "redirect:/allBooks";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int id) {
        service.deleteBookById(id);
        return "redirect:/allBooks";
    }

}
