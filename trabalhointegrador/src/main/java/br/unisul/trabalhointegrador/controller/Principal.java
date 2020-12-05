package br.unisul.trabalhointegrador.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

import br.unisul.trabalhointegrador.dao.DaoFactory;
import br.unisul.trabalhointegrador.dao.MotoristaDao;
import br.unisul.trabalhointegrador.model.*;
import br.unisul.trabalhointegrador.registry.*;

public class Principal {

    List<Veiculo> veiculos = new ArrayList<Veiculo>();
    List<Motorista> motoristas = new ArrayList<Motorista>();
    List<Objeto> objetos = new ArrayList<Objeto>();
    List<Rota> rotas = new ArrayList<Rota>();
    List<Rota> rotasAntigas = new ArrayList<Rota>();

    public Motorista cadastrarMotorista(Motorista motorista) {
        motoristas.add(motorista);
        RegistroMotorista.salvarMotoristas(motoristas);

        return motorista;
    }

    public void cadastrarObjeto(Objeto objeto) {
        objetos.add(objeto);
        RegistroObjeto.salvarObjetos(objetos);
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);

        Collections.sort(veiculos, new Comparator<Veiculo>() {
            @Override
            public int compare(Veiculo obj1, Veiculo obj2) {
                return obj1.getTipo() - obj2.getTipo();
            }
        });

        RegistroVeiculo.salvarVeiculos(veiculos);
    }

    public double gerarCodigoLocalizador() {
        Random randomico = new Random();
        double aux = randomico.nextDouble();
        return aux;
    }

    public boolean verificarCodLocalizador(double codigo) {
        for (int i = 0; i < objetos.size(); i++) {
            if (objetos.get(i).getCodigoLocalizador() == codigo) {
                return true;
            }
        }
        return false;
    }

    public boolean motoristaCompativel(Motorista motorista, Veiculo veiculo) {
        if (motorista.getTipoCNH().equalsIgnoreCase("C")) {
            return true;
        } else {
            if (veiculo.getTipo() == veiculo.VAN) {
                return true;
            }
        }
        return false;
    }

    public void tornarMotoristasDisponiveis() {
        for (Motorista motorista : motoristas) {
            motorista.setDisponivel(true);
        }
    }

    public void tornarVeiculosDisponiveis() {
        for (Veiculo veiculo : veiculos) {
            veiculo.setDisponivel(true);
        }
    }

    public void imprimirRotas(List<Rota> rotasImprimir) {
        String relatorioRotas = "";
        for (Rota rota : rotasImprimir) {
            relatorioRotas = relatorioRotas + rota.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, relatorioRotas);
    }

    public void imprimirTodasRotas() {
        imprimirRotas(rotas);
    }

    public void gerarRota() {
        tornarMotoristasDisponiveis();
        tornarVeiculosDisponiveis();

        for (Motorista motorista : motoristas) {
            if (motorista.isDisponivel()) {
                for (Veiculo veiculo : veiculos) {
                    if (veiculo.isDisponivel() && motoristaCompativel(motorista, veiculo)) {
                        motorista.setDisponivel(false);
                        veiculo.setDisponivel(false);
                        Rota rota = new Rota(veiculo, motorista);

                        for (int i = 0; i < veiculo.getCapacidade(); i++) {
                            if (objetos.isEmpty()) {
                                break;
                            }
                            rota.addObjeto(objetos.remove(0));
                        }

                        if (!rota.getObjetos().isEmpty()) {
                            rotas.add(rota);
                            rotasAntigas.add(rota);
                            RegistroRota.salvarRotas(rotasAntigas);
                        }
                    }
                }
            }
        }
    }

    public void mostrarObjetosRestantes() {
        String objetosRestantes = "";
        for (Objeto objeto : objetos) {
            objetosRestantes = objetosRestantes + objeto.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, objetosRestantes);
    }

    public void devolverObjeto(double codigo) {
        for (Rota rota : rotas) {
            List<Objeto> listaCopia = new ArrayList<Objeto>(rota.getObjetos());
            for (Objeto objeto : listaCopia) {
                if (objeto.getCodigoLocalizador() == codigo) {
                    Objeto copia = new Objeto(objeto);
                    objetos.add(copia);
                    rota.removerObjeto(objeto);
                }
            }
        }
    }

    public void buscarRotas(int tipoDeBusca, String filtro) {
        List<Rota> retornoBusca = new ArrayList<Rota>();

        switch (tipoDeBusca) {
            case 0:
                String dataString = filtro;
                SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
                Date date = null;

                try {
                    date = formatadorData.parse(dataString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                for (Rota rota : rotasAntigas) {
                    Calendar c1 = Calendar.getInstance();
                    Calendar c2 = Calendar.getInstance();

                    c1.setTime(date);
                    c2.setTime(rota.getData());

                    if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                            && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
                            && c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)) {
                        retornoBusca.add(rota);
                    }
                }
                break;

            case 1:
                String nome = filtro;

                for (Rota rota : rotasAntigas) {
                    if (rota.getMotorista().getNome().equalsIgnoreCase(nome)) {
                        retornoBusca.add(rota);
                    }
                }
                break;
        }

        imprimirRotas(retornoBusca);

    }

    public void carregarObjetos() {
        objetos = RegistroObjeto.carregarObjetos();
    }

    public void carregarVeiculos() {
        veiculos = RegistroVeiculo.carregarVeiculos();
    }

    public void carregarMotoristas() {
        motoristas = RegistroMotorista.carregarMotoristas();
    }

    public void carregarRotas() {
        rotas = new ArrayList<Rota>();
        rotasAntigas = RegistroRota.carregarRotas();
    }
}
