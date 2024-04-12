package org.example.SpringBootPathfinderWorkshop.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @UuidGenerator
    private String id;;

    @Column(nullable = false, updatable = false, insertable = false, name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "text_content", columnDefinition = "LONGTEXT", nullable = false)
    private String textContent;

    @ManyToOne
    private User author;

    @ManyToOne
    private User recipient;

    public Message() {
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

}
