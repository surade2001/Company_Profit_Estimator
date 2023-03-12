package Edubright;

import java.sql.*;

public class CompanyDAO {
	private Connection conn;

	public CompanyDAO(Connection conn) {
		this.conn = conn;
	}

	public void addCompany(Company company) throws SQLException {
		String sql = "INSERT INTO companies (name, revenue, expenses) VALUES (?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, company.getName());
		stmt.setDouble(2, company.getRevenue());
		stmt.setDouble(3, company.getExpenses());
		stmt.executeUpdate();
		stmt.close();
	}

	public Company getCompany(int id) throws SQLException {
		String sql = "SELECT name, revenue, expenses FROM companies WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Company company = null;
		if (rs.next()) {
			String name = rs.getString("name");
			double revenue = rs.getDouble("revenue");
			double expenses = rs.getDouble("expenses");
			company = new Company(id, name, revenue, expenses);
		}
		rs.close();
		stmt.close();
		return company;
	}
}
