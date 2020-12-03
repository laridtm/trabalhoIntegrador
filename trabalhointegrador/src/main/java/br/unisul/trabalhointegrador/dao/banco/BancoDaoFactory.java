package br.unisul.trabalhointegrador.dao.banco;

import br.unisul.trabalhointegrador.dao.DaoFactory;
import br.unisul.trabalhointegrador.dao.MotoristaDao;
import br.unisul.trabalhointegrador.dao.ObjetoDao;
import br.unisul.trabalhointegrador.dao.VeiculoDao;

public class BancoDaoFactory extends DaoFactory{

	@Override
	public MotoristaDao getMotoristaDao() {
		return new BancoMotoristaDao();
	}

	@Override
	public ObjetoDao getObjetoDao() {
		return new BancoObjetoDao();
	}

	@Override
	public VeiculoDao getVeiculoDao() {
		return new BancoVeiculoDao();
	}

}
