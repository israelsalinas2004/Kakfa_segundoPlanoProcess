package com.example.demo.controllers;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.ClusterAuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;

import com.example.demo.models.KafkaExample;
import com.example.demo.models.Message_basicrequest;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

import org.springframework.stereotype.Service;

//https://github.com/CloudKarafka/java-kafka-example/blob/main/src/main/java/KafkaExample.java
//https://github.com/CloudKarafka/springboot-kafka-example/blob/main/src/main/resources/application.properties


@RestController
@RequestMapping("/comun")
public class KakfaController {
		
	
	@PostMapping("/kafka/holaexample")
	public String sayHello() {
		return "Hola Mundo desde el servicio de kakfa!";
		
	}

	@PostMapping("/kafka/holaexample_withvalues")
	public String sayHello(@RequestBody Message_basicrequest variables ) {
		String result = "";
		
		if(!(variables == null)) {
			result = "OMP-Disrupting, ApacheKakfa-Example// Recibidos:  Key: " 
		             + variables.getKey() + ", Message: " + variables.getMessage();
			System.out.println(result);
				
		}
		else
		{
			result = "OMP-Disrupting, ApacheKakfa-Example: Los valores vienen en nulo";
		}
		
	
		return result;
		
	}
	
	
	@PostMapping("/kafka/send_basic_message")
	public String send_basic_message(@RequestBody Message_basicrequest variables ) {
		String result = "";
		
		try
		{
			String brokers = "glider.srvs.cloudkafka.com:9094";
			String username = "zjyjjdyc";
			String password = "QqYtZi3mgChCo5Ju2s9k-IiwfQKG6fVF";
			KafkaExample c = new KafkaExample(brokers, username, password);
	        c.produce();
	        c.consume();
	    	result = "(200) Mensaje-Agregado";
		}
		catch(Exception ex)
		{
			result = "(998) No se ejecuto. Error: "  + ex.getMessage();
		}
		

		return result;
	}
	

    
}
