package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {

		String tipoBanco = System.getenv("tipoBanco");

		try {
			Connection conexao = DriverManager.getConnection("jdbc:" + tipoBanco + "://localhost:3306/banco", "usuario", "senha");

			return conexao;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
