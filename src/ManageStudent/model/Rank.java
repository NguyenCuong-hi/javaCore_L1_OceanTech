package ManageStudent.model;

public enum Rank {


    EXCELLENT("1", "XUAT SAC"),
    VERRY_GOOD("2", "GIOI"),
    GOOD("3", "KHA"),
    BAD("4", "Trung Binh"),
    VERRY_BAD("5", "Yeu");

    private  String rankName;
    private  String rankID;

    private Rank(String rankID, String rankName) {
        this.rankID = rankID;
        this.rankName = rankName;
    }

    public String getRankID() {
        return rankID;
    }

    public String getRankName() {
        return rankName;
    }
}
