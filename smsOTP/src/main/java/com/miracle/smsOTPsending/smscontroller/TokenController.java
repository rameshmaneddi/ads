package com.miracle.smsOTPsending.smscontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miracle.smsOTPsending.OTPpojos.TempOTP;

@RestController
public class TokenController {
	
	@PostMapping("/otp")
	public ResponseEntity<String> ValidateToken(@RequestBody TempOTP otp){
		
		int sentotp=otp.getOtp();
		System.out.println(sentotp+":"+otp.getOtp());
		if(sentotp==otp.getOtp()) {
		    return new ResponseEntity<String>("Success otp",HttpStatus.OK);	
		}
		return new ResponseEntity<String>("faliure",HttpStatus.UNAUTHORIZED);
	}

}
