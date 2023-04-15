package lib;

public class TaxFunction {

	private static final int NON_TAXABLE_INCOME_SINGLE = 54000000;
	private static final int NON_TAXABLE_INCOME_MARRIED = 58500000;
	private static final int NON_TAXABLE_CHILDREN = 4500000;
	private static final int MAX_CHILDREN = 3;
	private static final double TAX_RATE = 0.05;

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {

		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
			return 0;
		}

		// Hitung penghasilan tidak kena pajak berdasarkan status perkawinan dan jumlah anak
		int nonTaxableIncome = calculateNonTaxableIncome(isMarried, numberOfChildren);

		// Menghitung penghasilan kena pajak
		int taxableIncome = calculateTaxableIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible, nonTaxableIncome);

		// Calculate tax amount
		int tax = calculateTaxAmount(taxableIncome);

		return tax;

	}

	private static int calculateNonTaxableIncome(boolean isMarried, int numberOfChildren) {
		int nonTaxableIncome = isMarried ? NON_TAXABLE_INCOME_MARRIED : NON_TAXABLE_INCOME_SINGLE;
		nonTaxableIncome += numberOfChildren > 0 ? (Math.min(numberOfChildren, MAX_CHILDREN) * NON_TAXABLE_CHILDREN) : 0;
		return nonTaxableIncome;
	}

	private static int calculateTaxableIncome(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, int nonTaxableIncome) {
		return ((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - nonTaxableIncome;
	}

	private static int calculateTaxAmount(int taxableIncome) {
		int tax = (int) Math.round(TAX_RATE * taxableIncome);
		return tax < 0 ? 0 : tax;
	}

}
