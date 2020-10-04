package br.unisul.trabalhointegrador;

import javax.swing.JOptionPane;
import br.unisul.trabalhointegrador.model.*;
import br.unisul.trabalhointegrador.controller.*;

public class App {

    private static Principal principal = new Principal();

    public static void main( String[] args )
    {
        int menu = 0;

        while (menu < 5) {

            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha entre as funções: \n"
                    + "1- Cadastrar objeto; \n" + "2- Cadastrar veículo; \n" + "3- Cadrastrar motorista; \n"
                    + "4- Gerar rota; \n" + "5- Sair;"));

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
                    principal.imprimirRotas();
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    menu = 0;
                break;
            }
        }
    }
}
