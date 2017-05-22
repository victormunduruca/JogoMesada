package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import excpeptions.IdNaoEncontradoException;
import model.Jogador;

public class Controller {
	
	private ArrayList<Jogador> jogadores; //Jogadores na partida
	private int idAtual; //Id do jogador que está em sua vez
	private int idJogadorMaquina; //Id jogador desse computador
	private ArrayList<String> cartasCorreio; //Cartas referentes a casa correio
	
	public Controller() {
		criaCartas();
	}
	//Colocar método update para mudar o id do jogador atual com base no controller de rede
	//Implementar padrão observer com a interface para atualizar quando um jogador muda
	
	/*
	 * while(nao acaba o jogo){
	 * 		if(idAtual == idJogadorMaquina) 
	 * 				jogadaInterna();
	 * 		else 
	 * 				jogadaExterna();	
	 * }
	 * Alternativa: while na view
	 */
	
//	public int jogar(int valorDado) throws IdNaoEncontradoException {
//		
//		if(idAtual != idJogadorMaquina) {
//			//
//		}
//		Jogador jogador = getJogador(idAtual);
//		
//		jogador.setPosicaoPino(jogador.getPosicaoPino() + valorDado);
//		
//		int posicao = jogador.getPosicaoPino();
//		
//		if(posicao == 2) {
//			jogador.setSaldo(jogador.getSaldo() + 5000);
//			//
//		} 
////		else if() {
////			
////		}
//			
//		
//		
//		return jogador.getId();
//	}
	public static void main(String[] args) {
		Controller controller = new Controller();
		Jogador jogador = new Jogador();
		jogador.setPosicaoPino(3);
		
		ArrayList<String> cartinhas = controller.casaCorreio(jogador);
		
	}
	public ArrayList<String> casaCorreio(Jogador jogador) {
		System.out.println("posicao: " +jogador.getPosicaoPino());
		int posicao = jogador.getPosicaoPino();
		int qtdCartas = 0;
		if(posicao == 1 || posicao == 11 || posicao == 19 || posicao == 22)
			qtdCartas = 1;
		else if(posicao == 24)
			qtdCartas = 2;
		else if(posicao == 16 || posicao == 3)
			qtdCartas = 3;
		System.out.println("qtdcartas: " +qtdCartas);
		ArrayList<String> cartasCorreios = geraCartasAleatorias(qtdCartas);
		return cartasCorreios;
	}
	public ArrayList<String> geraCartasAleatorias(int qtdCartas) {
		ArrayList<String> cartasAleatorias = new ArrayList<String>();
		Random rand = new Random();
		for(int i = 0; i < qtdCartas; i++) {
			cartasAleatorias.add(cartasCorreio.get(rand.nextInt(6)));
		}
		Iterator<String> it = (Iterator) cartasAleatorias.iterator();
		while(it.hasNext()) {
			String s = (String) it.next();
			System.out.println("Carta: " +s);
		}
		
		return cartasAleatorias;
	}
	public void criaCartas() {
		cartasCorreio = new ArrayList<String>();
		cartasCorreio.add("contas");
		cartasCorreio.add("pague a um vizinho agora");
		cartasCorreio.add("dinheiro extra");
		cartasCorreio.add("doações");
		cartasCorreio.add("cobrança monstro");
		cartasCorreio.add("vá para frente agora");
	}
	public Jogador getJogador(int idJogador) throws IdNaoEncontradoException {
		Iterator<Jogador> it = (Iterator) jogadores.iterator();
		while(it.hasNext()) {
			Jogador jogador = (Jogador) it.next();
			if(jogador.getId() == idJogador)
				return jogador;
		}
		throw new IdNaoEncontradoException();
	}
	
}
