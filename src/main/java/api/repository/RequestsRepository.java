package api.repository;

import api.entities.RequestEntity;

import java.util.List;

public interface RequestsRepository {

    void addRequest(RequestEntity request);

    List<RequestEntity> findAll();

    List<RequestEntity> findAllGetOkRequests();

    List<RequestEntity> findAllRandomDelayRequests();

    RequestEntity findByStartTime(String startTime);

}
