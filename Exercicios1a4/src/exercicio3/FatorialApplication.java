package exercicio3;

import java.util.*;

public class FatorialApplication {

	public static void main(String[] args) {

		// Instanciamento para receber um parametro
		Scanner ler = new Scanner(System.in);

		// V�riaveis
		int n, fatorial = 1;

		// Exibir no console o parametro informado pelo usu�rio
		System.out.print("Informe um n�mero qualquer: ");
		n = ler.nextInt();

		// Condi��o para ver se o valor � zero ou negativo
		if (n <= 0) {
			System.out.println("O fatorial s� pode ser realizado com n�meros maiores que 0!");
			System.out.printf("O fatorial do n�mero inserido �: %d", n);

		} else {
			// Caso o contr�rio da condi��o acima, o la�o de repeti��o ir� fazer o calculo
			// fatorial
			for (int i = 1; i <= n; i++) {
				fatorial *= i;
			}

			// Exibi��o final no console o resultado do fatorial
			System.out.printf("O fatorial do n�mero inserido �: %d", fatorial);
		}
	}

}
