package com.testpay.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.testpay.Dto.ProductRequest;
import com.testpay.Dto.StripeResponse;

@Service
public class Stripeservice {

	@Value("${stripe.secretKey}")
	private String 	secretKey;
	
	public StripeResponse checoutProducts(ProductRequest productRequest) {

	    Stripe.apiKey = secretKey;

	    SessionCreateParams.LineItem.PriceData.ProductData productData =
	            SessionCreateParams.LineItem.PriceData.ProductData.builder()
	                    .setName(productRequest.getName())
	                    .build();

	    SessionCreateParams.LineItem.PriceData priceData =
	            SessionCreateParams.LineItem.PriceData.builder()
	                    .setCurrency(productRequest.getCurrency() == null ? "USD" : productRequest.getCurrency())
	                    .setUnitAmount(productRequest.getAmount())
	                    .setProductData(productData)
	                    .build();

	    SessionCreateParams.LineItem lineIteam =
	            SessionCreateParams.LineItem.builder()
	                    .setQuantity(productRequest.getQuantity())
	                    .setPriceData(priceData)
	                    .build();

	    SessionCreateParams params = SessionCreateParams.builder()
	            .setMode(SessionCreateParams.Mode.PAYMENT)
	            .setSuccessUrl("http://localhost:8090/success")
	            .setCancelUrl("http://localhost:8090/cancel")
	            .addLineItem(lineIteam)
	            .build();

	    try {

	        Session session = Session.create(params);

	        return StripeResponse.builder()
	                .status("SUCCESS")
	                .message("Payment session created")
	                .sessionId(session.getId())
	                .sessionUrl(session.getUrl())
	                .build();

	    } catch (StripeException ex) {

	        System.out.println(ex.getMessage());

	        return StripeResponse.builder()
	                .status("FAILED")
	                .message("Stripe Error: " + ex.getMessage())
	                .sessionId(null)
	                .sessionUrl(null)
	                .build();
	    }
	}

	
}
