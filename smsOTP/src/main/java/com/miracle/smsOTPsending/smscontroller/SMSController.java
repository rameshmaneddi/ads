package com.miracle.smsOTPsending.smscontroller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miracle.smsOTPsending.OTPpojos.SmsPojo;
import com.miracle.smsOTPsending.smsService.SmsService;

@RestController
public class SMSController {
	
	@Autowired
    SmsService service;

    @Autowired
    private SimpMessagingTemplate webSocket;

   private final String  TOPIC_DESTINATION = "/lesson/sms";
  //You can send SMS in verified Number
    @RequestMapping(value = "/pnumber", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> smsSubmit(@RequestBody SmsPojo sms) {
        try{
        	System.out.println("hello");
               service.send(sms);
            System.out.println("hello");
        }
        catch(Exception e){

        	 return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: "+sms.getPnumber());
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }

    @RequestMapping(value = "/smscallback", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void smsCallback(@RequestBody MultiValueMap<String, String> map) {
       service.receive(map);
       webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": Twilio has made a callback request! Here are the contents: "+map.toString());
    }

    private String getTimeStamp() {
       return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }
//    git is my friend 

}
