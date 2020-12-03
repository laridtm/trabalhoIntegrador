package br.unisul.trabalhointegrador.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

import br.unisul.trabalhointegrador.dao.DaoFactory;
import br.unisul.trabalhointegrador.dao.MotoristaDao;
import br.unisul.trabalhointegrador.model.*;
import br.unisul.trabalhointegrador.registry.*;

public class Principal {

	List<Veiculo> veiculos = new ArrayList<Veiculo>();
	List<Motorista> motoristas = new ArrayList<Motorista>();
	List<Objeto> objetos = new ArrayList<Objeto>();
	List<Rota> rotas = new ArrayList<Rota>();
	List<Rota> rotasAntigas = new ArrayList<Rota>();

	public Motorista cadastrarMotorista() {
		Motorista motorista = new Motorista();
		motorista.setNome(JOptionPane.showInputDialog("Digite o nome do motorista"));
		motorista.setDataNascimento(JOptionPane.showInputDialog("Digite a data de nascimento"));

		int tipoCNH = 0;
		do {
			tipoCNH = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Digite o tipo da CNH: \n" + "1- B \n" + "2- B/C"));

			switch (tipoCNH) {
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

		motorista.setNumeroCNH(Double.parseDouble(JOptionPane.showInputDialog("Digite o numero da CNH:")));
		motorista.setEndereco(JOptionPane.showInputDialog("Digite o endereço"));
		motoristas.add(motorista);
		RegistroMotorista.salvarMotoristas(motoristas);

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

		while (codigo == 0 || verificarCodLocalizador(codigo)) {
			codigo = gerarCodigoLocalizador();
		}

		objeto.setCodigoLocalizador(codigo);
                
                /* Remover tudo de cima, receber objeto por parametro*/

		objetos.add(objeto);
		RegistroObjeto.salvarObjetos(objetos);

		return objeto;
	}

	public Veiculo cadastrarVeiculo() {
		int tipoVeiculo = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Digite o tipo de veiculo: \n" + "1 - Carreta \n" + "2 - Caminhão Baú \n" + "3 - Van"));

		Veiculo veiculo = null;
		switch (tipoVeiculo) {
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

		veiculo.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano do Veiculo:")));
		veiculo.setMarca(JOptionPane.showInputDialog(null, "Digite a marca do veiculo:"));
		veiculo.setModelo(JOptionPane.showInputDialog(null, "Digite o modelo do veiculo:"));
		veiculo.setPlaca(JOptionPane.showInputDialog(null, "Digite a placa do veiculo:"));
		veiculo.setTipo(tipoVeiculo);
		veiculos.add(veiculo);

		Collections.sort(veiculos, new Comparator<Veiculo>() {
			@Override
			public int compare(Veiculo obj1, Veiculo obj2) {
				return obj1.getTipo() - obj2.getTipo();
			}
		});

		RegistroVeiculo.salvarVeiculos(veiculos);

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

	public void imprimirRotas(List<Rota> rotasImprimir) {
		String relatorioRotas = "";
		for (Rota rota : rotasImprimir) {
			relatorioRotas = relatorioRotas + rota.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, relatorioRotas);
	}

	public void imprimirTodasRotas() {
		imprimirRotas(rotas);
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

						if (!rota.getObjetos().isEmpty()) {
							rotas.add(rota);
							rotasAntigas.add(rota);
							RegistroRota.salvarRotas(rotasAntigas);
						}
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

	public void buscarRotas() {
		int tipoDeBusca = 0;
		List<Rota> retornoBusca = new ArrayList<Rota>();

		do {
			tipoDeBusca = Integer.parseInt(
					JOptionPane.showInputDialog(null, "Digite o tipo de busca: \n" + "1 - Data \n" + "2 - Motorista"));

			switch (tipoDeBusca) {
			case 1:
				String dataString = JOptionPane.showInputDialog(null, "Digite a data (dd/mm/aaaa): ");
				SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
				Date date = null;

				try {
					date = formatadorData.parse(dataString);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				for (Rota rota : rotasAntigas) {
					Calendar c1 = Calendar.getInstance();
					Calendar c2 = Calendar.getInstance();

					c1.setTime(date);
					c2.setTime(rota.getData());

					if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
							&& c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
							&& c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)) {
						retornoBusca.add(rota);
					}
				}
				break;

			case 2:
				String nome = JOptionPane.showInputDialog(null, "Digite o nome do motorista: ");

				for (Rota rota : rotasAntigas) {
					if (rota.getMotorista().getNome().equalsIgnoreCase(nome)) {
						retornoBusca.add(rota);
					}
				}
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção inválida.");
				break;
			}
		} while (tipoDeBusca != 1 && tipoDeBusca != 2);

		imprimirRotas(retornoBusca);

	}

	public void carregarObjetos() {
		objetos = RegistroObjeto.carregarObjetos();
	}

	public void carregarVeiculos() {
		veiculos = RegistroVeiculo.carregarVeiculos();
	}

	public void carregarMotoristas() {
		motoristas = RegistroMotorista.carregarMotoristas();
	}

	public void carregarRotas() {
		rotas = new ArrayList<Rota>();
		rotasAntigas = RegistroRota.carregarRotas();
	}
}
