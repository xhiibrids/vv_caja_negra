package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SizeTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void setup() {
        list = new SingleLinkedListImpl<>();
    }

    @Test
    void listaVacia() {
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void listaNoVacia() {
        list.addNTimes("test", 300);
        Assertions.assertEquals(300, list.size());

    }

}
