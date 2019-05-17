package com.dz.services;

import com.dz.dto.CounterViewDto;
import com.dz.dto.ViewDto;
import com.dz.repositories.CounterRepository;
import com.dz.repositories.ViewRepository;
import com.dz.repositories.async.SaveThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static com.dz.models.View.from;

@Component
public class ViewService {

    @Autowired
    private CounterRepository counterRepository;

    @Autowired
    private ViewRepository viewRepository;

    public CounterViewDto getDayView(ViewDto dto){
        new SaveThread(viewRepository, from(dto, LocalDateTime.now())).start();
        return CounterViewDto.from(counterRepository.getDayViews(dto.getPage()));
    }

    public CounterViewDto getIntervalView(LocalDateTime start, LocalDateTime end){
        return CounterViewDto.from(counterRepository.getIntervalViews(Timestamp.valueOf(start), Timestamp.valueOf(end)));
    }

}
