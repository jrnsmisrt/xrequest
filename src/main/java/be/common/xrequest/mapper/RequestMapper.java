package be.common.xrequest.mapper;

import be.common.xrequest.domain.request.Request;
import be.common.xrequest.domain.request.dto.RequestDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RequestMapper {
    public RequestDto mapRequestToRequestDto(Request request) {

        return new RequestDto()
                .setId(request.getId().toString())
                .setAuthor(request.getAuthor())
                .setTitle(request.getTitle())
                .setContent(request.getContent())
                .setCategory(request.getCategory())
                .setDateTime(request.getDateTime())
                .setTags(request.getTags())
                .setPhotos(request.getPhotos());
    }

    public Request mapRequestDtoToRequest(RequestDto reqDto) {
        return new Request.RequestBuilder(
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
