package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Iterator;



class AddNtimesTest {
    /*
    Clases de equivalencia
    AddNTimes:
    Valores de Element:
    'A', 'B', 'M', 'Y', 'Z'
    Valores de times:
    -1, 1
    */
    static AbstractSingleLinkedListImpl<String> list;


    @BeforeEach
    void setUp() {
        list = new SingleLinkedListImpl<>();
    }

    @DisplayName("AddNTimes | Elementos válidos | Veces válidas")
    @ParameterizedTest
    @CsvSource({
            "A,1", "B,1", "M,1", "Y,1", "Z,1",
            "A,10", "B,10", "M,10", "Y,10", "Z,10"
    })
    void validElementNTimes(String element, String times) {
        int limit = Integer.parseInt(times);
        list.addNTimes(element, limit);
        Iterator<String> it = list.iterator();
        for (int i = 0; i < limit && it.hasNext(); i++) {
            Assertions.assertEquals(element, it.next());
        }
    }

    @DisplayName("AddNTimes | Elementos válidos | Veces inválidas")
    @ParameterizedTest
    @CsvSource({
            "A,0", "B,0", "M,0", "Y,0", "Z,0",
            "A,-1", "B,-1", "M,-1", "Y,-1", "Z,-1"
    })
    void validElementInvalidTimes(String element, String times) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.addNTimes(element, Integer.parseInt(times)));
    }

    @DisplayName("AddNTimes | Elementos inválidos | Veces válidas")
    @ParameterizedTest
    @CsvSource({
            "@,1", "[,1",
            "@,10", "[,10"
    })
    void invalidElementValidTimes(String element, String times) {
        int limit = Integer.parseInt(times);
        list.addNTimes(element, limit);
        Iterator<String> it = list.iterator();
        for (int i = 0; i < limit && it.hasNext(); i++) {
            Assertions.assertEquals(element, it.next());
        }
    }

    @DisplayName("AddNTimes | Elementos inválidos | Veces inválidas")
    @ParameterizedTest
    @CsvSource({
            "@,0", "[,0",
            "@,-1", "[,-1"
    })
    void invalidElementInvalidTimes(String element, String times) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.addNTimes(element, Integer.parseInt(times)));
    }
}
