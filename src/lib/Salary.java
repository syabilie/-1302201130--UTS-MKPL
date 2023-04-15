package lib;

public class Salary {
    private int grade;
    private boolean isForeigner;
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public Salary(int grade, boolean isForeigner) {
        this.grade = grade;
        this.isForeigner = isForeigner;
        setMonthlySalary();
    }

    public void setMonthlySalary() {
        switch (grade) {
            case 1:
                monthlySalary = 3000000;
                break;
            case 2:
                monthlySalary = 5000000;
                break;
            case 3:
                monthlySalary = 7000000;
                break;
            default:
                throw new IllegalArgumentException("Invalid grade: " + grade);
        }

        if (isForeigner) {
            monthlySalary = (int) (monthlySalary * 1.5);
        }
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }

    public int getGrade() {
        return grade;
    }

    public boolean isForeigner() {
        return isForeigner;
    }
}


