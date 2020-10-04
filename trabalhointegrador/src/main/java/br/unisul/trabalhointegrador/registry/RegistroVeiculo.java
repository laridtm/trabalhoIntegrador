package br.unisul.trabalhointegrador.registry;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

import br.unisul.trabalhointegrador.model.Veiculo;

public class RegistroVeiculo {
    public static void salvarVeiculos(List<Veiculo> objetos){
		try {
			FileOutputStream fos = new FileOutputStream("registro_veiculos");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(objetos);
			oos.close();	
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static List<Veiculo> carregarVeiculos(){
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
		}

		return listaVeiculos;
	}
}
