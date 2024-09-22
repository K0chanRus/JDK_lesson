package org.example.DZ_3;

public class EqualityArrays {
    public static <T> boolean compareArrays(T[] array1,T[] array2){
        if (array1.length != array2.length){
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].getClass().equals(array2[i].getClass())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] array1 = {"Cat", "Dog", "Dog", "Cat"};
        String[] array2 = {"Cat", "Dog", "Dog", "Cat"};
        System.out.println(EqualityArrays.compareArrays(array1,array2));
    }
}
