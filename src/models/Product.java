package models;

/**
 * Created by leonemborg on 20/11/2017.
 */
public class Product {
    //Fields and constructor
    private int productID;
    private String productNumber;
    private String eanNumber;
    private String productName;
    private double wholeSale;
    private double retailPrice;
    private boolean isActive;
    private int inStock;

    public Product(int productID, String productNumber, String eanNumber, String productName, double wholeSale, double retailPrice, boolean isActive, int inStock) {
        this.productID = productID;
        this.productNumber = productNumber;
        this.eanNumber = eanNumber;
        this.productName = productName;
        this.wholeSale = wholeSale;
        this.retailPrice = retailPrice;
        this.isActive = isActive;
        this.inStock = inStock;
    }


    //Getters and setters
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductNumber() {
        return productNumber;
    }
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getEanNumber() {
        return eanNumber;
    }
    public void setEanNumber(String eanNumber) {
        this.eanNumber = eanNumber;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getWholeSale() {
        return wholeSale;
    }
    public void setWholeSale(double wholeSale) {
        this.wholeSale = wholeSale;
    }

    public double getRetailPrice() {
        return retailPrice;
    }
    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
