package com.klef.soa.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.exam.entity.HomeCleaningBookingEntity;
import com.klef.soa.exam.service.HomeCleaningBookingService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/homecleaningbooking")
public class HomeCleaningBookingController {

    @Autowired
    private HomeCleaningBookingService service;

    @GetMapping("/")
    public String home() {
        return "Home Cleaning Booking Service Project";
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/instance")
    public String instance() {
        return "Home Cleaning Booking Service instance running on port: " + port;
    }

   
    @PostMapping("/add")
    public ResponseEntity<HomeCleaningBookingEntity> addHomeCleaning(
            @Valid @RequestBody HomeCleaningBookingEntity request) {

        return new ResponseEntity<>(
                service.addHomeCleaning(request),
                HttpStatus.CREATED);
    }

    @GetMapping("/displayAll")
    public ResponseEntity<List<HomeCleaningBookingEntity>> displayAll() 
    {
        return ResponseEntity.ok(service.getAllHomeCleaning());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {

        service.deleteHomeCleaning(id);

        return ResponseEntity.ok(
                "Home cleaning booking deleted successfully.");
    }
}
