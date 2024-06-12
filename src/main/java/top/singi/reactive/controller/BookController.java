package top.singi.reactive.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.singi.reactive.entity.Book;
import top.singi.reactive.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("")
    public Flux<Book> inde(@RequestParam Integer page, @RequestParam Integer per_page) {
        return bookRepository.search((page - 1) * per_page, per_page);
    }
    
    @GetMapping("/{id}")
    public Mono<Book> show(@PathVariable("id") Long id) {
        return bookRepository.findById(id);
    }
    
}
