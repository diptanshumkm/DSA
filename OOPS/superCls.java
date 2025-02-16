/*
super refers to the parent (superclass) of a subclass and is used in inheritance.

It can be used to access superclass variables, call superclass methods, and invoke superclass constructors.

super.variableName is used when a subclass variable shadows a superclass variable.

super.methodName() is used to call an overridden method from the superclass.

super() calls the constructor of the superclass and must be the first statement in the subclass constructor.
*/

public class superCls{

    static class Animal {
        String name = "Animal";
        Animal(){
            System.out.println("Parent ctor called");
        }
        void makeSound(){
            System.out.println("Sound from animal class...");
        }
    }
    
    static class Dog extends Animal {
        String name = "Dog";
        Dog(){
            super();
            System.out.println("Dog (Child) ctor called");
        }
        void display() {
            System.out.println("Subclass Name: " + name);
            System.out.println("Superclass Name: " + super.name);
            super.makeSound(); //Call method of parent class
        }
    }

    public static void main(String[] args){
        Dog d = new Dog();
        d.display();
    }
}