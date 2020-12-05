package br.unisul.trabalhointegrador.dao.arquivo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.unisul.trabalhointegrador.dao.MotoristaDao;
import br.unisul.trabalhointegrador.model.Motorista;

public class ArquivoMotoristaDao implements MotoristaDao {

    private List<Motorista> listaMotorista = new ArrayList<Motorista>(1000);

    @Override
    public List<Motorista> recuperarMotoristatipoCNH(String tipoCNH) {
        try {

            FileOutputStream fos = new FileOutputStream("registro_motoristas");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaMotorista);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

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

    @Override
    public void removerMotorista(String tipoCNH) {
        try {

            FileOutputStream fos = new FileOutputStream("registro_motoristas");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaMotorista);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

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

        // return listaMotoristas;
    }

    @Override
    public void inserirMotorista(Motorista motorista) {
        try {
            listaMotorista.add(motorista);

            FileOutputStream fos = new FileOutputStream("registro_motoristas");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaMotorista);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

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

        // return listaMotoristas;
    }

}
