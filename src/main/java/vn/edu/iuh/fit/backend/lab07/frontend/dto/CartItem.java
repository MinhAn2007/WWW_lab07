package vn.edu.iuh.fit.backend.lab07.frontend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.backend.lab07.backend.entities.Product;

import java.io.Serializable;

@Setter @Getter @NoArgsConstructor
public class CartItem implements Serializable {
    private Product product;
    private int amount;

    public CartItem(Product product, int amount) {
    }
}
