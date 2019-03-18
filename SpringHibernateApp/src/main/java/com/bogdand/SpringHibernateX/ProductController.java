package com.bogdand.SpringHibernateX;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductRepository prodR;
	
	@GetMapping("/product/count")
	public long getCount(Product prod) {
		return prodR.count();
	}
	
	@GetMapping("/product")
	public Page<Product> getAllProds(Pageable pageable) {
		return prodR.findAll(pageable);
	}
	
	@PostMapping("/product")
	public Product createProd(@Valid @RequestBody Product prod) {
		return prodR.save(prod);
	}
	
	@PutMapping("/product/{id}")
	public Product updateProd(@PathVariable Long id, @Valid @RequestBody Product prodReq) {
		return prodR.findById(id).map(prod -> {
			prod.setName(prodReq.getName());
			prod.setDescription(prodReq.getDescription());
			prod.setContent(prodReq.getContent());
			return prodR.save(prod);
		}).orElseThrow(() -> new Exceptions("Product "+id+" not found!"));
	}


	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProd(@PathVariable Long id) {
		return prodR.findById(id).map( prod -> {
			prodR.delete(prod);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exceptions("Product "+id+" not found!"));
	}
}	