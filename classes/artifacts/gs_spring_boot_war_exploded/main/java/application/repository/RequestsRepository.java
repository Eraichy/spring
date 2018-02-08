package application.repository;

import application.entities.RequestEntity;

import java.util.List;

public interface RequestsRepository {

    void addRequest(RequestEntity request);

    List<RequestEntity> findAll();

}
