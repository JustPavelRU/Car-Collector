package com.app.carcollector.service;

import com.app.carcollector.entity.Car;
import com.app.carcollector.entity.Wheel;
import com.app.carcollector.repository.WheelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WheelService {

    private final WheelRepository wheelRepository;

    public Wheel createWheel(Wheel wheel) {
        return wheelRepository.save(Wheel.builder()
                .wheelRadius(wheel.getWheelRadius())
                .manufactureName(wheel.getManufactureName())
                .build());
    }

    public Wheel getWheelById(Long id) {
        return wheelRepository.findById(id).orElseThrow();
    }

}
