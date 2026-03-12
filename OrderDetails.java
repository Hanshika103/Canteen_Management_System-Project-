

package model;

import java.math.BigDecimal;

public class OrderDetails {
    private int orderDetailId;
    private int orderId;
    private int itemId;
    private int quantity;
    private BigDecimal subtotal;

    public OrderDetails(int orderDetailId, int orderId, int itemId, int quantity, BigDecimal subtotal) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public int getOrderDetailId() { return orderDetailId; }
    public int getOrderId() { return orderId; }
    public int getItemId() { return itemId; }
    public int getQuantity() { return quantity; }
    public BigDecimal getSubtotal() { return subtotal; }

    public void setOrderDetailId(int orderDetailId) { this.orderDetailId = orderDetailId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setItemId(int itemId) { this.itemId = itemId; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}