package br.unisul.trabalhointegrador.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import br.unisul.trabalhointegrador.model.Motorista;
import br.unisul.trabalhointegrador.model.Rota;
import br.unisul.trabalhointegrador.model.Veiculo;
import br.unisul.trabalhointegrador.util.DatabaseService;

public class ControleRota {
	public List<Rota> recuperarRotaData(Veiculo veiculo, Motorista motorista) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Rota rota = null;
		List<Rota> rotas = new LinkedList<Rota>();

		try {
			conn = DatabaseService.getConnection();
			ps = conn.prepareStatement(
					"SELECT data, veiculo, motorista, objeto FROM objeto WHERE motorista, veiculo = ?,? ");
			// ps.motorista(1, motorista);

		} catch (Exception e) {

		}

		return null;
	}

	public void removerRota(Veiculo veiculo, Motorista motorista) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DatabaseService.getConnection();
			ps = conn.prepareStatement("DELETE FROM rota WHERE veiculo, motorista = ?,?");

		} catch (Exception e) {

		}

	}

	public void inserirRota(Rota rota) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DatabaseService.getConnection();
			ps = conn.prepareStatement("INSERT INTO Rota(data,veiculo,motorista.objeto) VALUES(?,?,?,?)");

		} catch (Exception e) {

		}

	}

}
