package br.unisul.trabalhointegrador.dao.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.unisul.trabalhointegrador.dao.ObjetoDao;
import br.unisul.trabalhointegrador.model.Objeto;
import br.unisul.trabalhointegrador.util.DatabaseService;

public class BancoObjetoDao implements ObjetoDao{

	@Override
	public List<Objeto> recuperarObjetocodigoLocalizador(double codigoLocalizador) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Objeto objeto = null;
		List<Objeto> Objetos = new LinkedList<Objeto>();

		try {
			conn = DatabaseService.getConnection();
			ps = conn.prepareStatement(
					"SELET nomeRemetente, endereçoRemetente, nomeDestinatario, endereçoDestinatario, dataDeposito, peso, codigoLocalizador FROM motorista WHERE codigoLocalizador = ?");
			ps.setDouble(1, codigoLocalizador);
			rs = ps.executeQuery();

			while (rs.next()) {
				objeto = new Objeto();
				objeto.setNomeRemetente(rs.getString("nomeRemetente"));
				objeto.setEnderecoRemetente(rs.getString("endereçoRemetente"));
				objeto.setNomeDestinatario(rs.getString("nomeDestinatario"));
				objeto.setEnderecoDestinatario(rs.getString("endereçoDestinatario"));
				objeto.setDataDeposito(rs.getString("dataDeposito"));
				objeto.setPeso(rs.getDouble("peso"));
				objeto.setCodigoLocalizador(rs.getDouble("codigoLocalizador"));

				Objetos.add(objeto);

			}

		} catch (SQLException e) {
			System.err.println(e);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
			}

		}

		return Objetos;

	}

	@Override
	public void removerObjeto(double codigoLocalizador) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DatabaseService.getConnection();
			ps = conn.prepareStatement("DELETE FROW motorista WHERE codigoLocalizador = ?");
			ps.setDouble(1, codigoLocalizador);

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
	public void inserirObjeto(Objeto objeto) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DatabaseService.getConnection();
			ps = conn.prepareStatement(
					"INSERT INTO Motorista(nomeRemetente, endereçoRemetente, nomeDestinatario, endereçoDestinatario, dataDeposito, peso, codigoLocalizador) values (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, objeto.getNomeRemetente());
			ps.setString(2, objeto.getEnderecoRemetente());
			ps.setString(3, objeto.getNomeDestinatario());
			ps.setString(4, objeto.getEnderecoDestinatario());
			ps.setString(5, objeto.getDataDeposito());
			ps.setDouble(6, objeto.getPeso());
			ps.setDouble(7, objeto.getCodigoLocalizador());

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
