package com.practica.cajanegra;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
public class AddAtPostTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void setup() {
        list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F", "G");
    }

    @Test
     void addAtPosIndex0(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> list.addAtPos("Z",0));
    }
    @Test
    void addAtPosIndex1(){
        list.addAtPos("Z",1);
        Assertions.assertEquals("Z",list.getAtPos(1));
    }
    @Test
    void addAtPosIndexN(){
        list.addAtPos("Z", list.size());
        Assertions.assertEquals("Z",list.getAtPos(list.size()));
    }

}
