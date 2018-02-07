package application.services;

import application.models.RequestModel;
import application.repository.RequestsRepository;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.util.Random;

import static application.helpers.ApplicationProperties.getProperty;

@Service("httpBinService")
public class HttpBinServiceImpl implements HttpBinService {

    @Autowired
    private RequestsRepository requestsRepository;

    private static final String HTTP_BIN_URL = getProperty("http.bin.url");

    public RequestModel getStatusOk() {
        HttpClient client = new HttpClient();
        GetMethod getMethod = new GetMethod(HTTP_BIN_URL + "/status/200");

        RequestModel request = new RequestModel();
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
        requestsRepository.save(request);
        return request;
    }

    public RequestModel randomDelay() {
        HttpClient client = new HttpClient();
        GetMethod getMethod = getRandomDelayMethod();

        RequestModel request = new RequestModel();
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
        requestsRepository.save(request);
        return request;
    }

    @Override
    public Iterable<RequestModel> getRequests() {
        return requestsRepository.findAll();
    }

    private GetMethod getRandomDelayMethod()
    {
        Random random = new Random();
        int delay = random.nextInt(5) + 1;
        return new GetMethod(String.format(HTTP_BIN_URL + "/delay/%s", delay));
    }
}
