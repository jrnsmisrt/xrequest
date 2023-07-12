package be.common.xrequest.mapper;

import be.common.xrequest.domain.request.XRequest;
import be.common.xrequest.domain.request.dto.XRequestDto;
import org.springframework.stereotype.Component;

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
                .setDateTime(XRequest.getDateTime())
                .setTags(XRequest.getTags())
                .setPhotos(XRequest.getPhotos());
    }

    public XRequest mapRequestDtoToRequest(XRequestDto reqDto) {
        return new XRequest.RequestBuilder(
                reqDto.getAuthor(),
                reqDto.getDateTime(),
                reqDto.getCategory(),
                reqDto.getTitle(),
                reqDto.getContent())
                .withPhotos(reqDto.getPhotos())
                .withTags(reqDto.getTags())
                .withId(UUID.fromString(reqDto.getId()))
                .build();
    }
}
