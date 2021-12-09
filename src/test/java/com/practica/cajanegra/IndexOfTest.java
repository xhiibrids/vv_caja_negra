package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class IndexOfTest {
    static SingleLinkedListImpl<String> list;

    @BeforeEach
    void init() {
        list = new SingleLinkedListImpl<>("A", "B", "M","Y","Z");
    }

    @Test
    @DisplayName("Test válidos sin duplicados")
    void IndexOfValid(){
        String [] prueba={"A", "B", "M","Y","Z"};
        int [] result={1,2,3,4,5};
        for(int i=0; i<prueba.length;i++){
            Assertions.assertEquals(result[i],list.indexOf(prueba[i]));
        }
    }
    @Test
    @DisplayName("Test válidos con duplicados")
    void IndexOfValidDuplicate(){
        list = new SingleLinkedListImpl<>("A","B","M","A","B","M","Y","Y","Z","Z");
        String [] prueba={"A","B","M","A","B","M","Y","Y","Z","Z"};
        int [] pos={1,2,3,7,9};
        Assertions.assertEquals(pos[0],list.indexOf(prueba[0]));
        Assertions.assertEquals(pos[1],list.indexOf(prueba[1]));
        Assertions.assertEquals(pos[2],list.indexOf(prueba[2]));
        Assertions.assertEquals(pos[0],list.indexOf(prueba[3]));
        Assertions.assertEquals(pos[1],list.indexOf(prueba[4]));
        Assertions.assertEquals(pos[2],list.indexOf(prueba[5]));
        Assertions.assertEquals(pos[3],list.indexOf(prueba[6]));
        Assertions.assertEquals(pos[3],list.indexOf(prueba[7]));
        Assertions.assertEquals(pos[4],list.indexOf(prueba[8]));
        Assertions.assertEquals(pos[4],list.indexOf(prueba[9]));
    }

    @Test
    @DisplayName("Test inválidos")
    void IndexOfInvalid() {
        Assertions.assertThrows(java.util.NoSuchElementException.class, () -> list.indexOf("@"));
        Assertions.assertThrows(java.util.NoSuchElementException.class, () -> list.indexOf("["));
        Assertions.assertThrows(java.util.NoSuchElementException.class, () -> list.indexOf("H"));
    }
}
