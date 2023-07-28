package be.common.xrequest.controller;

import be.common.xrequest.domain.author.dto.AuthorDto;
import be.common.xrequest.service.XRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(path = "/xrequests/authors")
public class AuthorController {

    XRequestService XRequestService;

    @Autowired
    public AuthorController(XRequestService XRequestService) {
        this.XRequestService = XRequestService;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseBody
    public AuthorDto getAuthorById(@PathVariable String id) {
        return XRequestService.getAuthor(id);
    }

    @PostMapping(produces = "application/json", consumes = "application/json", path = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto createRequest(@RequestBody AuthorDto authorDto) {
        return XRequestService.createAuthor(authorDto);
    }
}
