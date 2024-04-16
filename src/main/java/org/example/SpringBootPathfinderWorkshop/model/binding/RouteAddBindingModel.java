package org.example.SpringBootPathfinderWorkshop.model.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.CategoryNameEnum;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.LevelEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class RouteAddBindingModel {

    @NotBlank(message = "Route name should not be blank. Enter at least 3 characters.")
    @Length(min = 3, message = "Route name should be at least 3 characters long.")
    private String name;

    @NotBlank
    @Length(min = 5, message = "Description should be at least 5 symbols long")
    private String description;

    private MultipartFile gpxCoordinates;

    private LevelEnum level;

    @NotNull
    @Length(min = 11, max = 11, message = "Copy and paste only last 11 characters from youtube video.")
    private String videoUrl;

    @NotNull(message = "Choose at least 1 category.")
    private List<CategoryNameEnum> categories;

    public RouteAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
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
}
