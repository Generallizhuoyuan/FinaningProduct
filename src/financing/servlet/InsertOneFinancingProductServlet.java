package financing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import financing.entity.FinancingProduct;
import financing.service.FinancingProductServiceImpl;

public class InsertOneFinancingProductServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		int risk = Integer.parseInt(request.getParameter("risk"));
		String income = request.getParameter("income");
		Date saleStarting = java.sql.Date.valueOf(request.getParameter("saleStarting"));
		Date saleEnd = java.sql.Date.valueOf(request.getParameter("saleEnd"));
		Date end = java.sql.Date.valueOf(request.getParameter("end"));
		FinancingProduct fp = new FinancingProduct(id, risk, income, saleStarting, saleEnd, end);
		int result = new FinancingProductServiceImpl().insertOneFinancingProduct(fp);
		if(result > 0){
			out.print("<script>alert('保存成功!');</script>");
			out.print("<script>location.href='GetSomeFinancingProductServlet';</script>");
		}else{
			out.print("<script>alert('保存失败!');</script>");
			out.print("<script>history.back();</script>");
		}
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
