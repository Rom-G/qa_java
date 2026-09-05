package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void eatMeatReturnsMockedFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> result = feline.eatMeat();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }

    @Test
    public void getFamilyReturnsFelineFamily() {
        String actualFamily = feline.getFamily();

        assertEquals("Кошачьи", actualFamily);
    }

    @Test
    public void getKittensNoArgInvokeGetKittensWith1() throws Exception {
        feline.getKittens();

        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithArgReturnsCount() throws Exception {
        int actualCount = feline.getKittens(3);

        assertEquals(3, actualCount);
    }

    @Test
    public void getKittensWithNegativeArgThrowException() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> feline.getKittens(-1));

        assertEquals("Количество котят не может быть отрицательным", exception.getMessage());
    }

}
