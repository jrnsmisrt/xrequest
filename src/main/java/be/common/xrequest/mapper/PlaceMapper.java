package be.common.xrequest.mapper;

import be.common.xrequest.domain.place.Place;
import be.common.xrequest.domain.place.dto.PlaceDto;
import org.springframework.stereotype.Component;

@Component
public class PlaceMapper {

    public PlaceDto mapPlaceToPlaceDto(Place place) {
        return new PlaceDto()
                .setCity(place.getCity())
                .setState(place.getState())
                .setCountry(place.getCountry())
                .setPostal(place.getPostal())
                .setId(place.getId());
    }

    public Place mapPlaceDtoToPlace(PlaceDto placeDto) {
        return new Place(
                Integer.valueOf(placeDto.getId()),
                placeDto.getPostal(),
                placeDto.getCity(),
                placeDto.getState(),
                placeDto.getCountry()
        );
    }
}
