package com.globant.bootcamp.assembler;

import java.util.Collection;

public interface Assembler<T, E> {
	E toEntity(T dto);

	T toModel(E entity);

	Collection<E> toEntityList(Collection<T> dtos);

	Collection<T> toModelList(Collection<E> entities);
}