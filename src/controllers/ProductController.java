package controllers;

import java.util.HashMap;
import java.util.Map;

import daos.ProductDAO;
import models.Product;
import views.RegisterProductsView;

public class ProductController {
	
	private Product model;
	private ProductDAO dao;
	
	public ProductController() {
		this.model = new Product();
		this.dao = new ProductDAO();
	}
	
	public void search() {
		this.dao.get(this.model);	
	}
	
	public void insert() {	
		this.dao.create(this.model);
	}
	
	public void update() {
		this.dao.update(this.model);	
	}
	
	public void delete(int code) {
		this.model.setCode(code);
		this.dao.delete(this.model);
	}
	
	public void setModelValues(Map<String, String>  values) {
		int code = Integer.parseInt(values.get("code"));
		String name = values.get("name");
		String description = values.get("description");
		
		this.model.setCode(code);
		this.model.setName(name);
		this.model.setDescription(description);
		
	}

	public Map<String, String> getModelValues() {
		
		Map<String, String> modelValues = new HashMap<String, String>();
		
		modelValues.put("code",String.valueOf(this.model.getCode()));
		modelValues.put("name",this.model.getName());
		modelValues.put("description", this.model.getDescription());

		return modelValues;
	}
	
	public RegisterProductsView register() {
		return new RegisterProductsView(this);
	}
}
