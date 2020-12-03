package br.unisul.trabalhointegrador.dao.arquivo;

import br.unisul.trabalhointegrador.dao.DaoFactory;
import br.unisul.trabalhointegrador.dao.MotoristaDao;
import br.unisul.trabalhointegrador.dao.ObjetoDao;
import br.unisul.trabalhointegrador.dao.VeiculoDao;

public class ArquivoDaoFactory extends DaoFactory {

	@Override
	public MotoristaDao getMotoristaDao() {
		return new ArquivoMotoristaDao();
	}

	@Override
	public ObjetoDao getObjetoDao() {
		return new ArquivoObjetoDao();
	}

	@Override
	public VeiculoDao getVeiculoDao() {
		return new ArquivoVeiculoDao();
	}
	
	

}
