package ManageStudent.model;

import ManageStudent.constain.ConstantVariables;

import java.util.*;
import java.util.regex.Pattern;

public class StudentMethod {
    private static List<Student> studentList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static String setFullName() {
        String fullName;
        do {
            System.out.println("Họ và tên : ");
            fullName = scanner.nextLine();
            if (fullName.isEmpty()) {
                System.out.println("Tên không được để trống!");
            }
        } while (fullName.isEmpty());
        return fullName;
    }

    public static double setMark() {
        double mark;
        while (true) {
            try {
                System.out.println("\nĐiểm: ");
                mark = Double.parseDouble(scanner.nextLine());
                if (mark < ConstantVariables.MARK_LIMIT_MIN || mark > ConstantVariables.MARK_LIMIT_MAX) {
                    System.out.println("Nhập sai! Khoảng điểm từ (0-10)");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.print("Không đúng ! Điểm phải có giá trị là số !");
            }
        }
        return mark;
    }

    static boolean isValid(String emailAddress, String regexPattern) {

        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static String setEmail() {

        String emailAddress;
        do {
            System.out.println("Email: ");
            emailAddress = scanner.nextLine();
            if (!isValid(emailAddress, ConstantVariables.REGEX_PATTERN) || emailAddress.isEmpty()) {
                System.out.println("Email có dạng abc@gmail.com và Email không được để trống !\n");
            } else {
                break;
            }
        } while (!isValid(emailAddress, ConstantVariables.REGEX_PATTERN) || emailAddress.isEmpty());

        return emailAddress;
    }

    public static Student setStudent() {
        String fullName = setFullName();
        double mark = setMark();
        String email = setEmail();
        Student newStudent = new Student(fullName, mark, email);
        return newStudent;
    }

    public static void inputStudentList() {
        studentList.add(setStudent());
        System.out.println("Thêm sinh viên thành công !");
    }

    public static void printList(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Danh sách rỗng !");
        } else {
            for (Student student : students) {
                student.showStudent();
            }
        }
    }

    public static void showFullList() {
        printList(studentList);
    }

    public static List<Student> findStudentMark() {

        double minMark;
        double maxMark;
        while (true) {
            try {
                System.out.println("\nMức điểm nhỏ nhất : ");
                minMark = Double.parseDouble(scanner.nextLine());
                System.out.println("\nMức điểm lớn nhất : ");
                maxMark = Double.parseDouble(scanner.nextLine());
                if (minMark < ConstantVariables.MARK_LIMIT_MIN || minMark > ConstantVariables.MARK_LIMIT_MAX
                        && maxMark < ConstantVariables.MARK_LIMIT_MIN || maxMark > ConstantVariables.MARK_LIMIT_MAX) {
                    System.out.print("Nhập khoảng điểm cho phép (0-10)");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự !");
            }
        }
        if (minMark > maxMark) {
            double temp = minMark;
            minMark = maxMark;
            maxMark = temp;
        }
        int index = 0;
        List<Student> getStudentWithMark = new ArrayList<>();
        for (Student newStudent : studentList) {
            if (newStudent.getMark() > minMark && newStudent.getMark() < maxMark) {
                getStudentWithMark.add(newStudent);
                index++;
            }
        }
        if (index == 0) {
            System.out.println("Không tìm thấy sinh viên !");
        }
        return getStudentWithMark;
    }

    public static void printListStudentWithMark() {
        List<Student> studentsWithMark = findStudentMark();
        System.out.printf("%30s%10s%30s%20s\n", "Họ và Tên", "Điểm", "Email", "Học lực");
        printList(studentsWithMark);
    }


    public static List<Student> findStudentCapcity() {
        int selectRank;
        List<Student> studentRankList = new ArrayList<>();
        String findRank = Rank.EXCELLENT.getRankName();
        while (true) {
            try {
                System.out.println("Mức học lực: " +
                        "\n1.Xuat Sac" +
                        "\n2.Gioi" +
                        "\n3.Kha" +
                        "\n4.Trung binh" +
                        "\n5.Yeu");
                selectRank = Integer.parseInt(scanner.nextLine());
                if (selectRank < ConstantVariables.RANK_SELECT_MIN || selectRank > ConstantVariables.RANK_SELECT_MAX) {
                    System.out.println("Nhập sai! Lựa chọn từ (1-5)");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.print("Không đúng ! Điểm phải có giá trị là số !");
            }
        }
        switch (selectRank) {
            case 1:
                findRank = Rank.EXCELLENT.getRankName();
                break;
            case 2:
                findRank = Rank.VERRY_GOOD.getRankName();
                break;
            case 3:
                findRank = Rank.GOOD.getRankName();
                break;
            case 4:
                findRank = Rank.BAD.getRankName();
                break;
            case 5:
                findRank = Rank.VERRY_BAD.getRankName();
                break;
        }
        for (Student student : studentList) {
            if (student.Rank().equals(findRank)) {
                studentRankList.add(student);
            }
        }
        return studentRankList;
    }

    public static void printListStudentWithRank() {
        List<Student> listStudentWithRank = findStudentCapcity();
        System.out.printf("%30s%10s%30s%20s\n", "Họ và Tên", "Điểm", "Email", "Học lực");
        printList(listStudentWithRank);
    }

    public static void updateStudentInfo() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách rỗng !");
        } else {
            int studentCode;
            do {
                System.out.println("Mã sinh viên: ");
                studentCode = scanner.nextInt();
                if (studentCode > studentList.size() || studentCode < 0) {
                    System.out.println("Mã sinh viên không vượt quá số lượng sinh viên !");
                } else {
                    break;
                }
            } while (studentCode > studentList.size() || studentCode < 0);
            Student updateStudent = setStudent();
            studentList.set(studentCode, updateStudent);
            System.out.println("Sửa thành công !");
        }
    }

    public static void sortStudentMark() {
        studentList.sort(Comparator.comparing(Student::getMark));
        printList(studentList);
    }

    public static void getTop5StudentsHaveHighesMark() {

        if (studentList.size() < 5) {
            System.out.println("Số lượng học viên nhỏ hơn 5 !");
            System.out.printf("%30s%10s%30s%20s\n", "Họ và Tên", "Điểm", "Email", "Học lực");
            sortStudentMark();
        } else {
            System.out.printf("%30s%10s%30s%20s\n", "Họ và Tên", "Điểm", "Email", "Học lực");
            studentList.sort(Comparator.comparing(Student::getMark).reversed());
            for (int studentIndex = 0; studentIndex < 5; studentIndex++) {
                System.out.println(studentList.get(studentIndex));
                System.out.println();
            }
        }
    }

    public static float averageMark() {
        float average = 0.0f;
        if (studentList.isEmpty()) {
            System.out.println("Không có dữ liệu !");
        } else {
            float sum = 0.0f;
            for (Student student : studentList) {
                sum += student.getMark();
            }
            average = sum / studentList.size();
        }
        return average;
    }

    public static List<Student> getStudentMark() {
        System.out.printf("%30s%10s%30s%20s\n", "Họ và Tên", "Điểm", "Email", "Học lực");
        List<Student> studentsAverage = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getMark() >= averageMark()) {
                studentsAverage.add(student);
            }
        }
        return studentsAverage;
    }

    public static void printStudentHaveMark() {

        List<Student> listStudentHaveMarkAverage = getStudentMark();
        printList(listStudentHaveMarkAverage);

    }

    public static void getStudentRank(String findRank) {
        System.out.printf("%30s%10s%30s%20s\n", "Họ và Tên", "Điểm", "Email", "Học lực");
        int count = 0;
        for (Student student : studentList) {
            if (student.Rank().equalsIgnoreCase(findRank)) {
                student.showStudent();
                System.out.println();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Danh sách rỗng !");
        }
    }

}
