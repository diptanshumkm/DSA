import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class tryLock {
    
    public static class SharedResources {
        private final Lock lock = new ReentrantLock();

        public void display(String message){
            try {
                if (lock.tryLock(2, TimeUnit.SECONDS)) {
                    
                    try {
                        for(int i=1; i<=5; i++){
                            System.out.println(message+" -> "+i);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }finally{
                        lock.unlock();
                    }

                }else{
                    System.out.println(message + " could not acquire lock and is skipping execution.");
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            
        }
            
    }

    public static class MyThread extends Thread {
        SharedResources resources = new SharedResources();
        String message;                             

        MyThread(SharedResources obj ,String message){
            this.message = message;
            this.resources = obj;
        }
        
        @Override
        public void run(){
            resources.display(message);
        }

    }


    public static void main(String[] args) {
        SharedResources obj = new SharedResources();
        MyThread t1 = new MyThread(obj, "Thread 1");
        MyThread t2 = new MyThread(obj, "Thread 2");

        t1.start();
        t2.start();
    }



}
