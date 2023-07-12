package be.common.xrequest.domain.request;

import be.common.xrequest.domain.author.Author;
import be.common.xrequest.domain.requestcategory.RequestCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class XRequest {

    @Id
    private UUID id;

    @Transient private Author author;
    private LocalDateTime dateTime;
    private RequestCategory category;
    private String title;
    private String content;
    @Transient private List<Blob> photos;

    @Transient private List<String> tags;

    public XRequest() {
    }

    public XRequest(RequestBuilder builder) {
        this.category = builder.category;
        this.author = builder.author;
        this.dateTime = builder.dateTime;
        this.title = builder.title;
        this.content = builder.content;
        this.photos = builder.photos;
        this.tags = builder.tags;
    }

    public static class RequestBuilder {
        private UUID id;
        private Author author;
        private LocalDateTime dateTime;
        private RequestCategory category;
        private String title;
        private String content;

        //OPTIONAL
        private List<Blob> photos;

        private List<String> tags;

        public RequestBuilder(Author author, LocalDateTime dateTime, RequestCategory category, String title, String content) {
            this.category = category;
            this.author = author;
            this.dateTime = LocalDateTime.now();
            this.title = title;
            this.content = content;
            this.photos = new ArrayList<>();
            this.tags = new ArrayList<>();
        }


        public RequestBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public RequestBuilder withPhotos(List<Blob> photos) {
            this.photos = photos;
            return this;
        }

        public RequestBuilder withTags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public XRequest build() {
            return new XRequest(this);
        }
    }

    public UUID getId() {
        return this.id;
    }

    public Author getAuthor() {
        return this.author;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public RequestCategory getCategory() {
        return this.category;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public List<Blob> getPhotos() {
        return this.photos;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public void addTags(List<String> tags) {
        this.tags.addAll(tags);
    }
}
