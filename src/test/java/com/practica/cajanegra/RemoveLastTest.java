package com.practica.cajanegra;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Executable;

public class    RemoveLastTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void setup() {
        list = new SingleLinkedListImpl<>();
    }

    @DisplayName("RemoveLastTest | Elemento presente en la lista")
    @ParameterizedTest
    @CsvSource({ "A" })
    void elementoEnLista(String elemento) throws EmptyCollectionException {
        list.addLast(elemento);
        Assertions.assertEquals(elemento, list.removeLast());
    }

    @DisplayName("RemoveLastTest | Lista vacia")
    @Test
    void listaVacia() {
        Assertions.assertThrows(EmptyCollectionException.class, list::removeLast);
    }
}
