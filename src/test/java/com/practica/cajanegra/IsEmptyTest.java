package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IsEmptyTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void setup() {
        list = new SingleLinkedListImpl<>();
    }


    @Test
    void listaVacia() {
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    void listaNoVacia() {
        list.addLast("hola");
        Assertions.assertFalse(list.isEmpty());
    }

}
