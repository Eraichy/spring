package api.tasks;

import api.services.HttpBinService;

public class GetStatusOkTask implements Runnable {

    private HttpBinService httpBinService;

    public GetStatusOkTask(HttpBinService httpBinService) {
        this.httpBinService = httpBinService;
    }

    @Override
    public void run() {
        httpBinService.getStatusOk();
    }
}
