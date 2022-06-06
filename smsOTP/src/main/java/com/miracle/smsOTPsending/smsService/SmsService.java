package com.miracle.smsOTPsending.smsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.miracle.smsOTPsending.OTPpojos.SmsPojo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Component
public class SmsService {
     private final String ACCOUNT_SID ="ACfa26c6b770d41d075f7445fdaf196999";

    private final String AUTH_TOKEN = "8c175de93652735d6f079fdffaaeeda9";

    private final String FROM_NUMBER = "+918309278773";

    public void send(SmsPojo sms) throws ParseException {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
    	
        int min = 100000;  
         int max = 999999; 
        int number=(int)(Math.random()*(max-min+1)+min);
      
        
        String msg ="Your OTP - "+number+ " please verify this OTP in your Application by m.ramesh miraclesoft.com";
       
        
        Message message = Message.creator(new PhoneNumber(sms.getPnumber()), new PhoneNumber(FROM_NUMBER), msg)
                .create();
       
      /*  Date myDate=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sdf. parse(myDate.toString()); 
        long millis = date. getTime(); 
        System.out.println(millis);
       OTPpojo.setOtp(number);
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction
*/
    }

    public void receive(MultiValueMap<String, String> smscallback) {
   
    }

}
