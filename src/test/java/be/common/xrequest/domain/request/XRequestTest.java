package be.common.xrequest.domain.request;

import be.common.xrequest.domain.requestcategory.RequestCategory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

class XRequestTest {
    XRequest mockRequest;
    UUID authorId = UUID.fromString("ad52cc5b-1490-47c4-a3b9-7e9388a0cfe7");
    UUID requestId = UUID.fromString("c7e66845-d254-4b93-b412-2b1a44445df2");

    @BeforeEach
    void setUp() {
        this.mockRequest = new XRequest.RequestBuilder(
                this.authorId,
                LocalDateTime.now(),
                RequestCategory.BDSMFETISHKINK,
                "mockTitle",
                "mockContent")
                .withId(this.requestId)
                .withPhotos(List.of("/photos", "/images"))
                .withTags(List.of("Mock", "Test"))
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
        Assertions.assertEquals(this.mockRequest.getTags(), List.of("Mock", "Test"));
    }

    @Test
    void setId() {
    }

    @Test
    void setAuthor() {
    }

    @Test
    void setCategory() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void setContent() {
    }

    @Test
    void addPhotos() {
    }

    @Test
    void addTags() {
    }
}