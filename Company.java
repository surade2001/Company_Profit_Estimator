package Edubright;

public class Company {
	private int id;
	private String name;
	private double revenue;
	private double expenses;

	public Company(int id, String name, double revenue, double expenses) {
		this.id = id;
		this.name = name;
		this.revenue = revenue;
		this.expenses = expenses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public double getExpenses() {
		return expenses;
	}

	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
}

//class CompanyDAO {
//    private Connection conn;
//    
//    public CompanyDAO(Connection conn) {
//        this.conn = conn;
//    }
//    
//    public void addCompany(Company company) throws SQLException {
//        String sql = "INSERT INTO companies (name, revenue, expenses) VALUES (?, ?, ?)";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.setString(1, company.getName());
//        stmt.setDouble(2, company.getRevenue());
//        stmt.setDouble(3, company.getExpenses());
//        stmt.executeUpdate();
//        stmt.close();
//    }
//    
//    public Company getCompany(int id) throws SQLException {
//        String sql = "SELECT name, revenue, expenses FROM companies WHERE id = ?";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.setInt(1, id);
//        ResultSet rs = stmt.executeQuery();
//        Company company = null;
//        if (rs.next()) {
//            String name = rs.getString("name");
//            double revenue = rs.getDouble("revenue");
//            double expenses = rs.getDouble("expenses");
//            company = new Company(id, name, revenue, expenses);
//        }
//        rs.close();
//        stmt.close();
//        return company;
//    }
//}
