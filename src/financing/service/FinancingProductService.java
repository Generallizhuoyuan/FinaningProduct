package financing.service;

import java.util.List;

import financing.entity.FinancingProduct;

public interface FinancingProductService {
	List<FinancingProduct> getSomeFinancingProduct(String str);
	FinancingProduct getOneFinancingProduct(String id);
	int insertOneFinancingProduct(FinancingProduct fp);
}
