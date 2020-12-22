package brankosaponjic.springbootmongodb.service;

import brankosaponjic.springbootmongodb.entity.Book;
import brankosaponjic.springbootmongodb.DAO.BookDAO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BookService {

    private final BookDAO bookDAO;

    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public Collection<Book> getBooks() {
        return bookDAO.getBooks();
    }

    public Book createBook(Book book) {
        return bookDAO.createBook(book);
    }

    public Collection<Book> createBookCollection(Collection<Book> bookCollection) {
        return bookDAO.createBookCollection(bookCollection);
    }

    public Optional<Book> getBookById(int id) {
        return bookDAO.getBookById(id);
    }

    public Optional<Book> deleteBookById(int id) {
        return bookDAO.deleteBookById(id);
    }

    public Optional<Book> updateBook(int id, Book book) { return bookDAO.updateBook(id, book);}

}
