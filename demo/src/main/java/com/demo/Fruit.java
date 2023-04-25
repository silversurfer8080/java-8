package com.demo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Fruit {
    private String name;
    private int calories;
    private String color;

}
