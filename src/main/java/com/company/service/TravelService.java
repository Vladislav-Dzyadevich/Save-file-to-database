package com.company.service;

import com.company.dto.TravelDto;
import com.company.entity.Travel;

import java.util.List;

public interface TravelService {
    void addTravel(TravelDto travelDto);
    List<Travel> showTravel();
}
