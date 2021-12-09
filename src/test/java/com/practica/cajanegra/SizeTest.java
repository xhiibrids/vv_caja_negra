package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SizeTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void setup() {
        list = new SingleLinkedListImpl<>();
    }

    @DisplayName("SizeTest | Lista Vacia")
    @ParameterizedTest
    @CsvSource({ "0" })
    void listaVacia(String tamano) {
        Assertions.assertEquals(Integer.parseInt(tamano), list.size());
    }

    @DisplayName("SizeTest | Lista no vacia")
    @ParameterizedTest
    @CsvSource({ "A,300" })
    void listaNoVacia(String elemento, String veces) {
        list.addNTimes(elemento,Integer.parseInt(veces));
        Assertions.assertEquals(Integer.parseInt(veces), list.size());
    }

}
