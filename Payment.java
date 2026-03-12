

package model;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
    private int paymentId;
    private int orderId;
    private String paymentMethod;
    private Date paymentDate;
    private BigDecimal amount;
    private String paymentStatus;

    public Payment(int paymentId, int orderId, String paymentMethod, Date paymentDate, BigDecimal amount, String paymentStatus) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentId() { return paymentId; }
    public int getOrderId() { return orderId; }
    public String getPaymentMethod() { return paymentMethod; }
    public Date getPaymentDate() { return paymentDate; }
    public BigDecimal getAmount() { return amount; }
    public String getPaymentStatus() { return paymentStatus; }

    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}