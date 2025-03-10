import java.util.ArrayList;

public class ShallowDeep {
    
    public static class Student {
        String name;
        int age;
        ArrayList<Integer> grades;

        Student(int age, String name, ArrayList<Integer> gradeList){
            this.age = age;
            this.name = name;
            this.grades = gradeList;
        }

        // Shallow copy
        Student(Student s){
            this.name = s.name;
            this.age = s.age;
            this.grades = s.grades;
        }

        // Deep Copy
        // Student(Student stud){
        //     this.name = stud.name;
        //     this.age = stud.age;
        //     this.grades = new ArrayList<>(stud.grades);
        // }

        void displayInfo(){
            System.out.println(this.age);
            System.out.println(this.name);
            System.out.println(this.grades);
        }
        
    }



    public static void main(String[] args) {
        ArrayList<Integer> grade = new ArrayList<>();
        grade.add(1);
        grade.add(2);
        grade.add(3);
        grade.add(4);
        grade.add(5);

        Student student = new Student(2, "Shivam", grade);
        student.displayInfo();

        Student student1 = new Student(student);
        student1.displayInfo();

        System.out.println("---------------------------------------------------------------");
        student1.grades.add(6);
        student1.age = 5;
        student.displayInfo();
        student1.displayInfo();
    }

}
