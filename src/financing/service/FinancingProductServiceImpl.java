package financing.service;

import java.util.List;

import financing.dao.impl.FinancingProductDaoMySqlImpl;
import financing.entity.FinancingProduct;

public class FinancingProductServiceImpl implements FinancingProductService {

	@Override
	public List<FinancingProduct> getSomeFinancingProduct(String str) {
		return new FinancingProductDaoMySqlImpl().getSomeFinancingProduct(str);
	}

	@Override
	public FinancingProduct getOneFinancingProduct(String id) {
		return new FinancingProductDaoMySqlImpl().getOneFinancingProduct(id);
	}

	@Override
	public int insertOneFinancingProduct(FinancingProduct fp) {
		return new FinancingProductDaoMySqlImpl().insertOneFinancingProduct(fp);
	}

}
