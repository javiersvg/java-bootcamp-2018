package com.globant.bootcamp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@OneToOne(mappedBy = "shoppingCart")
	private User user;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "shoppingcart_item",
			joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "shoppingcart_id", referencedColumnName = "id")
	)
	private List<Item> items = new ArrayList<>();

	@Transient
	public void setItems(List<Item> items) {
		clear();
		addItems(items);
	}

	@Transient
	public void addItems(List<Item> items) {
		this.items.addAll(items);
	}

	@Transient
	public void addItem(Item item) {
		items.add(item);
	}

	@Transient
	public boolean isEmpty() {
		return items.isEmpty();
	}

	@Transient
	public boolean contains(Item item) {
		return items.contains(item);
	}

	@Transient
	public boolean contains(Long id) {
		return items.stream()
				.anyMatch(item -> item.getId().equals(id));
	}

	@Transient
	public void clear() {
		for (Item item : items
		) {
			item.getShoppingCarts().remove(this);
		}
		items.clear();
	}

	@Transient
	public void removeItem(Item item) {
		items.remove(item);
	}

	@Transient
	public Optional<Item> getItem(Long itemId) {
		return items.stream()
				.filter(itemDTO -> itemDTO.getId().equals(itemId))
				.findAny();
	}
}

