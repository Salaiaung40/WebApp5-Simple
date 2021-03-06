package salai.springframework.webapp5simple.bootStrap;

//Created by Salai 6 May 2021

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import salai.springframework.webapp5simple.domain.Author;
import salai.springframework.webapp5simple.domain.Book;
import salai.springframework.webapp5simple.domain.Publisher;
import salai.springframework.webapp5simple.repositories.AuthorRepository;
import salai.springframework.webapp5simple.repositories.BookRepository;
import salai.springframework.webapp5simple.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in BootStrap");

        //Add publisher for all
        Publisher publisher = new Publisher("Penguin", "Avenue Louis", "Brussel", "Brussels", 1000);

        //Save should be right after input
        publisherRepository.save(publisher);

        //need to build many to many fpr publisher
        //code goes hear

        //First Author, Book
        Author eric = new Author("Eric", "Evans");
        Book dddd = new Book("Domain Driven Design", "123456");

        //For many to many Publisher
        // Publisher penguin = new Publisher("Penguin", "Avenue Louis", "Brussel", "Brussels", 1000 );
         /*
        dddd.getPublisher(penguin);
        penguin.getBooks().add(dddd);
/        penguin.getAuthors().add(eric);
         */

        eric.getBooks().add(dddd);
        dddd.getAuthors().add(eric);

        dddd.setPublisher(publisher);
        publisher.getBooks().add(dddd);

        authorRepository.save(eric);
        bookRepository.save(dddd);
        publisherRepository.save(publisher);

        //        publisherRepositories.save(penguin);



        //Second Author, Book
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE", "123457");
//        Publisher person = new Publisher("Person", "Avenue Gourge", "Etterbeek", "Brussel", 1200);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);


        /*
        noEJB.setPublisher(person);
        person.getBooks().add(noEJB);

         */

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Author : " + authorRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publisher: " + publisherRepository.count());
        System.out.println("Publisher by Number of Books: " + publisher.getBooks().size());
         /*
        System.out.println("Publisher by Number of Books: " + penguin.getBooks().size());
        System.out.println("Publisher by Number of Books: " + person.getBooks().size());
         */
    }

}
