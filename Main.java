import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {
    private static Principal principal = new Principal();
    public static void main(String[] args) {
        
        int menu = 0;

        while (menu < 3) {

            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha entre as funções: \n"
                    + "1- Cadastrar objeto; \n" + "2- P; \n" + "3- Sair;"));

            switch (menu) {
                case 1:
                    Objeto objeto = principal.cadastrarObjeto();
                    if (objeto.getCodigoLocalizador() == 0){
                        objeto.setCodigoLocalizador(principal.gerarCodigoLocalizador());
                    }
                    principal.verificarCodLocalizador(objeto);
                    }

                break;

                case 2:

                break;

                case 3:
                    
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    menu = 0;
                break;
            }
        }
    }
    }
    
}
