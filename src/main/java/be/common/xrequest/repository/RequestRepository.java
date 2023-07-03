package be.common.xrequest.repository;

import be.common.xrequest.domain.request.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestRepository extends JpaRepository<Request, UUID> {

}
