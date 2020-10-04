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
	List<Rota> rotas = new ArrayList<Rota>();

	public Motorista cadastrarMotorista() {
		Motorista motorista = new Motorista();
		motorista.setNome(JOptionPane.showInputDialog("Digite o nome do motorista"));
		motorista.setDataNascimento(JOptionPane.showInputDialog("Digite a data de nascimento"));

		int tipoCNH = 0;
		do {
			tipoCNH = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tipo da CNH: \n" 
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
		} while (tipoCNH != 1 && tipoCNH != 2);
		
		motorista.setNumeroCNH(Double.parseDouble(JOptionPane.showInputDialog("Digite o numero da CNH")));
		motorista.setEndereco(JOptionPane.showInputDialog("Digite o endere�o"));
		motoristas.add(motorista);

		return motorista;
	}

	public Objeto cadastrarObjeto() {
		Objeto objeto = new Objeto();
		objeto.setNomeRemetente(JOptionPane.showInputDialog(null, "Digite o nome do remetente:"));
		objeto.setEnderecoRemetente(JOptionPane.showInputDialog(null, "Digite o endereço do remetente:"));
		objeto.setNomeDestinatario(JOptionPane.showInputDialog(null, "Digite o nome do destinatário:"));
		objeto.setEnderecoDestinatario(JOptionPane.showInputDialog(null, "Digite o endereço do destinatário:"));
		objeto.setDataDeposito(JOptionPane.showInputDialog(null, "Digite a data do depósito:"));
		objeto.setPeso(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o peso do objeto:")));
		double codigo = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o código localizador:"));
		objetos.add(objeto);

		while (codigo == 0 || verificarCodLocalizador(codigo)){
			codigo = gerarCodigoLocalizador();
		}

		objeto.setCodigoLocalizador(codigo);

		return objeto;
	}

	public Veiculo cadastrarVeiculo() {
		int tipoVeiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tipo de veiculo: \n" 
		+ "1 - Carreta \n" + "2 - Caminhão Baú \n" + "3 - Van"));

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

		return veiculo;
	}

	public double gerarCodigoLocalizador() {
		Random randomico = new Random();
		double aux = randomico.nextDouble();
		return aux;
	}

	public boolean verificarCodLocalizador(double codigo) {
		for (int i = 0; i < objetos.size(); i++) {
			if (objetos.get(i).getCodigoLocalizador() == codigo) {
				return true;
			}
		}
		return false;
	}

	public boolean motoristaCompativel(Motorista motorista, Veiculo veiculo) {
		if (motorista.getTipoCNH().equalsIgnoreCase("C")) {
			return true;
		} else {
			if (veiculo.getTipo() == veiculo.VAN) {
				return true;
			}
		}
		return false;
	}

	public void tornarMotoristasDisponiveis() {
		for (Motorista motorista : motoristas) {
			motorista.setDisponivel(true);
		}
	}

	public void tornarVeiculosDisponiveis() {
		for (Veiculo veiculo : veiculos) {
			veiculo.setDisponivel(true);
		}
	}

	public void imprimirRotas() {
		String relatorioRotas = "";
		for (Rota rota : rotas) {
			relatorioRotas = relatorioRotas + rota.toString() + "\n";	
		}
		JOptionPane.showMessageDialog(null, relatorioRotas);
	}

	public void gerarRota() {
		tornarMotoristasDisponiveis();
		tornarVeiculosDisponiveis();

		for (Motorista motorista : motoristas) {
			if (motorista.isDisponivel()) {
				for (Veiculo veiculo : veiculos) {
					if (veiculo.isDisponivel() && motoristaCompativel(motorista, veiculo)) {
						motorista.setDisponivel(false);
						veiculo.setDisponivel(false);
						Rota rota = new Rota(veiculo, motorista);
	
						for (int i = 0; i < veiculo.getCapacidade(); i++) {
							if (objetos.isEmpty()) {
								break;
							}
							rota.addObjeto(objetos.remove(0)); 
						}
	
						rotas.add(rota);
					} 
				}
			}	
		}
	}

	public void mostrarObjetosRestantes() {
		String objetosRestantes = "";
		for (Objeto objeto : objetos) {
			objetosRestantes = objetosRestantes + objeto.toString() + "\n";	
		}
		JOptionPane.showMessageDialog(null, objetosRestantes);
	}

	public void devolverObjeto(double codigo) {
		for (Rota rota : rotas) {
			List<Objeto> listaCopia = new ArrayList<Objeto>(rota.getObjetos());
			for (Objeto objeto : listaCopia) {
				if (objeto.getCodigoLocalizador() == codigo) {
					Objeto copia = new Objeto(objeto);
					objetos.add(copia);
					rota.removerObjeto(objeto);
				}
			}
		}
	}
}