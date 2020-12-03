package br.unisul.trabalhointegrador.controller;


import java.util.List;

import br.unisul.trabalhointegrador.dao.DaoFactory;
import br.unisul.trabalhointegrador.dao.MotoristaDao;
import br.unisul.trabalhointegrador.dao.ObjetoDao;
import br.unisul.trabalhointegrador.model.Objeto;
import br.unisul.trabalhointegrador.util.DatabaseService;

public class ControleObjeto {
	
	private DaoFactory daoFactory = null;
	private ObjetoDao objetoDao = null;
	
	public ControleObjeto(int codigoFonte) {
		
		daoFactory = DaoFactory.getDaoFactory(codigoFonte);
		objetoDao = daoFactory.getObjetoDao();
		
	}

	
	public List<Objeto> recuperarObjetocodigoLocalizador(double codigoLocalizador) {
		return objetoDao.recuperarObjetocodigoLocalizador(codigoLocalizador);
		
	}

	public void removerObjeto(double codigoLocalizador) {
		objetoDao.removerObjeto(codigoLocalizador);
		
	}

	public void inserirObjeto(Objeto objeto) {
		objetoDao.inserirObjeto(objeto);
		
	}

}