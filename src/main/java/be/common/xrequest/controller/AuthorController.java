package be.common.xrequest.controller;

import be.common.xrequest.domain.author.dto.AuthorDto;
import be.common.xrequest.service.XRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(path = "/xrequests/authors")
public class AuthorController {

    XRequestService xRequestService;

    @Autowired
    public AuthorController(XRequestService xRequestService) {
        this.xRequestService = xRequestService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDto> getAuthors(){
        return xRequestService.getAuthors();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseBody
    public AuthorDto getAuthorById(@PathVariable String id) {
        return xRequestService.getAuthor(id);
    }

    @PostMapping(produces = "application/json", consumes = "application/json", path = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto createRequest(@RequestBody AuthorDto authorDto) {
        return xRequestService.createAuthor(authorDto);
    }
}
