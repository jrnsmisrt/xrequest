package be.common.xrequest.service;

import be.common.xrequest.domain.request.XRequest;
import be.common.xrequest.domain.request.dto.XRequestDto;
import be.common.xrequest.mapper.XRequestMapper;
import be.common.xrequest.repository.XRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class XRequestService {
    XRequestRepository repository;
    XRequestMapper mapper;

    @Autowired
    public XRequestService(XRequestRepository repository, XRequestMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public XRequestService() {
    }

    public XRequestDto createRequest(XRequestDto XRequestDto) {
        XRequest req = mapper.mapRequestDtoToRequest(XRequestDto);

        repository.saveAndFlush(req);

        return this.getRequestById(req.getId().toString());
    }


    public List<XRequestDto> getAllRequests() {
        List<XRequestDto> dtoList = new ArrayList<>();
        System.out.println("hello");

        repository.findAll().forEach(r -> {
            System.out.println(r.getId());
        });

        repository.findAll().forEach(r -> {
            XRequestDto mapped = mapper.mapRequestToRequestDto(r);
            if (!dtoList.contains(mapped)) {
                dtoList.add(mapped);
                System.out.println(mapped.getTitle() + " : has been added to dto list");
            }
        });

        return dtoList;
    }

    public XRequestDto getRequestById(String id) {
        UUID mappedId = UUID.fromString(id);
        Optional<XRequest> optional = repository.findAll().stream().filter(req -> req.getId().equals(mappedId)).findFirst();

        if (optional.isEmpty()) {
            throw new NullPointerException();
        }

        return mapper.mapRequestToRequestDto(optional.get());
    }

    public XRequestDto updateRequestById(String id, XRequestDto XRequestDto) {
        if (this.getRequestById(id).getId() != null &&
                (!this.getRequestById(id).getId().isEmpty()
                        || !this.getRequestById(id).getId().isBlank())) {
            XRequest mapped = mapper.mapRequestDtoToRequest(XRequestDto);
            repository.saveAndFlush(mapped);

            return this.getRequestById(mapped.getId().toString());
        } else throw new NullPointerException();
    }
}
