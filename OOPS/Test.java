public class Test {
    
    public static class Animal{
        int age;
        Animal(){
            System.out.println("parent ctor called...");
        }
        void eat(){
            System.out.println("Animal is eating....");
        }

        void speak(){
            System.out.println("Speaking...");
        }

    }
    public static class Cat extends Animal{
        Cat(){
            super(); //Calls parent ctor
            System.out.println("Child ctor called...");
        }
        @Override
          void speak(){
            System.out.println("Meow...");
            super.eat(); // Calls parent method
        }
    }

    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.eat();
    
    }

}
