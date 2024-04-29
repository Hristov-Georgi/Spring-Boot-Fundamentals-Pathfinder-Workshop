package org.example.SpringBootPathfinderWorkshop.model.entity;

import jakarta.persistence.*;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.LevelEnum;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @UuidGenerator
    private String id;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @Column(columnDefinition = "LONGTEXT")
    private String gpx;

    @Enumerated(value = EnumType.STRING)
    private LevelEnum level;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private UserEntity author;

    @Column(name = "video_url")
    private String videoUrl;

    @ManyToMany
    private List<Category> categories;

    @OneToMany(mappedBy = "route", targetEntity = Picture.class, fetch = FetchType.EAGER)
    private List<Picture> pictures;

    public Route() {
    }

    public String getId() {
        return id;
    }

    public String getGpx() {
        return gpx;
    }

    public void setGpx(String gpx) {
        this.gpx = gpx;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
