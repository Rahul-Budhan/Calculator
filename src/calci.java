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
    public void throwError(calci object){
        System.out.println("ERROR");
        object.cli();
    }
    public double addition(double a){
        return mainValue+a;
    }
    public double subtraction(double a){
        return mainValue-a;
    }
    public double multiplication(double a){
        return a*mainValue;
    }
    public double division(double a){
        return mainValue/a;
    }
    public double remainder(double a){
        return mainValue%a;
    }
    public double logOf(double a){
        return Math.log(a);
    }
    public double squareOf(double a){
        mainValue = (a*a);
        return mainValue;
    }
    public double squareRootOf(double a){
        mainValue = Math.sqrt(a);
        return mainValue;
    }
    public double powerOf(double a, int b){
        mainValue = Math.pow(a,b);
        return mainValue;
    }
    public void operatorSelect(Scanner sc, calci object){
        System.out.println("Main Value is "+mainValue);
        System.out.println("Enter the operator");
        String operator = sc.next().trim();
        if(false){
            //check if it starts with a number, if it does then that becoomes mainValue
        }
        else if (operator.startsWith("+")) {
            System.out.println("Enter the values");
            answer = object.addition(Double.parseDouble(operator.substring(1)));
        } else if (operator.startsWith("-")) {
            System.out.println("Enter the values");
            answer = object.subtraction(Double.parseDouble(operator.substring(1)));
        } else if (operator.startsWith("/")) {
            System.out.println("Enter the values");
            answer = object.division(Double.parseDouble(operator.substring(1)));
        } else if (operator.startsWith("*")) {
            System.out.println("Enter the values");
            answer = object.multiplication(Double.parseDouble(operator.substring(1)));
        } else if (operator.startsWith("%")) {
            System.out.println("Enter the values");
            answer = object.remainder(Double.parseDouble(operator.substring(1)));
        } else if (operator.startsWith("log")) {
            System.out.println("Enter the value");
            answer = object.logOf(Double.parseDouble(operator.substring(3)));
        } else if (operator.startsWith("square")) {
            System.out.println("Enter the value"+operator.substring(6));
            answer = object.squareOf(Double.parseDouble(operator.substring(6)));
        } else if (operator.startsWith("sqrt")) {
            System.out.println("Enter the values"+(operator.substring(4)).trim());

//            answer = object.squareRootOf(Double.parseDouble(operator.substring(4).trim()));
        } else if (operator.startsWith("power")) {
            System.out.println("Enter the values");
            answer = object.powerOf(sc.nextDouble(), sc.nextInt());
        } else {
            object.throwError(object);
        }
        {
            mainValue = answer;
        }
        System.out.println(answer);
        object.operatorSelect(sc,object);
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
        clearScreen();
        object.home();
        object.operatorSelect(sc,object);

    }
    public static void main(String[] args) {
        calci object = new calci();
        object.cli();
    }
}
