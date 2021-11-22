package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


public class AddLastTest {

    /**
     * ----------- BORRAR ESTO ANTES DE LA ENTREGA --------------
     *
     * -- Clases de equivalencia 'AddLast' --
     *
     * "public abstract void addLast(T element)"
     *
     *
     * 'element':
     *
     * · Clases de equivalencia válidas:
     * E1 = {element: 'A' <= element <= 'Z'}
     *
     * · Clases de equivalencia no válidas:
     * E2 = {element: element < 'A'}
     * E3 = {element: element > 'Z'}
     * */

    /**
     *
     */

    static SingleLinkedListImpl<String> list;

    @BeforeAll
    static void init() {
        list = new SingleLinkedListImpl<>();
    }

    @DisplayName("Test valores válidos")
    @ParameterizedTest
    @MethodSource(value = "validData")
    void addLastValidCases(String element, String result) {
        list.addLast(element);
        Assertions.assertEquals(result, list.getAtPos(list.size()));
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
    void addLastInvalidCases(String element, String result) {
        list.addLast(element);
        Assertions.assertNotEquals(result, list.getAtPos(list.size()));
    }

    static String[][] invalidData() {
        return new String[][]{
                {"@", "@"},
                {"[", "["}
        };
    }
}
