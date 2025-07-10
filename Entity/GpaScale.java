package Nguoi.Entity;

public enum GpaScale {
    A(0, 3.0f, "Kém"),
    B(3.0f, 5.0f, "Yếu"),
    C(5.0f, 6.5f, "Trung bình"),
    D(6.5f, 7.5f, "Khá"),
    F(7.5f, 9.0f, "Giỏi"),
    G(9.0f, 10.0f, "Xuất sắc");

    private final float minGpa;
    private final float maxGpa;
    private final String description;

    GpaScale(float minGpa, float maxGpa, String description) {//constructor của java được ngầm định là private
        this.minGpa = minGpa;
        this.maxGpa = maxGpa;
        this.description = description;
    }

    public float getMinGpa() {
        return minGpa;
    }

    public float getMaxGpa() {
        return maxGpa;
    }

    public String getDescription() {
        return description;
    }

    public static String getPerformance(float gpa) {
        {
            if (gpa >= A.getMinGpa() && gpa < A.getMaxGpa()) {
                return A.getDescription();
            } else if (gpa >= B.getMinGpa() && gpa < B.getMaxGpa()) {
                return B.getDescription();
            } else if (gpa >=C.getMinGpa() && gpa < C.getMaxGpa()) {
                return C.getDescription();
            } else if (gpa >= D.getMinGpa() && gpa < D.getMaxGpa()) {
                return D.getDescription();
            } else if (gpa >= F.getMinGpa() && gpa < F.getMaxGpa()) {
                return F.getDescription();
            } else if (gpa >= G.getMinGpa() && gpa <= G.getMaxGpa()) {
                return G.getDescription();
            }
        }
        return "GPA không hợp lệ";
    }
}
