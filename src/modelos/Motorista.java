package src.modelos;

public class Motorista {
	
	private String Nome;
    private String dataNascimento;
    private String endereco;
    private String tipoCNH;
    private double numeroCNH;
    public boolean disponivel;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoCNH() {
        return tipoCNH;
    }

    public void setTipoCNH(String tipoCNH) {
        this.tipoCNH = tipoCNH;
    }

    public double getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(double numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}
