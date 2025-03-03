/*
    1️⃣ Single Level Inheritance
    A subclass inherits from a single parent class (class B extends A).
    
    2️⃣ Multi-Level Inheritance
    A class inherits from another derived class, forming a hierarchy (class C extends B extends A).

    3️⃣ Hierarchical Inheritance
    Multiple subclasses inherit from a single parent class (class B extends A, class C extends A).
    
    4️⃣ Multiple Inheritance (via Interfaces)
    A class implements multiple interfaces to inherit behavior (class A implements X, Y).
    
    5️⃣ Hybrid Inheritance
    A mix of two or more types of inheritance, mainly achieved using interfaces.
 */


public class Inheritance {
    
    //-----------------------------------Single Level Inheritence-------------------------------------
    // public static class Parent {
    //     void display(){
    //         System.out.println("This is Parent class...");
    //     }
    // }

    // public static class Child extends Parent {
    //     void show(){
    //         System.out.println("This is child class");
    //     } 
    // }


    // -------------------------------------------Multi-Level Inheritance---------------------------------------------
    // public static class GrandParent {
    //     void showGrandParent(){
    //         System.out.println("This is grandpa...");
    //     }
    // }
    // public static class Parent extends GrandParent {
    //     void showParent(){
    //         System.out.println("This is Parent...");
    //     }
    // }
    // public static class Child extends Parent {
    //     void showChild(){
    //         System.out.println("This is Child...");
    //     }
    // }


    //  ---------------------------------------------------Hybrid Inheritance----------------------------------------------------
    // interface Interface1 {
    //     void method1();
    // }
    
    // interface Interface2 {
    //     void method2();
    // }
    
    // static class Parent {
    //     void showParent() {
    //         System.out.println("This is the Parent class.");
    //     }
    // }
    
    // // Implementing multiple interfaces in Child class
    // static class Child extends Parent implements Interface1, Interface2 {
    //     public void method1() {
    //         System.out.println("Method from Interface1.");
    //     }
    
    //     public void method2() {
    //         System.out.println("Method from Interface2.");
    //     }
    
    //     void showChild() {
    //         System.out.println("This is the Child class.");
    //     }
    // }


    public static void main(String[] args) {
        
        //-----------------------------------Single Level Inheritence-------------------------------------
        // Child obj = new Child();
        // obj.display();  // Inherited method
        // obj.show();     // Child class method
        

        // -------------------------------------------Multi-Level Inheritance---------------------------------------------
        // Child obj = new Child();
        // obj.showGrandParent();  // Inherited from GrandParent
        // obj.showParent();       // Inherited from Parent
        // obj.showChild();        // Child class method


        //  ---------------------------------------------Hybrid Inheritance----------------------------------------------------
        // Child obj = new Child();
        // obj.showParent();  // Inherited from Parent class
        // obj.method1();     // Implemented from Interface1
        // obj.method2();     // Implemented from Interface2
        // obj.showChild();   // Child class method


    }
}
