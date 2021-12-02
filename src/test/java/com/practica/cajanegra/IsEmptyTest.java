package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IsEmptyTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void setup() {
        list = new SingleLinkedListImpl<>();
    }

    @DisplayName("IsEmpty | Lista vacia")
    @Test
    void listaVacia() {
        Assertions.assertTrue(list.isEmpty());
    }

    @DisplayName("IsEmpty | Lista con algun elemento")
    @Test
    void listaNoVacia() {
        list.addLast("M");
        Assertions.assertFalse(list.isEmpty());
    }

}
