package jdbc;

import java.util.List;

import javax.swing.JOptionPane;

import br.unisul.trabalhointegrador.controller.ControleMotorista;
import br.unisul.trabalhointegrador.model.Motorista;

public class PrincipalJdbc {

    public static void main(String[] args) {
        int codigoFonte = Integer
                .parseInt(JOptionPane.showInputDialog("Digite:\n0 - para Bando de Dados\n" + "1 - para Arquivo"));

        ControleMotorista controleMotorista = new ControleMotorista(codigoFonte);
        List<Motorista> motoristas = controleMotorista.recuperarMotoristatipoCNH("b");

        for (Motorista motorista : motoristas) {
            System.out.println("nome:" + motorista.getNome());
        }
    }

}
