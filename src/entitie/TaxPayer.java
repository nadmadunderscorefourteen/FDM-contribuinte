package entitie;

public class TaxPayer {

	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	private double thirtyPerCent = 0.3;
	private double twenyPerCent = 0.2;
	private double tenPerCent = 0.1;
	private double fifteenPerCent = 0.15;

	public TaxPayer() {
	}

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {
		double anualSalary = salaryIncome / 12;
		if (anualSalary >= 3000 & anualSalary < 5000) {
			return salaryIncome * tenPerCent;
		} else if (anualSalary >= 5000) {
			return salaryIncome * twenyPerCent;
		}
		return 0;
	}

	public double servicesTax() {
		return (!(servicesIncome == 0)) ? servicesIncome * fifteenPerCent : 0;
	}

	public double capitalTax() {
		return (!(capitalIncome == 0)) ? capitalIncome * twenyPerCent : 0;
	}

	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public double taxRebate() {
		return (healthSpending + educationSpending < grossTax()) ? healthSpending + educationSpending
				: grossTax() * thirtyPerCent;
	}

	public double netTax() {
		return (taxRebate() != healthSpending + educationSpending) ? grossTax() - taxRebate()
				: grossTax() - (healthSpending + educationSpending);
	}

	@Override
	public String toString() {
		return String.format("Imposto bruto total: %.2f\n", grossTax())
				+ String.format("Abatimento: %.2f\n", taxRebate()) 
				+ String.format("Imposto devido: %.2f\n", netTax());
	}
}
