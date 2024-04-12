package org.example.SpringBootPathfinderWorkshop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;


@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @UuidGenerator
    private String id;

    private boolean approved;

    @Column(nullable = false, updatable = false, insertable = false)
    @PastOrPresent(message = "Date should not be in the future")
    private LocalDateTime created;

    @Column(columnDefinition = "LONGTEXT")
    private String text;

    @ManyToOne
    private User author;

    @OneToOne
    private Route route;

    public Comment() {
    }

    public String getId() {
        return id;
    }


    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
    //    • approved - Accepts boolean values
    //    • created - Accepts Date and Time values
    //        ◦  The values should not be future dates
    //    • text content - Accepts very long text values
    //    • author - Accepts User Entities as values
    //    • route - Accepts Route Entities as values
}
