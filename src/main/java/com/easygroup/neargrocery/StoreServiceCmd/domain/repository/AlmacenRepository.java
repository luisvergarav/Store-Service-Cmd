package com.easygroup.neargrocery.StoreServiceCmd.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author VassChile
 */
public interface AlmacenRepository<Almacen, String> extends Repository<Almacen, String> {

    
	public Almacen get(Integer id) throws Exception;
	public List<Almacen> getAll(String region,String comuna,String articulo) throws Exception;
		
	
    
}
