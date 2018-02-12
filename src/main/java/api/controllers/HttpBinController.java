package api.controllers;

import api.entities.RequestEntity;
import api.scheduler.TaskScheduler;
import api.tasks.DelayTask;
import api.tasks.GetStatusOkTask;
import api.services.HttpBinServiceImpl;
import api.services.HttpBinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping(path="/httpBin")
public class HttpBinController {

    @Autowired
    private HttpBinService httpBinService = new HttpBinServiceImpl();

    @Autowired
    private TaskScheduler scheduler;

    @RequestMapping("/getRequests")
    public ResponseEntity<List<RequestEntity>> getRequests() {
        return new ResponseEntity<>(httpBinService.getRequests(), HttpStatus.OK);
    }

    @RequestMapping("/getAllGetOkRequests")
    public ResponseEntity<List<RequestEntity>> getAllGetOkRequests() {
        return new ResponseEntity<>(httpBinService.getAllGetOkRequests(), HttpStatus.OK);
    }

    @RequestMapping("/getAllDelayRequests")
    public ResponseEntity<List<RequestEntity>> getAllDelayRequests() {
        return new ResponseEntity<>(httpBinService.getAllDelayRequests(), HttpStatus.OK);
    }

    @RequestMapping("/getStatusOkLoad")
    public ResponseEntity getStatusOkLoad(@RequestParam("requestsPerMin") int requestsPerMin) {
        scheduler.scheduleAtFixedRate(new GetStatusOkTask(httpBinService), 60000 / requestsPerMin);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/getDelayLoad")
    public ResponseEntity getDelayLoad(@RequestParam("requestsPerMin") int requestsPerMin) {
        scheduler.scheduleAtFixedRate(new DelayTask(httpBinService), 60000 / requestsPerMin);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/stopTasks")
    public ResponseEntity stopTasks() {
        scheduler.stopTasks();
        return new ResponseEntity(HttpStatus.OK);
    }
}
