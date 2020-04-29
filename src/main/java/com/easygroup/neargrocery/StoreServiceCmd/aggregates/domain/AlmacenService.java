package com.easygroup.neargrocery.StoreServiceCmd.aggregates.domain;



import java.util.Collection;
import java.util.List;

import com.easygroup.neargrocery.StoreServiceCmd.domain.entities.Almacen;





/**
 *
 * @author Vass Chile
 */
public interface AlmacenService {

	public Almacen get(Integer id) throws Exception;
	public Almacen get(String userId) throws Exception;
	public Collection<Almacen> getAll(String id) throws Exception;
	public List<Almacen> getAll(String region,String comuna,String articulo) throws Exception;
}
