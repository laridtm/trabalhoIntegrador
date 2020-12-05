package br.unisul.trabalhointegrador.controller;

import br.unisul.trabalhointegrador.dao.DaoFactory;
import br.unisul.trabalhointegrador.dao.VeiculoDao;
import br.unisul.trabalhointegrador.model.Veiculo;

public class ControleVeiculo {

    private DaoFactory daoFactory = null;
    private VeiculoDao veiculoDao = null;

    public ControleVeiculo(int codigoFonte) {
        daoFactory = DaoFactory.getDaoFactory(codigoFonte);
        veiculoDao = daoFactory.getVeiculoDao();
    }

    public void removerVeiculo(String placa) {
        veiculoDao.removerVeiculo(placa);

    }

    public void inserirVeiculo(Veiculo veiculo) {
        veiculoDao.inserirVeiculo(veiculo);

    }
}
