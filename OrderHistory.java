

package model;

import java.util.Date;

public class OrderHistory {
    private int historyId;
    private int orderId;
    private String orderStatus;
    private Date orderDate;

    public OrderHistory(int historyId, int orderId, String orderStatus, Date orderDate) {
        this.historyId = historyId;
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    public int getHistoryId() { return historyId; }
    public int getOrderId() { return orderId; }
    public String getOrderStatus() { return orderStatus; }
    public Date getOrderDate() { return orderDate; }

    public void setHistoryId(int historyId) { this.historyId = historyId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
}

