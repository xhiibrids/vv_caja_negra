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

    private static SingleLinkedListImpl<String> list,listoneelement,listtwoelement;


    @Test
    void reverse() {
        list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F", "G");
        Assertions.assertEquals("[G, F, E, D, C, B, A]",list.reverse().toString());
        Assertions.assertEquals("[A, B, C, D, E, F, G]",list.toString());




    }
    @Test
    void reverseoneelement(){
        listoneelement=  new SingleLinkedListImpl<>("A");
        Assertions.assertEquals("[A]",listoneelement.reverse().toString());
        Assertions.assertEquals("[A]",listoneelement.toString());
    }

    @Test
    void resversetwoelements(){

        listtwoelement =  new SingleLinkedListImpl<>("A","B");
        Assertions.assertEquals("[B, A]",listtwoelement.reverse().toString());
        Assertions.assertEquals("[A, B]",listtwoelement.toString());

    }
    @Test
    void reverseempty() {
        list = new SingleLinkedListImpl<>();
        Assertions.assertEquals("[]",list.reverse().toString());
        Assertions.assertEquals("[]",list.toString());

    }



}
