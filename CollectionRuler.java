import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CollectionRuler {
    PriorityQueue<Person> myQueue = new PriorityQueue<>();
    private java.time.LocalDate date;

    CollectionRuler(){
        this.date = LocalDate.now();
    }

    public void load(String fileName){
        char[] into = new char[1000];
        try{
            FileReader reader = new FileReader(fileName);
            int count;
            while((count = reader.read(into))>0){
                if(count<1000){
                    into = Arrays.copyOf(into, count);
                }
            }
        }
        catch(IOException exception){System.out.println(exception.getMessage());return;}
        String data = new String(into);
        Gson gson = new Gson();
        Type myType = new TypeToken<ArrayList<Person>>(){}.getType();
        ArrayList<Person> list = gson.fromJson(data, myType);
        for(Person person: list){
            myQueue.add(person);
        }
        System.out.println("Коллекция успешно загружена из файла");
    }

    public void sort(){
        List<Person> list = new ArrayList<>(myQueue);
        Collections.sort(list, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.toString().compareTo(p2.toString());
            }
        });
        PriorityQueue<Person> sortedQueue = new PriorityQueue<>();
        for(Person person: list){
            sortedQueue.add(person);
        }
        myQueue = sortedQueue;
    }

    public void help(){
        System.out.println("Список доступных команд и их описание:");
        System.out.println("info : выводит информацию о коллекции");
        System.out.println("show : выводит все элементы коллекции в строковом представлении");
        System.out.println("add {element} : добавляет новый элемент в коллекцию");
        System.out.println("update id {element} : обновляет значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id id : удаляет элемент коллекции, id которого равен заданному");
        System.out.println("clear : очищает коллекцию");
        System.out.println("save : сохраняет коллекцию в файл");
        System.out.println("execute_script file_name : считает и исполняет скрипт из указанного файла");
        System.out.println("exit : завершает программу без предварительного сохранения коллекции в файл");
        System.out.println("remove_first : удаляет первый элемент из коллекции");
        System.out.println("remove_head : выводит первый элемент из коллекции и удаляет его");
        System.out.println("history : выводит последние 15 команд");
        System.out.println("max_by_name : выводит любой объект из коллекции, значение поля name которого является максимальным");
        System.out.println("count_greater_than_eye_color eyeColor : выводит количество элементов, значение поля eyeColor которых больше заданного");
        System.out.println("print_field_descending_eye_color : выводит значение поля eyeColor всех элементов в порядке убывания");
    }

    public void info(){
        System.out.printf("тип коллекции: %s%n", myQueue.getClass());
        System.out.printf("дата инициализации: %s%n", date.toString());
        System.out.printf("количество элементов: %s%n", myQueue.size());
    }

    public void show(){
        for(Person person: myQueue){
            System.out.println(person.toString());
        }
    }

    public void add(String newName, Integer newX, Float newY, double newHeight, String newEyeColor, String newHairColor, String newCountry, Location newLocation){
        Coordinates coordinates = new Coordinates(newX, newY);
        EyeColor eyeColor = EyeColor.GREEN;
        switch(newEyeColor.toLowerCase()){
            case "green": eyeColor = EyeColor.GREEN;
                break;
            case "red": eyeColor = EyeColor.RED;
                break;
            case "yellow": eyeColor = EyeColor.YELLOW;
                break;
            case "orange": eyeColor = EyeColor.ORANGE;
                break;
        }
        HairColor hairColor = HairColor.BLACK;
        switch(newHairColor.toLowerCase()){
            case "black": hairColor = hairColor.BLACK;
                break;
            case "red": hairColor = HairColor.RED;
                break;
            case "blue": hairColor = HairColor.BLUE;
                break;
            case "orange": hairColor = HairColor.ORANGE;
                break;
        }
        Country country = Country.ITALY;
        switch(newCountry.toLowerCase()){
            case "india": country = Country.INDIA;
                break;
            case "italy": country = Country.ITALY;
                break;
            case "thailand": country = Country.THAILAND;
                break;
        }
        Person person = new Person(newName, coordinates, newHeight, eyeColor, hairColor, country, newLocation);
        myQueue.add(person);
        System.out.println("Объект добавлен");
    }

    public void update(int id, String newName, Integer newX, Float newY, double newHeight, String newEyeColor, String newHairColor, String newCountry, Location newLocation){
        Coordinates coordinates = new Coordinates(newX, newY);
        EyeColor eyeColor = EyeColor.GREEN;
        switch(newEyeColor.toLowerCase()){
            case "green": eyeColor = EyeColor.GREEN;
                break;
            case "red": eyeColor = EyeColor.RED;
                break;
            case "yellow": eyeColor = EyeColor.YELLOW;
                break;
            case "orange": eyeColor = EyeColor.ORANGE;
                break;
        }
        HairColor hairColor = HairColor.BLACK;
        switch(newHairColor.toLowerCase()){
            case "black": hairColor = hairColor.BLACK;
                break;
            case "red": hairColor = HairColor.RED;
                break;
            case "blue": hairColor = HairColor.BLUE;
                break;
            case "orange": hairColor = HairColor.ORANGE;
                break;
        }
        Country country = Country.ITALY;
        switch(newCountry.toLowerCase()){
            case "india": country = Country.INDIA;
                break;
            case "italy": country = Country.ITALY;
                break;
            case "thailand": country = Country.THAILAND;
                break;
        }
        Person newPerson = new Person(id, newName, coordinates, newHeight, eyeColor, hairColor, country, newLocation);
        for(Person person: myQueue){
            if(person.getId() == id){
                myQueue.remove(person);
                break;
            }
        }
        myQueue.add(newPerson);
        System.out.println("Объект обновлён");
    }

    public void remove_by_id(int id){
        Person removed = new Person();
        for(Person person: myQueue){
            if(person.getId() == id){
                removed = person;
            }
        }
        if(removed.getId() != id){
            System.out.println("Элемента с таким id не существует");
        }
        else{
            myQueue.remove(removed);
            System.out.println("Элемент удалён");
        }
    }

    public void clear(){
        myQueue.clear();
        System.out.println("Коллекция очищена");
    }

    public void save(String fileName){
        Gson gson = new Gson();
        try {
            FileOutputStream output = new FileOutputStream(fileName);
            String packed = gson.toJson(myQueue);
            byte[] buffer = packed.getBytes();
            output.write(buffer, 0 , buffer.length);
            output.close();
            System.out.println("Коллекция сохранена");
        }
        catch (IOException e) {
            System.out.println("Ошибка сохранения коллекции");
        }
    }

    public void remove_first(){
        try{myQueue.poll();
            System.out.println("Первый элемент удалён");}
        catch(NullPointerException exception){
            System.out.print(exception.getMessage());
        }
    }

    public void remove_head(){
        try{System.out.println("Первый элемент коллекции:");
            System.out.println(myQueue.peek().toString());
            myQueue.poll();
            System.out.println("Первый элемент удалён");
        }
        catch(NullPointerException exception){
            System.out.print(exception.getMessage());
        }
    }

    public void max_by_name(){
        Person maxNamePerson = myQueue.peek();
        for(Person person: myQueue){
            if(maxNamePerson.getName().compareTo(person.getName())>0){
                maxNamePerson = person;
            }
        }
        System.out.println(maxNamePerson);
    }

    public void count_greater_than_eye_color(String string){
        EyeColor eyeColor = EyeColor.GREEN;
        switch(string.toLowerCase()){
            case "green": eyeColor = EyeColor.GREEN;
                break;
            case "red": eyeColor = EyeColor.RED;
                break;
            case "yellow": eyeColor = EyeColor.YELLOW;
                break;
            case "orange": eyeColor = EyeColor.ORANGE;
                break;
        }
        int count = 0;
        for(Person person: myQueue){
            if(eyeColor.toString().compareTo(person.getEyeColor().toString())>0){
                count++;
            }
        }
        System.out.println(count);
    }

    public void print_field_descending_eye_color(){
        sort();
        for(Person person: myQueue){
            System.out.println(person.getEyeColor());
        }
    }
}
