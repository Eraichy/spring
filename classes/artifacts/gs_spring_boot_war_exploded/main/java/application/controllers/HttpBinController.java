package application.controllers;

import application.entities.RequestEntity;
import application.services.HttpBinServiceImpl;
import application.services.HttpBinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping(path="/httpBin")
public class HttpBinController {

    @Autowired
    private HttpBinService httpBinService = new HttpBinServiceImpl();

    @RequestMapping("/getStatusOk")
    public ResponseEntity<RequestEntity> getStatusOk() {
        return new ResponseEntity<>(httpBinService.getStatusOk(), HttpStatus.OK);
    }

    @RequestMapping("/randomDelay")
    public ResponseEntity<RequestEntity> randomDelay() {
        return new ResponseEntity<>(httpBinService.randomDelay(), HttpStatus.OK);
    }

    @RequestMapping("/getRequests")
    public ResponseEntity<List<RequestEntity>> getRequests() {
        return new ResponseEntity<>(httpBinService.getRequests(), HttpStatus.OK);
    }
}
