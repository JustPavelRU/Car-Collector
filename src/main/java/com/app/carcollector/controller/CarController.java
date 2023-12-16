package com.app.carcollector.controller;

import com.app.carcollector.dto.CarDTO;
import com.app.carcollector.entity.Body;
import com.app.carcollector.entity.Car;
import com.app.carcollector.entity.Wheel;
import com.app.carcollector.exceptions.NoBodyException;
import com.app.carcollector.exceptions.NoWheelException;
import com.app.carcollector.exceptions.NotEnoughWheelsException;
import com.app.carcollector.service.BodyService;
import com.app.carcollector.service.CarService;
import com.app.carcollector.service.WheelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
public class CarController {

    private final CarService carService;
    private final WheelService wheelService;
    private final BodyService bodyService;



    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody CarDTO dto) {

        Wheel wheel = null;
        Body body = null;

        try {
            wheel = new ResponseEntity<>(wheelService.getWheelById(dto.getWheelId()), HttpStatus.OK).getBody();
            body = new ResponseEntity<>(bodyService.getBodyById(dto.getBodyId()), HttpStatus.OK).getBody();
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (dto.getWheelsCount() < 2) throw new NotEnoughWheelsException("Not enough wheel!");

        return new ResponseEntity<>(carService.createCar(body, wheel, dto.getWheelsCount()), HttpStatus.OK);
    }

    @GetMapping("/bodies")
    public ResponseEntity<List<Body>> getAllCarBody() {
        return new ResponseEntity<>(carService.getAllCarBody(), HttpStatus.OK);
    }

    @GetMapping("/wheels")
    public ResponseEntity<List<Wheel>> getAllCarWheels() {
        return new ResponseEntity<>(carService.getAllCarWheels(), HttpStatus.OK);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/car {id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @GetMapping("/wheel {id}")
    public ResponseEntity<Wheel> getWheelById(@PathVariable Long id) {
        return new ResponseEntity<>(wheelService.getWheelById(id), HttpStatus.OK);
    }

}
