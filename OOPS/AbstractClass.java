/*
    ----------------------------------------Rules of Abstract Classes & Methods----------------------------------------------------
    
    1️⃣ An abstract class cannot be instantiated (cannot create an object of it).
    2️⃣ Can have constructors to initialize variables in subclasses.
    3️⃣ Can contain both abstract and concrete (normal) methods.
    4️⃣ At least one abstract method is required to make a class abstract.
    5️⃣ Child class must override all abstract methods, otherwise, it must also be declared abstract.
    6️⃣ Cannot have private or static abstract methods since abstract methods must be overridden.
    7️⃣ Can have final methods, but those cannot be overridden in child classes.
    8️⃣ Abstract methods must be declared inside an abstract class (cannot exist in a normal class).
    9️⃣ Can extend another abstract class and inherit its abstract methods.
    🔟 Can implement interfaces along with defining abstract methods.
    

    Access Modifier	                 Allowed?	                 Explanation
       public	                     ✅ Yes	                    Abstract methods can be public and must be overridden in child classes.
       protected	                 ✅ Yes	                    Can be accessed by child classes within the same package or through inheritance.
       private	                     ❌ No	                    Not allowed because abstract methods must be overridden, and private methods are not accessible in child classes.
       static	                     ❌ No	                    Abstract methods require overriding, but static methods belong to the class and cannot be overridden.
 */


public class AbstractClass {
    
    static abstract class Phone {
        protected String brand;
        protected String IMEI;

        public Phone(String brand, String IMEI) {
            this.IMEI = IMEI;
            this.brand = brand;
        }
        
        abstract void call(String number);

        public void showBrand() {
            System.out.println("Brand: " + brand);
        }

        // Private method (hidden from child classes)
        private void securityCheck() {
            System.out.println("Performing security check using IMEI: " + IMEI);
        }
    }

    static class SmartPhone extends Phone {
        public SmartPhone(String brand, String IMEI) {
            super(brand, IMEI);
        }

        @Override
        void call(String number) {
            System.out.println(brand + " calling " + number + " using VoLTE...");
        }
    }

    public static void main(String[] args) {
        Phone p1 = new SmartPhone("Apple", "155153131318");
        p1.securityCheck(); // This line should cause a compilation error
        
        p1.call("54434543");
        p1.showBrand();
    }
}
