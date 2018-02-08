package api.repository;

import api.entities.RequestEntity;
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
    public void addRequest(RequestEntity request) {
        jdbcTemplate.update(
                "INSERT INTO requests (requestUrl, requestStartTime, requestEndTime) VALUES (?, ?, ?)",
                request.getRequestUrl(), request.getRequestStartTime(), request.getRequestEndTime());
    }

    @Override
    public List<RequestEntity> findAll() {
        return jdbcTemplate.query("SELECT * FROM requests", new BeanPropertyRowMapper(RequestEntity.class));
    }

    @Override
    public List<RequestEntity> findAllGetOkRequests() {
        return jdbcTemplate.query("SELECT * FROM requests WHERE requestUrl LIKE '%status/200'",
                new BeanPropertyRowMapper(RequestEntity.class));
    }

    @Override
    public List<RequestEntity> findAllRandomDelayRequests() {
        return jdbcTemplate.query("SELECT * FROM requests WHERE requestUrl LIKE '%delay%'",
                new BeanPropertyRowMapper(RequestEntity.class));
    }

    @Override
    public RequestEntity findByStartTime(String startTime) {
        return  (RequestEntity)jdbcTemplate
                .queryForObject(
                        String.format("SELECT * FROM requests WHERE requests.requestStartTime LIKE '%s'", startTime),
                new BeanPropertyRowMapper(RequestEntity.class));
    }
}
