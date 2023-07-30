package be.common.xrequest.service;

import be.common.xrequest.domain.author.Author;
import be.common.xrequest.domain.author.dto.AuthorDto;
import be.common.xrequest.domain.place.dto.PlaceDto;
import be.common.xrequest.domain.request.XRequest;
import be.common.xrequest.domain.request.dto.XRequestDto;
import be.common.xrequest.mapper.AuthorMapper;
import be.common.xrequest.mapper.PlaceMapper;
import be.common.xrequest.mapper.XRequestMapper;
import be.common.xrequest.repository.AuthorRepository;
import be.common.xrequest.repository.PlaceRepository;
import be.common.xrequest.repository.XRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public XRequestService(XRequestRepository xRequestRepository,
                           XRequestMapper xRequestMapper,
                           AuthorRepository authorRepository,
                           AuthorMapper authorMapper,
                           PlaceRepository placeRepository,
                           PlaceMapper placeMapper) {
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
        System.out.println(xRequestDto.getAuthor() + xRequestDto.getContent());
        xRequestRepository.save(req);

        return this.getRequestById(req.getId().toString());
    }


    public List<XRequestDto> getAllRequests() {
        return xRequestRepository.findAll().stream()
                .map(request -> xRequestMapper.mapRequestToRequestDto(request)).collect(Collectors.toList());
    }

    public XRequestDto getRequestById(String id) {
        UUID mappedId = UUID.fromString(id);
        Optional<XRequest> optional = xRequestRepository.findAll().stream().filter(req -> req.getId().equals(mappedId)).findFirst();

        if (optional.isEmpty()) {
            throw new NullPointerException();
        }

        return xRequestMapper.mapRequestToRequestDto(optional.get());
    }

    public XRequestDto updateRequestById(String id, XRequestDto XRequestDto) {
        if (this.getRequestById(id).getId() != null &&
                (!this.getRequestById(id).getId().isEmpty()
                        || !this.getRequestById(id).getId().isBlank())) {
            XRequest mapped = xRequestMapper.mapRequestDtoToRequest(XRequestDto);
            xRequestRepository.saveAndFlush(mapped);

            return this.getRequestById(mapped.getId().toString());
        } else throw new NullPointerException();
    }

    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = this.authorMapper.mapAuthorDtoToAuthor(authorDto);

        this.authorRepository.save(author);
        return this.getAuthor(author.getId().toString());
    }

    public AuthorDto getAuthor(String id) {
        Optional<Author> optionalAuthor = this.authorRepository.findById(UUID.fromString(id));
        AuthorDto author = optionalAuthor.map(value -> authorMapper.mapAuthorToAuthorDto(value)).orElse(null);

        return author;
    }

    public List<PlaceDto> getPlaces() {
        return this.placeRepository.findAll().stream().map(place -> placeMapper.mapPlaceToPlaceDto(place)).collect(Collectors.toList());
    }

    public List<AuthorDto> getAuthors() {
        return this.authorRepository.findAll().stream().map(author -> authorMapper.mapAuthorToAuthorDto(author)).collect(Collectors.toList());
    }
}
