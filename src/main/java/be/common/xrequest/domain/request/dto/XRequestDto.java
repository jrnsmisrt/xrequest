package be.common.xrequest.domain.request.dto;

import be.common.xrequest.domain.requestcategory.RequestCategory;

import java.util.List;
import java.util.UUID;

public class XRequestDto {

    private String id;
    private String authorId;
    private String dateTime;
    private String category;
    private String title;
    private String content;
    private List<String> photos;

    private List<String> tags;


    public List<String> getTags() {
        return tags;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDateTime() {
        return dateTime;
    }

    public UUID getAuthor() {
        return UUID.fromString(authorId);
    }

    public String getId() {
        return id;
    }

    public XRequestDto setId(String id) {
        this.id = id;
        return this;
    }

    public XRequestDto setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public XRequestDto setPhotos(List<String> photos) {
        this.photos = photos;
        return this;
    }

    public XRequestDto setContent(String content) {
        this.content = content;
        return this;
    }

    public XRequestDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public XRequestDto setCategory(RequestCategory category) {
        this.category = category.toString();
        return this;
    }

    public XRequestDto setDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;

    }

    public XRequestDto setAuthor(UUID author) {
        this.authorId = author.toString();
        return this;
    }
}
