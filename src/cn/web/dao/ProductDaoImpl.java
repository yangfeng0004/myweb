package cn.web.dao;

import cn.web.model.Product;


public class ProductDaoImpl extends BaseDao {

	public static void main(String[] args) {
		ProductDaoImpl daoImpl = new ProductDaoImpl();
		
		daoImpl.delete(5);
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
