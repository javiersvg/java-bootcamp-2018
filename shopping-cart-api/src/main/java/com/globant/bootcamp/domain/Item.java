package com.globant.bootcamp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Basic(optional = false)
	private String name;

	private String category;

	@Basic(optional = false)
	private Long price;

	@ManyToMany(mappedBy = "items")
	private Set<ShoppingCart> shoppingCarts = new HashSet<>();
}
