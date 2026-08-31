package arvores;

public class MainArvoreBinariaBusca {
	public static void main(String[] args) {
		ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
		
		arvore.inserir(50);
		arvore.inserir(30);
		arvore.inserir(70);
		arvore.inserir(20);
		arvore.inserir(40);
		arvore.inserir(60);
		arvore.inserir(80);
		
		System.out.println("Tentando inserir valor repetido");
		arvore.inserir(60);
		
		System.out.println();
		System.out.println("Percurso em ordem");
		arvore.emOrdem();
		
		System.out.println();
		System.out.println("Buscas");
		System.out.println("Existe 60? " + arvore.buscar(60));
		System.out.println("Existe 40? " + arvore.buscar(40));
		System.out.println("Existe 35? " + arvore.buscar(35));
		
		System.out.println();
		
		System.out.println("Removendo um nó folha ");
		arvore.remover(20);
		arvore.emOrdem();
		
		System.out.println("Removendo um nó com 2 filhos");
		arvore.remover(50);
		arvore.emOrdem();
		
		System.out.println();
		System.out.println("Percurso por nível");
		arvore.mostrarPorNivel();
		
		System.out.println();
		System.out.println("Nível Nó: " + arvore.nivelNo(60));
		System.out.println("Nível Nó: " + arvore.nivelNo(30));
		System.out.println("Nível Nó: " + arvore.nivelNo(40));
		
		System.out.println();
		System.out.println("Altura da árvore: " + arvore.alturaArvore(arvore.raiz));
		
	}
}
