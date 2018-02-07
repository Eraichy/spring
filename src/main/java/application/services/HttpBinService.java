package application.services;

import application.models.RequestModel;

public interface HttpBinService {

    RequestModel getStatusOk();

    RequestModel randomDelay();

    Iterable<RequestModel> getRequests();
}
