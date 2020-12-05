package br.unisul.trabalhointegrador.dao;

import java.util.List;

import br.unisul.trabalhointegrador.model.Motorista;

public interface MotoristaDao {

    /**
     * Metodo responsável por recuperar o motorista pelo tipoCNH.
     *
     * @param tipoCNH String
     * @return {@link Motorista}
     */
    public List<Motorista> recuperarMotoristatipoCNH(String tipoCNH);

    /**
     * Metodo que remove motorista pelo tipoCnh.
     *
     * @param tipoCNH
     */
    public void removerMotorista(String tipoCNH);

    /**
     * Metodo responsavel por inserir motorista.
     *
     * @param motorista {@link Motorista}
     */
    public void inserirMotorista(Motorista motorista);

}
