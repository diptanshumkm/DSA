public class Singleton {
    
    //2 private static instance of class
    private static Singleton instance;

    //1 Make ctor private
    private Singleton(){
        System.out.println("Ctor called!");
    }

    //3 getter
    public synchronized static Singleton getInstance(){
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    } 

    
    public static void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 + " " + s2);
    }

}
