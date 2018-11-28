package io.klesogor.Lab03.Entities;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    private String user_name,text;
    @ManyToOne
    private Place place;

    @Id
    @GeneratedValue
    private int id;

    protected Review(){}

    public Review(String user_name, String text, Place place)
    {
        this.user_name = user_name;
        this.text = text;
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
