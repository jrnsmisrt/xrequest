package be.common.xrequest.domain.request.dto;

import be.common.xrequest.domain.author.Author;
import be.common.xrequest.domain.requestcategory.RequestCategory;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

public class RequestDto {
    private Author author;
    private LocalDateTime dateTime;
    private RequestCategory category;
    private String title;
    private String content;
    private List<Blob> photos;

    private List<String> tags;


    public List<String> getTags() {
        return tags;
    }

    public List<Blob> getPhotos() {
        return photos;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public RequestCategory getCategory() {
        return category;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Author getAuthor() {
        return author;
    }

    public RequestDto setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public RequestDto setPhotos(List<Blob> photos) {
        this.photos = photos;
        return this;
    }

    public RequestDto setContent(String content) {
        this.content = content;
        return this;
    }

    public RequestDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public RequestDto setCategory(RequestCategory category) {
        this.category = category;
        return this;
    }

    public RequestDto setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;

    }

    public RequestDto setAuthor(Author author) {
        this.author = author;
        return this;
    }
}
