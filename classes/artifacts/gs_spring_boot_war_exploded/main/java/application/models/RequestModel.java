package application.models;


import org.springframework.data.annotation.Id;
//import javax.persistence.*;
//
//@Entity
//@Table(name="requests")
public class RequestModel {

//    @Id
//    @Column(name="id")
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;

    private String requestUrl;

    private String requestStartTime;

    private String requestEndTime;

    public RequestModel() { }

    public RequestModel(String id, String requestUrl, String requestStartTime, String requestEndTime) {
        this.id = id;
        this.requestUrl = requestUrl;
        this.requestStartTime = requestStartTime;
        this.requestEndTime = requestEndTime;
    }

    public String getId() {
        return id;
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
