package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Product;
import java.util.List;

public interface ProductDAO {

    List<Product> getProductListByCategory(String categoryId);

    Product getProduct(String categoryId);

    List<Product> searchProductList(String keywords);

    List<Product> searchAutoProductList(String keywords);


}
