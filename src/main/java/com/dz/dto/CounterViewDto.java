package com.dz.dto;

import com.dz.models.CounterView;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CounterViewDto {
    Integer all;
    Integer unique;
    Integer permanent;

    public static CounterViewDto from(CounterView counterView){
        return CounterViewDto.builder()
                .unique(counterView.getUnique())
                .permanent(counterView.getPermanent())
                .all(counterView.getAll())
                .build();
    }
}
