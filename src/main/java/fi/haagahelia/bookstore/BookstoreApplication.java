package fi.haagahelia.bookstore;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository drepository) {
		return (args) -> {
			log.info("save a couple of category");
			Stream.of("Fiction", "Mystery", "Romance", "Science Fiction", "Fantasy", "Biography").forEach(name -> {
				drepository.save(new Category(name));
			});

			log.info("save a couple of books");
			brepository.save(new Book("The Old Man and the Sea", "Ernest Hemingway", 1952, 97819075 - 9027 - 6,
					drepository.findByName("Fiction").get(0)));
			brepository.save(new Book("Romance of the Three Kingdoms", "Luo Guanzhong", 1907, 8951346,
					drepository.findByName("Fiction").get(0)));

			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
