package org.example.Sem_3.Sem;

import java.util.Iterator;
import java.util.List;

public class Program3<T> implements Iterator<T> {

    private List<T> list;
    private int index;

    public Program3(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }

    @Override
    public void remove() {
        list.remove(index -1);
    }
}
