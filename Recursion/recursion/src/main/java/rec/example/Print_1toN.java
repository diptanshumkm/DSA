package rec.example;

public class Print_1toN {
    
    public static void print1toN(int n){

        if (n <=0) {
            return;
        }
        print1toN(n-1);
        System.out.println(n);

    }

    public static void printNto1(int n){

        if (n <=0) {
            return;
        }
        System.out.println(n);
        printNto1(n-1);
    }

    public static int sumOf1toN(int n){
        if (n<=0) {
            return 0;
        }
        return n + sumOf1toN(n-1);
    }

    public static int factorial(int n){
        if (n<=0) {
            return 1;
        }

        return n * factorial(n-1);
    }

    public static int fibonacci(int n){

        if(n<=1){
            return n;
        }

        int last = fibonacci(n-1);
        int second_last = fibonacci(n-2);

        return last + second_last;

    }

    public static boolean isPalindrome(int index, StringBuilder str){

        if (index >= str.length() /2) {
            return true;
        }
        if (str.charAt(index) != str.charAt(str.length()- 1 -index ) ) {
            return false;
        }

        return isPalindrome(index+1, str);


    }


    public static void main(String[] args) {
        
        print1toN(5);
        System.out.println("N to 1");
        printNto1(5);

        System.out.println("Sum of n natural num: ");
        System.out.println(sumOf1toN(5));

        System.out.println("Factorial of num: ");

        System.out.println(factorial(5));

        System.out.println("Fibonacci: " );
        System.out.println(fibonacci(6));

        StringBuilder sb = new StringBuilder("madam");
        System.out.println("Palindrome................. ");

        System.out.println(isPalindrome(0, sb));


    }


}
