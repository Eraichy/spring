package api.repository;

import api.entities.RequestEntity;

import java.util.List;

public interface RequestsRepository {

    void addRequest(RequestEntity request);

    List<RequestEntity> findAll();

}
