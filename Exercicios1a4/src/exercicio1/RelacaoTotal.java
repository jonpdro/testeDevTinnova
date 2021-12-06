package exercicio1;

public class RelacaoTotal {
	
	// Váriavel
	double resultado;

	// Método que faz o processo percentual
	public double percentual(int totalEleitores, double votos) {
		
		// Cálculo
		resultado = votos / totalEleitores;
		resultado *= 100;

		// Retornando o resultado
		return resultado;
	}
}
