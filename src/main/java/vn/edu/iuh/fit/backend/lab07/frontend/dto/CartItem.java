package vn.edu.iuh.fit.backend.lab07.frontend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.backend.lab07.backend.entities.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem implements Serializable {
    private Product product;
    private int amount;
    public static List<CartItem> mapToCartItemList(HashMap<Long, CartItem> cartMap) {
        List<CartItem> cartItemList = new ArrayList<>();
        for (CartItem cartItem : cartMap.values()) {
            cartItemList.add(cartItem);
        }
        return cartItemList;
    }

    public static List<Long> mapToAmountList(HashMap<Long, CartItem> cartMap) {
        List<Long> amountsList = new ArrayList<>();
        for (CartItem cartItem : cartMap.values()) {
            amountsList.add((long) cartItem.getAmount());
        }
        return amountsList;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }



}
