package com.example.contra_backend.service.Repository;

import com.example.contra_backend.service.Model.Service;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicesRepository extends MongoRepository<Service, String> {
    Service findByService(String service);
}
