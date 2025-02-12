package com.piyal.service;

import com.piyal.data.BookData;
import com.piyal.exception.BookNotFoundException;
import com.piyal.model.Book;
import com.piyal.repository.BookRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class BookService {

  @Inject
  BookRepository bookRepository;

  public Book save(BookData bookData) {
    Long id = bookRepository.findAll().stream().mapToLong(Book::getId).max().orElse(0) + 1;
    Book book = new Book(id, bookData.name(), bookData.author(), bookData.price(), bookData.totalPage());
    return bookRepository.save(book);
  }

  public void deleteById(Long id) {
    bookRepository.deleteById(id);
  }

  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  public Book findById(Long id) {
    return bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException("Book with id %s not found".formatted(id)));
  }

  public Book update(Long id, BookData bookData) {
    Book bookToUpdate = bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException("Book with id %s not found".formatted(id)));
    bookRepository.deleteById(bookToUpdate.getId());
    Book book = new Book(id, bookData.name(), bookData.author(), bookData.price(), bookData.totalPage());
    return bookRepository.save(book);
  }
}