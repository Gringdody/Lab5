import com.google.gson.Gson;
import java.time.LocalDate;
import java.util.Random;

public class Person implements Comparable<Person>{
    private static int lastID = 0;

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double height; //Значение поля должно быть больше 0
    private EyeColor eyeColor; //Поле не может быть null
    private HairColor hairColor; //Поле может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле может быть null

    public Person(){

    }

    public Person(String newName, Coordinates newCoordinates, double newHeight, EyeColor newEyeColor, HairColor newHairColor, Country newCountry, Location newLocation){
        lastID++;
        this.id = lastID;
        this.name = newName;
        this.coordinates = newCoordinates;
        this.creationDate = LocalDate.now();
        if(newHeight != -1){this.height = newHeight;}
        else{
            Random random = new Random();
            this.height = 145 + random.nextInt(70);
        }
        this.eyeColor = newEyeColor;
        this.hairColor = newHairColor;
        this.nationality = newCountry;
        this.location = newLocation;
    }

    public Person(int newId, String newName, Coordinates newCoordinates, double newHeight, EyeColor newEyeColor, HairColor newHairColor, Country newCountry, Location newLocation){
        this.id = newId;
        this.name = newName;
        this.coordinates = newCoordinates;
        this.creationDate = LocalDate.now();
        if(newHeight != -1){this.height = newHeight;}
        else{
            Random random = new Random();
            this.height = 145 + random.nextInt(70);
        }
        if(newEyeColor != null){this.eyeColor = newEyeColor;}
        else{this.eyeColor = EyeColor.ORANGE;}
        this.hairColor = newHairColor;
        this.nationality = newCountry;
        this.location = newLocation;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public EyeColor getEyeColor(){
        return this.eyeColor;
    }

    public int compareTo(Person p){
        return this.name.compareTo(p.getName());
    }

    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}