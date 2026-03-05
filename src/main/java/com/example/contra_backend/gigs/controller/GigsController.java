package com.example.contra_backend.gigs.controller;

import com.example.contra_backend.gigs.models.Gig;
import com.example.contra_backend.gigs.services.GigsServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dev1/gigs")
public class GigsController {

    private final GigsServices gigsServices;

    public GigsController(GigsServices gigsServices) {
        this.gigsServices = gigsServices;
    }

    @GetMapping
    List<Gig> findAll() {
        return gigsServices.findAll();
    }

    @GetMapping("/near")
    List<Gig> findNearest(
            @RequestParam Double lon,
            @RequestParam Double lat,
            @RequestParam(required = false) Double km
            ) {
        return gigsServices.findNearestRequested(lon, lat, km);
    }

    @PostMapping
    Gig saveGig(@RequestBody Gig gig) {
        return gigsServices.saveGig(gig);
    }                                                  

    @DeleteMapping("/{id}")
    void deleteGig(@PathVariable String id) {
        gigsServices.deleteGig(id);
    }
}
