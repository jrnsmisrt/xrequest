package be.common.xrequest.repository;

import be.common.xrequest.domain.request.XRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface XRequestRepository extends JpaRepository<XRequest, UUID> {

}
