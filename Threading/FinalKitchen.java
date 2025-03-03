/*.🛠 Real-World Analogy: A Restaurant Kitchen with Multiple Chefs */

import java.util.List;
import java.util.concurrent.*;

public class FinalKitchen {



    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        ExecutorService kitchen = Executors.newFixedThreadPool(3);

        System.out.println("Restaurant is OPEN!");


        // Submit a simple food preparation task (Runnable)
        kitchen.submit(() -> {
            System.out.println("Order Preparing...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Cooking Interrupted!" + e);
            }

            System.out.println("Dish is ready ✅");
        }
        );

        //(Callable)
        Future<String> specialDish = kitchen.submit(() -> {
            System.out.println("Preparing (callable) Dish");
            Thread.sleep(3000);
            return "Pizza is ready";
        });

        System.out.println("Customer is waiting for special dish...");

        try {
            String result = specialDish.get(2, TimeUnit.SECONDS);
            System.out.println("Customer received " + result);
        } catch (TimeoutException e) {
            System.out.println("⏰ Pizza is taking too long! Customer is waiting...");
            String result = specialDish.get();
            System.out.println("✅ Customer finally got: " + result);
        }
        

        // Bulk order
        
        List<Callable<String>> foodOrders = List.of(
            () -> {
                Thread.sleep(2000);
                return "🥗 Salad is ready!";
            },
            () -> {
                Thread.sleep(3000);
                return "🍝 Pasta is ready!";
            },
            () -> {
                Thread.sleep(1000);
                return "🥤 Drink is ready!";
            }
            
        );
            
        System.out.println("Bulk order placed! Assigning multiple chefs");
        List<Future<String>> results = kitchen.invokeAll(foodOrders);

        for(Future<String> f:results){
            System.out.println(f.get());
        }

        
        kitchen.shutdown();
        System.out.println("🛑 No more new orders! Kitchen is closing soon...");


        if (!kitchen.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("⚠️ Some chefs are still cooking! Forcing shutdown...");
            kitchen.shutdownNow();
        }

        if (kitchen.isShutdown()) {
            System.out.println("🔒 Kitchen is CLOSED for new orders.");
        }
        if (kitchen.isTerminated()) {
            System.out.println("🎉 All chefs have finished cooking! Restaurant is now fully closed.");
        }

    }
    
}
