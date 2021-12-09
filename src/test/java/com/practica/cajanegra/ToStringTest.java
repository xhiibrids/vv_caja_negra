package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ToStringTest {

    private static SingleLinkedListImpl<String> list;

    @Test
    @DisplayName("Test toString con una lista vacía")
    void emptyList() {
        list = new SingleLinkedListImpl<>();
        Assertions.assertEquals("[]", list.toString());
    }

    @Test
    @DisplayName("Test toString con un solo elemento")
    void singleElementList() {
        list = new SingleLinkedListImpl<>("A");
        Assertions.assertEquals("[A]", list.toString());
    }

    @Test
    @DisplayName("Test toString con una lista de varios elementos")
    void variousElementsList() {
        list = new SingleLinkedListImpl<>("A", "B", "D", "W");
        Assertions.assertEquals("[A, B, D, W]", list.toString());
    }

}
