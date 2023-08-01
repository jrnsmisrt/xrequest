package be.common.xrequest.controller;

import be.common.xrequest.domain.request.dto.XRequestDto;
import be.common.xrequest.service.XRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(path = "/xrequests")
public class XRequestController {
    XRequestService XRequestService;

    @Autowired
    public XRequestController(XRequestService XRequestService) {
        this.XRequestService = XRequestService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<XRequestDto> getAllRequests() {
        return XRequestService.getAllRequests();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseBody
    public XRequestDto getRequestById(@PathVariable String id) {
        return XRequestService.getRequestById(id);
    }

    @PostMapping(produces = "application/json", consumes = "application/json", path = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    public XRequestDto createRequest(@RequestBody XRequestDto XRequestDto) {
        return XRequestService.createRequest(XRequestDto);
    }

    @PutMapping(path = "/{id}", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public XRequestDto editRequestById(@PathVariable String id, @RequestBody XRequestDto XRequestDto) {
        return XRequestService.updateRequestById(id, XRequestDto);
    }
}
