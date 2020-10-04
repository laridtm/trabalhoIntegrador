package br.unisul.trabalhointegrador.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

import br.unisul.trabalhointegrador.model.*;

public class Principal {

	List<Veiculo> veiculos = new ArrayList<Veiculo>();
	List<Motorista> motoristas = new ArrayList<Motorista>();
	List<Objeto> objetos = new ArrayList<Objeto>();

	public Motorista cadastrarMotorista() {
		Motorista motorista = new Motorista();
		motorista.setNome(JOptionPane.showInputDialog("Digite o nome do motorista"));
		motorista.setDataNascimento(JOptionPane.showInputDialog("Digite a data de nascimento"));

		int tipoCNH = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tipo da CNH: \n" 
		+ "1- B \n" + "2- B/C"));
		switch(tipoCNH) {
			case 1: 
				motorista.setTipoCNH("B");
			break;
				
			case 2: 
				motorista.setTipoCNH("C");
			break;

			default:
				JOptionPane.showMessageDialog(null, "Opção inválida.");
			break;
		}

		motorista.setNumeroCNH(Double.parseDouble(JOptionPane.showInputDialog("Digite o numero da cnh")));
		motorista.setEndereco(JOptionPane.showInputDialog("Digite o endere�o"));
		motoristas.add(motorista);

		return motorista;
	}

	public Objeto cadastrarObjeto() {
		Objeto objeto = new Objeto();
		objeto.setNomeRemetente(JOptionPane.showInputDialog(null, "Digite o nome do remetente:"));
		objeto.setEnderecoRemetente(JOptionPane.showInputDialog(null, "Digite o endere�o do remetente:"));
		objeto.setNomeDestinatario(JOptionPane.showInputDialog(null, "Digite o nome do destinat�rio:"));
		objeto.setEnderecoDestinatario(JOptionPane.showInputDialog(null, "Digite o endere�o do destinat�rio:"));
		objeto.setDataDeposito(JOptionPane.showInputDialog(null, "Digite a data do dep�sito:"));
		objeto.setPeso(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o peso do objeto:")));
		objeto.setCodigoLocalizador(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o c�digo localizador:")));
		objetos.add(objeto);

		return objeto;
	}

	public Veiculo cadastrarVeiculo() {
		int tipoVeiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tipo de veiculo: \n" 
		+ "1 - Carreta \n" + "2 - Caminhão Bau \n" + "3 - Van"));

		Veiculo veiculo = null;
		switch(tipoVeiculo) {
			case 1: 
				veiculo = new Carreta();
			break;
			
			case 2: 
				veiculo = new CaminhaoBau();
			break;
			
			case 3: 
				veiculo = new Van();
			break;

			default:
				JOptionPane.showMessageDialog(null, "Opção inválida.");
			break;
		}
		
		veiculo.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano do Veiculo")));
		veiculo.setMarca(JOptionPane.showInputDialog(null, "Digite a marca do veiculo"));
		veiculo.setModelo(JOptionPane.showInputDialog(null, "Digite o modelo do veiculo"));
		veiculo.setPlaca(JOptionPane.showInputDialog(null, "Digite a placa do veiculo"));
		veiculo.setTipo(tipoVeiculo);
		veiculos.add(veiculo);
		
		Collections.sort(veiculos, new Comparator<Veiculo>() {
			@Override
			public int compare(Veiculo obj1, Veiculo obj2) {
				return obj1.getTipo() - obj2.getTipo();
			}
		});
		for (Veiculo v : veiculos) {
			System.out.println(v.toString());
		}
		return veiculo;
	}

	public int gerarCodigoLocalizador() {
		Random randomico = new Random();
		int aux = randomico.nextInt();
		return aux;
	}

	public double verificarCodLocalizador(Objeto objeto) {
		for (int i = 0; i < objetos.size(); i++) {
			if (objetos.get(i).getCodigoLocalizador() == objeto.getCodigoLocalizador()) {
				objeto.setCodigoLocalizador(gerarCodigoLocalizador());
			}
			break;
		}
		verificarCodLocalizador(objeto);
		return objeto.getCodigoLocalizador();
	}

	public void gerarRota() {
		Motorista motorista = motoristas.get(0);
		for (Veiculo veiculo : veiculos) {
			if (motorista.getTipoCNH().equalsIgnoreCase("B")) {
				
			}
		}
	}
}