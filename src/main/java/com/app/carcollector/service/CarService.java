package com.app.carcollector.service;

import com.app.carcollector.entity.Body;
import com.app.carcollector.entity.Car;
import com.app.carcollector.entity.Wheel;
import com.app.carcollector.repository.BodyRepository;
import com.app.carcollector.repository.CarRepository;
import com.app.carcollector.repository.WheelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final WheelRepository wheelRepository;
    private final WheelService wheelService;
    private final BodyRepository bodyRepository;
    private final BodyService bodyService;

    public Car createCar(Body body, Wheel wheel, int wheelsCount) {

        return carRepository.save(Car.builder()
                .body(body)
                .wheel(wheel)
                .wheelsCount(wheelsCount)
                .build());
    }

    public List<Body> getAllCarBody() {
        return bodyRepository.findAll();
    }

    public List<Wheel> getAllCarWheels() {
        return wheelRepository.findAll();
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow();
    }

}
