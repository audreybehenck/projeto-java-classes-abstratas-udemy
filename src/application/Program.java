package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> list = new ArrayList<>();
		
		System.out.println("Digite o número de contribuintes:");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Dados do "+ (i+1) +"º contribuinte:");
			System.out.println("Pessoa Física ou Pessoa Jurídica (f/j)? ");
			char tipoPessoa = sc.next().charAt(0);
			System.out.println("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println("Renda anual: ");
			double rendaAnual = sc.nextDouble();
			if (tipoPessoa == 'f') {
				System.out.println("Despesas de saúde: ");
				double gastosComSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastosComSaude));
			}
			else if (tipoPessoa == 'j') {
				System.out.println("Número de funcionários: ");
				int numeroFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
			}
		}
		
		System.out.println("\nIMPOSTOS PAGOS: ");
		
		double soma = 0.0;
		for (Pessoa pessoa : list) {
			if (pessoa instanceof PessoaFisica) {
				PessoaFisica pessoaFisica = (PessoaFisica) pessoa;
				System.out.println(pessoaFisica.toString());
				soma = soma + pessoaFisica.calculoImposto();
			}
			else {
					PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;
					System.out.println(pessoaJuridica.toString());
					soma = soma + pessoaJuridica.calculoImposto();
			}
		}
		
		System.out.printf("TOTAL TAXES: %.2f", soma);
		

		sc.close();

	}
}
