package com.app.carcollector.dto;

import com.app.carcollector.entity.Body;
import com.app.carcollector.entity.Wheel;
import lombok.Data;

@Data
public class CarDTO {

    private Long id;
    private Long bodyId;
    private Long wheelId;
    private int wheelsCount;

}
