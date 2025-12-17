package com.example.servicecar.repositories;

import com.example.servicecar.entities.Car;
import com.example.servicecar.entities.Client;
import com.example.servicecar.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarRepository carRepository;
    private final WebClient.Builder webClientBuilder;

    public CarController(CarRepository carRepository, WebClient.Builder webClientBuilder) {
        this.carRepository = carRepository;
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping
    public List<Car> findAll() {
        List<Car> cars = carRepository.findAll();

        // Pour chaque voiture, on va chercher le client via le microservice
        for (Car car : cars) {
            if(car.getClientId() != null) {
                Client c = webClientBuilder.build()
                        .get()
                        .uri("http://SERVICE-CLIENT/api/clients/" + car.getClientId())
                        .retrieve()
                        .bodyToMono(Client.class)
                        .block(); // Appel bloquant
                car.setClient(c);
            }
        }
        return cars;
    }

    @PostMapping
    public Car save(@RequestBody Car car) {
        return carRepository.save(car);
    }
}