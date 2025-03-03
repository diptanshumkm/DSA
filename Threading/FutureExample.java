import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        
        ExecutorService executor = Executors.newFixedThreadPool(1); 

        // Submit the task (Callable)
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(5000);
            return 50;
        });

        System.out.println("Task submitted doing other work...");

        if(!future.isDone()){
            System.out.println("Task is still running...");
        }

        int result = 0;
        try {
            try {
                result = future.get(2, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                System.out.println("Tasks take too long! " + e);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (ExecutionException e) {
            System.out.println(e);
        }
        System.out.println("Result: " + result);
        executor.shutdown();

    }

}
