package org.example.DZ_3;

public class Pair <T, V>{
    private T value1;
    private V value2;

    public Pair(T value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T getFirst() {
        return value1;
    }

    public V getSecond() {
        return value2;
    }

    @Override
    public String toString(){
        return value1 + ", " + value2;
    }

    public static void main(String[] args) {
        String first = "Hello";
        Integer second = 007;
        Pair pair = new Pair(first, second);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        System.out.println(pair.toString());
    }
}
