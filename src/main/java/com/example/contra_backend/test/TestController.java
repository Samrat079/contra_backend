package com.example.contra_backend.test;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dev1/test")
public class TestController {

    private final TestRepository testRepository;

    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping
    public List<Test> findAll(){
        return testRepository.findAll();
    }

    @PostMapping
    public Test saveTest(@RequestBody Test test){
        return testRepository.save(test);
    }

    @DeleteMapping("/{id}")
    public void deleteTest(@PathVariable String id){
        testRepository.deleteById(id);
    }
}
