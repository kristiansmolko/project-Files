package students;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Student[] array = null;
        array = readStudentsFromFile(array);
        array = readContactsFromFile(array);
        printContacts(array);



    }

    private static Student[] readContactsFromFile(Student[] array){
        try {
            if (!new File("resource/contacts.dat").exists()){
                System.out.println("This file does not exist!");
            }
            FileReader fr = new FileReader("resource/contacts.dat");
            String line;
            BufferedReader reader = new BufferedReader(fr);
            String email = null;
            String mobil = null;
            String skype = null;
            while ((line= reader.readLine()) != null){
                String[] temp = line.split(" ");
                for (Student student : array) {
                    Contact contact = new Contact();
                    if (temp[0].equals(student.getFname()) && temp[1].equals(student.getLname())) {
                        for (int i = 2; i < temp.length; i++) {
                            String temp1 = temp[i];
                            switch (temp1.substring(0, 5)) {
                                case "email" -> email = temp1.substring(6);
                                case "mobil" -> mobil = temp1.substring(6);
                                case "skype" -> skype = temp1.substring(6);
                            }
                        }
                        if (email != null)
                            contact.setEmail(email);
                        if (skype != null)
                            contact.setSkype(skype);
                        if (mobil != null)
                            contact.setMobil(mobil);
                        student.setContact(contact);
                        break;
                    }

                }
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return array;
    }


    private static Student[] readStudentsFromFile(Student[] array) {
        try{
            if (!new File("resource/students.dat").exists()){
                System.out.println("This file does not exist!");
            }
            FileReader fr = new FileReader("resource/students.dat");
            String line;
            BufferedReader reader = new BufferedReader(fr);
            line = reader.readLine();
            int num = Integer.parseInt(line);
            System.out.println("File contains " + num + " records");
            array = new Student[num];
            for (int i = 0; i < num; i++){
                line = reader.readLine();
                String[] temp = line.split(" ");
                Student s = new Student(temp[0], temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]));
                array[i] = s;

            }
            fr.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return array;
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

    public static void printContacts(Student[] array) throws NullPointerException{
        System.out.println("Contact of students: ");
        for (Student student : array){
            if (student.getContact() != null) {
                System.out.println(student.getFname() + " " + student.getLname() + " ");
                student.getContact().print();
            }
            else{
                System.out.println(student.getFname() + " " + student.getLname());
                System.out.println("\033[31mHas no contacts yet\033[0m");
            }
            System.out.println();
        }
        System.out.println();
    }
}
