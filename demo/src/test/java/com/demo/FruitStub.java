package com.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitStub {

    private static String fileName = "src/test/java/resources/Fruits.csv";
    public static List<Fruit> readFile(){
        String line;
        List<Fruit> fruits = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            while ((line = bufferedReader.readLine()) != null){
                fruits.add(createFruitFromLine(line));
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return fruits;
    }

    public static Fruit createFruitFromLine(String line){
        String[] split = line.split(",");
        return new Fruit().builder()
                .name(split[0])
                .calories(Integer.valueOf(split[1]))
                .color(split[2])
                .build();
    }

}
