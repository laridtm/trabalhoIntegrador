package br.unisul.trabalhointegrador.dao;

import java.util.List;

import br.unisul.trabalhointegrador.model.Objeto;

public interface ObjetoDao {
	
	/**
	 * Metodo responsável por recuperar objeto pelo codigoLocalizador
	 * @param codigoLocalizador double.
	 * @return {@link Objeto}
	 */
	public List<Objeto> recuperarObjetocodigoLocalizador(double codigoLocalizador);
	
	/**
	 * Metodo que remove o objeto pelo codigoLocalizador
	 * @param codigoLocalizador
	 */
	public void removerObjeto(double codigoLocalizador);
	
	/**
	 * Metodo responsavel por inserir objeto
	 * @param objeto {@link Objeto}
	 */
	public void inserirObjeto(Objeto objeto);

}
