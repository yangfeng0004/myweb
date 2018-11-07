package cn.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import cn.web.model.Product;


public class ProductDaoImpl extends BaseDao<Product> {

	
	protected Product getRow(ResultSet rs) throws SQLException {
		
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setRemark(rs.getString("remark"));
		
		return product;
	}

	public static void main(String[] args) {
		ProductDaoImpl daoImpl = new ProductDaoImpl();
		Product product = daoImpl.getById(1);
		System.out.println(product);
	}

	public Product getById(int id) {
		String sql = "select * from product where id = ?";
		return super.getById(sql, id);
	}
	public List<Product> queryByName(String keyworld) {
		new Date();
		return null;
	}

	public int update(Product product) {
		String sql = "update product set name = ? ,price = ? ,remark = ? where id = ?";
		return super.update(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() });
	}

	public int delete(int id) {
		String sql = "delete from product where id = ?";
		return super.update(sql, new Object[] { id });
	}

	public int save(Product product) {
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		return super.update(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}
}
