package be.common.xrequest.service;

import be.common.xrequest.domain.author.Author;
import be.common.xrequest.domain.author.dto.AuthorDto;
import be.common.xrequest.domain.place.dto.PlaceDto;
import be.common.xrequest.domain.request.XRequest;
import be.common.xrequest.domain.request.dto.XRequestDto;
import be.common.xrequest.exception.AuthorNotFoundException;
import be.common.xrequest.exception.PlaceNotFoundException;
import be.common.xrequest.exception.XRequestNotFoundException;
import be.common.xrequest.mapper.AuthorMapper;
import be.common.xrequest.mapper.PlaceMapper;
import be.common.xrequest.mapper.XRequestMapper;
import be.common.xrequest.repository.AuthorRepository;
import be.common.xrequest.repository.PlaceRepository;
import be.common.xrequest.repository.XRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class XRequestService {
    XRequestRepository xRequestRepository;
    AuthorRepository authorRepository;

    PlaceRepository placeRepository;
    XRequestMapper xRequestMapper;
    AuthorMapper authorMapper;
    PlaceMapper placeMapper;

    @Autowired
    public XRequestService(XRequestRepository xRequestRepository, XRequestMapper xRequestMapper, AuthorRepository authorRepository, AuthorMapper authorMapper, PlaceRepository placeRepository, PlaceMapper placeMapper) {
        this.xRequestRepository = xRequestRepository;
        this.xRequestMapper = xRequestMapper;
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
        this.placeRepository = placeRepository;
        this.placeMapper = placeMapper;
    }

    public XRequestService() {
    }

    public XRequestDto createRequest(XRequestDto xRequestDto) {
        XRequest req = xRequestMapper.mapRequestDtoToRequest(xRequestDto);

        xRequestRepository.save(req);

        return xRequestMapper.mapRequestToRequestDto(req);
    }


    public List<XRequestDto> getAllRequests() {
        List<XRequestDto> dtoList = xRequestRepository.findAll().stream().map(request -> xRequestMapper.mapRequestToRequestDto(request)).collect(Collectors.toList());

        if (dtoList.isEmpty()) {
            throw new XRequestNotFoundException("All Requests");
        }

        return dtoList;
    }

    public XRequestDto getRequestById(String id) {
        UUID mappedId = UUID.fromString(id);
        Optional<XRequest> optional = xRequestRepository.findAll().stream().filter(req -> req.getId().equals(mappedId)).findFirst();

        if (optional.isEmpty()) {
            throw new XRequestNotFoundException(id);
        }

        return xRequestMapper.mapRequestToRequestDto(optional.get());
    }

    public XRequestDto updateRequestById(String id, XRequestDto XRequestDto) {
        if (this.getRequestById(id).getId() != null && (!this.getRequestById(id).getId().isEmpty() || !this.getRequestById(id).getId().isBlank())) {
            XRequest mapped = xRequestMapper.mapRequestDtoToRequest(XRequestDto);
            xRequestRepository.saveAndFlush(mapped);

            return this.getRequestById(mapped.getId().toString());
        } else throw new XRequestNotFoundException(id);
    }

    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = this.authorMapper.mapAuthorDtoToAuthor(authorDto);

        this.authorRepository.save(author);
        return this.getAuthor(author.getId().toString());
    }

    public List<AuthorDto> getAuthors() {
        return this.authorRepository.findAll().stream().map(author -> authorMapper.mapAuthorToAuthorDto(author)).collect(Collectors.toList());
    }

    public AuthorDto getAuthor(String id) {
        Optional<AuthorDto> optionalAuthor = this.authorRepository.findById(UUID.fromString(id)).map(value -> authorMapper.mapAuthorToAuthorDto(value));

        if (optionalAuthor.isEmpty()) throw new AuthorNotFoundException(id);
        else return optionalAuthor.get();
    }

    public List<PlaceDto> getPlaces() {
        return this.placeRepository.findAll().stream().map(place -> placeMapper.mapPlaceToPlaceDto(place)).collect(Collectors.toList());
    }

    public PlaceDto getPlace(Integer id) {
        Optional<PlaceDto> optionalPlace = this.placeRepository.findById(id).map(p -> placeMapper.mapPlaceToPlaceDto(p));

        if (optionalPlace.isEmpty()) throw new PlaceNotFoundException(id.toString());
        else return optionalPlace.get();
    }

    public List<PlaceDto> getPlaceByPostal(String postal) {
        List<PlaceDto> optionalPlace = this.placeRepository.findAll().stream()
                .filter(p -> p.getPostal().equals(postal))
                .map(p -> placeMapper.mapPlaceToPlaceDto(p)).toList();

        if (optionalPlace.isEmpty()) throw new PlaceNotFoundException("All places");
        else return optionalPlace;
    }

    public List<PlaceDto> getPlaceByCity(String city) {
        List<PlaceDto> optionalPlace = this.placeRepository.findAll().stream()
                .filter(p -> p.getCity().replace(" ", "").equalsIgnoreCase(city.replace(" ", "")))
                .map(p -> placeMapper.mapPlaceToPlaceDto(p)).toList();

        if (optionalPlace.isEmpty()) throw new PlaceNotFoundException("All places");
        else return optionalPlace;
    }
}
