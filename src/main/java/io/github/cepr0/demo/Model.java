package io.github.cepr0.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Model implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	public Model(String name) {
		this.name = name;
	}
}
