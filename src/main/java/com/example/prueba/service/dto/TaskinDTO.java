package com.example.prueba.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskinDTO {
    private String Title;
    private String Description;
    private LocalDateTime eta;

}
