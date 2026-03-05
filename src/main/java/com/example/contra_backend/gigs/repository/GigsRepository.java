package com.example.contra_backend.gigs.repository;

import com.example.contra_backend.gigs.models.Gig;
import com.example.contra_backend.gigs.models.GigStatus;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.Instant;
import java.util.List;

public interface GigsRepository extends MongoRepository<Gig, String> {
    void deleteByStatusAndUpdatedAtBefore(GigStatus status, Instant time);


    List<Gig> findByStatusAndLocationNear(GigStatus status, Point location, Distance distance);
}