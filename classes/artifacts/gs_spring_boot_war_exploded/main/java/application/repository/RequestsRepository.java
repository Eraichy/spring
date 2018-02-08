package application.repository;

import application.models.RequestModel;

import java.util.List;

public interface RequestsRepository {

    void addRequest(RequestModel request);

    List<RequestModel> findAll();

}
