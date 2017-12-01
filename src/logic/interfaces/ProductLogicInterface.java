package logic.interfaces;

import models.Product;

import java.util.List;

/**
 * Created by leonemborg on 20/11/2017.
 */
public interface ProductLogicInterface {
    List fillProductList(List productList);

    void deleteProduct(Product product, List productList);
}
