package be.common.xrequest.service;

import be.common.xrequest.mapper.RequestMapper;
import be.common.xrequest.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

@Autowired
    public RequestService(RequestRepository repo, RequestMapper mapper){

}
}
