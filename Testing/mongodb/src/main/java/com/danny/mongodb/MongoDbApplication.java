package com.danny.mongodb;

import com.danny.mongodb.model.Book;
import com.danny.mongodb.model.Role;
import com.danny.mongodb.model.User;
import com.danny.mongodb.repository.BookRepository;
import com.danny.mongodb.repository.RoleRepository;
import com.danny.mongodb.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@AllArgsConstructor

@SpringBootApplication
public class MongoDbApplication implements CommandLineRunner {

    private BookRepository bookRepository;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApplication.class, args);
    }

    @Override
    public void run(String... args) {

//        Book book = new Book(ObjectId.get(), "Spring Core", "Danny");
        Book book = new Book();
        book.setBookName("Spring Core");
        book.setAuthorName("Danny");
        bookRepository.save(book);


        Role adminRole = roleRepository.findByRole("ADMIN");
        if (adminRole == null) {
            Role newAdminRole = new Role();
            newAdminRole.setRole("ADMIN");
            adminRole = roleRepository.save(newAdminRole);
        }

        Role userRole = roleRepository.findByRole("USER");
        if (userRole == null) {
            Role newUserRole = new Role();
            newUserRole.setRole("USER");
            userRole = roleRepository.save(newUserRole);
        }


        User user = userRepository.findByEmail("danny@ibm.com");
        if (user == null) {
            User adminUser = new User();
            adminUser.setEmail("danny@ibm.com");
            adminUser.setPassword(passwordEncoder.encode("danny"));
            adminUser.setFullName("Danny David");
            adminUser.setEnabled(true);
            adminUser.getRoles().add(userRole);
            adminUser.getRoles().add(adminRole);
            userRepository.save(adminUser);
        }

    }

}
