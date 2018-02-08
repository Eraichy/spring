package application.services;

import application.entities.RequestEntity;

import java.util.List;

public interface HttpBinService {

    RequestEntity getStatusOk();

    RequestEntity randomDelay();

    List<RequestEntity> getRequests();
}
