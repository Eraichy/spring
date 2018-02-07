package application.controllers;

import application.models.RequestModel;
import application.services.HttpBinServiceImpl;
import application.services.HttpBinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path="/httpBin")
public class HttpBinController {

    @Autowired
    private HttpBinService httpBinService = new HttpBinServiceImpl();

    @RequestMapping("/getStatusOk")
    public ResponseEntity<RequestModel> getStatusOk() {
        return new ResponseEntity<>(httpBinService.getStatusOk(), HttpStatus.OK);
    }

    @RequestMapping("/randomDelay")
    public ResponseEntity<RequestModel> randomDelay() {
        return new ResponseEntity<>(httpBinService.randomDelay(), HttpStatus.OK);
    }

    @RequestMapping("/getRequests")
    public ResponseEntity<Iterable<RequestModel>> getRequests() {
        return new ResponseEntity<>(httpBinService.getRequests(), HttpStatus.OK);
    }
}
