package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class AddFirstTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void init() {
        list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F", "G");
    }

    @Test
    @DisplayName("Test añadir válidos")
    @ParameterizedTest
    @MethodSource(value = "validData")
    void addFirstValid(String element,String result) {
        list.addFirst(element);
        Assertions.assertEquals(result,list.getAtPos(1));
    }

    static String[][] validData() {
        return new String[][]{
                {"A", "A"},
                {"B", "B"},
                {"M", "M"},
                {"Y", "Y"},
                {"Z", "Z"}
        };
    }


    @DisplayName("Test valores inválidos")
    @ParameterizedTest
    @MethodSource(value = "invalidData")
    void addFirstInvalid(String element, String result) {
        list.addFirst(element);
        Assertions.assertEquals(result,list.getAtPos(1));

    }

    @DisplayName("Test valor añadido valido")
    @ParameterizedTest
    @MethodSource(value = "validData")
    void addFirstVaciavalid(String element, String result){
        list = new SingleLinkedListImpl<>();
        list.addFirst(element);
        Assertions.assertEquals(result,list.getAtPos(1));
    }

    @DisplayName("Test valor añadido invalido")
    @ParameterizedTest
    @MethodSource(value = "invalidData")
    void addFirstVaciaInvalid(String element, String result){
        list = new SingleLinkedListImpl<>();
        list.addFirst(element);
        Assertions.assertEquals(result,list.getAtPos(1));
    }
    static String[][] invalidData() {
        return new String[][]{
                {"@", "@"},
                {"[", "["}
        };
    }


}
