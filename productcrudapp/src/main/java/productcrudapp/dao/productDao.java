package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component
public class productDao {
   
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	//insert
	@Transactional
	public void createProduct(Product product) {
	   this.hibernateTemplate.saveOrUpdate(product);	
	}
	
	//get all product
	public List<Product> getproducts(){
		List<Product>products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//delete the single product
	//load method is used to retrieve persistent object from the database by its identifier
	@Transactional
	public void deleteproduct(int pid) {
		Product p = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(p);
		
	}
	
	//get the single product
	public Product getproduct(int pid) {
		return this.hibernateTemplate.get(Product.class,pid );
	}
	
}
