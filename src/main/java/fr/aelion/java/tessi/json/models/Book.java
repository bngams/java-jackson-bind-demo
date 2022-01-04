package fr.aelion.java.tessi.json.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Book {
    @NonNull
    private Integer id;

    @NonNull
    @JsonProperty(value="title")
    private String name;

    @JsonIgnore
    private String ISBN;

    @JsonBackReference
    private Author author;
}
