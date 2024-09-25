package org.example.DZ_4;

import java.util.*;

public class WorkersGuide {
    private Scanner scanner = new Scanner(System.in);
    private List<Worker> guide = new LinkedList<>();
    public WorkersGuide() {
        guide.add(new Worker(1,8999,"Ivan",6));
        guide.add(new Worker(3,8956,"Sergey",4));
        guide.add(new Worker(4,8912,"Sveta",8));
        guide.add(new Worker(6,8980,"Irina",1));
        String numberMenu = "";
        int x = 0;
        while (!"6".equals(numberMenu)){
            System.out.println("Справочник сотрудников");
            System.out.println("Выберите пункт меню");
            System.out.println("1. Показать список сотрудников");
            System.out.println("2. Добавить нового сотрудника");
            System.out.println("3. Найти номер телефона по имени");
            System.out.println("4. Найти сотрудника по табельному номеру");
            System.out.println("5. Найти сотрудника по стажу");
            System.out.println("6. Выйти из приложения");
            System.out.println("Введите пункт меню: ");
            numberMenu = scanner.nextLine();
            x = Integer.parseInt(numberMenu);
            switch (x){
                case 1:
                    viewWorkers();
                    break;
                case 2:
                    addNewWorker();
                    break;
                case 3:
                    findPhoneByName();
                    break;
                case 4:
                    findWorkerByNumber();
                    break;
                case 5:
                    findWorkerByExperience();
                    break;
            }
        }
    }

    public void viewWorkers(){

        System.out.println("Список сотрудников:");
        for (Worker worker : guide){
            System.out.println(worker);
        }
        System.out.println();
    }

    public void addNewWorker(){
        System.out.println("Добавление нового сотрудника.");
        System.out.println("Введите табельный номер:");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите телефон сотрудника:");
        int phone = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите имя сотрудника:");
        String name = scanner.nextLine();
        System.out.println("Введите стаж сотрудника:");
        int experience = Integer.parseInt(scanner.nextLine());
        guide.add(new Worker(number, phone, name, experience));
    }

    public void findPhoneByName(){
        System.out.println("Найти номер телефона по имени");
        System.out.println("Введите имя сотрудника:");
        String findName = scanner.nextLine();
        for (int i = 0; i < guide.size(); i++) {
            String element = String.valueOf(guide.get(i));
            if (element.contains(findName)) {
                System.out.println(element);
            }
        }
        System.out.println();
    }

    public void findWorkerByNumber(){
        String CH = "[";
        String CHend = "]";
        System.out.println("Найти сотрудника по табельному номеру");
        System.out.println("Введите табельный номер:");
        String findName = scanner.nextLine().trim();
        for (int i = 0; i < guide.size(); i++) {
            String element = String.valueOf(guide.get(i));
            int start = element.indexOf(CH) + 1;
            int end = element.lastIndexOf(CHend);
            String cut = element.substring(start,end).trim();
            if (findName.equals(cut)) {
                System.out.println(element);
            }
        }
        System.out.println();
    }

    public void findWorkerByExperience(){
        String CH = "{";
        String CHend = "}";
        System.out.println("Найти сотрудника по стажу");
        System.out.println("Введите стаж:");
        String findName = scanner.nextLine().trim();
        for (int i = 0; i < guide.size(); i++) {
            String element = String.valueOf(guide.get(i));
            int start = element.indexOf(CH) + 1;
            int end = element.lastIndexOf(CHend);
            String cut = element.substring(start,end).trim();
            if (findName.equals(cut)) {
                System.out.println(element);
            }
        }
        System.out.println();

    }
}
