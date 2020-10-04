import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class Principal {

	ArrayList<Carreta> carretas = new ArrayList<Carreta>();
	ArrayList<CaminhaoBau> caminhoes = new ArrayList<CaminhaoBau>();
	ArrayList<Van> vans = new ArrayList<Van>();
	ArrayList<Motorista> motoristas = new ArrayList<Motorista>();
	ArrayList<Objeto> objetos = new ArrayList<Objeto>();

	public Motorista cadastrarMotorista() {

		Motorista motorista = new Motorista();
		motorista.setNome(JOptionPane.showInputDialog("Digite o nome do motorista"));
		motorista.setDataNascimento(JOptionPane.showInputDialog("Digite a data de nascimento"));
		motorista.setTipoCNH(JOptionPane.showInputDialog("Digite o tipo de cnh"));
		motorista.setNumeroCNH(Double.parseDouble(JOptionPane.showInputDialog("Digite o numero da cnh")));
		motorista.setEndereco(JOptionPane.showInputDialog("Digite o endereço"));
		motorista.setDisponivel(Boolean.parseBoolean(JOptionPane.showInputDialog("Digite o disponivel")));
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
		objeto.setCodigoLocalizador(
				Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o código localizador:")));
		objetos.add(objeto);
		return objeto;
	}

	public Veiculo cadastrarVeiculo(Motorista motorista) {
		int tipoVeiculo = Integer.parseInt(JOptionPane.showInputDialog(null, " Digite o tipo de veiculo:\n" 
	    + "1 - Carreta\n" + "2 - Caminhão Bau\n" + "3 - Van"));
	switch(tipoVeiculo) {
	case 1: 
		Carreta veiculo = new Carreta();
		
	break;
	
	case 2: 
		CaminhaoBau veiculo = new CaminhaoBau();
		
	break;
	
	case 3: 
		Van veiculo = new Van();
		
		break;
		
		veiculo.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano do Veiculo")));
		veiculo.setMarca(JOptionPane.showInputDialog(null, "Digite a marca do veiculo"));
		veiculo.setModelo(JOptionPane.showInputDialog(null, "Digite o modelo do veiculo"));
		veiculo.setMotorista(motorista);
		veiculo.setPlaca(JOptionPane.showInputDialog(null, "Digite a placa do veiculo"));

		return veiculo
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
}