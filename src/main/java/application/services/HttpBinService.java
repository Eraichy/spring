package application.services;

import application.models.RequestModel;

import java.util.List;

public interface HttpBinService {

    RequestModel getStatusOk();

    RequestModel randomDelay();

    List<RequestModel> getRequests();
}
