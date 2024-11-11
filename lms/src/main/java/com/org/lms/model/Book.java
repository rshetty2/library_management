package com.org.lms.model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
public class Book {

    @Getter
    @EqualsAndHashCode.Include
    private String title;
    @Getter
    @EqualsAndHashCode.Include
    private String author;
    @Getter
    @Setter
    private int totalQuantity;
    @Getter
    @Setter
    private int availableQuantity;


    public Book(String title, String author, int totalQuantity) {
        this.title = title;
        this.author = author;
        this.totalQuantity = totalQuantity;
        this.availableQuantity = totalQuantity;
    }


}
