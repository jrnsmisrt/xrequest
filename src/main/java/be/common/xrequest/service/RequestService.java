package be.common.xrequest.service;

import be.common.xrequest.domain.request.Request;
import be.common.xrequest.domain.request.dto.RequestDto;
import be.common.xrequest.mapper.RequestMapper;
import be.common.xrequest.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RequestService {
    RequestRepository requestRepository;
    RequestMapper mapper;

    @Autowired
    public RequestService(RequestRepository repository, RequestMapper mapper) {
        this.requestRepository = repository;
        this.mapper = mapper;
    }

    public RequestService() {
    }

    public RequestDto createRequest(RequestDto requestDto) {
        Request req = mapper.mapRequestDtoToRequest(requestDto);

        requestRepository.saveAndFlush(req);

        return this.getRequestById(req.getId().toString());
    }


    public List<RequestDto> getAllRequests() {
        List<RequestDto> dtoList = new ArrayList<>();

        requestRepository.findAll().forEach(r -> {
            RequestDto mapped = mapper.mapRequestToRequestDto(r);
            if (!dtoList.contains(mapped)) {
                dtoList.add(mapped);
                System.out.println(mapped.getTitle() + " : has been added to dto list");
            }
        });

        return dtoList;
    }

    public RequestDto getRequestById(String id) {
        UUID mappedId = UUID.fromString(id);
        Optional<Request> optional = requestRepository.findAll().stream().filter(req -> req.getId().equals(mappedId)).findFirst();

        if (optional.isEmpty()) {
            throw new NullPointerException();
        }

        return mapper.mapRequestToRequestDto(optional.get());
    }

    public RequestDto updateRequestById(String id, RequestDto requestDto) {
        if (this.getRequestById(id).getId() != null &&
                (!this.getRequestById(id).getId().isEmpty()
                        || !this.getRequestById(id).getId().isBlank())) {
            Request mapped = mapper.mapRequestDtoToRequest(requestDto);
            requestRepository.saveAndFlush(mapped);

            return this.getRequestById(mapped.getId().toString());
        } else throw new NullPointerException();
    }
}
