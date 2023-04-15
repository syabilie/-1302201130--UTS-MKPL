package lib;

public class TaxFunction {

	
	private static final int MAX_CHILDREN = 3;
	private static final double TAX_RATE = 0.05;
	
	public static int calculateTax(double monthlySalary, double otherMonthlyIncome, int numberOfMonthsWorking, double deductible, boolean isMarried, int numberOfChildren) {
		
		if (numberOfMonthsWorking > 12) {
			System.err.println("More than 12 month working per year");
			return 0;
		}
		
		// Hitung penghasilan tidak kena pajak berdasarkan status perkawinan dan jumlah anak
		double nonTaxableIncome = calculateNonTaxableIncome(isMarried, numberOfChildren);
		
		// Menghitung penghasilan kena pajak
		double taxableIncome = calculateTaxableIncome(monthlySalary, otherMonthlyIncome, numberOfMonthsWorking, deductible, nonTaxableIncome);
		
		// Calculate tax amount
		int taxAmount = calculateTaxAmount(taxableIncome);
		
		return taxAmount;
	}
	
	private static double calculateNonTaxableIncome(boolean isMarried, int numberOfChildren) {
		double nonTaxableIncome = 0;
		if (isMarried) {
			nonTaxableIncome += 2_000_000;
		} else {
			nonTaxableIncome += 1_000_000;
		}
		nonTaxableIncome += numberOfChildren * 500_000;
		nonTaxableIncome *= 12;
		return nonTaxableIncome;
	}
	
	private static double calculateTaxableIncome(double monthlySalary, double otherMonthlyIncome, int numberOfMonthsWorking, double deductible, double nonTaxableIncome) {
		double totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthsWorking;
		totalIncome -= deductible;
		totalIncome -= nonTaxableIncome;
		return totalIncome;
	}
	
	private static int calculateTaxAmount(double taxableIncome) {
		return (int) Math.ceil(taxableIncome * TAX_RATE);
	}
	
	
}
