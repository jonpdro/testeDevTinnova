package exercicio1;

public class RelacaoTotal {
	
	// V�riavel
	double resultado;

	// M�todo que faz o processo percentual
	public double percentual(int totalEleitores, double votos) {
		
		// C�lculo
		resultado = votos / totalEleitores;
		resultado *= 100;

		// Retornando o resultado
		return resultado;
	}
}
