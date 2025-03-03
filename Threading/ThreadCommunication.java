public class ThreadCommunication {

/*->*/public static class PizzaShop {
        private boolean isPizzaReady = false;
        
        public synchronized void makePizza(){
            while (isPizzaReady) {
                try {
                    System.out.println("Chef: Plate full! Waiting... ⏳");
                    wait();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            System.out.println("Chef: Made Pizza");
            isPizzaReady = true;
            notify();
        }
        public synchronized  void eatPizza(){
            while (!isPizzaReady) {
                try {
                    System.out.println("Waiting for pizza to be ready");
                    wait();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            System.out.println("Customer: I ate pizza!");
            isPizzaReady= false;
            notify();
        }


    }
    

    public static class Chef extends Thread {
        PizzaShop shop;
        Chef(PizzaShop shop){
            this.shop = shop;
        }

        @Override
        public void run(){
            while (true) {
                shop.makePizza();
                try {
                    Thread.sleep(1000); // Simulate pizza-making time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Customer extends Thread {
        PizzaShop shop;
        Customer(PizzaShop shop){
            this.shop = shop;
        }

        public void run() {
            while (true) {
                shop.eatPizza();
                try {
                    Thread.sleep(1500); // Simulate eating time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main(String[] args) {
        PizzaShop shop = new PizzaShop();
        Chef chef = new Chef(shop);
        Customer customer = new Customer(shop);

        chef.start();
        customer.start();
    }
}
