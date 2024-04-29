package org.example.SpringBootPathfinderWorkshop.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;


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
    private UserEntity author;

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

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

}
