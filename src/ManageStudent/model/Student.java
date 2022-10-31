package ManageStudent.model;



import java.io.Serializable;

public class Student implements Serializable {

    private String fullName;
    private double mark;
    private String email;
    public Student() {

    }
    public Student(String fullName, double mark, String email) {
        this.fullName = fullName;
        this.mark = mark;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String Rank() {

        if (mark <= 5) {
            return Rank.VERRY_BAD.getRankName();
        }
        if (mark > 5 && mark <= 6.5) {
            return Rank.BAD.getRankName();
        }
        if (mark > 6.5 && mark <= 7.5) {
            return Rank.GOOD.getRankName();
        }
        if (mark > 7.5 && mark <= 9) {
            return Rank.VERRY_GOOD.getRankName();
        }
        return Rank.EXCELLENT.getRankName();
    }

    public  String toString()
    {
        return  fullName +"," + mark +"," + email + "," + Rank()+"\n";
    }
    public  void showStudent() {
        System.out.printf("%30s%10s%30s%20s\n", fullName,mark, email,Rank());
    }



}
