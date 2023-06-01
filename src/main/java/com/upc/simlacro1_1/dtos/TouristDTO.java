package com.upc.simlacro1_1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TouristDTO {
    private Long id;
    private String name;
    private Integer dni;
    private Integer age;
    private String status;
    private Integer salary;
    private String bag;

}
