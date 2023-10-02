package ra.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private String email;
    private String phone;
    private boolean sex;
    private float javascore;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, String email, String phone, boolean sex, float javascore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.javascore = javascore;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isSex() {
        return sex;
    }

    public float getJavascore() {
        return javascore;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setJavascore(float javascore) {
        this.javascore = javascore;
    }

    public void inputData(Scanner scanner, Student[] arrStudent, int currentIndex) {
        //vòng lặp chạy vô hạn
        boolean isExit = true;
        System.out.println("Nhập vào mã SV: "); //Có 5 ký tự, bắt đầu là ký tự P, không trùng lặp
        do {
            this.studentId = scanner.nextLine();
            //Có 5 ký tự
            if (studentId.length() == 5) {
                //bắt đầu là ký tự P
                if (studentId.startsWith("P")) {
                    //không trùng lặp
                    boolean isExist = false; //tồn lại
                    for (int i = 0; i < currentIndex; i++) {
                        if (arrStudent[i].getStudentId().equals(this.studentId)) {
                            isExist = true; //đã tồn tại
                            break; //cua vong for
                        }
                    }
                    //sau khi kết thúc vòng for ->maSv đã tồn tại thì:
                    if (isExist) {
                        System.err.println("Mã SV đã tồn tại, vui lòng nhập lại!");
                    } else {
                        // thoã mãn điều kiện thì break, thoát khỏi do while
                        break;
                    }
                } else {
                    System.err.println("Mã SV phải bắt đầu là ký tự P, vui lòng nhập lại!");
                }
            } else {
                System.err.println("Mã SV phải gồm 5 ký tự, vui lòng nhập lại!");
            }
        } while (isExit); //thoát

        System.out.println("Nhập tên SV: "); //có độ dài từ 10-50 ký tự
        do {
            this.studentName = scanner.nextLine();
            if (studentName.length() >= 10 && studentName.length() <= 50) {
                //thoã mãn đk thì
                break;
            } else {
                System.err.println("Tên SV phải từ 10->50 ký tự, vui lòng nhập lai!");
            }

        } while (isExit);

        System.out.println("Nhập vào tuổi SV: "); //có giá trị lớn hơn 0
        do {
            this.age = Integer.parseInt(scanner.nextLine());
            if(this.age>0){
                break;
            }else {
                System.err.println("Nhập vào tuổi phải lớn hơn 0, vui lòng nhập lại!");
            }

        } while (isExit);

        String regexEmail="([a-z0-9_.-]+)@([a-z0-9_.-]+[a-z])";
        System.out.println("Nhập vào Email: "); //có định dạng email
        do {
            this.email=scanner.nextLine();
            //nếu khớp
            if(Pattern.matches(regexEmail,this.email)){
                break;
            }else {
                System.err.println("Định email chưa đúng, vui lòng nhập lại!");
            }
        }while (isExit);

        String regexPhone="^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        System.out.println("Nhập vào số phone: ");
        do {
            this.phone=scanner.nextLine();
            if(Pattern.matches(regexPhone,this.phone)){
                break;
            }else {
                System.err.println("Không đúng dịnh dạng phone, vui lòng nhập lại!");
            }

        }while (isExit);

        System.out.println("Nhập vào giới tính: ");
        do {
            String gender=scanner.nextLine();
            if(gender.equals("True") || gender.equals("False")){
                this.sex=Boolean.parseBoolean(gender);
                break;
            }else {
                System.err.println("Giới tính chỉ nhập vào true || false, vui lòng nhập lại!");
            }
        }while (isExit);

        System.out.println("Nhập vào điểm javaCore: ");
        do {
            this.javascore=Float.parseFloat(scanner.nextLine());
            if(this.javascore>=0 && this.javascore<=10){
                break;
            }else {
                System.err.println("Điểm nhậo vào từ 0->10, vui lòng nhập lại!");
            }
        }while (isExit);
    }

    public void displayData(){
        System.out.printf("Mã SV: %s - Tên SV: %s - Tuổi: %d - Email: %s\n", this.studentId, this.studentName, this.age, this.email);
        System.out.printf("Số phone: %s - Giới tính: %b - Điểm javacore: %f\n", this.phone, this.sex ? "Nam" : "Nữ", this.javascore);
        System.out.println("------------------------------------");
    }


}
