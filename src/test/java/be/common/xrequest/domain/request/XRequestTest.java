package be.common.xrequest.domain.request;

import be.common.xrequest.domain.requestcategory.RequestCategory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class XRequestTest {
    XRequest mockRequest;
    UUID authorId = UUID.fromString("ad52cc5b-1490-47c4-a3b9-7e9388a0cfe7");
    UUID requestId = UUID.fromString("c7e66845-d254-4b93-b412-2b1a44445df2");

    @BeforeEach
    void setUp() {
        List<String> photos = new ArrayList<>();
        photos.add("/photos");
        photos.add("/images");

        List<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");

        this.mockRequest = new XRequest.RequestBuilder(
                this.authorId,
                LocalDateTime.now(),
                RequestCategory.BDSMFETISHKINK,
                "mockTitle",
                "mockContent")
                .withId(this.requestId)
                .withPhotos(photos)
                .withTags(tags)
                .build();
    }

    @AfterEach
    void tearDown() {
        this.mockRequest = null;
    }

    @Test
    void getId() {
        Assertions.assertEquals(this.mockRequest.getId(), UUID.fromString("c7e66845-d254-4b93-b412-2b1a44445df2"));
    }

    @Test
    void getAuthor() {
        Assertions.assertEquals(this.mockRequest.getAuthor(), UUID.fromString("ad52cc5b-1490-47c4-a3b9-7e9388a0cfe7"));

    }

    @Test
    void getDateTime() {
        Assertions.assertEquals(this.mockRequest.getDateTime(), LocalDateTime.now());
    }

    @Test
    void getCategory() {
        Assertions.assertEquals(this.mockRequest.getCategory(), RequestCategory.BDSMFETISHKINK);
    }

    @Test
    void getTitle() {
        Assertions.assertEquals(this.mockRequest.getTitle(), "mockTitle");
    }

    @Test
    void getContent() {
        Assertions.assertEquals(this.mockRequest.getContent(), "mockContent");
    }

    @Test
    void getPhotos() {
        Assertions.assertEquals(this.mockRequest.getPhotos(), List.of("/photos", "/images"));
    }

    @Test
    void getTags() {
        Assertions.assertEquals(this.mockRequest.getTags(), List.of("tag1", "tag2"));
    }

    @Test
    void setId() {
        UUID random = UUID.randomUUID();
        this.mockRequest.setId(random);

        Assertions.assertEquals(this.mockRequest.getId(), random);
    }

    @Test
    void setAuthor() {
        UUID random = UUID.randomUUID();
        this.mockRequest.setAuthor(random);

        Assertions.assertEquals(this.mockRequest.getAuthor(), random);
    }

    @Test
    void setCategory() {
        this.mockRequest.setCategory(RequestCategory.COUPLE4COUPLE);

        Assertions.assertEquals(this.mockRequest.getCategory(), RequestCategory.COUPLE4COUPLE);
    }

    @Test
    void setTitle() {
        this.mockRequest.setTitle("mockTitle2");

        Assertions.assertEquals(this.mockRequest.getTitle(), "mockTitle2");
    }

    @Test
    void setContent() {
        this.mockRequest.setContent("newContent");

        Assertions.assertEquals(this.mockRequest.getContent(), "newContent");
    }

    @Test
    void addPhotos() {
        List<String> add = new ArrayList<>();
        add.add(("yolo"));

        this.mockRequest.addPhotos(add);

        Assertions.assertEquals(this.mockRequest.getPhotos(), List.of("/photos", "/images", "yolo"));
    }

    @Test
    void addTags() {
        List<String> add = new ArrayList<>();
        add.add(("tag3"));

        this.mockRequest.addTags(add);

        Assertions.assertEquals(this.mockRequest.getTags(), List.of("tag1", "tag2", "tag3"));
    }
}