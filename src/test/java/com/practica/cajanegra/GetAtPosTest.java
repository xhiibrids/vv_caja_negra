package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetAtPosTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void setup() {
        list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F", "G");
    }

    @Test
    void idxFueraDeLimites() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.getAtPos(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.getAtPos(list.size() + 1));
    }

    @Test
    void idxLimite() {
        Assertions.assertEquals("A", list.getAtPos(1));
        Assertions.assertEquals("G", list.getAtPos(list.size()));

        Assertions.assertEquals("B", list.getAtPos(2));
        Assertions.assertEquals("F", list.getAtPos(list.size() - 1));

        Assertions.assertEquals("D", list.getAtPos(4));
    }




}
