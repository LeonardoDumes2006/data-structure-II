package buscaSequencial;
import java.util.Arrays;

public class ExemploBibliotecaArrays {
	public static void main(String[] args) {
		int[] numeros = {3,7 , 9 ,12 ,18, 25 , 30 };
		int posicao = Arrays.binarySearch(numeros, 20);
		System.out.println("Resultado " + posicao);
	}
}
