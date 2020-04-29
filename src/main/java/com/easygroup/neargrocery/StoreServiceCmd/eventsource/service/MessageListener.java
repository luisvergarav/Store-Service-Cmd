package com.easygroup.neargrocery.StoreServiceCmd.eventsource.service;

import java.io.IOException;
import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.easygroup.neargrocery.StoreServiceCmd.aggregates.domain.AlmacenService;
import com.easygroup.neargrocery.StoreServiceCmd.aggregates.domain.AlmacenServiceImpl;
import com.easygroup.neargrocery.StoreServiceCmd.domain.entities.Almacen;
import com.easygroup.neargrocery.StoreServiceCmd.eventsource.domain.message.Message;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@EnableBinding(Sink.class)
public class MessageListener {
  
  @Autowired
  private AlmacenServiceImpl almacenService;
  
  /**
   * Handles incoming OrderPlacedEvents. 
   * 
   *  Using the conditional {@link StreamListener} from 
   * https://github.com/spring-cloud/spring-cloud-stream/blob/master/spring-cloud-stream-core-docs/src/main/asciidoc/spring-cloud-stream-overview.adoc
   * in a way close to what Axion
   *  would do (see e.g. https://dturanski.wordpress.com/2017/03/26/spring-cloud-stream-for-event-driven-architectures/)
   */
  @StreamListener(target = Sink.INPUT)
  @Transactional
  public void storeCreatedReceived(String messageJson) throws JsonParseException, JsonMappingException, IOException {
    //Message<Almacen> message = new ObjectMapper().readValue(messageJson, new TypeReference<Message<Almacen>>(){});
    //Almacen almacen = message.getPayload();
    
    //System.out.println("New store created. " + almacen);
    
    // persist domain entity
    try {
		//almacenService.add(almacen);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    
    
   }
  
  

}
