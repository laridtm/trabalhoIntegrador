package br.unisul.trabalhointegrador.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Rota {
     
    private Date data;
    private Veiculo veiculo;
    private Motorista motorista;
    private List<Objeto> objetos;

    public Rota(Veiculo veiculo, Motorista motorista) {
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.data = new Date();
        this.objetos = new ArrayList<Objeto>();
    }

    public Date getData() {
        return data;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void addObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    public void removerObjeto (Objeto objeto){
        objetos.remove(objeto);
    }

    @Override
    public String toString() {
        return "Rota [" + motorista.toString() + ", " + objetos.toString() + ", " + veiculo.toString() + "]";
    }
}
