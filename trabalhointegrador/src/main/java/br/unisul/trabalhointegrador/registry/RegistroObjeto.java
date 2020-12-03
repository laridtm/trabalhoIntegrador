package br.unisul.trabalhointegrador.registry;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

import br.unisul.trabalhointegrador.model.Objeto;

public class RegistroObjeto {

    public static void salvarObjetos(List<Objeto> objetos){
		try {
			FileOutputStream fos = new FileOutputStream("registro_objetos");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(objetos);
			oos.close();	
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static List<Objeto> carregarObjetos(){
		List<Objeto> listaObjetos = new ArrayList<Objeto>();

		try {
			FileInputStream fis = new FileInputStream("registro_objetos");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Objeto> objetosLidos = (List<Objeto>) ois.readObject();

			for (Objeto objeto : objetosLidos) {
				listaObjetos.add(objeto);
			}
			
			ois.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			
		}

		return listaObjetos;
	}
}
