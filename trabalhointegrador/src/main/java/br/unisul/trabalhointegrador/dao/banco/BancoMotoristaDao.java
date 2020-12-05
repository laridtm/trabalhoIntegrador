package br.unisul.trabalhointegrador.dao.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.unisul.trabalhointegrador.dao.MotoristaDao;
import br.unisul.trabalhointegrador.model.Motorista;
import br.unisul.trabalhointegrador.util.DatabaseService;

public class BancoMotoristaDao implements MotoristaDao {

    @Override
    public List<Motorista> recuperarMotoristatipoCNH(String tipoCNH) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Motorista motorista = null;
        List<Motorista> motoristas = new LinkedList<Motorista>();

        try {
            conn = DatabaseService.getConnection();
            ps = conn.prepareStatement(
                    "SELECT Nome, dataNascimento, endereço, tipoCNH, numeroCNH, disponivel FROM motorista WHERE tipoCNH = ?");
            ps.setString(1, tipoCNH);

            rs = ps.executeQuery();

            while (rs.next()) {
                motorista = new Motorista();
                motorista.setNome(rs.getString("nome"));
                motorista.setDataNascimento(rs.getString("dataNascimento"));
                motorista.setEndereco(rs.getString("endereço"));
                motorista.setTipoCNH(rs.getString("tipoCNH"));
                motorista.setNumeroCNH(rs.getDouble("numeroCNH"));

                motoristas.add(motorista);

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

        return motoristas;
    }

    @Override
    public void removerMotorista(String tipoCNH) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseService.getConnection();
            ps = conn.prepareStatement("DELETE FROM motorista WHERE tipoCNH = ?");
            ps.setString(1, tipoCNH);

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
    public void inserirMotorista(Motorista motorista) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseService.getConnection();
            ps = conn.prepareStatement(
                    "INSERT INTO Motorista(Nome, dataNascimento, endereço, tipoCNH, numeroCNH, disponivel) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, motorista.getNome());
            ps.setString(2, motorista.getDataNascimento());
            ps.setString(3, motorista.getEndereco());
            ps.setString(4, motorista.getTipoCNH());
            ps.setDouble(5, motorista.getNumeroCNH());
            ps.setBoolean(6, motorista.isDisponivel());

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
