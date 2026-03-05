package com.example.contra_backend.test;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<Test, String> {
}
