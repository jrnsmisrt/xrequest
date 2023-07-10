package be.common.xrequest.controller;

import be.common.xrequest.domain.request.dto.RequestDto;
import be.common.xrequest.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/requests")
public class RequestController {
    RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<RequestDto> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public RequestDto getRequestById(@RequestParam String id) {
        return requestService.getRequestById(id);
    }

    @PostMapping(produces = "application/json", consumes = "application/json", path = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    public RequestDto createRequest(@RequestBody RequestDto requestDto) {
        return requestService.createRequest(requestDto);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    @ResponseBody
    public RequestDto editRequestById(@RequestParam String id, @RequestBody RequestDto requestDto) {
        return requestService.updateRequestById(id, requestDto);
    }
}
