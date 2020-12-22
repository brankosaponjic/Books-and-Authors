package brankosaponjic.springbootmongodb.DAO;

import brankosaponjic.springbootmongodb.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {

}
