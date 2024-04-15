package org.example.SpringBootPathfinderWorkshop.model.view;

import org.example.SpringBootPathfinderWorkshop.model.entity.Picture;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.LevelEnum;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class RouteDetailedView {

    private String id;

    private String description;

    private String gpx;

    private LevelEnum level;

    private String authorName;

    private String videoUrl;

    private String name;

    private List<Picture> pictures;

    public RouteDetailedView() {
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
