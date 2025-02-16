import java.io.*;
public class exceptionHandling {

    public static void validateAge(int age){
        if (age < 18) {
            throw new IllegalArgumentException("Age is invalid");
        }else{
            System.out.println("Age is valid");
        }

    }

    public static void fileReader(String file_path) throws IOException{
        FileReader file = new FileReader(file_path);
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

        try{
            fileReader("C:/Users/Diptanshu/Desktop/Informal txt.txt");
            System.out.println("Done.........");
        }catch(IOException e){
            System.out.println("File not found");
        }



        System.out.println();
        System.out.println();



    }
}
