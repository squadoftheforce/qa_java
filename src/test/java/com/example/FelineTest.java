package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = Mockito.spy(new Feline());
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.doReturn(expectedFood).when(feline).getFood("Хищник");
        assertEquals(expectedFood, feline.eatMeat());
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Метод getFamily должен возвращать Кошачьи","Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        assertEquals("Метод getKittens должен возвращать 1",1, feline.getKittens());
    }

    @Test
    public void getKittensTestWithArg() {
        assertEquals("Метод getKittens(3) должен возвращать 3",3, feline.getKittens(3));
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.getFood("Хищник"));
    }
}