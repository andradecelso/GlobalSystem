package br.com.empresa.crud.acessoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoOracle {

	public static Connection obterConexao() {

		Connection conexao = null;

		try {
			Class.forName("oracle.jdbc.Driver.OracleDriver");
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "fuctura", "aluno");

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException f) {

			f.printStackTrace();
		}

		return conexao;

	}

}
