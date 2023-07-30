package be.common.xrequest.mapper;

import be.common.xrequest.domain.request.XRequest;
import be.common.xrequest.domain.request.dto.XRequestDto;
import be.common.xrequest.domain.requestcategory.RequestCategory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.stream.Collectors;

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
                .setDateTime(xRequest.getDateTime())
                .setTags(xRequest.getTags())
                .setPhotos(xRequest.getPhotos());
    }

    public XRequest mapRequestDtoToRequest(XRequestDto reqDto) {
        return new XRequest.RequestBuilder(
                reqDto.getAuthor(),
                reqDto.getDateTime(),
                RequestCategory.valueOf(reqDto.getCategory()),
                reqDto.getTitle(),
                reqDto.getContent())
                .withPhotos(reqDto.getPhotos())
                .withTags(reqDto.getTags())
                .withId(UUID.fromString(reqDto.getId()))
                .build();
    }
}
