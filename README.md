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

## CREACIÓN DE LA INTERFAZ PERSONADAO

Una interfaz (interface) es sintácticamente similar a una clase abstracta, en la que puede especificar uno o más métodos que no tienen cuerpo ({}). Esos métodos deben ser implementados por una clase para que se definan sus acciones.

Por lo tanto, una interfaz especifica qué se debe hacer, pero no cómo hacerlo. Una vez que se define una interfaz, cualquier cantidad de clases puede implementarla. Además, una clase puede implementar cualquier cantidad de interfaces.

Para implementar una interfaz, una clase debe proporcionar cuerpos (implementaciones) para los métodos descritos por la interfaz. Cada clase es libre de determinar los detalles de su propia implementación. Dos clases pueden implementar la misma interfaz de diferentes maneras, pero cada clase aún admite el mismo conjunto de métodos. Por lo tanto, el código que tiene conocimiento de la interfaz puede usar objetos de cualquier clase, ya que la interfaz con esos objetos es la misma.

_La carpeta DAO es el equivalente a CONTROLLERS donde se almacena la lógica de la aplicación._
```
package com.api.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.models.Persona;

public interface PersonaDAO extends JpaRepository<Persona, Integer> {

}
```

## CONFIGURACIÓN DE LA CLASE PERSONAREST

En el package de REST van todas las peticiones al servidor, en este caso hemos creado un CRUD para la tabla personas:

```
package com.api.rest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.dao.PersonaDAO;
import com.api.rest.models.Persona;

@RestController
@RequestMapping("personas")
public class PersonaRest {

	@Autowired
	private PersonaDAO personaDAO;
	
//	Metodos HTTP - Peticiones al servidor
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Persona persona) {
		personaDAO.save(persona);
	}
	
	@GetMapping("/listar")
	public List<Persona> listar() {
		return personaDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		personaDAO.deleteById(id);
	}
	
	@PutMapping("actualizar")
	public void actualizar(@RequestBody Persona persona) {
		personaDAO.save(persona);
	}
	
}
```