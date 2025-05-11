public class DiamondProb {
    
    static interface A {

        default void display(){
            System.out.println("Hello from A");
        }

    }
    static interface B extends A{
        default void display(){
            System.out.println("Hello from B");
        }    
    }
    static interface C extends A{
        default void display(){
            System.out.println("Hello from C");
        }
    }

    static class D implements B, C{

        public void display(){
            // B.super.display();
            System.out.println("Hello from D");
        }

    } 

    public static void main(String[] args) {
        A obj = new D();
        obj.display();
    }

}
