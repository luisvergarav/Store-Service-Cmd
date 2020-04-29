package com.easygroup.neargrocery.StoreServiceCmd.aggregates.domain;

import java.util.List;

import com.easygroup.neargrocery.StoreServiceCmd.domain.config.RestConfig;

public class AlmacenAggregate {

	final AlmacenRootEntity almacenRootEntity;

	public AlmacenAggregate(Builder builder) {
		this.almacenRootEntity = new AlmacenRootEntity(builder.idAlmacen, builder.activo, builder.imagen,
				builder.nombreAlmacen,builder.idUsuario);
	}

	public boolean isValid() {
		if (!this.almacenRootEntity.getNombreAlmacen().equals(""))
			return true;
		else
			return false;
	}

	public List<ArticuloEntity> getArticulos(RestConfig.QueryClient qClient) {

		this.almacenRootEntity.setProductos(qClient.getProductsByStoreId(this.almacenRootEntity.getIdAlmacen()));
		return this.almacenRootEntity.getProductos();
	}

	public static class Builder {

		private Integer idAlmacen;

		private String activo;

		private String imagen;

		private String nombreAlmacen;
		
		private Integer idUsuario;
		
		public Builder idUsuario(Integer idUsuario) {
			this.idUsuario = idUsuario;
			return this;
		}


		public Builder idAlmacen(Integer idAlmacen) {
			this.idAlmacen = idAlmacen;
			return this;
		}

		public Builder activo(String activo) {
			this.activo = activo;
			return this;
		}

		public Builder imagen(String imagen) {
			this.imagen = imagen;
			return this;
		}

		public Builder nsombreAlmacen(String nombreAlmacen) {
			this.nombreAlmacen = nombreAlmacen;
			return this;
		}

		public AlmacenAggregate build() {

			return new AlmacenAggregate(this);
		}

	}
}
