/*----------------Types of Polymorphism in Java:
Compile-Time Polymorphism (Static Polymorphism)
Run-Time Polymorphism (Dynamic Polymorphism)-----------------------------*/


public class practice3 {
    
    static class Calci {
        /*
            1. Compile-Time Polymorphism (Static Polymorphism)
                This is achieved through Method Overloading.

                Method Overloading:
                Same method name but different parameters (type, number, or both).
                The decision of which method to call is made at compile time.
        */

        int add(int a, int b){
            return a+b;
        }
        int add(int a, int b, int c){
            return a+b+c;
        }
    }


    /*  
        Method Overriding?
        Method Overriding occurs when a subclass (child class) provides a specific implementation of a method that is already defined in its superclass (parent class).
        The method in the subclass must have the same name, return type, and parameters as the method in the parent class.
        It allows runtime polymorphism, meaning the decision of which method to call is made at runtime based on the object
     */
    static class Animal {
        void sound(){
            System.out.println("Animal makes sound");
        }
    }

    static class Dog extends Animal {
        @Override
        void sound(){
            super.sound(); // Calling parent class method
            System.out.println("Dog barks...");
        }    
    }
    static class Cat extends Animal {
        @Override
        void sound(){
            System.out.println("Cat meows...");
        }
        
    }

    public static void main(String[] args) {
        
        Calci c = new Calci();
        int result = c.add(500,200,5);
        System.out.println(result);

        Animal a;
        a = new Dog(); // Output will include both parent and child behavior
        a.sound();
        a = new Cat();
        a.sound();

    }
}
