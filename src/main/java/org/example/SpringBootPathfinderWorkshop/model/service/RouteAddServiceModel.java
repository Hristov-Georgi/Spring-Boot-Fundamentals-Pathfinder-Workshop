package org.example.SpringBootPathfinderWorkshop.model.service;

import org.example.SpringBootPathfinderWorkshop.model.entity.Picture;
import org.example.SpringBootPathfinderWorkshop.model.entity.UserEntity;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.CategoryNameEnum;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.LevelEnum;

import java.util.List;

public class RouteAddServiceModel {

    private String id;

    private String description;

    private String gpx;

    private LevelEnum level;

    private String name;

    private UserEntity author;

    private String videoUrl;

    private List<CategoryNameEnum> categories;

    private List<Picture> pictures;

    public RouteAddServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<CategoryNameEnum> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryNameEnum> categories) {
        this.categories = categories;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
