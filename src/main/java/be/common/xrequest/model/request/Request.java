package be.common.xrequest.model.request;

import be.common.xrequest.model.author.Author;
import be.common.xrequest.model.requestcategory.RequestCategory;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Request {

    private Author author;
    private final LocalDateTime dateTime;
    private RequestCategory category;
    private String title;
    private String content;
    private final List<Blob> photos;

    public Request(Author author, RequestCategory category, String title, String content) {
        this.category = category;
        this.author = author;
        this.dateTime = LocalDateTime.now();
        this.title = title;
        this.content = content;
        this.photos = new ArrayList<>();
    }

    public Author getAuthor() {
        return author;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public RequestCategory getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Blob> getPhotos() {
        return photos;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategory(RequestCategory category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addPhotos(List<Blob> photos) {
        this.photos.addAll(photos);
    }
}
