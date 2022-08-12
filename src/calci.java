import java.util.Scanner;

public class calci {
    public double addition(double a, double b){
     return a+b;
    }
    public double subtraction(double a,double b){
        return a-b;
    }
    public double multiplication(double a, double b){
        return a*b;
    }
    public double division(double a, double b){
        return a/b;
    }
    public double remainder(double a, double b){
        return a%b;
    }
    public double logOf(double a){
        return Math.log(a);
    }
    public void home(){
        //insert clear screen function
        System.out.println("CALCULATOR HOME");
    }
    public void cli(){
        Scanner sc = new Scanner(System.in);
        calci object = new calci();
        object.
        object.home();
    }
    public static void main(String[] args) {
        calci object = new calci();
        object.cli();
    }
}
