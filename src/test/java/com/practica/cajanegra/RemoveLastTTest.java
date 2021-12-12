package com.practica.cajanegra;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.NoSuchElementException;

public class RemoveLastTTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void setup() {
        list = new SingleLinkedListImpl<>("A", "C", "B", "C", "D", "C", "B");
    }

    @DisplayName("RemoveLastTTest | Lista vacia")
    @ParameterizedTest
    @CsvSource({ "A" })
    void listaVacia(String elemento) {
        list = new SingleLinkedListImpl<>();
        Assertions.assertThrows(EmptyCollectionException.class, ()-> list.removeLast(elemento));
    }

    @DisplayName("RemoveLastTest | Elemento presente en la lista no vacia")
    @ParameterizedTest
    @CsvSource({ "D" })
    void elementoEnLista(String elemento) throws EmptyCollectionException {
        Assertions.assertEquals(elemento, list.removeLast(elemento));
    }

    @DisplayName("RemoveLastTest | Elemento no presente en la lista no vacia")
    @ParameterizedTest
    @CsvSource({ "E" })
    void elementoNoEnLista(String elemento) {
        Assertions.assertThrows(java.util.NoSuchElementException.class, () -> list.removeLast(elemento));
    }

}
