public class lib extends calci {

    public void throwError(calci object){
        System.out.println("ERROR");
        object.cli();
    }
    public double addition(double b,double a){
        return b+a;
    }
    public double subtraction(double b,double a){
        return b-a;
    }
    public double multiplication(double b,double a){
        return a*b;
    }
    public double division(double b,double a){
        return b/a;
    }
    public double remainder(double b,double a){
        return b%a;
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
}
