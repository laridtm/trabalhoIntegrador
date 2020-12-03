package br.unisul.trabalhointegrador.dao.arquivo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.unisul.trabalhointegrador.dao.ObjetoDao;
import br.unisul.trabalhointegrador.model.Objeto;

public class ArquivoObjetoDao implements ObjetoDao {

	private List<Objeto> listaObjeto = new ArrayList<Objeto>();

	@Override
	public List<Objeto> recuperarObjetocodigoLocalizador(double codigoLocalizador) {
		try {
			FileOutputStream fos = new FileOutputStream("registro_objetos");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listaObjeto);
			oos.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
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
		} finally {

		}

		return listaObjetos;

	}

	@Override
	public void removerObjeto(double codigoLocalizador) {
		try {

			FileOutputStream fos = new FileOutputStream("registro_objetos");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listaObjeto);
			oos.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

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
		} finally {

		}

		// return listaObjetos;

	}

	@Override
	public void inserirObjeto(Objeto objeto) {
		try {
			listaObjeto.add(objeto);

			FileOutputStream fos = new FileOutputStream("registro_objetos");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listaObjeto);
			oos.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		List<Objeto> listaObjetos = new ArrayList<Objeto>();

		try {
			FileInputStream fis = new FileInputStream("registro_objetos");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Objeto> objetosLidos = (List<Objeto>) ois.readObject();

			for (Objeto objeto1 : objetosLidos) {
				listaObjetos.add(objeto);
			}

			ois.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {

		}

		// return listaObjetos;
	}

}
