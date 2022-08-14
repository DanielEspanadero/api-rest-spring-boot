# API REST SPRING BOOT

Api rest creada con spring tools 4 para eclipse.

## CONFIGURACIÓN DE APLICATION.PROPERTIES
Para configurar el archivo aplication.properties solo he utilizado la configuración de la conexión a la base de datos.
```
spring.jpa.database=MYSQL
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos
spring.datasource.username=root
spring.datasource.password=********
```

## CREACIÓN DE LA ENTIDAD PERSONA

Una entidad en Java es un objeto de persistencia.

La persistencia es la habilidad de una aplicación para mantener(persistir) y recuperar información de sistemas de almacenamiento no volátiles.

Una entidad representa una tabla en una base de datos, y cada instancia de entidad corresponde a una fila en la tabla.

El estado de una entidad se representa por campos de persistencia o propiedades de persistencia.

⚠️ PARA DIFERENCIAR UNA CLASE ESTANDARD DE UNA ENTIDAD, TENEMOS QUE UTILIZAR LA ANOTACIÓN @Entity ⚠️

Tambien hay otras anotaciones como @Id o @Column que sirven para crear tablas.
```
package com.api.rest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {

	
	@Id
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private Integer edad;

	
//	Getters and Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
}
```

