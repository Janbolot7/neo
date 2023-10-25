package Janbolot.neobis.week2.pojo;

import java.util.List;

public class Orders {
    private Long orderId;
    private List<Product> product;
    private int totalAmount;

    public Orders(Long orderId, List<Product> products, int totalAmount) {
        this.orderId = orderId;
        this.product = product;
        this.totalAmount = totalAmount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> products) {
        this.product = products;
        totalAmount = product.stream().mapToInt(Product::getProductPrice).sum();
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
