package com.example.contra_backend.gigs.services;

import com.example.contra_backend.gigs.models.Gig;
import com.example.contra_backend.gigs.models.GigStatus;
import com.example.contra_backend.gigs.repository.GigsRepository;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class GigsServices {
    private final GigsRepository gigsRepository;

    public GigsServices(GigsRepository gigsRepository) {
        this.gigsRepository = gigsRepository;
    }

    public List<Gig> findAll() {
        return gigsRepository.findAll();
    }

    public Gig saveGig(Gig gig) {
        return gigsRepository.save(gig);
    }

    public void deleteGig(String id) {
        gigsRepository.deleteById(id);
    }

    public List<Gig> findNearestRequested(Double lon, Double lat, Double km) {
        if (km == null) {km = 1.0;}
        Point point = new Point(lon, lat);
        Distance distance = new Distance(km, Metrics.KILOMETERS);
        return gigsRepository.findByStatusAndLocationNear(GigStatus.REQUESTED, point, distance);
    }

    @Scheduled(fixedDelay = 60000)
    public void deleteInactiveGig() {
        gigsRepository.deleteByStatusAndUpdatedAtBefore(
                GigStatus.REQUESTED,
                Instant.now().minusSeconds(6000)
        );
    }
}
