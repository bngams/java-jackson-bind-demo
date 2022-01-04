package fr.aelion.java.tessi.json.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private String name;
    @JsonManagedReference
    private List<Book> books;
}
