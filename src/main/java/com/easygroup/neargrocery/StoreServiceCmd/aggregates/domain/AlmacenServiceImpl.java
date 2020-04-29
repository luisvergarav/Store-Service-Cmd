package com.easygroup.neargrocery.StoreServiceCmd.aggregates.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygroup.neargrocery.StoreServiceCmd.aggregates.domain.AlmacenAggregate;
import com.easygroup.neargrocery.StoreServiceCmd.domain.entities.Almacen;
import com.easygroup.neargrocery.StoreServiceCmd.domain.repository.AlmacenRepository;


 
/**
 *
 * @author Vass Chile
 */
@Service("almacenService")
public class AlmacenServiceImpl implements AlmacenService {
 
	private static final int List = 0;
	private AlmacenRepository<Almacen, String> almacenRepository;

	/**
	 *
	 * @param AlmacenVO
	 *            Repository
	 */
	@Autowired
	public AlmacenServiceImpl(AlmacenRepository<Almacen, String> almacenRepository) {
	
		this.almacenRepository = almacenRepository;
	}

	@Override
	public Almacen get(String id) throws Exception {
		// TODO Auto-generated method stub
		return (Almacen) almacenRepository.get(id);
	}
	@Override
	public Collection<Almacen> getAll(String id) throws Exception {
		return this.almacenRepository.getAll(id);		
		
	}

	@Override
	public Almacen get(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return (Almacen) almacenRepository.get(id);
	}

	@Override
	public List<Almacen> getAll(String region, String comuna, String articulo) throws Exception {
		// TODO Auto-generated method stub
		return (List<Almacen>) almacenRepository.getAll(region, comuna, articulo);
	}
	public void add(AlmacenAggregate entity) {
		
		Almacen almacen = new Almacen();
		almacen.setActivo(entity.almacenRootEntity.getActivo());
		almacen.setImagen(entity.almacenRootEntity.getImagen());
		almacen.setNombreAlmacen(entity.almacenRootEntity.getNombreAlmacen());
		almacen.setIdUsuario(entity.almacenRootEntity.getIdUsuario());
		this.almacenRepository.add(almacen);
	}

}
