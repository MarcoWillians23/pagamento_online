package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PayPalService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Número: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double value = sc.nextDouble();

		Contract contract = new Contract(number, date, value);

		System.out.println();
		System.out.print("Entre com o número de parcelas: ");
		int n = sc.nextInt();

		ContractService contractService = new ContractService(new PayPalService());
		contractService.processContract(contract, n);

		System.out.println();
		System.out.println("Parcelas: ");

		for (Installment installment : contract.getInstallment()) {
			System.out.println(installment);
		}

		sc.close();

	}
}
