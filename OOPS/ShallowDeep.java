
public class ShallowDeep {
    
    public static class Address {
        String city;

        Address(String city){
            this.city = city;
        }
    }

    public static class Person{
        int age;
        Address address;

        Person(int age, Address add){
            this.age = age;
            this.address = add;
        }
        // Shallow copy ctor
        // Copies the age and the *reference* of the Address object (both persons share the same address)
        // Person(Person p){
        //     this.age = p.age;
        //     this.address=p.address;
        // }

        // Deep copy ctor
        Person(Person p){
            this.age = p.age;
            this.address = new Address(p.address.city); // Deep copy: creates a new Address object with the same city
        }

        void displayInfo(){
            System.out.println(this.age);
            System.out.println(this.address.city);
        }
    }

    public static void main(String[] args) {
        Address address = new Address("Wellington");
        Person per1 = new Person(22, address);
        Person per2 = new Person(per1);

        per1.displayInfo();
        System.out.println();
        per2.displayInfo();

        address.city="Auckland";
        per1.displayInfo();
        System.err.println();
        per2.displayInfo();


    }
}
