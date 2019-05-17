package com.dz.controllers;

import com.dz.dto.CounterViewDto;
import com.dz.dto.ViewDto;
import com.dz.services.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class RestApiController {

    @Autowired
    private ViewService viewService;

    @GetMapping("/page/{page-name}/user/{user-id}")
    public CounterViewDto createEvent(@PathVariable("page-name") String pageName, @PathVariable("user-id") Long userId){
        ViewDto viewDto = ViewDto.builder()
                .page(pageName)
                .userId(userId)
                .build();
        return viewService.getDayView(viewDto);
    }


    @PostMapping("/page/interval/")
    public CounterViewDto getInterval(@RequestParam("start") String start, @RequestParam("end") String end){
        return viewService.getIntervalView(LocalDateTime.parse(start), LocalDateTime.parse(end));
    }

}
