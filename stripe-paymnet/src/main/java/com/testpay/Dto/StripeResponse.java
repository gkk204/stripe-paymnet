package com.testpay.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StripeResponse {
	
 private String status;
 private String message;
 private String sessionId;
 private String sessionUrl;
 
 
 
 


}
