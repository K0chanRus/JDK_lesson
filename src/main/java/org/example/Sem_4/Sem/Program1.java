package org.example.Sem_4.Sem;

import java.util.*;

public class Program1 {
    public static void sortByAlphabet(List<String> list){
        Collections.sort(list);
    }

    public static void sortByLength(List<String> list){
        list.sort(Comparator.comparing(String::length));
    }

    public static void reversList(List<String> list){
        Collections.reverse(list);
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Ivan", "Sergey", "Aleksandr", "Irina", "Svetlana"));
        sortByAlphabet(names);
        System.out.println(names);
        sortByLength(names);
        System.out.println(names);
        reversList(names);
        System.out.println(names);
    }
}
