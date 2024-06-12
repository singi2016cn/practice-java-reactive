package top.singi.reactive.entity;

import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class Book {
    @Id
    Long id;
    String cate;
    String isbn;
    String title;
    String author;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Instant createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Instant updatedAt;
}
