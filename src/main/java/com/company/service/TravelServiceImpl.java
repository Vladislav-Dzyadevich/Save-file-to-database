package com.company.service;

import com.company.dto.TravelDto;
import com.company.entity.Travel;
import com.company.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {
    @Autowired
    private TravelRepository travelRepository;

    @Override
    public void addTravel(TravelDto travelDto) {
        Travel travel = new Travel();
        travel.setCity(travelDto.getCity());
        travel.setCountry(travelDto.getCountry());
        travel.setContinent(travelDto.getContinent());
        travel.setYearOfVisit(travelDto.getYearOfVisit());
        travelRepository.save(travel);
    }

    @Override
    public List<Travel> showTravel() {
        return travelRepository.findAll();
    }
}
