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
        
        Motorista motorista1 = new Motorista();
        motorista1.setNome("Gustavo Pereira");
        motorista1.setDataNascimento("10/03/1965");
        motorista1.setTipoCNH("ABC");
        motorista1.setNumeroCNH(2147483647);
        motorista1.setEndereco("Rua ALtamiro de Bernadi 285, Centro/Florianópolis");
        motorista1.setDisponivel(false);
        motoristas.add(motorista1);

        Carreta carreta1 = new Carreta();
        carreta1.setModelo("Fiorino");
        carreta1.setAno(2015);
        carreta1.setMarca("Fiat");
        carreta1.setPlaca("MAE8233");
        carreta1.setMotorista(motorista1);
        carretas.add(carreta1);

    public Objeto cadastrarObjeto() {
        Objeto objeto = new Objeto();
        objeto.setNomeRemetente(JOptionPane.showInputDialog(null, "Digite o nome do remetente:"));
        objeto.setEnderecoRemetente(JOptionPane.showInputDialog(null, "Digite o endereço do remetente:"));
        objeto.setNomeDestinatario(JOptionPane.showInputDialog(null, "Digite o nome do destinatário:"));
        objeto.setEnderecoDestinatario(JOptionPane.showInputDialog(null, "Digite o endereço do destinatário:"));
        objeto.setDataDeposito(JOptionPane.showInputDialog(null, "Digite a data do depósito:"));
        objeto.setPeso(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o peso do objeto:")));
        objeto.setCodigoLocalizador(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o código localizador:")));
        objetos.add(objeto);
        return objeto;
    }

    public int gerarCodigoLocalizador() {
        Random randomico = new Random();
        int aux = randomico.nextInt();
        return aux;
    }

    public double verificarCodLocalizador(Objeto objeto){
        for(int i=0;i<objetos.size();i++){
            if(objetos.get(i).getCodigoLocalizador() == objeto.getCodigoLocalizador()){
                objeto.setCodigoLocalizador(gerarCodigoLocalizador());
            }
            break;
        }
        verificarCodLocalizador(objeto);
        return objeto.getCodigoLocalizador();
    }


    //gerar roteiro
    //cadastrar objeto -> distribuir veiculo
    //os objetos devem ser distribuidos pelos veiculos em ordem crescente a data de cadastro
    //geracao de roteiros diarios por veiculo
}
