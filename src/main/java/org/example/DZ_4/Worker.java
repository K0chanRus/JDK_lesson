package org.example.DZ_4;

import java.util.Map;

public class Worker {
    public Integer number;
    public Integer phone;
    public String name;
    public Integer experience;

    public Worker(Integer number, Integer phone, String name, Integer experience) {
        this.number = number;
        this.phone = phone;
        this.name = name;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Табельный = [" + number + "]" +
                ", Телефон = " + phone +
                ", Имя = '" + name + '\'' +
                ", Стаж = {" + experience + "}";
    }
}
