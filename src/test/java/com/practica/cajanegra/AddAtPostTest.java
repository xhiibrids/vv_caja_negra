package com.practica.cajanegra;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

public class AddAtPostTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void setup() {
        list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F", "G");
    }


    @DisplayName("addAtPos valid cases")
    @ParameterizedTest()
    @MethodSource("perValidGenerator")
    void addAtPos(int position, String elem,String result){
            list.addAtPos(elem,position);
            Assertions.assertEquals(result,list.getAtPos(position));
    }
    static Stream<Arguments> perValidGenerator(){
        return Stream.of(
                arguments(1,"A","A"),
                arguments(1,"B","B"),
                arguments(1,"K","K"),
                arguments(1,"Y","Y"),
                arguments(1,"Z","Z"),

                arguments(2,"A","A"),
                arguments(2,"B","B"),
                arguments(2,"K","K"),
                arguments(2,"Y","Y"),
                arguments(2,"Z","Z"),

                arguments(4,"A","A"),
                arguments(4,"B","B"),
                arguments(4,"K","K"),
                arguments(4,"Y","Y"),
                arguments(4,"Z","Z"),

                arguments(6,"A","A"),
                arguments(6,"B","B"),
                arguments(6,"K","K"),
                arguments(6,"Y","Y"),
                arguments(6,"Z","Z"),

                arguments(7,"A","A"),
                arguments(7,"B","B"),
                arguments(7,"K","K"),
                arguments(7,"Y","Y"),
                arguments(7,"Z","Z"),

                arguments(8,"A","A"),
                arguments(8,"B","B"),
                arguments(8,"K","K"),
                arguments(8,"Y","Y"),
                arguments(8,"Z","Z")

                );
    }
    @DisplayName("addAtPos insertar elementos en la posicion 0")
    @ParameterizedTest()
    @MethodSource("perInvalidGenerator")
    void addAtPosInvalid(int position, String elem,String result){
        Assertions.assertThrows(IllegalArgumentException.class ,() ->list.addAtPos(elem,position));
    }
    static Stream<Arguments> perInvalidGenerator(){
        return Stream.of(
                arguments(0,"A","A"),
                arguments(0,"B","B"),
                arguments(0,"K","K"),
                arguments(0,"Y","Y"),
                arguments(0,"Z","Z"),

                arguments(0,"@","@"),
                arguments(0,"[","[")
        );
    }

    @DisplayName("addAtPos  string fuera del dominio superior e inferior")
    @ParameterizedTest()
    @MethodSource("perOutGenerator")
    void addAtPosOut(int position, String elem,String result){
        int lastsize = list.size();
        list.addAtPos(elem,position);
        Assertions.assertNotEquals(result,list.getAtPos(position));
        Assertions.assertEquals(lastsize,list.size());

    }
    static Stream<Arguments> perOutGenerator(){
        return Stream.of(
                arguments(1,"@","@"),
                arguments(1,"[","["),
                arguments(2,"@","@"),
                arguments(2,"["," ["),
                arguments(4,"@","@"),
                arguments(4,"[","["),
                arguments(6,"@","@"),
                arguments(6,"[","["),
                arguments(7,"@","@"),
                arguments(7,"[","["),
                arguments(8,"@","@"),
                arguments(8,"[","[")
                );
    }




}
