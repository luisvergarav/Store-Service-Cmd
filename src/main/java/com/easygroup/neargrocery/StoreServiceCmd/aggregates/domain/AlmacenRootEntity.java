package com.easygroup.neargrocery.StoreServiceCmd.aggregates.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


 class AlmacenRootEntity{

	  Integer idAlmacen;

	 String activo;

	 String imagen;

	 String nombreAlmacen;
	 
	 List <ArticuloEntity> productos;
	 
	 Integer idUsuario;
	 

	public AlmacenRootEntity(Integer idAlmacen, String activo, String imagen, String nombreAlmacen,
			Integer idUsuario) {
		super();
		this.idAlmacen = idAlmacen;
		this.activo = activo;
		this.imagen = imagen;
		this.nombreAlmacen = nombreAlmacen;
		this.idUsuario = idUsuario;
	}
	
	public void addProduct() {
		
	}

	public AlmacenRootEntity() {
	}

	public int getIdAlmacen() {
		return this.idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombreAlmacen() {
		return this.nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public List<ArticuloEntity> getProductos() {
		return productos;
	}

	public void setProductos(List<ArticuloEntity> productos) {
		this.productos = productos;
	}

	public void setIdAlmacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	

}