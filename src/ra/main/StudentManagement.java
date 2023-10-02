package ra.main;

import ra.entity.Student;

import java.util.Scanner;

public class StudentManagement {
    //khởi tạo mảng arrStudents để chứa all data của sinh viên
    private static Student[] arrStudents = new Student[100];
    private static int indexCurrent = 0; //khởi tạo chỉ số phần tử nhập data
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("******************MENU*****************");
            System.out.println("1. Nhập thông tin n sinh viên");
            System.out.println("2. Hiển thị thông tin n sinh viên");
            System.out.println("3. Thoát");
            System.out.println("****************************************");
            System.out.println("Mời bạn lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("1. Nhập thông tin n sinh viên");
                    StudentManagement.inputListStudent();
                    break;
                case 2:
                    System.out.println("2. Hiển thị thông tin n sinh viên");
                    StudentManagement.displayListStudent();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("vui lòng nhập từ 1->3");
            }

        } while (true);
    }
    public static void inputListStudent(){
        System.out.println("Nhập vào sô sinh viên cần nhập thông tin: ");
        int n =Integer.parseInt(scanner.nextLine());
        for(int i=0; i<n; i++){
            //khởi tạo phần tử thức indexCurrent là 1 đối tượng sinh viên cần nhập
            arrStudents[indexCurrent]=new Student();
            //nhập thông tin cho sinh viên
            arrStudents[indexCurrent].inputData(scanner,arrStudents,indexCurrent);
            //tang indexCurrent
            indexCurrent++;
        }
    }
    public static void displayListStudent(){
        for(int i=0;i<indexCurrent;i++){
            arrStudents[i].displayData();
        }
    }

}
