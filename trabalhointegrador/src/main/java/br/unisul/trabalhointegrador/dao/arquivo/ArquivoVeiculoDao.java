package br.unisul.trabalhointegrador.dao.arquivo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.unisul.trabalhointegrador.dao.VeiculoDao;
import br.unisul.trabalhointegrador.model.Veiculo;

public class ArquivoVeiculoDao implements VeiculoDao {

    private List<Veiculo> listaVeiculo = new ArrayList<Veiculo>();

    @Override
    public void removerVeiculo(String placa) {
        try {
            FileOutputStream fos = new FileOutputStream("registro_veiculos");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaVeiculo);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

        try {
            FileInputStream fis = new FileInputStream("registro_veiculos");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Veiculo> objetosLidos = (List<Veiculo>) ois.readObject();

            for (Veiculo objeto : objetosLidos) {
                listaVeiculos.add(objeto);
            }

            ois.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {

        }

        // return listaVeiculos;
    }

    @Override
    public void inserirVeiculo(Veiculo veiculo) {
        try {

            listaVeiculo.add(veiculo);

            FileOutputStream fos = new FileOutputStream("registro_veiculos");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaVeiculo);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

        try {
            FileInputStream fis = new FileInputStream("registro_veiculos");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Veiculo> objetosLidos = (List<Veiculo>) ois.readObject();

            for (Veiculo objeto : objetosLidos) {
                listaVeiculos.add(objeto);
            }

            ois.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {

        }

        // return listaVeiculos;
    }

}
