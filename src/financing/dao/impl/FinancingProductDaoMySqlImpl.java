package financing.dao.impl;

import java.util.*;
import java.sql.*;
import java.util.Date;
import financing.dao.BaseDao;
import financing.dao.FinancingProductDao;
import financing.entity.FinancingProduct;

public class FinancingProductDaoMySqlImpl extends BaseDao implements
		FinancingProductDao {

	@Override
	public List<FinancingProduct> getSomeFinancingProduct(String str) {
		List<FinancingProduct> list = new ArrayList<FinancingProduct>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FinancingProduct WHERE 1=1 "
					+str+" ORDER BY saleStarting DESC";
		try {
			con = getCon();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String id = rs.getString("id");
				int risk = rs.getInt("risk");
				String income = rs.getString("income");
				Date saleStarting = rs.getDate("saleStarting");
				Date saleEnd = rs.getDate("saleEnd");
				Date end = rs.getDate("end");
				FinancingProduct fp = new FinancingProduct(id, risk, income, saleStarting, saleEnd, end);
				list.add(fp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeAll(con, pstmt, rs);
		}
		return list;
	}

	@Override
	public FinancingProduct getOneFinancingProduct(String id) {
		FinancingProduct fp = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FinancingProduct WHERE id=?";
		try {
			con = getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				int risk = rs.getInt("risk");
				String income = rs.getString("income");
				Date saleStarting = rs.getDate("saleStarting");
				Date saleEnd = rs.getDate("saleEnd");
				Date end = rs.getDate("end");
				fp = new FinancingProduct(id, risk, income, saleStarting, saleEnd, end);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeAll(con, pstmt, rs);
		}
		return fp;
	}

	@Override
	public int insertOneFinancingProduct(FinancingProduct fp) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FinancingProduct VALUES (?,?,?,?,?,?)";
		try {
			con = getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fp.getId());
			pstmt.setInt(2, fp.getRisk());
			pstmt.setString(3, fp.getIncome());
			pstmt.setDate(4, (java.sql.Date)fp.getSaleStarting());
			pstmt.setDate(5, (java.sql.Date)fp.getSaleEnd());
			pstmt.setDate(6, (java.sql.Date)fp.getEnd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeAll(con, pstmt, null);
		}
		return result;
	}

}
