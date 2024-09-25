package org.example.Sem_4.Sem;

import java.util.*;

public class Program2 {

    public static Set<String> convertListToSet(List<String> list){
        return new HashSet<>(list);
    }

    public static String orderNames(Set<String> list){
        return list.stream().min(Comparator.naturalOrder()).orElse(null);
    }

    public static String minAndMaxLengthNames(Set<String> list){
        String min = list.stream().min(Comparator.comparing(String::length)).orElse(null);
        String max = list.stream().max(Comparator.comparing(String::length)).orElse(null);
        return "Max = " + max + " Min = " + min;
    }

    public static void removeNamesByChar (Set<String> list, String symbol){
        list.removeIf(name -> name.contains(symbol));
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Ivan", "Sergey", "Aleksandr", "Irina", "Svetlana", "Ivan", "Svetlana"));
        Set<String> setNames = convertListToSet(names);
        convertListToSet(names);
        System.out.println(names);
        System.out.println(setNames);
        System.out.println("Min name: " + orderNames(setNames));
        System.out.println(minAndMaxLengthNames(setNames));
        removeNamesByChar(setNames, "A");
        System.out.println(setNames);
    }
}
