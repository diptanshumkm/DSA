// -------------------------------------------Copy constructor---------------------------------------------------
public class CopyCtor {
    public static class Student {
        int age;
        String name;

        Student(int age, String name){
            this.age = age;
            this.name = name;
        }

        // Copy ctor
        Student(Student s){
            this.name = s.name;
            this.age = s.age;
        }
        
        void displayInfo(){
            System.out.println(this.name);
            System.out.println(this.age);
        }
    }

    public static void main(String[] args) {
        
       System.out.println();
       Student s1 = new Student(22, "Shiv");
       Student s2 = new Student(s1);

       s1.displayInfo();
       System.out.println();
       System.out.println();
       s2.displayInfo();
    }
     
}