package api.services;

import api.entities.RequestEntity;
import api.repository.RequestsRepository;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Random;

import static api.helpers.ApplicationProperties.getProperty;

@Service("httpBinService")
public class HttpBinServiceImpl implements HttpBinService {

    @Autowired
    private RequestsRepository requestsRepository;

    private static final String HTTP_BIN_URL = getProperty("http.bin.url");

    public RequestEntity getStatusOk() {
        HttpClient client = new HttpClient();
        GetMethod getMethod = new GetMethod(HTTP_BIN_URL + "/status/200");

        RequestEntity request = new RequestEntity();
        try {
            request.setRequestUrl(getMethod.getURI().toString());
        } catch (URIException e) {
            e.printStackTrace();
        }

        request.setRequestStartTime(Instant.now().toString());

        try {
            client.executeMethod(getMethod);
        } catch (IOException ignored) {}

        request.setRequestEndTime(Instant.now().toString());
        requestsRepository.addRequest(request);
        return requestsRepository.findByStartTime(request.getRequestStartTime());
    }

    public RequestEntity randomDelay() {
        HttpClient client = new HttpClient();
        GetMethod getMethod = getRandomDelayMethod();

        RequestEntity request = new RequestEntity();
        try {
            request.setRequestUrl(getMethod.getURI().toString());
        } catch (URIException e) {
            e.printStackTrace();
        }

        request.setRequestStartTime(Instant.now().toString());

        try {
            client.executeMethod(getMethod);
        } catch (IOException ignored) {}

        request.setRequestEndTime(Instant.now().toString());
        requestsRepository.addRequest(request);
        return requestsRepository.findByStartTime(request.getRequestStartTime());
    }

    @Override
    public List<RequestEntity> getRequests() {
        return requestsRepository.findAll();
    }

    @Override
    public List<RequestEntity> getAllGetOkRequests() {
        return requestsRepository.findAllGetOkRequests();
    }

    @Override
    public List<RequestEntity> getAllDelayRequests() {
        return requestsRepository.findAllDelayRequests();
    }

    private GetMethod getRandomDelayMethod()
    {
        Random random = new Random();
        int delay = random.nextInt(5) + 1;
        return new GetMethod(String.format(HTTP_BIN_URL + "/delay/%s", delay));
    }
}
