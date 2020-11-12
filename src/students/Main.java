package students;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            if (new File("resource/students.dat").exists() == false){
                System.out.println("This file does not exist!");
            }
            FileReader fr = new FileReader("resource/students.dat");
            String line;
            BufferedReader reader = new BufferedReader(fr);
            line = reader.readLine();
            int num = Integer.parseInt(line);
            System.out.println("File contains " + num + " records");
            Student[] array = new Student[num];
            for (int i = 0; i < num; i++){
                line = reader.readLine();
                String[] temp = line.split(" ");
                Student s = new Student(temp[0], temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]));
                array[i] = s;

            }
            printAllAge(array);

            fr.close();


        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void printAllStudents(Student[] array){
        System.out.println("\033[33mList of all students: \033[0m");
        for (Student student : array) {
            System.out.println(student.getFname() + " " + student.getLname() + " " + student.getHeight() + " " + student.getWeight());
        }
        System.out.println();
    }

    public static void printAllWomen(Student[] array){
        System.out.println("\033[35mList of all women: \033[0m");
        for (Student student : array){
            if (student.getGender()==Gender.FEMALE){
                System.out.println(student.getFname() + " " + student.getLname());
            }
        }
        System.out.println();
    }

    public static void printAllAge(Student[] array){
        System.out.println("\033[31mAge of all students: \033[0m");
        for (Student student : array){
            System.out.println(student.getFname() + " " + student.getLname() + ": " + student.getAge());
        }
        System.out.println();
    }
}
