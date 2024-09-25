package org.example.Sem_4.Sem;

import java.util.*;
import java.util.stream.Collectors;

public class Program3 {

    public static String findByMinPhoneNumber(Map<String, String> phonebook){
        Set<Long> numbers = phonebook.keySet().stream().map(el -> Long.valueOf(el)).collect(Collectors.toSet());
        return String.valueOf(numbers.stream().min(Comparator.naturalOrder()).get());
    }

    public static String findByMaxAlphabetName(Map<String, String> phonebook){
        Set<Map.Entry<String, String>> elements = phonebook.entrySet();
        Map.Entry<String, String> name = elements.stream().max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())).get();
        return String.valueOf(name);
    }

    public static void main(String[] args) {
        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("79991004562", "Ivan");
        phonebook.put("79991008166", "Svetlana");
        phonebook.put("79991005917", "Irina");
        phonebook.put("79991003654", "Aleksandr");
        phonebook.put("79991003498", "Sergey");

        System.out.println("Min number " + findByMinPhoneNumber(phonebook));
        System.out.println("Max number " + findByMaxAlphabetName(phonebook));
    }
}
