package org.example.SpringBootPathfinderWorkshop.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;


@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String url;

    @ManyToOne
    private User author;

    @ManyToOne
    private Route route;

    public Picture() {
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    //    • id - Accepts UUID String or Long values
    //    • title - Accepts String values
    //    • url - Accepts very long String values
    //    • author - Accepts User Entities as values
    //    • route - Accepts Route Entities as values
}
