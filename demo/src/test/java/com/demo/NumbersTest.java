package com.demo;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersTest {
    @Test
    public static void  sumOfEvensTest(){
        final IntPredicate evens = i -> i % 2 == 0;
        final IntPredicate odd = evens.negate();

        //Even sum
        long evenSum = IntStream.rangeClosed(0,10).filter(evens).sum(); // 2+4+6+8+10 = 30
        long oddSum = IntStream.rangeClosed(0,10).filter(odd).sum(); // 1+3+5+7+9 = 25

        Assert.assertEquals(30, evenSum);
        Assert.assertEquals(25, oddSum);

    }

}
