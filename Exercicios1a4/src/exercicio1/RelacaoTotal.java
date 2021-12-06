package exercicio1;

public class RelacaoTotal {
	
	double resultado;

	public double percentual(int totalEleitores, double votos) {
		
		resultado = votos / totalEleitores;
		resultado *= 100;

		return resultado;
	}
}
