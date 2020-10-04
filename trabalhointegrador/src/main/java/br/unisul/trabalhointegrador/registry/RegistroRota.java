package br.unisul.trabalhointegrador.registry;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

import br.unisul.trabalhointegrador.model.Rota;

public class RegistroRota {
    public static void salvarRotas(List<Rota> objetos){
		try {
			FileOutputStream fos = new FileOutputStream("registro_rotas");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(objetos);
			oos.close();	
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static List<Rota> carregarRotas(){
		List<Rota> listaRotas = new ArrayList<Rota>();

		try {
			FileInputStream fis = new FileInputStream("registro_rotas");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Rota> objetosLidos = (List<Rota>) ois.readObject();

			for (Rota objeto : objetosLidos) {
				listaRotas.add(objeto);
			}
			
			ois.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return listaRotas;
	}
}
