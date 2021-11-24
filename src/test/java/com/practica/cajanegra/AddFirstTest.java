package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class AddFirstTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void init() {
        list = new SingleLinkedListImpl<>("A","B","C");
    }


    @DisplayName("Test añadir válidos")
    @ParameterizedTest
    @MethodSource(value = "validData")
    void addFirstValid(String element,String result) {
        list.addFirst(element);
        Assertions.assertEquals(result,list.getAtPos(1));
    }
    @DisplayName("Test vacio añadir válidos")
    @ParameterizedTest
    @MethodSource(value = "validData")
    void addFirstEmptyValid(String element,String result) {
        list = new SingleLinkedListImpl<>();
        list.addFirst(element);
        String actual = list.toString();
        Assertions.assertEquals(result,actual);
    }
    static String[][] validData() {
        return new String[][]{
                {"J", "J"},
                {"B", "B"},
                {"M", "M"},
                {"Y", "Y"},
                {"Z", "Z"}
        };
    }

    @DisplayName("Test añadir inválidos")
    @ParameterizedTest
    @MethodSource(value = "invalidData")
    void addFirstInvalid(String element, String result) {
        list.addFirst(element);
        Assertions.assertNotEquals(result,list.getAtPos(1));

    }

    @DisplayName("Test vacio añadir inválidos")
    @ParameterizedTest
    @MethodSource(value = "invalidData")
    void addFirstEmptyInvalid(String element,String result) {
        list = new SingleLinkedListImpl<>();
        list.addFirst(element);
        String actual = list.toString();
        Assertions.assertNotEquals(result,actual);
    }

    static String[][] invalidData() {
        return new String[][]{
                {"@", "@"},
                {"[", "["}
        };
    }




}
