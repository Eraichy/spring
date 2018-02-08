package api.entities;

public class RequestEntity {
    private int id;

    private String requestUrl;

    private String requestStartTime;

    private String requestEndTime;

    public RequestEntity() { }

    public RequestEntity(int id, String requestUrl, String requestStartTime, String requestEndTime) {
        this.id = id;
        this.requestUrl = requestUrl;
        this.requestStartTime = requestStartTime;
        this.requestEndTime = requestEndTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestStartTime() {
        return requestStartTime;
    }

    public void setRequestStartTime(String requestStartTime) {
        this.requestStartTime = requestStartTime;
    }

    public String getRequestEndTime() {
        return requestEndTime;
    }

    public void setRequestEndTime(String requestEndTime) {
        this.requestEndTime = requestEndTime;
    }
}
