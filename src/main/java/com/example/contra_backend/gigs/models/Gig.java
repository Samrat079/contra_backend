package com.example.contra_backend.gigs.models;

import com.example.contra_backend.service.Model.Service;
import com.example.contra_backend.users.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "gigs")
public class Gig {

    @Id
    private String id;
    private Service service;
    private double fair;
    private GigStatus status;
    private User operator;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private List<Double> location;

    @LastModifiedDate
    private Instant updatedAt;

    @CreatedDate
    private Instant createdAt;

    @CreatedBy
    private User customer;
}
