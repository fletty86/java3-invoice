package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) {
		if (name == null || name.isEmpty()) { //ważna jest kolejność! Java najpierw sprawdzi pierwszy warunek
			//name.contentEquals("") lub name.isEmpty()
			throw new IllegalArgumentException("Product name cannot be null.");
		}
		this.name = name;
		
		if (price == null || price.compareTo(new BigDecimal("0")) <0) {
			throw new IllegalArgumentException("Bad price");
		}
		this.price = price;
		this.taxPercent = tax;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getTaxPercent() {
		return taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		return this.price.add(this.taxPercent.multiply(this.price));
	}
}
