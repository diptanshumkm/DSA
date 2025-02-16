

public class Cls {
    public static class Cars{
        String brand;
        String model;
        double price;

        Cars(){
            this("Unknown", "Unknown", 0.0);
        }
        
        Cars(String brand, String model, double price){
            this.brand = brand;
            this.model = model;
            this.price = price;
        }

        void updatePrice(double x){
            this.price = x;
            System.out.println("Updated price: " + price);
        }

        void displayInfo(){
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Price: " + price);
        }

    }

    public static void main(String[] args) {
        
        

    }
}