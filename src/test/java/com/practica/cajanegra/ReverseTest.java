package com.practica.cajanegra;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

public class ReverseTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void setup() {
        list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F", "G");
    }

    @Test
    void reverse() {
        list.reverse();
        Assertions.assertEquals("[G, F, E, D, C, B, A]",list.reverse().toString());
    }
    @Test
    void reverseempty() {
        list = new SingleLinkedListImpl<>();
        list.reverse();
        Assertions.assertEquals("[]",list.reverse().toString());
    }



}
