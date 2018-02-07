package application.configuration;

import application.repository.RequestsRepository;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = RequestsRepository.class)
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "http_bin_requests_db";
    }

    @Override
    public Mongo mongo() {
        return new MongoClient("127.0.0.1", 27017);
    }

//    @Override
//    protected String getMappingBasePackage() {
//        return "application.repository";
//    }

}
