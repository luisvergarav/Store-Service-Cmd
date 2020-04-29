package com.easygroup.neargrocery.StoreServiceCmd.domain.config;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.easygroup.neargrocery.StoreServiceCmd.aggregates.domain.ArticuloEntity;


@Configuration
@EnableFeignClients
public class RestConfig {

   
    @FeignClient( value = "ProductServiceCmd" )
    public interface QueryClient {

        @GetMapping( path = "/api/product/{storeId}" )
        List<ArticuloEntity> getProductsByStoreId( @PathVariable( "storeId" ) Integer storeId );

       
        	
        
    }
}
