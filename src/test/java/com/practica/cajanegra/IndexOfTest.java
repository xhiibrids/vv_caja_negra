package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


public class IndexOfTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void init() {
        list = new SingleLinkedListImpl<>("A", "B", "M","Y","Z");
    }

    @Test
    @DisplayName("Test válidos sin duplicados")
    void indexOfValid(){
        String [] prueba={"A", "B", "M","Y","Z"};
        int [] result={1,2,3,4,5};
        for(int i=0; i<prueba.length;i++){
            Assertions.assertEquals(result[i],list.indexOf(prueba[i]));
        }
    }

    @ParameterizedTest
    @DisplayName("Test válidos con duplicados")
    @MethodSource(value = "validdata")
    void indexOfValidDuplicate(String pos,String element){
        list = new SingleLinkedListImpl<>("A","B","M","A","B","M","Y","Y","Z","Z");
        int result = Integer.parseInt(pos);
        Assertions.assertEquals(result,list.indexOf(element));
    }
    static String [][] validdata(){
        return new String[][]{
                {"1","A"},
                {"2","B"},
                {"3","M"},
                {"7","Y"},
                {"9","Z"}
        };
    }

    @Test
    @DisplayName("Test inválidos")
    void indexOfInvalid() {
        Assertions.assertThrows(java.util.NoSuchElementException.class, () -> list.indexOf("@"));
        Assertions.assertThrows(java.util.NoSuchElementException.class, () -> list.indexOf("["));
    }
}
