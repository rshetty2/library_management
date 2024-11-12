package com.org.lms.model;

import com.org.lms.exception.CustomException;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


public class Inventory {
    private static Inventory inventory;

    private Inventory() {

    }

    @Getter
    private ConcurrentHashMap<String, Book> books = new ConcurrentHashMap<>();

    public static Inventory getInventory() {
        if (inventory == null) {
            synchronized (Inventory.class) {
                if(inventory == null) {
                    inventory = new Inventory();
                }
            }
        }
        return inventory;
    }

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

    }

    public Optional<Book> search(Book book) {
            return Optional.ofNullable(books.get(bookKey(book)));
    }

    private String bookKey(Book book) {
        return String.join(book.getTitle()," ", book.getAuthor());
    }

}
