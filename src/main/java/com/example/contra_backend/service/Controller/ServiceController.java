package com.example.contra_backend.service.Controller;

import com.example.contra_backend.service.Model.Service;
import com.example.contra_backend.service.Repository.ServicesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dev1/services")
public class ServiceController {

    private final ServicesRepository servicesRepository;

    public ServiceController(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    @GetMapping
    public List<Service> getAll(){
        return servicesRepository.findAll();
    }
    @PostMapping
    public Service addService(@RequestBody Service service){
        return servicesRepository.save(service);
    }

    @DeleteMapping("/{service}")
    public void deleteService(@PathVariable String service) {
        Service temp_service = servicesRepository.findByService(service);
        servicesRepository.deleteById(temp_service.getId());
    }
}
