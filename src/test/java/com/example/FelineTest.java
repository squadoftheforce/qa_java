package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline felineSpy;

    @Before
    public void setUp() {
        felineSpy = Mockito.spy(new Feline());
    }

    @Test
    public void eatMeatShouldReturnCorrectFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.doReturn(expectedFood).when(felineSpy).getFood("Хищник");
        assertEquals(expectedFood, felineSpy.eatMeat());
    }
    
    @Test
    public void eatMeatShouldCallGetFood() throws Exception {
        felineSpy.eatMeat();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Метод getFamily должен возвращать Кошачьи", "Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        assertEquals("Метод getKittens должен возвращать 1", 1, feline.getKittens());
    }

    @Test
    public void getKittensTestWithArg() {
        Feline feline = new Feline();
        assertEquals("Метод getKittens(3) должен возвращать 3", 3, feline.getKittens(3));
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.getFood("Хищник"));
    }
}