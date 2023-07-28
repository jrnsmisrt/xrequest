package be.common.xrequest.mapper;

import be.common.xrequest.domain.request.XRequest;
import be.common.xrequest.domain.request.dto.XRequestDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class XRequestMapper {
    public XRequestDto mapRequestToRequestDto(XRequest XRequest) {

        return new XRequestDto()
                .setId(XRequest.getId().toString())
                .setAuthor(XRequest.getAuthor())
                .setTitle(XRequest.getTitle())
                .setContent(XRequest.getContent())
                .setCategory(XRequest.getCategory())
                .setDateTime(XRequest.getDateTime().toString())
                .setTags(XRequest.getTags())
                .setPhotos(XRequest.getPhotos());
    }

    public XRequest mapRequestDtoToRequest(XRequestDto reqDto) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return new XRequest.RequestBuilder(
                reqDto.getAuthor(),
                LocalDateTime.parse(reqDto.getDateTime(), dateTimeFormatter),
                reqDto.getCategory(),
                reqDto.getTitle(),
                reqDto.getContent())
                .withPhotos(reqDto.getPhotos())
                .withTags(reqDto.getTags())
                .withId(UUID.fromString(reqDto.getId()))
                .build();
    }
}
