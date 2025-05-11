import java.util.ArrayList;

public class Prac2 {
    
    public static class Person{
        String name;
        int age;
        ArrayList<Integer> marks;

        Person(String name, int age, ArrayList<Integer> m){
            this.name= name;
            this.age = age;
            this.marks = m;
        }
        //shallow 
        // Person(Person p){
        //     this.name = p.name;
        //     this.age=p.age;
        //     this.marks = p.marks;
        // }


        //deep
        Person(Person p){
            this.age = p.age;
            this.name = p.name;
            this.marks = new ArrayList<>(p.marks);
        }

        public void printDetail(){
            System.out.println(this.name + " " + this.age);
            System.out.println(this.marks);
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>(); 
        marks.add(10);
        marks.add(20);
        marks.add(30);
        Person p1 = new Person("Annu", 19, marks);
        
        Person p2 = new Person(p1);
        
        p2.name="Vibha";
        p2.age = 54;
        p2.marks.add(50);
        p1.printDetail();
        p2.printDetail();

    }
}
