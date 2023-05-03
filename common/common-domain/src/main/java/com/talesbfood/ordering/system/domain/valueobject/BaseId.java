package com.talesbfood.ordering.system.domain.valueobject;

public abstract class BaseId<T> {

	private final T value;

	protected BaseId(T value) {
		super();
		this.value = value;
	}
	
	
	
}
