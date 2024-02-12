package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Animal {
    private String name;
    private LocalDate birthday;
}