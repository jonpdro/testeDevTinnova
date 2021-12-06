package exercicio1;

import java.text.DecimalFormat;

public class Application {

	public static void main(String[] args) {

		// Instanciamento de uma biblioteca e do objeto
		RelacaoTotal relacaoTotal = new RelacaoTotal();
		DecimalFormat toString = new DecimalFormat();
		
		// Váriaveis
		int totalEleitores, validos, brancos, nulos;
		String percentualV, percentualB, percentualN;
		
		// Atribuição de valores às váriaveis
		totalEleitores = 1000;
		validos = 800;
		brancos = 150;
		nulos = 50;

		// Convertendo o valor Int em String e exibindo o resultado no console
		percentualV = toString.format(relacaoTotal.percentual(totalEleitores, validos));
		System.out.println("O percentual de votos válidos é de: " + percentualV + "%");
		
		percentualB = toString.format(relacaoTotal.percentual(totalEleitores, brancos));
		System.out.println("O percentual de votos brancos é de: " + percentualB + "%");
		
		percentualN = toString.format(relacaoTotal.percentual(totalEleitores, nulos));
		System.out.println("O percentual de votos nulos é de: " + percentualN + "%");
	}

}
