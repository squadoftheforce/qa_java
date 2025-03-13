package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class LionTest {
    private Feline feline;

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Test
    public void getKittensTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самец", feline);
        assertEquals("Метод getKittens должен возвращать значение из Feline", 5, lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", feline);
        assertEquals("Метод getFood должен возвращать рацион из Feline", expectedFood, lion.getFood());
    }

    @Test
    public void doesHaveManeForMaleTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue("У самца должна быть грива", lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeForFemaleTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse("У самки не должно быть гривы", lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeForInvalidSexTest() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Другое", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}