package com.example.contra_backend.users.Repository;

import com.example.contra_backend.users.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
