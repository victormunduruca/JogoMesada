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
