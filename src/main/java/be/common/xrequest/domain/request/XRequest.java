package be.common.xrequest.domain.request;

import be.common.xrequest.domain.requestcategory.RequestCategory;
import be.common.xrequest.helper.CustomLocalDateTimeConverter;
import be.common.xrequest.helper.StringListConverter;
import jakarta.persistence.*;
import org.springframework.data.convert.Jsr310Converters;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "XREQUEST")
public class XRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "author_id")
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private UUID author;

    @Convert(converter = CustomLocalDateTimeConverter.class)
    @Column(name = "datetime_request")
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_request")
    private RequestCategory category;
    @Column(name = "title")
    private String title;
    @Column(name = "content_request")
    private String content;

    @Convert(converter = StringListConverter.class)
    @Column(name = "photos_url")
    private List<String> photos = new ArrayList<>();

    @Convert(converter = StringListConverter.class)
    @Column(name = "TAGS")
    private List<String> tags = new ArrayList<>();

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
        private UUID author;
        private LocalDateTime dateTime;
        private RequestCategory category;
        private String title;
        private String content;

        //OPTIONAL
        private List<String> photos;

        private List<String> tags;

        public RequestBuilder(UUID author, LocalDateTime dateTime, RequestCategory category, String title, String content) {
            this.category = category;
            this.author = author;
            this.dateTime = dateTime;
            this.title = title;
            this.content = content;
            this.photos = new ArrayList<>();
            this.tags = new ArrayList<>();
        }


        public RequestBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public RequestBuilder withPhotos(List<String> photos) {
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

    public UUID getAuthor() {
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

    public List<String> getPhotos() {
        return this.photos;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAuthor(UUID author) {
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

    public void addPhotos(List<String> photos) {
        this.photos.addAll(photos);
    }

    public void addTags(List<String> tags) {
        this.tags.addAll(tags);
    }
}
