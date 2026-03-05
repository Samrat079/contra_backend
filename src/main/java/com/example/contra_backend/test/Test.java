package com.example.contra_backend.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("test")
public class Test {
    @Id
    private String id;
    private String username;

    @Indexed(unique = true)
    private String phone_no;
}
