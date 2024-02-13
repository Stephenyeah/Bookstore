package fi.haagahelia.bookstore.domain;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;
    private String name;


    @OneToMany(cascade = CascadeType.ALL, mappedBy =  "category")
    private List<Book> books;

    public Category() {}

    public Category(String name) {
        super();
        this.name = name;

    }


    public long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }


    public void setCategoryId(long id) {
        this.categoryId = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }



    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + ",]";
    }
}
