package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products = new ArrayList<>();

	public void addProduct(Product product) {
		products.add(product);
	}

	public void addProduct(Product product, Integer quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity of products can't be less or equal to 0.");
		}
		for (int i=0; i<quantity; i++) {
			products.add(product);
		}
	}

	public BigDecimal getNetPrice() {
		BigDecimal sum = BigDecimal.ZERO;
		for (Product product: products) {
			sum = sum.add(product.getPrice());
		}
		return sum;
	}

	public BigDecimal getTax() {
		BigDecimal sumTax = BigDecimal.ZERO;
		for (Product product : products) {
			sumTax = sumTax.add(product.getTaxValue());
		}
		return sumTax;
	}
	

	public BigDecimal getGrossPrice() {
        BigDecimal sumTotal = BigDecimal.ZERO;
        for (Product product : products) {
            sumTotal = sumTotal.add(product.getPriceWithTax());
        }
        return sumTotal;
    }
}
