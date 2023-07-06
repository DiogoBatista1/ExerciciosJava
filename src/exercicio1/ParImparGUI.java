package exercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParImparGUI extends JFrame {
	private JTextField textField;
	private JLabel resultadoLabel;
	
	public ParImparGUI() {
//		Configurações da janela
		setTitle("Verificador de par ou impar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(500, 300);
		setLocationRelativeTo(null);
		
//		Painel principal
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		
//		Rótulo de instrução
		JLabel instrucaoLabel = new JLabel("Digite um número: ");
		panel.add(instrucaoLabel);
		
//		Campo de texto para o número
		textField = new JTextField();
		panel.add(textField);
		
//		Rótulo para mostrar resultado
		resultadoLabel = new JLabel();
		panel.add(resultadoLabel);
		
//		Botão para verificar se é par ou impar
		JButton verificarButton = new JButton("Verificar");
		verificarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verificarParOuImpar();
			}
		});
		panel.add(verificarButton);
		
//		Adiciona o painel a jabela
		add(panel);		
	}
	
	private void verificarParOuImpar() {
		String numeroStr = textField.getText();
		
		try {
			int numero = Integer.parseInt(numeroStr);
			if (numero % 2 == 0) {
				resultadoLabel.setText(numero + " é par.");
			} else {
				resultadoLabel.setText(numero + " é impar.");
			}
		} catch (NumberFormatException e) {
			resultadoLabel.setText("Digite um número válido.");
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ParImparGUI gui = new ParImparGUI();
				gui.setVisible(true);
			}
		});
	}
}