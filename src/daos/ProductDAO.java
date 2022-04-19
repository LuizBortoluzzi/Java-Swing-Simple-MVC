package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import models.Product;

public class ProductDAO extends DataAccessObject{
		
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ProductDAO() {
		
	}
	
	public List<Object> getAll(){
		return null;
	}
	
	public Product get(Product model) {
		try {

			this.pstmt = this.dbc.prepareStatement("select codigo, nome, descricao from produto where codigo = ?");
			this.pstmt.setInt(1, model.getCode());
			rs = this.pstmt.executeQuery();
			
			if (rs.next()) {
				model.setCode(rs.getInt("codigo"));
				model.setName(rs.getString("nome"));
				model.setDescription(rs.getString("descricao"));
			}
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	public void create(Product model) {
		try {

			this.pstmt = this.dbc.prepareStatement("insert into produto(codigo, nome, descricao) values (?, ?, ?)");
			this.pstmt.setInt(1, model.getCode());
			this.pstmt.setString(2, model.getName());
			this.pstmt.setString(3, model.getDescription());
			this.pstmt.execute();
			this.pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Product model) {
		try {

			this.pstmt = this.dbc.prepareStatement("update produto set nome = ?, descricao = ? where codigo =  ?");
			this.pstmt.setString(1, model.getName());
			this.pstmt.setString(2, model.getDescription());
			this.pstmt.setInt(3, model.getCode());	
			this.pstmt.execute();
			this.pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Product model) {
		try {
			
			this.pstmt = this.dbc.prepareStatement("delete from produto where codigo =  ?");
			this.pstmt.setString(1, model.getName());
			this.pstmt.execute();
			this.pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
