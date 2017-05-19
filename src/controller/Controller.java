package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import excpeptions.IdNaoEncontradoException;
import model.Jogador;

public class Controller {
	
	private ArrayList<Jogador> jogadores; //Jogadores na partida
	private int idAtual; 
	private int idJogadorMaquina;
	
	//Colocar m�todo update para mudar o id do jogador atual com base no controller de rede
	//Implementar padr�o observer com a interface para atualizar quando um jogador muda
	
	public int jogar() throws IdNaoEncontradoException {
		Random rand = new Random();
		int valorDado = rand.nextInt(6) + 1;
		
		Jogador jogador = getJogador(idAtual);
		
		
		
		return valorDado;
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
