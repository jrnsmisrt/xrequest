package be.common.xrequest.controller;

import be.common.xrequest.domain.place.dto.PlaceDto;
import be.common.xrequest.service.XRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(path = "/xrequests/places")
public class PlaceController {
    XRequestService XRequestService;

    @Autowired
    public PlaceController(XRequestService XRequestService) {
        this.XRequestService = XRequestService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<PlaceDto> getAllRequests() {
        return XRequestService.getPlaces();
    }

}
