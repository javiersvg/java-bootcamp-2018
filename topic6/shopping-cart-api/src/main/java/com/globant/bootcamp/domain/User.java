package com.globant.bootcamp.domain;

import lombok.*;

import javax.persistence.*;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Basic(optional = false)
	private String name;

	@Basic(optional = false)
	private String password;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_shoppingcart")
	private ShoppingCart shoppingCart;

	public void removeCart() {
		this.shoppingCart.setUser(null);
		this.shoppingCart = null;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		shoppingCart.setUser(this);
		this.shoppingCart = shoppingCart;
	}
}
