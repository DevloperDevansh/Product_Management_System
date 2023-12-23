package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.productDao;
import productcrudapp.model.Product;

@Controller
public class MainController {

	//Here i got the productDao object using spring Ioc container using AutoWired annotation
	
	@Autowired
	private productDao productDao;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		//get list of product from productDao
		  List<Product> products =this.productDao.getproducts();
		  //adding list of product into model attribute
		  model.addAttribute("product", products);
		 
		  return "index";
	}
	
	//handler for add form
	//show add product form
    @RequestMapping("/add-product")
	public String addProduct() {
		return "add_product_form";
	}
    
    //handler for handling form request 
    @RequestMapping(value="/handle-product",method = RequestMethod.POST)
    public  RedirectView handleproduct(@ModelAttribute Product product ,HttpServletRequest request){
    	     System.out.println(product);
    	     //Here I passed product object for saving product information into database
    	     //Using HiberNate technology 
    	     
    	     this.productDao.createProduct(product);
    	     
    	     //here i redirect the page on contextPath on index page
    	     //using create redirect object
    	     RedirectView redirectView =new RedirectView();
    	     redirectView.setUrl(request.getContextPath() + "/");
    	     return redirectView;
    }
	
    
    //delete handler
    
    @RequestMapping("/delete/{productId}")
    public RedirectView deleteProduct(@PathVariable("productId") int productId,HttpServletRequest request) {
    	this.productDao.deleteproduct(productId);
    	
    	//here i redirect the page on contextPath on index page
	     //using create redirect object
	     RedirectView redirectView =new RedirectView();
	     redirectView.setUrl(request.getContextPath() + "/");
    	
    	return redirectView;
    }
    
    //update handler
    
    @RequestMapping("/update/{productId}")
    public String updateProduct(@PathVariable("productId") int productId,Model model) {
    	
    	Product product = this.productDao.getproduct(productId);
    	model.addAttribute("product",product);
 
		return "update_form";
    }
}
