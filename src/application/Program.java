package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitie.TaxPayer;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> payer = new ArrayList<>();
		int i = 1;

		System.out.print("Quantos contribuintes voc� vai digitar? ");
		int repeat = sc.nextInt();

		for (int j = 1; j <= repeat; j++) {
			System.out.println("Digite os dados do " + j + "� contribuinte:");
			System.out.print("Renda anual com sal�rio: ");
			double salary = sc.nextDouble();
			System.out.print("Renda anual com presta��o de servi�o: ");
			double services = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capital = sc.nextDouble();
			System.out.print("Gastos m�dicos: ");
			double medicalCosts = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double education = sc.nextDouble();
			System.out.println();
			TaxPayer tax = new TaxPayer(salary, services, capital, medicalCosts, education);
			payer.add(tax);
		}
		
		for (TaxPayer taxPayer : payer) {
			System.out.println("Resumo do " + i + "� contribuinte");
			System.out.println(taxPayer);
			i++;
		}

		sc.close();
	}
}
