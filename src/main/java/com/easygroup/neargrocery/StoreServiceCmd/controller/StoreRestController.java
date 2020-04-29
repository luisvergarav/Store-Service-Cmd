package com.easygroup.neargrocery.StoreServiceCmd.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.easygroup.neargrocery.StoreServiceCmd.adapters_input.StoreAplicationService;
import com.easygroup.neargrocery.StoreServiceCmd.aggregates.domain.ArticuloEntity;
import com.easygroup.neargrocery.StoreServiceCmd.domain.entities.Almacen;
import com.easygroup.neargrocery.StoreServiceCmd.eventsource.domain.message.Message;
import com.easygroup.neargrocery.StoreServiceCmd.eventsource.service.DomainEventSourceSender;
import com.easygroup.neargrocery.StoreServiceCmd.vo.AlmacenRequest;
import com.easygroup.neargrocery.StoreServiceCmd.vo.ProductoVO;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class StoreRestController {

	@Autowired
	StoreAplicationService storeApplicationService;

	@RequestMapping(path = "/api/store", method = POST)
	public ResponseEntity<AlmacenRequest> addStore(@RequestBody AlmacenRequest almacenRequest) {
		storeApplicationService.addAlmacen(almacenRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(path = "/api/store/{storeId}/products", method = RequestMethod.GET)
	public ResponseEntity<Collection<ProductoVO>> getArticulos(@PathVariable("storeId") Integer storeId) {

		List<ProductoVO> productos = new ArrayList<>();

		List<ArticuloEntity> listaProductos = storeApplicationService.getArticulos(storeId);

		for (ArticuloEntity entity : listaProductos) {

			ProductoVO producto = new ProductoVO();
			producto.setCantidad(entity.getCantidad());
			producto.setFechaActualizacion(entity.getFechaActualizacion());
			producto.setIdArticulo(entity.getIdArticulo());
			producto.setIdTipoArticulo(entity.getIdTipoArticulo());
			producto.setNombreArticulo(entity.getNombreArticulo());
			producto.setPrecio(entity.getPrecio());
			producto.setUnidadMedida(entity.getUnidadMedida());

			productos.add(producto);
		}
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}

	@RequestMapping(path = "/api/store", method = RequestMethod.GET)
	public ResponseEntity<AlmacenRequest> getStore(@RequestParam(value = "search") String search) {
		Almacen a = this.storeApplicationService.getAlmacen(search);

		if (a == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
			AlmacenRequest ar = new AlmacenRequest();
			ar.setActivo(a.getActivo()); 
			ar.setIdAlmacen(a.getIdAlmacen());
			ar.setImagen(a.getImagen());
			ar.setNombreAlmacen(a.getNombreAlmacen());
		return new ResponseEntity<>(ar, HttpStatus.OK);
	}

	@RequestMapping(path = "/api/store/filter", method = RequestMethod.GET)
	public ResponseEntity<List<AlmacenRequest>> getStoreByFilter(@RequestParam(value = "region") String region,
			@RequestParam(value = "comuna") String comuna, 
			@RequestParam(value = "articulo") String articulo) {

		List<AlmacenRequest> almacenes = new ArrayList<AlmacenRequest>();
		for (Almacen a : this.storeApplicationService.getAlmacenes(region, comuna, articulo)) {

			AlmacenRequest ar = new AlmacenRequest();
			ar.setActivo(a.getActivo());
			ar.setIdAlmacen(a.getIdAlmacen());
			ar.setImagen(a.getImagen());
			ar.setNombreAlmacen(a.getNombreAlmacen());
			almacenes.add(ar);
		}

		return new ResponseEntity<>(almacenes, HttpStatus.OK);

	}
}