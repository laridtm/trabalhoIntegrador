import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        int menu = 0;

        while (menu < 3) {

            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha entre as funções: \n"
                    + "1- Cadastrar objeto; \n" + "2- P; \n" + "3- Sair;"));

            switch (menu) {
                case 1:
            
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
