package src;

import javax.swing.JOptionPane;
import src.controlador.*;
import src.modelos.*;

public class Main {
	
	private static Principal principal = new Principal();
    public static void main(String[] args) {
        
        int menu = 0;

        while (menu < 4) {

            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha entre as funções: \n"
                    + "1- Cadastrar objeto; \n" + "2- Cadastrar Veiculo; \n" + "3- Cadrastrar motorista;"));

            switch (menu) {
                case 1:
                    Objeto objeto = principal.cadastrarObjeto();
                    if (objeto.getCodigoLocalizador() == 0){
                        objeto.setCodigoLocalizador(principal.gerarCodigoLocalizador());
                    }
                    principal.verificarCodLocalizador(objeto);  

                    // ao cadastrar o objeto, deve-se encaixálo em um dos veículos disponíveis 
                    //em um dos dias da semana 
                break;

                case 2:
                    Veiculo veiculo = principal.cadastrarVeiculo();
                break;

                case 3:
                    Motorista motorista = principal.cadastrarMotorista();
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    menu = 0;
                break;
            }
        }
    }
}


