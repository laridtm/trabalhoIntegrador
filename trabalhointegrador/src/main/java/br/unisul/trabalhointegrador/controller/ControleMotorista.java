package br.unisul.trabalhointegrador.controller;

import java.util.List;

import br.unisul.trabalhointegrador.dao.DaoFactory;
import br.unisul.trabalhointegrador.dao.MotoristaDao;
import br.unisul.trabalhointegrador.model.Motorista;

public class ControleMotorista {

	private DaoFactory daoFactory = null;
	private MotoristaDao motoristaDao = null;
	
	public ControleMotorista(int codigoFonte) {
		daoFactory = DaoFactory.getDaoFactory(codigoFonte);
		motoristaDao = daoFactory.getMotoristaDao();
		
	}

	public List<Motorista> recuperarMotoristatipoCNH(String tipoCNH) {
		return motoristaDao.recuperarMotoristatipoCNH(tipoCNH);

	}

	public void removerMotorista(String tipoCNH) {
		motoristaDao.removerMotorista(tipoCNH);

	}

	public void inserirMotorista(Motorista motorista) {
		motoristaDao.inserirMotorista(motorista);

	}

}
