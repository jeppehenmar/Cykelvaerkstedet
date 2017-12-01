package logic;

import logic.interfaces.ProductLogicInterface;
import models.Product;

import java.util.List;

/**
 * Created by leonemborg on 20/11/2017.
 */
public class ProductLogic implements ProductLogicInterface {

    @Override
    public List fillProductList(List productList){
        Product tire = new Product(1, "tire12-28", "123456789012", "28\" Chaoyang Dæk", 125.56, 300.00, true, 12);
        Product tube = new Product(2, "tube25-32", "123456789013", "25-32 Chaoyang Slange", 15.00, 75.00, true, 20);
        Product bars = new Product(3, "nittoflat-78", "123456789014", "27cm Nitto Flatbar", 88.25, 199.00, true, 2);
        Product frame = new Product(4, "vigorelli", "123456789015", "Cinelli Vigorelli 57cm", 3200.00, 4999.00, true, 1);
        Product hub = new Product(5, "philwood32-bk", "123456789016", "Phil Wood 32 hul sort", 650.00, 949.00, true, 4);

        productList.add(tire);
        productList.add(tube);
        productList.add(bars);
        productList.add(frame);
        productList.add(hub);
        return productList;
    }

    @Override
    public void deleteProduct(Product product, List productList) {
        productList.remove(product);
    }
}
