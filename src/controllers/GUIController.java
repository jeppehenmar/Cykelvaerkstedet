package controllers;

import logic.ProductLogic;
import logic.interfaces.ProductLogicInterface;
import models.Constants;
import models.Product;

import java.util.List;

/**
 * Created by jeppe on 20-11-2017.
 */
public class GUIController {
    ProductLogicInterface productLogic = new ProductLogic();

    public List getProductList() {
        return productLogic.fillProductList(Constants.getProductList());
    }

    public void deleteProduct(Product product) {
        productLogic.deleteProduct(product, Constants.getProductList());
    }
}
