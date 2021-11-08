package com.practica.cajanegra;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

public class RemoveLastTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void setup() {
        list = new SingleLinkedListImpl<>();
    }

    @Test
    void elementoEnLista() throws EmptyCollectionException {
        String test = "TEST";
        list.addLast(test);
        Assertions.assertEquals(test, list.removeLast());
    }

    @Test
    void listaVacia() {
        Assertions.assertThrows(EmptyCollectionException.class, list::removeLast);
    }
}
