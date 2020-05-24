package com.github.rakhmedovrs.domain;

import lombok.*;

import java.math.BigDecimal;
import javax.persistence.*;

/**
 * @author RakhmedovRS
 * @created 18-May-20
 */
@Data
@EqualsAndHashCode(exclude = "recipe")
@Entity
public class Ingredient
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;
	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure uom;
	@ManyToOne(targetEntity = Recipe.class)
	private Recipe recipe;

	public Ingredient()
	{
	}

	public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe)
	{
		this.description = description;
		this.amount = amount;
		this.uom = uom;
		this.recipe = recipe;
	}
}
