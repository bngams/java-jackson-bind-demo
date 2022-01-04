package fr.aelion.java.tessi.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.aelion.java.tessi.json.models.Author;
import fr.aelion.java.tessi.json.models.Book;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Log
public class Main {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "JAVA Programming"));
        books.add(new Book(2, "JAVA Streams"));

        try {
            // jackson serialization
            ObjectMapper om = new ObjectMapper();
            String jsonBooks =  om.writeValueAsString(books);
            log.info("serialized books: " + jsonBooks);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Author eni = new Author("eni", books);
        for (Book b : books) {
            b.setAuthor(eni);
        }

        try {
            // jackson serialization
            ObjectMapper om = new ObjectMapper();
            String json =  om.writeValueAsString(eni);
            log.info("serialized books: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // manually serialize to json
        String json = "[";
        for (Book b : books) {
            json += "{ 'id':"+ b.getId() +", 'title': '"+ b.getName() +"' }";
        }
        json += "]";
    }
}
