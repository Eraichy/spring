package api.tasks;

import api.services.HttpBinService;

public class DelayTask implements Runnable {

    private HttpBinService httpBinService;

    public DelayTask(HttpBinService httpBinService) {
        this.httpBinService = httpBinService;
    }

    @Override
    public void run() {
        httpBinService.randomDelay();
    }
}
