package brankosaponjic.springbootmongodb.DAO;

import brankosaponjic.springbootmongodb.entity.Book;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class BookDAO {
    private final BookRepository repository;

    public BookDAO(BookRepository repository) {
        this.repository = repository;
    }

    public Collection<Book> getBooks() {
        return repository.findAll();
    }

    public Book createBook(Book book) {
        return repository.insert(book);
    }

    public Collection<Book> createBookCollection(Collection<Book> bookCollection) { return repository.insert(bookCollection); }

    public Optional<Book> getBookById(int id) {
        return repository.findById(id);
    }

    public Optional<Book> deleteBookById(int id) {
        Optional<Book> book = repository.findById(id);
        book.ifPresent(repository::delete); // (b -> repository.delete(b))
        return book;
    }

    public Optional<Book> updateBook(int id, Book newBook) {
        Optional<Book> oldBook = repository.findById(id);
        oldBook.ifPresent(b -> b.setTitle(newBook.getTitle()));
        oldBook.ifPresent(b -> b.setAuthor(newBook.getAuthor()));
        oldBook.ifPresent(repository::save); // (b -> repository.insert(b))
        return oldBook;
    }

}
