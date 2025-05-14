// import java.io.*;
public class exceptionHandling {

    public static void validateAge(int age){
        if (age < 18) {
            throw new IllegalArgumentException("Age is invalid");
        }else{
            System.out.println("Age is valid");
        }

    }

    public static void prac(){
        int age = 20;

        try{
            age = age/10;
            if (age<18) {
                throw new ArithmeticException();
            }

        }catch(ArithmeticException e){
            System.out.println(e + " Low age");
        }

    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        try {
            int result = 10/0;
        } catch (ArithmeticException e) {

            System.out.println("Cannot divide the equation....." + e);
        }

        System.out.println("Program Continues..........");
        System.out.println();
        System.out.println();
        
        try{
            int[] arr = {1,3,4};
            int ans = arr[4];
        }catch(ArithmeticException e){
            System.out.println("Arithmetic exception.....");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Index Out of bound..... " + e);
        }



        System.out.println();
        System.out.println();



        try {
            int result = 10/0;
            System.out.println("Result: "+result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide the equation....." );
        }finally{
            System.out.println("This will always execute...");
        }


        System.out.println();
        System.out.println();

        validateAge(19);


        System.out.println();
        System.out.println();


        System.out.println();
        System.out.println();


        prac();
          System.out.println();
        System.out.println();
    }
}
