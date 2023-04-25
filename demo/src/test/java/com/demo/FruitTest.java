package com.demo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTest {

    @MockBean
    List<Fruit> fruitListFromTxt =  FruitStub.readFile();

    @Test
    public void only_green_fruits_test(){
        List<Fruit> greenFruits = fruitListFromTxt.stream().filter(it -> it.getColor().equalsIgnoreCase("GREEN")).collect(Collectors.toList());
        Assert.assertTrue(greenFruits.size() == 2);
    }

    @Test
    public void count_calories_fruits_test(){
        int totalCalories = fruitListFromTxt.stream().map(it -> it.getCalories()).reduce(0, (a, b) -> a + b);

        int totalCalories2 = fruitListFromTxt.stream().mapToInt(n -> n.getCalories()).sum();

        Assert.assertEquals(totalCalories, totalCalories2 );
    }

    @Test
    public void color_ordered_fruits_test(){
        List<String> distinctColorAscOrderedFruit = fruitListFromTxt.stream().map(f -> f.getColor()).sorted().distinct().collect(Collectors.toList());
        List<String> colorTest = Arrays.asList("Blue", "Green", "Orange","Red", "Yellow");
        Assert.assertEquals(distinctColorAscOrderedFruit, colorTest);
    }

    @Test
    public void limit_calories_fruits_test(){
        List<Fruit> limitCaloriesFruit = fruitListFromTxt.stream().filter( f -> f.getCalories() < 100).limit(3).collect(Collectors.toList());
        Assert.assertEquals(limitCaloriesFruit.size(), 3);
    }

    @Test
    public void max_calories_fruit_test(){
        Fruit hiperCalorieFruit = fruitListFromTxt.stream().max((a,b) -> a.getCalories() - b.getCalories()).get();
        Assert.assertEquals(hiperCalorieFruit.getCalories(), 109);
    }



}
