package br.unisul.trabalhointegrador.registry;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

import br.unisul.trabalhointegrador.model.Motorista;

public class RegistroMotorista {

    public static void salvarMotoristas(List<Motorista> objetos) {
        try {
            FileOutputStream fos = new FileOutputStream("registro_motoristas");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objetos);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static List<Motorista> carregarMotoristas() {
        List<Motorista> listaMotoristas = new ArrayList<Motorista>();

        try {
            FileInputStream fis = new FileInputStream("registro_motoristas");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Motorista> objetosLidos = (List<Motorista>) ois.readObject();

            for (Motorista objeto : objetosLidos) {
                listaMotoristas.add(objeto);
            }

            ois.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {

        }

        return listaMotoristas;
    }
}
