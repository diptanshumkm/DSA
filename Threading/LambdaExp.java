
public class LambdaExp{

    public interface MyInterface {
        void sayHello();
    }

    public interface Calculator {
        int Operate(int a, int b);
    }


    public static void main(String[] args) {
        // MyInterface obj = new MyInterface() {
        //     public void sayHello(){
        //         System.out.println("Hello World!");
        //     }
        // };

        // obj.sayHello();

        // MyInterface obj1 = () -> {System.out.println("Hello world 1");};
        // obj1.sayHello();


        // Calculator add = new Calculator() {
        //     @Override
        //     public int Operate(int a, int b){
        //         return a+b;
        //     }
        // };

        // Calculator multiply = new Calculator() {
        //     @Override
        //     public int Operate(int a, int b){
        //         return a*b;
        //     }
        // };
        
        // System.out.println( add.Operate(1, 2) );
        
        // System.out.println( multiply.Operate(1, 2) );



        Calculator add1 = (int a, int b) -> a+b;
        Calculator multiply1 = (int a, int b) -> a*b;

        System.out.println( add1.Operate(1, 2) );
        System.out.println( multiply1.Operate(1, 2) );

    }

}
