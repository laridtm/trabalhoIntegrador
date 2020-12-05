package br.unisul.trabalhointegrador.model;

import java.io.Serializable;
import java.util.Comparator;

public class Veiculo implements Serializable {

    public static int CARRETA = 1;
    public static int CAMINHAO_BAU = 2;
    public static int VAN = 3;

    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private int tipo;
    private int capacidade;
    private boolean disponivel;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Veiculo [placa=" + placa + ", tipo=" + tipo + "]";
    }
}
