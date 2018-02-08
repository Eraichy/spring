package application.repository;

import application.models.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("requestsRepository")
public class RequestsRepositoryImpl implements RequestsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addRequest(RequestModel request) {
        jdbcTemplate.update(
                "INSERT INTO requests (requestUrl, requestStartTime, requestEndTime) VALUES (?, ?, ?)",
                request.getRequestUrl(), request.getRequestStartTime(), request.getRequestEndTime());
    }

    @Override
    public List<RequestModel> findAll() {
        return jdbcTemplate.query("SELECT * FROM requests", new BeanPropertyRowMapper(RequestModel.class));
    }
}
