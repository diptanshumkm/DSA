public class Synchronization {
    
    public static class SharedResources {        
        public synchronized void display(String name){

            for(int i=1; i<=5; i++){
                System.out.println(name + " -> " + i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

            }
        }   
    }

    public static class MyThread extends Thread{   
        SharedResources resource;
        String threadName;

        MyThread(String name, SharedResources obj){
            this.resource = obj;
            this.threadName=name;
        }

        @Override
        public void run(){
            resource.display(threadName);
        }
    }


    public static void main(String[] args) {
        
        SharedResources obj  = new SharedResources();

        MyThread t1 = new MyThread("Thread 1", obj); //Concept of shallow and deep copy
        MyThread t2 = new MyThread("Thread 2", obj);

        t1.start();
        t2.start();
    }

}
