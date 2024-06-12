package top.singi.reactive.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;
import top.singi.reactive.entity.Book;

public interface BookRepository extends R2dbcRepository<Book, Long> {
    Flux<Book> findByTitle(String title, Pageable pageable);

    @Query("select * from book order by id desc limit :offset,:limit")
    Flux<Book> search(Integer offset, Integer limit);
}
