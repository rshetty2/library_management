package com.org.lms.model;

import com.org.lms.exception.CustomException;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;


public class Inventory {
    @Getter
    private HashMap<String, Book> books;

    public void add(Book book) {
        books.put(bookKey(book),book);
    }

    public void delete(Book book) {
        Optional<Book> bookInInventory = search(book);
        bookInInventory.ifPresentOrElse(v -> { if(v.getAvailableQuantity() == v.getTotalQuantity())
                                                    books.remove(bookKey(v));
                                                else throw new CustomException(String.format("Cannot delete book %s because it is currently borrowed.",book.getTitle()));
                                             },
                                        () -> {throw new CustomException("Book not found");}
                                    );
    }

    public void borrow(Book book) {
        Optional<Book> bookInInventory = search(book);
        bookInInventory.ifPresentOrElse(v -> { if(v.getAvailableQuantity() > 0)
                    v.setAvailableQuantity(v.getAvailableQuantity() - 1);
                else throw new CustomException("Not enough books in inventory");
                },
                () -> {throw new CustomException("Book not found");}
        );


//        Optional<Book> bookInInventory = search(book);
//        bookInInventory.ifPresent
//        if (bookInInventory != null) {
//            int availableQuantity = bookInInventory.getAvailableQuantity();
//            if (availableQuantity < 0)
//                throw new CustomException("Not enough books in inventory");
//            bookInInventory.setAvailableQuantity(availableQuantity - 1);
//            return "Successfully Borrowed";
//        }
//        throw new CustomException("Book not found");
    }

    public Optional<Book> search(Book book) {
            return Optional.ofNullable(books.get(bookKey(book)));
    }

    private String bookKey(Book book) {
        return String.join(book.getTitle()," ", book.getAuthor());
    }

}
