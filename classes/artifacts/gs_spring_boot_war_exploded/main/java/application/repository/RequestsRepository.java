package application.repository;

import application.models.RequestModel;
import org.springframework.data.mongodb.repository.MongoRepository;
//
//import application.models.RequestModel;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository

public interface RequestsRepository extends MongoRepository<RequestModel, String> {
}
