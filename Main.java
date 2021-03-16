import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args){
        CollectionRuler start = new CollectionRuler();
        try{start.load(args[0]);}
        catch(ArrayIndexOutOfBoundsException ex){System.out.println(ex.getMessage());}
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        boolean file = false;
        String fromFile = "";
        File fileName = new File(fromFile);
        List<String> history= new ArrayList<>();
        do{
            if(!scan.hasNextLine()){file = false; scan = new Scanner(System.in);}
            String string = scan.nextLine();
            String[] arguments = string.split(" ");
            history.add(arguments[0]);
            switch(arguments[0]){
                case "help": start.help();
                    break;
                case "info": start.info();
                    break;
                case "show": start.show();
                    break;
                case "remove_by_id": start.remove_by_id(Integer.parseInt(arguments[1]));
                    break;
                case "clear": start.clear();
                    break;
                case "save": start.save(arguments[1]);
                    break;
                case "exit": exit = true;
                    break;

                case "execute_script":{
                    if(file && fromFile.equals(arguments[1])){
                        System.out.println("Эта команда приведёт к зацикливанию. Она не выполнится.");
                        break;
                    }
                    file = true;
                    fromFile = arguments[1];
                    try {
                        fileName = new File(fromFile);
                        scan = new Scanner(fileName);
                    }
                    catch(FileNotFoundException ex){System.out.println(ex.getMessage());}
                    break;
                }

                case "remove_first": start.remove_first();
                    break;
                case "remove_head": start.remove_head();
                    break;
                case "history":
                    for(int i=0; i<history.size(); i++){
                        if(history.size()-i <= 15){
                            System.out.println(history.get(i));
                        }
                    }
                    break;
                case "max_by_name": start.max_by_name();
                    break;
                case "count_greater_than_eye_color": start.count_greater_than_eye_color(arguments[1]);
                    break;
                case "print_field_descending_eye_color": start.print_field_descending_eye_color();
                    break;

                case "add": {System.out.println("Введите имя:");
                    String instr = scan.nextLine();
                    String name = new String();
                    if(instr.equals("")){
                        System.out.println("Введите допустимое имя, или команда не выполнится");
                        instr = scan.nextLine();
                        if(instr.equals("")){break;}
                    }
                    name = instr;

                    System.out.println("Введите координату x:");
                    Integer x;
                    instr = scan.nextLine();
                    try{x = Integer.parseInt(instr);}
                    catch(NumberFormatException ex){
                        System.out.println("Введите допустимое значение, или команда не выполнится");
                        instr = scan.nextLine();
                        try{x = Integer.parseInt(instr);}
                        catch(NumberFormatException ex2){
                            x = -1;
                        }
                    }

                    System.out.println("Введите координату y:");
                    float y;
                    instr = scan.nextLine();
                    try{y = Float.parseFloat(instr);}
                    catch(NumberFormatException ex){
                        System.out.println("Введите допустимое значение, или команда не выполнится");
                        instr = scan.nextLine();
                        try{y = Float.parseFloat(instr);}
                        catch(NumberFormatException ex2){
                            y = -1;
                        }
                    }

                    System.out.println("Введите рост:");
                    double height;
                    instr = scan.nextLine();
                    try{height = Double.parseDouble(instr);}
                    catch(NumberFormatException ex){
                        System.out.println("Введите допустимое значение, или команда не выполнится");
                        instr = scan.nextLine();
                        try{height = Double.parseDouble(instr);}
                        catch(NumberFormatException ex2){
                            height = -1;
                        }
                    }

                    System.out.println("Введите цвет глаз. Допустимые значения: GREEN, RED, YELLOW, ORANGE:");
                    String eyeColor;
                    instr = scan.nextLine();
                    if(!instr.toLowerCase().equals("green") && !instr.toLowerCase().equals("red") && !instr.toLowerCase().equals("yellow") && !instr.toLowerCase().equals("orange")){
                        System.out.println("Введите допустимое значение, или команда не выполнится");
                        instr = scan.nextLine();
                        if(!instr.toLowerCase().equals("green") && !instr.toLowerCase().equals("red") && !instr.toLowerCase().equals("yellow") && !instr.toLowerCase().equals("orange")){eyeColor = "green";}
                        else{eyeColor = instr;}
                    }
                    else{eyeColor = instr;}

                    System.out.println("Введите цвет волос. Допустимые значения: RED, BLACK, BLUE, ORANGE:");
                    String hairColor;
                    instr = scan.nextLine();
                    if(!instr.toLowerCase().equals("black") && !instr.toLowerCase().equals("red") && !instr.toLowerCase().equals("blue") && !instr.toLowerCase().equals("orange")){
                        System.out.println("Введите допустимое значение, или команда не выполнится");
                        instr = scan.nextLine();
                        if(!instr.toLowerCase().equals("black") && !instr.toLowerCase().equals("red") && !instr.toLowerCase().equals("blue") && !instr.toLowerCase().equals("orange")){hairColor = "black";}
                        else{hairColor = instr;}
                    }
                    else{hairColor = instr;}

                    System.out.println("Введите национальность. Допустимые значения: INDIA, ITALY, THAILAND:");
                    String nationality;
                    instr = scan.nextLine();
                    if(!instr.toLowerCase().equals("india") &&!instr.toLowerCase().equals("italy") && !instr.toLowerCase().equals("thailand")){
                        System.out.println("Введите допустимое значение, или команда не выполнится");
                        instr = scan.nextLine();
                        if(!instr.toLowerCase().equals("india") &&!instr.toLowerCase().equals("italy") && !instr.toLowerCase().equals("thailand")){nationality = "italy";}
                        else{nationality = instr;}
                    }
                    else{nationality = instr;}
                    Location location = new Location((float)x, (long)y, name);
                    start.add(name, x, y, height, eyeColor, hairColor, nationality, location);
                    break;
                }

                case "update": {System.out.println("Введите имя:");
                    String instr = scan.nextLine();
                    String name = new String();
                    if(instr.equals("")){
                        System.out.println("Введите допустимое имя, или команда не выполнится");
                        instr = scan.nextLine();
                        if(instr.equals("")){break;}
                    }
                    name = instr;

                    System.out.println("Введите координату x:");
                    Integer x;
                    instr = scan.nextLine();
                    try{x = Integer.parseInt(instr);}
                    catch(NumberFormatException ex){
                        System.out.println("Введите допустимое значение, или команда не выполнится");
                        instr = scan.nextLine();
                        try{x = Integer.parseInt(instr);}
                        catch(NumberFormatException ex2){
                            x = -1;
                        }
                    }

                    System.out.println("Введите координату y:");
                    float y;
                    instr = scan.nextLine();
                    try{y = Float.parseFloat(instr);}
                    catch(NumberFormatException ex){
                        System.out.println("Введите допустимое значение, или команда не выполнится");
                        instr = scan.nextLine();
                        try{y = Float.parseFloat(instr);}
                        catch(NumberFormatException ex2){
                            y = -1;
                        }
                    }

                    System.out.println("Введите рост:");
                    double height;
                    instr = scan.nextLine();
                    try{height = Double.parseDouble(instr);}
                    catch(NumberFormatException ex){
                        System.out.println("Введите допустимое значение, или команда не выполнится");
                        instr = scan.nextLine();
                        try{height = Double.parseDouble(instr);}
                        catch(NumberFormatException ex2){
                            height = -1;
                        }
                    }

                    System.out.println("Введите цвет глаз. Допустимые значения: GREEN, RED, YELLOW, ORANGE:");
                    String eyeColor;
                    instr = scan.nextLine();
                    if(!instr.toLowerCase().equals("green") && !instr.toLowerCase().equals("red") && !instr.toLowerCase().equals("yellow") && !instr.toLowerCase().equals("orange")){
                        System.out.println("Введите допустимое значение, или команда не выполнится");
                        instr = scan.nextLine();
                        if(!instr.toLowerCase().equals("green") && !instr.toLowerCase().equals("red") && !instr.toLowerCase().equals("yellow") && !instr.toLowerCase().equals("orange")){eyeColor = "green";}
                        else{eyeColor = instr;}
                    }
                    else{eyeColor = instr;}

                    System.out.println("Введите цвет волос. Допустимые значения: RED, BLACK, BLUE, ORANGE:");
                    String hairColor;
                    instr = scan.nextLine();
                    if(!instr.toLowerCase().equals("black") && !instr.toLowerCase().equals("red") && !instr.toLowerCase().equals("blue") && !instr.toLowerCase().equals("orange")){
                        System.out.println("Введите допустимое значение, или команда не выполнится");
                        instr = scan.nextLine();
                        if(!instr.toLowerCase().equals("black") && !instr.toLowerCase().equals("red") && !instr.toLowerCase().equals("blue") && !instr.toLowerCase().equals("orange")){hairColor = "black";}
                        else{hairColor = instr;}
                    }
                    else{hairColor = instr;}

                    System.out.println("Введите национальность. Допустимые значения: INDIA, ITALY, THAILAND:");
                    String nationality;
                    instr = scan.nextLine();
                    if(!instr.toLowerCase().equals("india") &&!instr.toLowerCase().equals("italy") && !instr.toLowerCase().equals("thailand")){
                        System.out.println("Введите допустимое значение, или команда не выполнится");
                        instr = scan.nextLine();
                        if(!instr.toLowerCase().equals("india") &&!instr.toLowerCase().equals("italy") && !instr.toLowerCase().equals("thailand")){nationality = "italy";}
                        else{nationality = instr;}
                    }
                    else{nationality = instr;}
                    Location location = new Location((float)x, (long)y, name);
                    start.update(Integer.parseInt(arguments[1]), name, x, y, height, eyeColor, hairColor, nationality, location);
                    break;
                }

                default:
                    System.out.println("Пожалуйста, введите существующую команду. Вы можете посмотреть список команд с помошью help");
                    break;
            }
        }while(!exit);
    }
}
