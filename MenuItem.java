

package model;

import java.math.BigDecimal;

public class MenuItem {
    private int itemId;
    private String itemName;
    private BigDecimal price;
    private String category;
    private String availabilityStatus;

    public MenuItem(int itemId, String itemName, BigDecimal price, String category, String availabilityStatus) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.availabilityStatus = availabilityStatus;
    }

    public int getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public BigDecimal getPrice() { return price; }
    public String getCategory() { return category; }
    public String getAvailabilityStatus() { return availabilityStatus; }

    public void setItemId(int itemId) { this.itemId = itemId; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setCategory(String category) { this.category = category; }
    public void setAvailabilityStatus(String availabilityStatus) { this.availabilityStatus = availabilityStatus; }
}