package com.dz.models;

import com.dz.dto.CounterViewDto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CounterView {
    Integer all;
    Integer unique;
    Integer permanent;

    public static CounterView from(CounterViewDto dto){
        return CounterView.builder()
                .unique(dto.getUnique())
                .permanent(dto.getPermanent())
                .all(dto.getAll())
                .build();
    }
}
