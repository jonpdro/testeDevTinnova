package exercicio4;

import java.util.*;

public class SomaMultiplosApplication {

	public static void main(String[] args) {

		// Instanciamento para receber um parametro
		Scanner ler = new Scanner(System.in);

		// V�riaveis
		int x, soma = 0;

		// Exibir no console o parametro informado pelo usu�rio
		System.out.print("Informe um valor: ");
		x = ler.nextInt();

		// Condi��o para ver se o valor inserido � multiplo de 3 ou 5
		if (x % 3 == 0 || x % 5 == 0) {
			
			// La�o de repeti��o para fazer o calculo da soma dos m�ltiplos
			for (int i = x - 1; i > 0; i--) {
				if (i % 3 == 0 || i % 5 == 0) {
					soma += i;
				}
			}

			// Exibindo no console o resultado da soma
			System.out.printf("\nO valor inserido foi: %d.\nA soma dos mult�plos de 3 ou 5 � de: %d.", x, soma);
		} else {
		
			// Se a condi��o acima for falsa, o retorno no console que o valor � negativo ou n�o m�ltiplo.
			System.out.println("O valor informado � negativo ou n�o pode ser multiplo de 3 ou 5.");

		}
	}

}
