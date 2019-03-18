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
public class OpinionController {
	@Autowired
	private OpinionRepository or;
	
	@Autowired
	private ProductRepository pr;
	
	@GetMapping("/products/opinions/count")
	public long getCount(Opinion op) {
		return or.count();
	}
	
	@GetMapping("/products/{id}/opinions")
	public Page<Opinion> getOpinionById(@PathVariable(value="id") Long id, Pageable pageable) {
		return or.findByProductId(id, pageable);
	}
	
	@PostMapping("/products/{id}/opinions")
	public Opinion createOpinion(@PathVariable(value="id") Long id, @Valid @RequestBody Opinion opinionx) {
		return pr.findById(id).map(prod -> {
			opinionx.setProduct(prod);
			return or.save(opinionx);
		}).orElseThrow(() -> new Exceptions("Product "+id+ " not found!"));
	}	
	
	@PostMapping("/products/opinions/all")
	public Page<Opinion> allOpinionsByProdId(Pageable pageable) {
		return or.findAll(pageable);
}	
	
	@PutMapping("/products/{pid}/opinions/{oid}")
	public Opinion updateOpinion (@PathVariable(value="pid") Long prodId, @PathVariable(value="oid") Long opId, @Valid @RequestBody Opinion opReq) {
		if (!pr.existsById(prodId)) {
			throw new Exceptions("Product "+prodId+" not found");
		}
		
		return or.findById(opId).map(opinion -> {
			opinion.setText(opReq.getText());
			return or.save(opinion);
		}).orElseThrow(() -> new Exceptions("Opinion "+opId+" not found!"));
	}
	
	@DeleteMapping("/products/{pid}/opinions/{oid}")
	public ResponseEntity<?> deleteOpinion(@PathVariable (value="pid") Long prodId, @PathVariable(value="oid") Long opId) {
		if (!pr.existsById(prodId)) {
			throw new Exceptions("Product "+prodId+" not found");
		}
		return or.findById(opId).map( opinion -> {
			or.delete(opinion);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exceptions("Opinion "+opId+" not found!"));
	}
	
		
}

