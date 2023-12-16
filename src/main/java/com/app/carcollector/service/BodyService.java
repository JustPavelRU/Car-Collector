package com.app.carcollector.service;

import com.app.carcollector.entity.Body;
import com.app.carcollector.entity.Wheel;
import com.app.carcollector.repository.BodyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BodyService {

    private final BodyRepository bodyRepository;

    public Body createBody(Body body) {
        return bodyRepository.save(Body.builder()
                .bodyType(body.getBodyType())
                .color(body.getColor())
                .build());
    }

    public Body getBodyById(Long id) {
        return bodyRepository.findById(id).orElseThrow();
    }

}
