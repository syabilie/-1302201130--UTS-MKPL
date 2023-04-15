package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {
    private PersonalInfo personalInfo;
    private Salary salary;
    private Family family;
	private PersonalInfo person;

    public Employee(PersonalInfo personalInfo, Salary salary, Family family, PersonalInfo person) {
        this.personalInfo = personalInfo;
        this.salary = salary;
        this.family = family;
		this.person = person;
    }

    public int getAnnualIncomeTax() {
        LocalDate currentDate = LocalDate.now();
        int monthsWorked = 12;
        if (currentDate.getYear() == personalInfo.getDateJoined().getYear()) {
            monthsWorked = currentDate.getMonthValue() - personalInfo.getDateJoined().getMonthValue();
        }
        int numChildren = family.getChildIdNumbers().size();
        boolean isMarried = family.getSpouseIdNumber() != null && !family.getSpouseIdNumber().isEmpty();
        return TaxFunction.calculateTax(salary.getMonthlySalary(), salary.getOtherMonthlyIncome(), monthsWorked, salary.getAnnualDeductible(), isMarried, numChildren);
    }
}
