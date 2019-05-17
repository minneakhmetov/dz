package com.dz.models;

import com.dz.dto.ViewDto;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class View {
    Long userId;
    String page;
    LocalDateTime time;

    public static View from(ViewDto dto, LocalDateTime dateTime){
        return View.builder()
                .page(dto.getPage())
                .userId(dto.getUserId())
                .time(dateTime)
                .build();
    }
}
