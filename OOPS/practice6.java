/*-----------------------------------------------------------INTERFACE-------------------------------------------- 
    1️⃣ Basic Interface
    An interface defines a set of abstract methods that a class must implement.
    A class uses the implements keyword to provide method implementations.
    
    2️⃣ Interface with Multiple Implementations
    Multiple classes can implement the same interface, each providing its own logic.
    This ensures code reusability and a consistent structure across different classes.
    
    3️⃣ Multiple Interfaces
    A class can implement multiple interfaces, achieving multiple inheritance in Java.
    The class must override all abstract methods from the implemented interfaces.
    
    4️⃣ Default and Static Methods in Interface (Java 8+)
    Default methods: Provide a method body inside an interface using the default keyword.
    Static methods: Defined in the interface and can be called using the interface name.
    
    5️⃣ Private Methods in Interface (Java 9+)
    Private methods allow code reuse within an interface but are not accessible outside.
    Useful for reducing code duplication in default and static methods. 


Feature	                        Interface	                                                                Abstract Class
Methods	                        Only abstract methods (before Java 8)	                                    Can have abstract and concrete methods
Implementation	                Implemented using implements	                                            Extended using extends
Multiple Inheritance	        Supports multiple inheritance	                                            Supports single inheritance only
Variables	                    public, static, final by default	                                        Can have instance variables
Constructors	                Not allowed	                                                                Can have constructors
Access Modifiers	            Methods are public by default	                                            Methods can have any access modifier (public, protected, private)
Default & Static Methods	    Supported (default, static from Java 8+)	                                Supported
Usage	                        Used for defining a contract that multiple classes can follow	            Used for code reusability and partial abstraction


*/


public class practice6 {
    
    //--------------------------------------------------BASIC INTERFACE---------------------------------------
    // public interface Bicycle {
    //     int a = 44;
    //     void horn();
    //     void brake();
    // }
    // public static class AvonCycle implements Bicycle {
    //     public void horn(){
    //         System.out.println("Blowing horn.......");
    //     }
        
    //     public void brake(){
    //         System.out.println("Applying brake...");
    //     }
    // }


    // ------------------------------------------------Interface with Multiple Implementations------------------------
    // public interface Vehicle {
    //     void start();
    // }
    // public static class Car implements Vehicle{
    //     public void start(){
    //         System.out.println("Car is starting.....");
    //     }
    // }
    // public static class Truck implements Vehicle {
    //     public void start(){
    //         System.out.println("Truck is starting...");
    //     }
    // }

    // -------------------------------------------------------Multiple Interfaces-------------------------------------
    // public interface fly {
    //     void flying();
    // }
    // public interface swim {
    //     void swimming();
    // }
    // public static class Human implements fly, swim {
    //     public void flying(){
    //         System.out.println("Flying....");
    //     }
    //     public void swimming(){
    //         System.out.println("Swimming......");
    //     }
        
    // }

    // ---------------------------------------------Default and Static Methods ---------------------------------------
    // public interface Camera {
    //     void capture();

    //     default void batteryStatus(){
    //         System.out.println("Battery status: 80%");
    //     }

    //     static void softwareUpdate(){
    //         System.out.println("Updating software...");
    //     }
        
    // }
    // public static class Apple implements Camera{
    //     public void capture(){
    //         System.out.println("Clicking pic...");
    //     }
    // }
    

    // -----------------------------------------------Private Methods in Interface ---------------------------------
    // interface Calculator {
    //     default void add(int a, int b){
    //         int sum = compute(a,b);
    //         System.out.println("Sum: "+ sum);
    //     }

    //     private int compute(int x, int y){
    //         return x+y;
    //     }
        
    // }
    // public static class MathsOperation implements Calculator{};



    public static void main(String[] args) {
        //--------------------------------------------------BASIC INTERFACE---------------------------------------
        // Bicycle c1 = new AvonCycle();
        // c1.brake();
        // c1.horn();

        // ------------------------------------------------Interface with Multiple Implementations------------------------
        // Vehicle car = new Car();
        // car.start();   

        // Vehicle truck = new Truck();
        // truck.start();
        
        // -------------------------------------------------------Multiple Interfaces-------------------------------------
        // Human h1 = new Human();
        // h1.flying();
        // h1.swimming();

        //---------------------------------------------------------Default and Static Methods--------------------------- 
        // Apple iphone = new Apple();
        // iphone.batteryStatus();
        // iphone.capture();

        // Camera.softwareUpdate();

        // ------------------------------------------------------------------Private Methods in Interface --------------------------------------
        // MathsOperation x = new MathsOperation();
        // x.add(2, 6);

        
    }
}
