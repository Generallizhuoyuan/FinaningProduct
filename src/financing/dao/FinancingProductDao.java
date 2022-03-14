package financing.dao;
import java.util.*;
import financing.entity.*;
public interface FinancingProductDao {
	List<FinancingProduct> getSomeFinancingProduct(String str);
	FinancingProduct getOneFinancingProduct(String id);
	int insertOneFinancingProduct(FinancingProduct fp);
}
