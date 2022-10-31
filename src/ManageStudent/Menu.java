package ManageStudent;




import ManageStudent.constain.ConstantVariables;
import ManageStudent.model.StudentMethod;

import java.util.Scanner;


public class Menu {


    static int selectOption;
   private static Scanner scanner = new Scanner(System.in);
    public static void printMenu() {
        System.out.println(""
                + "\n1. Nhập danh sách học viên."
                + "\n2. In danh sách học viên."
                + "\n3. Tìm kiếm học viên theo khoảng điểm."
                + "\n4. Tìm kiếm học viên theo học lực."
                + "\n5. Cập nhật thông tin học viên."
                + "\n6. Sắp xếp học viên theo điểm."
                + "\n7. Đưa ra 5 học viên có điểm cao nhất."
                + "\n8. Điểm trung bình của lớp."
                + "\n9. Danh sách học viên có điểm trên Trung bình cộng cả lớp."
                + "\n10.Tổng hợp số học viên theo học lực."
                + "\n0. Thoát."
                + "\n");
    }

    public static void createMenu() {

        printMenu();

        while (true) {
            try {

                System.out.println("Lựa chọn: ");
                selectOption = Integer.parseInt(scanner.nextLine());
                if (selectOption < 0 || selectOption > 11) {
                    System.out.println("Cho phép lựa chọn từ 1-10");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.print("Chỉ nhập số !");
            }
        }
        switch (selectOption) {
            case 1:
                StudentMethod.inputStudentList();
                createMenu();
                break;
            case 2:
                System.out.println("Danh sách sinh viên trong list:\n");
                System.out.printf("%30s%10s%30s%20s\n", "Họ và Tên", "Điểm", "Email", "Học lực");
                StudentMethod.showFullList();
                createMenu();
                break;
            case 3:

                StudentMethod.printListStudentWithMark();
                createMenu();
                break;
            case 4:
                StudentMethod.printListStudentWithRank();
                createMenu();
                break;
            case 5:
                StudentMethod.updateStudentInfo();
                createMenu();
                break;
            case 6:
                System.out.printf("%30s%10s%30s%20s\n", "Họ và Tên", "Điểm", "Email", "Học lực");
                StudentMethod.sortStudentMark();
                createMenu();
                break;
            case 7:
                StudentMethod.getTop5StudentsHaveHighesMark();
                createMenu();
                break;
            case 8:
                System.out.printf("Điểm trung bình của cả lớp: %.2f", StudentMethod.averageMark());
                System.out.println();
                createMenu();
                break;
            case 9:
                StudentMethod.printStudentHaveMark();
                createMenu();
                break;
            case 10:
                System.out.println("*** Học lực Xuất Sắc ***");
                StudentMethod.getStudentRank(ConstantVariables.RANK_NAME_EXCELLENT);
                System.out.println("*** Học lực Giỏi ***");
                StudentMethod.getStudentRank(ConstantVariables.RANK_NAME_VERY_GOOD);
                System.out.println("*** Học lực Khá ***");
                StudentMethod.getStudentRank(ConstantVariables.RANK_NAME_GOOD);
                System.out.println("*** Học lực Trung bình ***");
                StudentMethod.getStudentRank(ConstantVariables.RANK_NAME_BAD);
                System.out.println("*** Học lực Yếu ***");
                StudentMethod.getStudentRank(ConstantVariables.RANK_NAME_VERY_BAD);
                createMenu();
                break;
            case 0:
                break;
            default:
                System.out.println("Thoat");
        }
    }


}

