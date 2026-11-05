package arvores;
public class ArvoreAVL {
	private class No{
		int valor; 
		No esq, dir;
		int alturaEsq, alturaDir;
		
		public No(int valor) {
			this.valor = valor;
			esq = dir = null;
			alturaEsq = alturaDir = 0;
		}
	}
	
	private No raiz;
	
	public ArvoreAVL() {
		raiz = null;
	}
	
	public void inserirNo(int valor) {
		raiz = inserirNo(raiz,valor);
	}
	
	private No inserirNo(No atual, int valor) {
		if(atual == null) {
			return new No(valor);
		}
		
		//inserção na subárvore esquerda (valores menores)
		if (valor < atual.valor) {
			atual.esq = inserirNo(atual.esq, valor);
			atual.alturaEsq = Math.max(atual.esq.alturaEsq, atual.esq.alturaDir)+1;
		}
		
		//inserção na subárvore direita (valores maiores)
		if (valor > atual.valor) {
			atual.dir = inserirNo(atual.dir, valor);
			atual.alturaDir = Math.max(atual.dir.alturaEsq, atual.dir.alturaDir)+1;
		}
				
		return balancear(atual);
	}
	
	private No balancear(No atual) {
		int fatorBalanceamento = atual.alturaDir - atual.alturaEsq;
		
		//Desbaleanceamento à direita
		if(fatorBalanceamento == 2) {
			//se o filho à direita também está desbalanceado
			//rotação simples à esqueda
			if(atual.dir.alturaDir >= atual.dir.alturaEsq) {
				return rotacaoEsquerda(atual);
			} else {
				atual.dir = rotacaoDireita(atual.dir);
				return rotacaoEsquerda(atual);
			}
		}
		
		//Desbalanceamento à esquerda
		else if (fatorBalanceamento == -2) {
			//rotação simples à direita
			if(atual.esq.alturaEsq >= atual.esq.alturaDir) {
				return rotacaoDireita(atual);
			} else {
				//caso contrário, rotação dupla esquerda-direita
				atual.esq = rotacaoEsquerda(atual.esq);
				return rotacaoDireita(atual);
			}
		}
		
		//retorna o nó atual, balanceando se necessário
		return atual;
	}
	
	private No rotacaoEsquerda(No raiz) {
		No novaRaiz = raiz.dir; //filho dir se torna a nova raiz
		raiz.dir = novaRaiz.esq;
		novaRaiz.esq = raiz;
		
		//atualizar alturas
		atualizarAlturas(raiz);
		atualizarAlturas(novaRaiz);
		
		return novaRaiz;
	}
	
	private No rotacaoDireita(No raiz) {
		No novaRaiz = raiz.esq;
		raiz.esq = novaRaiz.dir;
		novaRaiz.dir = raiz;
		
		//atualizar alturas
		atualizarAlturas(raiz);
		atualizarAlturas(novaRaiz);
		
		return novaRaiz;
	}
	
	private void atualizarAlturas(No no) {
		if(no != null) {
			no.alturaEsq = (no.esq == null) ? 0: Math.max(no.esq.alturaEsq, no.esq.alturaDir)+1;
			
			no.alturaDir = (no.dir == null) ? 0: Math.max(no.dir.alturaEsq, no.dir.alturaDir)+1;
		}
	}
	
	public void mostrar() {
		mostrar(raiz);
	}
	
	private void mostrar(No no) {
		if(no != null) {
			mostrar(no.esq);
			System.out.println(no.valor);
			mostrar(no.dir);
		}
		
	}
}