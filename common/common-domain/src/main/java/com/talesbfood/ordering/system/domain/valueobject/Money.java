package com.talesbfood.ordering.system.domain.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {

	private final BigDecimal amount;

	public Money(BigDecimal amount) {
		super();
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public boolean isGreaterThanZero() {
		return this.amount != null && this.amount.compareTo(BigDecimal.ZERO) > 0;
	}
	
	public boolean isGreaterThan(Money money) {
		return this.amount != null && this.amount.compareTo(money.getAmount()) > 0;
	}
	
	
	public Money add(Money money) {
		return new Money(this.setScale( this.amount.add(money.getAmount())));
	}
	
	
	public Money subtract(Money money) {
		return new Money(this.setScale( this.amount.subtract(money.getAmount())));
	}
	
	public Money multiply(int multiplier) {
		return new Money(this.setScale( this.amount.multiply(new BigDecimal(multiplier))));
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return Objects.equals(amount, other.amount);
	}
	
	public BigDecimal setScale(BigDecimal input) {
		return  input.setScale(2,RoundingMode.HALF_EVEN);
	}
	

}
