package br.unisul.trabalhointegrador.model;

public class Objeto {
	
	private String nomeRemetente;
    private String enderecoRemetente;
    private String nomeDestinatario;
    private String enderecoDestinatario;
    private String dataDeposito;
    private double peso;
    private double codigoLocalizador;

    public Objeto() {
    }

    public Objeto(Objeto outro) {
        this.nomeRemetente = outro.nomeRemetente;
        this.enderecoRemetente = outro.enderecoDestinatario;
        this.nomeDestinatario = outro.nomeDestinatario;
        this.enderecoDestinatario = outro.enderecoDestinatario;
        this.dataDeposito = outro.dataDeposito;
        this.peso = outro.peso;
        this.codigoLocalizador = outro.codigoLocalizador;
    }

    public String getNomeRemetente() {
        return nomeRemetente;
    }

    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }

    public String getEnderecoRemetente() {
        return enderecoRemetente;
    }

    public void setEnderecoRemetente(String enderecoRemetente) {
        this.enderecoRemetente = enderecoRemetente;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getEnderecoDestinatario() {
        return enderecoDestinatario;
    }

    public void setEnderecoDestinatario(String enderecoDestinatario) {
        this.enderecoDestinatario = enderecoDestinatario;
    }

    public String getDataDeposito() {
        return dataDeposito;
    }

    public void setDataDeposito(String dataDeposito) {
        this.dataDeposito = dataDeposito;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCodigoLocalizador() {
        return codigoLocalizador;
    }

    public void setCodigoLocalizador(double codigoLocalizador) {
        this.codigoLocalizador = codigoLocalizador;
    }

    @Override
    public String toString() {
        return "Objeto [codigoLocalizador=" + codigoLocalizador + "]";
    }
}
