package org.example.Sem_3.Sem;

import java.util.ArrayList;
import java.util.Arrays;

public class Program2 <T>{
    private Object [] array;
    private int size;

    public Program2(int length) {
        this.array = new Object[length];
    }

    public void addToArray(T el){
        if (size >= array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = el;
    }
    public void delToArray(T el){
        for (int i = 0; i < size; i++ ){
            if (array[i].equals(el)){
                for (int j = i; j < size-1; j++){
                    array[j] = array[j +1];
                }
                break;
            }
        }
    }
}
