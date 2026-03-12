

package model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private int orderId;
    private int studentId;
    private Date orderDate;
    private BigDecimal totalAmount;
    private String orderStatus;

    public Order(int orderId, int studentId, Date orderDate, BigDecimal totalAmount, String orderStatus) {
        this.orderId = orderId;
        this.studentId = studentId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() { return orderId; }
    public int getStudentId() { return studentId; }
    public Date getOrderDate() { return orderDate; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public String getOrderStatus() { return orderStatus; }

    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
}
