package br.unisul.trabalhointegrador.dao;

import br.unisul.trabalhointegrador.dao.arquivo.ArquivoDaoFactory;
import br.unisul.trabalhointegrador.dao.banco.BancoDaoFactory;

public abstract class DaoFactory {

	/**
	 * Metodo principal para fazer um objeto do tipo Dao
	 * 
	 * @param CodigoFonte int -> O - Banco de Dados | 1 - Arquivo Se o codigoFonte
	 *                    for diferente de 0 ou 1 retorna null
	 * @return {@link DaoFactory}
	 */
	public static DaoFactory getDaoFactory(int CodigoFonte) {
		if (CodigoFonte == 0) {
			return new BancoDaoFactory();
		} else if (CodigoFonte == 1) {
			return new ArquivoDaoFactory();
		} else {
			return null;
		}
	}

	public abstract MotoristaDao getMotoristaDao();

	public abstract ObjetoDao getObjetoDao();

	public abstract VeiculoDao getVeiculoDao();

}
