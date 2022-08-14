import java.io.IOException;
import java.util.Scanner;
//TODO=> work on the trim part for input
//TODO=> return one step back on error don't shut down
//TODO=> work on the power functin and spaces in input
//TODO=> check if string starts with number and make it the main value
//TODO=> add clear option to menu
//TODO=> display rules when loggin in for the first time


public class calci {
     double mainValue,answer;


    public void operatorSelect(Scanner sc, calci object, lib object2){
        System.out.println("Main Value is "+mainValue);
        System.out.println("Enter the operator");
        String inPut = sc.next().trim();
        String firstCharacter = String.valueOf(inPut.charAt(0));
        boolean number = isNumeric(firstCharacter);
        if(number){
            mainValue=0;
        }
        while (number) {
            System.out.println(firstCharacter+" "+inPut+" "+" "+number);
            if (inPut.startsWith("+") ||inPut.startsWith("-") || inPut.startsWith("/") || inPut.startsWith("%") || inPut.startsWith("*") )
            {break;}
            double a = Double.parseDouble(firstCharacter);
            mainValue = (mainValue*10 + (a));
            inPut = inPut.substring(1);
            firstCharacter = String.valueOf(inPut.charAt(0));
            number = isNumeric(firstCharacter);
        }
        System.out.println(mainValue+"::");
        if (inPut.startsWith("+")) {
            System.out.println("Enter the values"+inPut);
            answer = object2.addition(mainValue,Double.parseDouble(inPut.substring(1)));
        } else if (inPut.startsWith("-")) {
            System.out.println("Enter the values");
            answer = object2.subtraction(mainValue,Double.parseDouble(inPut.substring(1)));
        } else if (inPut.startsWith("/")) {
            System.out.println("Enter the values");
            answer = object2.division(mainValue,Double.parseDouble(inPut.substring(1)));
        } else if (inPut.startsWith("*")) {
            System.out.println("Enter the values");
            answer = object2.multiplication(mainValue,Double.parseDouble(inPut.substring(1)));
        } else if (inPut.startsWith("%")) {
            System.out.println("Enter the values");
            answer = object2.remainder(mainValue,Double.parseDouble(inPut.substring(1)));
        } else if (inPut.startsWith("log")) {
            System.out.println("Enter the value");
            answer = object2.logOf(Double.parseDouble(inPut.substring(3)));
        } else if (inPut.startsWith("square")) {
            System.out.println("Enter the value"+inPut.substring(6));
            answer = object2.squareOf(Double.parseDouble(inPut.substring(6)));
        } else if (inPut.startsWith("sqrt")) {
            System.out.println("Enter the values"+(inPut.substring(4)).trim());
        } else if (inPut.startsWith("power")) {
            System.out.println("Enter the values");
            answer = object2.powerOf(sc.nextDouble(), sc.nextInt());
        } else if (inPut.startsWith("clear")) {
            clearScreen();
        } else {
            object2.throwError(object);
        }
        {
            mainValue = answer;
        }
        System.out.println(answer);
        object.operatorSelect(sc,object, object2);
    }
    public static boolean isNumeric(String string) {
        int intValue;
        System.out.printf("Parsing string: \"%s\"%n", string);
        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
    public static void clearScreen(){//Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {}
    }
    public void home(){
        System.out.println("Use this calculator to get ");
        System.out.println("+,-,*,/,%,log,square,sqrt(square root)");
        System.out.println("Default value is 0");
        mainValue = 0;
    }
    public void cli(){
        Scanner sc = new Scanner(System.in);
        calci object = new calci();
        lib object2 = new lib();
        clearScreen();
        object.home();
        object.operatorSelect(sc,object,object2);

    }
    public static void main(String[] args) {
        calci object = new calci();
        object.cli();
    }
}
