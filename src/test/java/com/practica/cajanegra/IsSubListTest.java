package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class IsSubListTest {


    /**
     * -------------- BORRAR ESTO ANTES DE LA ENTREGA ----------------
     * <p>
     * -- Clases de equivalencia 'IsSubList' --
     * <p>
     * "public abstract int isSubList(AbstractSingleLinkedListImpl<T> part)"
     * <p>
     * 'part':
     * <p>
     * · Clases de equivalencia válidas:
     * <p>
     * Borrador:
     * <p>
     * - Elemento no-lista
     * - Lista vacía
     * - Lista no-vacía
     * <p>
     * <p>
     * - Elemento no-lista
     * - Lista vacía
     * - Lista no-vacía:
     * -- Lista no-vacía es sublista
     * -- Lista no-vacía no es sublista
     * <p>
     * <p>
     * Casos de prueba:
     * 1. Lista vacía y Elemento que no es lista
     * 2. Lista no vacía --> valores límite en: sublista al principio, sublista en medio, sublista al final, sublista
     * parcial(por delante y por detrás), NO-sublista
     */

    static SingleLinkedListImpl<String> list;

    static Stream<Arguments> notEmptyList() {
        return Stream.of(
                /**Min*/
                arguments(new SingleLinkedListImpl<>("A", "B", "C"), 1),
                /**Inmediatamente después de min*/
                arguments(new SingleLinkedListImpl<>("B", "C", "D"), 2),
                /**Nominal*/
                arguments(new SingleLinkedListImpl<>("D", "E", "F"), 4),
                /**Inmediatamente antes de max*/
                arguments(new SingleLinkedListImpl<>("E", "F", "G"), 5),
                /**Max*/
                arguments(new SingleLinkedListImpl<>("F", "G", "H"), 6),
                /**Antes de min*/
                arguments(new SingleLinkedListImpl<>("W", "A", "B"), -1),
                /**Después de max*/
                arguments(new SingleLinkedListImpl<>("G", "H", "X"), -1),
                /**Sublista fuera del dominio*/
                arguments(new SingleLinkedListImpl<>("A", "C", "D", "E", "H"), -1)

        );
    }

    @BeforeEach
    void init() {
        list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F", "G", "H");
    }

    @DisplayName("Comprobar lista vacía")
    @Test
    void isEmptyList() {
        Assertions.assertEquals(0, list.isSubList(new SingleLinkedListImpl<>()));
    }

    @DisplayName("Comprobar elemento que no sea una lista")
    @Test
    void isNotList() {
        Assertions.assertEquals(0, list.isSubList(null));
    }

    @DisplayName("Comprobar casos de prueba para valores límite de sublistas no vacías")
    @ParameterizedTest
    @MethodSource(value = "notEmptyList")
    void notEmptyListWithCases(SingleLinkedListImpl<String> sublista, int result) {
        Assertions.assertEquals(result, list.isSubList(sublista));
    }

}
