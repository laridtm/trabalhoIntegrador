package src;

import javax.swing.JOptionPane;
import src.controlador.*;
import src.modelos.*;

public class Main {
	
	private static Principal principal = new Principal();
    public static void main(String[] args) {
        
        int menu = 0;

        while (menu < 5) {

            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha entre as funções: \n"
                    + "1- Cadastrar objeto; \n" + "2- Cadastrar veículo; \n" + "3- Cadrastrar motorista; \n"
                    + "4- Gerar rota; \n" + "5- Sair;"));

            switch (menu) {
                case 1:
                    Objeto objeto = principal.cadastrarObjeto();
                    if (objeto.getCodigoLocalizador() == 0){
                        objeto.setCodigoLocalizador(principal.gerarCodigoLocalizador());
                    }
                    principal.verificarCodLocalizador(objeto);   
                break;

                case 2:
                    Veiculo veiculo = principal.cadastrarVeiculo();
                break;

                case 3:
                    Motorista motorista = principal.cadastrarMotorista();
                break;

                case 4: 
                    
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    menu = 0;
                break;
            }
        }
    }
}


