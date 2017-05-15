package view;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.Controller;


public class Janela {
	
	private Controller controller;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
			// handle exception
		}
		catch (ClassNotFoundException e) {
			// handle exception
		}
		catch (InstantiationException e) {
			// handle exception
		}
		catch (IllegalAccessException e) {	       // handle exception
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		controller = new Controller();
		
		Pino pinoAmarelo = new Pino("pinoAmarelo.png");
		Pino pinoAzul = new Pino("pinoAzul.png");
		Pino pinoRosa = new Pino("pinoRosa.png");
		Pino pinoRoxo = new Pino("pinoRoxo.png");
		Pino pinoVerde = new Pino("pinoVerde.png");
		Pino pinoVermelho = new Pino("pinoVermelho.png");
		
		JPanel panel = new JPanel();
		JLayeredPane jLay = new JLayeredPane();
		JLabel imagemTabuleiro = new JLabel(new ImageIcon("Tabuleiro.png"));
		frame = new JFrame();
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 1190, 871);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBounds(10, 39, 896, 685);

		jLay.setPreferredSize(new Dimension(896, 685));
		jLay.add(imagemTabuleiro, new Integer(10));
		
		jLay.add(pinoAmarelo.getLabel(), new Integer(20));
		jLay.add(pinoAzul.getLabel(), new Integer(30));
		jLay.add(pinoRosa.getLabel(), new Integer(40));
		jLay.add(pinoRoxo.getLabel(), new Integer(50));
		jLay.add(pinoVerde.getLabel(), new Integer(60));
		jLay.add(pinoVermelho.getLabel(), new Integer(70));

		imagemTabuleiro.setBounds(0, 0, 896, 685);
		frame.getContentPane().add(panel);
		panel.add(jLay);
		
		JButton btnRodarDado = new JButton("Lan�ar Dado");
		btnRodarDado.addActionListener(new ActionListener() {
			int valorDado = 0;
			public void actionPerformed(ActionEvent arg0) {
				valorDado = jogaDado();
				andaDado(valorDado, pinoAmarelo);
				andaDado(valorDado, pinoAzul);
				andaDado(valorDado, pinoRosa);
				andaDado(valorDado, pinoVerde);
				andaDado(valorDado, pinoRoxo);
				andaDado(valorDado, pinoVermelho);
				JOptionPane.showMessageDialog(null, "Valor do dado foi de = " + valorDado);
				System.out.println("Valor dado: " +valorDado);
			}
		});
		btnRodarDado.setBounds(966, 39, 113, 51);
		frame.getContentPane().add(btnRodarDado);	
		
		JLabel saldo = new JLabel();
		saldo.setText("Saldo = " + controller.getSaldoTeste()); //controller.getSaldo();
		saldo.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 22));
		saldo.setBounds(77, 756, 360, 51);
		frame.getContentPane().add(saldo);
		
		JButton btnMudaSaldo = new JButton("muda saldo");
		btnMudaSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mudaSaldo();
			}
		});
		btnMudaSaldo.setBounds(1020, 480, 89, 23);
		frame.getContentPane().add(btnMudaSaldo);
	}
	public void andaDado(int numeroDado, Pino pino) {
		for(int i = numeroDado; i > 0; i--) {
			System.out.println("\n i = "+i + "\n");
			System.out.println("X: " +pino.getX() + " Y: " +pino.getY());
			if(pino.getX() >= 384 &&  pino.getY() == 137*4) { //chega no final
				pino.getLabel().setBounds(0, 0, 128, 137);
				pino.setY(0);
				pino.setX(0);
				break;
			}
//			if(pino.getX() == 768) //se ele estiver na ultima casa vai ter q iterar mais uma vez
//				i++;
			if(pino.getX() >= 768) { //se for igual ao valor fora da borda ele desce
				pino.getLabel().setBounds(0, pino.getY()+137, 128, 137);
				pino.setY(pino.getY()+137);
				pino.setX(0);
			} else{
				System.out.println("Entrou no else");
				pino.getLabel().setBounds(pino.getX() + 128, pino.getY(), 128, 137);
				pino.setX(pino.getX() + 128);
				System.out.println("DEPOIS X: " +pino.getX() + " Y: " +pino.getY());
			}
		}
	}
	private static int jogaDado() {
		Random rand = new Random();
		return rand.nextInt(6) + 1;
	}
}
