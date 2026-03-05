package com.example.contra_backend.service.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "services")
public class Service {

    @Id
    private String id;
    private String service;

}
