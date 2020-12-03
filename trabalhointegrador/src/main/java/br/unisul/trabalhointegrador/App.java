package br.unisul.trabalhointegrador;

import java.util.List;

import javax.swing.JOptionPane;
import br.unisul.trabalhointegrador.model.*;
import br.unisul.trabalhointegrador.controller.*;

public class App {

	private static final int CodigoFonte = 0;
	private static Principal principal = new Principal();

	public static void main(String[] args) {
		int menu = 0;

		principal.carregarObjetos();
		principal.carregarVeiculos();
		principal.carregarMotoristas();
		principal.carregarRotas();

		while (menu < 8) {

			menu = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Escolha entre as funções: \n" + "1- Cadastrar objeto; \n" + "2- Cadastrar veículo; \n"
							+ "3- Cadrastrar motorista; \n" + "4- Gerar rota; \n" + "5- Mostrar objetos restantes\n"
							+ "6 - Devolver objetos \n" + "7 - Buscar rotas \n" + "8 - Sair"));

			switch (menu) {
			case 1:
				Objeto objeto = principal.cadastrarObjeto();
				break;

			case 2:
				Veiculo veiculo = principal.cadastrarVeiculo();
				break;

			case 3:
				Motorista motorista = principal.cadastrarMotorista();
				break;

			case 4:
				principal.gerarRota();
				principal.imprimirTodasRotas();
				break;

			case 5:
				principal.mostrarObjetosRestantes();
				break;

			case 6:
				double codigo = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o código localizador:"));
				principal.devolverObjeto(codigo);
				break;

			case 7:
				principal.buscarRotas();
				break;

			case 8:
				System.exit(0);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção inválida.");
				menu = 0;
				break;
			}
		}
	}

}
