package br.unisul.trabalhointegrador.dao.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.unisul.trabalhointegrador.dao.VeiculoDao;
import br.unisul.trabalhointegrador.model.Veiculo;
import br.unisul.trabalhointegrador.util.DatabaseService;

public class BancoVeiculoDao implements VeiculoDao {

	@Override
	public void removerVeiculo(String placa) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DatabaseService.getConnection();
			ps = conn.prepareStatement("DELETE FROM veiculo WHERE placa = ? ");
			ps.setString(1, placa);

			ps.execute();

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

			}
		}
	}

	@Override
	public void inserirVeiculo(Veiculo veiculo) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DatabaseService.getConnection();
			ps = conn.prepareStatement(
					"INSERT INTO Veiculo(marca, modelo, ano, plca, tipo, capacidade, disponivel) VALUES(?,?,?,?,?,?,?)");

			ps.setString(1, veiculo.getMarca());
			ps.setString(2, veiculo.getModelo());
			ps.setInt(3, veiculo.getAno());
			ps.setString(4, veiculo.getPlaca());
			ps.setInt(5, veiculo.getTipo());
			ps.setInt(6, veiculo.getCapacidade());
			ps.setBoolean(7, veiculo.isDisponivel());

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

			}

		}

	}

}
