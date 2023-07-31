package be.common.xrequest.mapper;

import be.common.xrequest.domain.request.XRequest;
import be.common.xrequest.domain.request.dto.XRequestDto;
import be.common.xrequest.domain.requestcategory.RequestCategory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class XRequestMapper {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    public XRequestDto mapRequestToRequestDto(XRequest xRequest) {
        return new XRequestDto()
                .setId(xRequest.getId())
                .setAuthor(xRequest.getAuthor())
                .setTitle(xRequest.getTitle())
                .setContent(xRequest.getContent())
                .setCategory(xRequest.getCategory())
                .setDateTime(xRequest.getDateTime().toString())
                .setTags(xRequest.getTags())
                .setPhotos(xRequest.getPhotos());
    }

    public XRequest mapRequestDtoToRequest(XRequestDto reqDto) {
        LocalDateTime dateTime = LocalDateTime.parse(reqDto.getDateTime(), dateTimeFormatter);
        System.out.println("tesettttt : " + reqDto.getAuthor());
        return new XRequest.RequestBuilder(
                UUID.fromString(reqDto.getAuthor()),
                dateTime,
                RequestCategory.valueOf(reqDto.getCategory()),
                reqDto.getTitle(),
                reqDto.getContent())
                .withId(UUID.randomUUID())
                .withPhotos(reqDto.getPhotos())
                .withTags(reqDto.getTags())
                .build();
    }
}
