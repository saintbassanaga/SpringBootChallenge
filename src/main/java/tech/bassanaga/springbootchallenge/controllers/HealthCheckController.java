package tech.bassanaga.springbootchallenge.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HealthCheckController {

    private static boolean isDown = false;

    @GetMapping("/health")
    public String healthCheck() {
        if (isDown) {
            return "Application is DOWN as of: " + LocalDateTime.now();
        }
        return "Application is running successfully!";
    }

    // A simple endpoint to toggle the health status
    @GetMapping("/toggle-health")
    public String toggleHealth(@RequestParam boolean status) {
        isDown = status;
        return "Application status set to: " + (status ? "DOWN" : "UP");
    }
}