package com.testpay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testpay.Dto.ProductRequest;
import com.testpay.Dto.StripeResponse;
import com.testpay.service.Stripeservice;

@RestController
@RequestMapping("/product/v1")
public class ProductCheckoutController {

	
	private Stripeservice StripeService;
	
	public ProductCheckoutController(Stripeservice StripeService ) {
		
		
		this.StripeService=StripeService;
	}
	@PostMapping("/checkout")
	public ResponseEntity<StripeResponse> checkoutProducts(@RequestBody ProductRequest productRequest){
		
		StripeResponse stripeResponse=StripeService.checoutProducts(productRequest);
		return ResponseEntity.status(HttpStatus.OK)
				.body(stripeResponse);
		
	}
}
