package io.klesogor.Lab03.Entities;


import javax.persistence.*;

@Entity
@Table(name="places")
public class Place{
    private String name, address;
    private int rating;
    @ManyToOne
    private Category category;
    @Id
    @GeneratedValue
    private int id;

    protected Place(){}

    public Place(String name, String address, Category category, int rating)
    {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id =  id; }
}
