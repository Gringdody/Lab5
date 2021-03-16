public class Location {
    private Float x; //Поле не может быть null
    private Long y; //Поле не может быть null
    private String name; //Строка не может быть пустой, Поле может быть null

    public Location(Float newX, Long newY, String newName){
        this.x = newX;
        this.y = newY;
        this.name = newName;
    }
}