package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GetAtPosTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void setup() {
        list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F", "G");
    }

    @DisplayName("GetAtPos | Parametro fuera de limites")
    @ParameterizedTest
    @CsvSource({ "0","8" })
    void idxFueraDeLimites(String posicion) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.getAtPos(Integer.parseInt(posicion)));
    }

    @DisplayName("GetAtPos | Parametro dentro de limites")
    @ParameterizedTest
    @CsvSource({ "1,A","7,G","2,B","6,F","4,D" })
    void idxLimite(String posicion, String elemento) {
        Assertions.assertEquals(elemento, list.getAtPos(Integer.parseInt(posicion)));
    }




}
