package com.easygroup.neargrocery.StoreServiceCmd.adapters_input;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygroup.neargrocery.StoreServiceCmd.aggregates.domain.AlmacenAggregate;
import com.easygroup.neargrocery.StoreServiceCmd.aggregates.domain.AlmacenServiceImpl;
import com.easygroup.neargrocery.StoreServiceCmd.aggregates.domain.ArticuloEntity;
import com.easygroup.neargrocery.StoreServiceCmd.domain.config.RestConfig;
import com.easygroup.neargrocery.StoreServiceCmd.domain.entities.Almacen;
import com.easygroup.neargrocery.StoreServiceCmd.eventsource.domain.message.Message;
import com.easygroup.neargrocery.StoreServiceCmd.eventsource.service.DomainEventSourceSender;
import com.easygroup.neargrocery.StoreServiceCmd.vo.AlmacenRequest;


@Service("storeApplicationService")
public class StoreAplicationService {
	@Autowired
	private DomainEventSourceSender messageSender;

	@Autowired
	private AlmacenServiceImpl almacenService;
	
	@Autowired
	private  RestConfig.QueryClient qClient;

	public List<ArticuloEntity> getArticulos(Integer storeId){
		 AlmacenAggregate almacen = new AlmacenAggregate.Builder().idAlmacen(storeId).build();
		
		 return almacen.getArticulos(qClient);
		 
	}
	public void addAlmacen(AlmacenRequest almacenRequest) {

		AlmacenAggregate almacen = new AlmacenAggregate.Builder()
				.activo(almacenRequest.getActivo())
				.nsombreAlmacen(almacenRequest.getNombreAlmacen())
				.imagen(almacenRequest.getImagen())
				.idUsuario(almacenRequest.getIdUsuario())
				.build();

		if (almacen.isValid()) {

			try {
				almacenService.add(almacen);
				Message<AlmacenAggregate> message = new Message<AlmacenAggregate>("almacenCreatedEvent", almacen);
				//messageSender.send(message);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Almacen getAlmacen(String userId)
	{
		try {
			return this.almacenService.get(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
	

	public List<Almacen> getAlmacenes(String region,
										String comuna,
										String articulo)
	{
		try {
			return this.almacenService.getAll(region, comuna, articulo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
}
