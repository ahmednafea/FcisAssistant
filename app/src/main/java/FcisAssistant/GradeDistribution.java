package FcisAssistant;

public class GradeDistribution {
    protected int MaxAssignment;
    protected int MaxMidterm;
    protected int MaxFinal;
    protected int MaxAttendance;
    protected int MaxBounce;
    protected int MaxQuizzes;
    protected int MaxPractical;
    protected int MaxWeight;

    public GradeDistribution(int maxAssignment,
                             int maxMidterm, int maxFinal, int maxAttendance,
                             int maxBounce, int maxQuizzes, int maxPractical, int maxWeight) {
        MaxAssignment = maxAssignment;
        MaxMidterm = maxMidterm;
        MaxFinal = maxFinal;
        MaxAttendance = maxAttendance;
        MaxBounce = maxBounce;
        MaxQuizzes = maxQuizzes;
        MaxPractical = maxPractical;
        MaxWeight = maxWeight;
    }
    public GradeDistribution() {
        MaxAssignment=0;
        MaxMidterm=0;
        MaxFinal=0;
        MaxAttendance=0;
        MaxBounce=0;
        MaxQuizzes=0;
        MaxPractical=0;
        MaxWeight=0;
    }
    public int getMaxAssignment() {
        return MaxAssignment;
    }

    public void setMaxAssignment(int maxAssignment) {
        MaxAssignment = maxAssignment;
    }

    public int getMaxMidterm() {
        return MaxMidterm;
    }

    public void setMaxMidterm(int maxMidterm) {
        MaxMidterm = maxMidterm;
    }

    public int getMaxFinal() {
        return MaxFinal;
    }

    public void setMaxFinal(int maxFinal) {
        MaxFinal = maxFinal;
    }

    public int getMaxAttendance() {
        return MaxAttendance;
    }

    public void setMaxAttendance(int maxAttendance) {
        MaxAttendance = maxAttendance;
    }

    public int getMaxBounce() {
        return MaxBounce;
    }

    public void setMaxBounce(int maxBounce) {
        MaxBounce = maxBounce;
    }

    public int getMaxQuizzes() {
        return MaxQuizzes;
    }

    public void setMaxQuizzes(int maxQuizzes) {
        MaxQuizzes = maxQuizzes;
    }

    public int getMaxPractical() {
        return MaxPractical;
    }

    public void setMaxPractical(int maxPractical) {
        MaxPractical = maxPractical;
    }

    public int getMaxWeight() {
        return MaxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        MaxWeight = maxWeight;
    }
}
