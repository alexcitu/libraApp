package Controller;

import java.security.MessageDigest;
import java.sql.*;

public class Database {

	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=Login;";

	static final String USER = "alex";
	static final String PASS = "alex";

	private Connection conn = null;
	private PreparedStatement stmt = null;

	public Database() {

	}
	
	public boolean adaugaAutor(String cnp, String nume, String prenume){
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.prepareStatement("SELECT * FROM Autor where CNPAutor = ?");
			stmt.setString(1, cnp);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				rs.close();
				stmt.close();
				conn.close();
				return false;
			}
			
			stmt = conn.prepareStatement("Insert into autor values(?,?,?)");
			stmt.setString(1, cnp);
			stmt.setString(2, nume);
			stmt.setString(3, prenume);
			stmt.executeUpdate();
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return true;
		
	}
	
	public boolean verificareParola(String email, String parola){
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.prepareStatement("SELECT * FROM Login where email = ? and password = ?");
			stmt.setString(1, email);
			stmt.setString(2, sha256(parola));

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				rs.close();
				stmt.close();
				conn.close();
				return true;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return false;
		
	}
	
	public boolean modificareParola(String email, String password) {

		try {
			String user = null;
			String pass = null;
			String nume = null;
			String prenume = null;
			String mail = null;
			String localitate = null;

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.prepareStatement("SELECT * FROM Login where email = ?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				user = rs.getString("username");
				pass = rs.getString("password");
				nume = rs.getString("nume");
				prenume = rs.getString("prenume");
				mail = rs.getString("email");
				localitate = rs.getString("localitate");

				stmt = conn.prepareStatement("DELETE FROM Login where email = ?");
				stmt.setString(1, email);
				stmt.executeUpdate();

				stmt = conn.prepareStatement("Insert into login values(?,?,?,?,?,?)");
				stmt.setString(1, user);
				stmt.setString(2, sha256(password));
				stmt.setString(3, nume);
				stmt.setString(4, prenume);
				stmt.setString(5, mail);
				stmt.setString(6, localitate);
				stmt.executeUpdate();

				rs.close();
				stmt.close();
				conn.close();
				return true;
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return false;
	}

	public boolean verificareLogin(String user, String pass) {

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.prepareStatement("SELECT * FROM Login where username = ? and password = ?");
			stmt.setString(1, user);
			stmt.setString(2, sha256(pass));

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				rs.close();
				stmt.close();
				conn.close();
				return true;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return false;
	}

	public boolean introducereUtilizator(String user, String pass, String nume, String prenume, String email,
			String localitate) {

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.prepareStatement("SELECT * FROM Login where email = ?");
			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				rs.close();
				stmt.close();
				conn.close();
				return false;
			}

			stmt = conn.prepareStatement("Insert into login values(?,?,?,?,?,?)");
			stmt.setString(1, user);
			stmt.setString(2, sha256(pass));
			stmt.setString(3, nume);
			stmt.setString(4, prenume);
			stmt.setString(5, email);
			stmt.setString(6, localitate);
			stmt.executeUpdate();

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return true;
	}
	
	public boolean cautaUtilizator(String email) {

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.prepareStatement("SELECT * FROM Login where Email = ?");
			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				rs.close();
				stmt.close();
				conn.close();
				return true;
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return false;
	}
	
	public void stergeUtilizator(String email) {

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.prepareStatement("DELETE FROM Login where Email = ?");
			stmt.setString(1, email);
			stmt.executeUpdate();

			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	String sha256(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(("" + password).getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
