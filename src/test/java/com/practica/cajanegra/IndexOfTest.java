package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class IndexOfTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void init() {
        list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F", "G");
    }

    @Test
    @DisplayName("Test válidos")
    void IndexOfValid(){
        String [] prueba={"A", "B", "C", "D", "E", "F", "G"};
        int [] result={1,2,3,4,5,6,7};
        for(int i=0; i<prueba.length;i++){
            Assertions.assertEquals(result[i],list.indexOf(prueba[i]));
        }
    }

    @Test
    @DisplayName("Test inválidos")
    void IndexOfInvalid() {
        Assertions.assertThrows(java.util.NoSuchElementException.class, () -> list.indexOf("H"));
        list = new SingleLinkedListImpl<>();
        Assertions.assertThrows(java.util.NoSuchElementException.class, () -> list.indexOf("A"));
    }
}
