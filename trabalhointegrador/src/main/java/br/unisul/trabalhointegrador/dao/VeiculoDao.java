package br.unisul.trabalhointegrador.dao;

import br.unisul.trabalhointegrador.model.Veiculo;

public interface VeiculoDao {

    /**
     * Metodo que remove o veiculo pela placa
     *
     * @param placa
     */
    public void removerVeiculo(String placa);

    /**
     * Metodo responsavel por inserir o veiculo
     *
     * @param veiculo {@link Veiculo}
     */
    public void inserirVeiculo(Veiculo veiculo);

}
