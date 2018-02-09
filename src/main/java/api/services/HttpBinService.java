package api.services;

import api.entities.RequestEntity;

import java.util.List;

public interface HttpBinService {

    RequestEntity getStatusOk();

    RequestEntity randomDelay();

    List<RequestEntity> getRequests();

    List<RequestEntity> getAllGetOkRequests();

    List<RequestEntity> getAllDelayRequests();

    void getStatusOkLoad(int rate, int period);
}
