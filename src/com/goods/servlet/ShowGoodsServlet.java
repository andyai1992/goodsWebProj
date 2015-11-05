package com.goods.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.biz.GoodsBIZ;
import com.goods.dao.GoodsDAO;
import com.goods.entity.Goods;
@WebServlet(
		name="ShowGoodsServlet",
		urlPatterns={"/showgoods.servlet"}
)
public class ShowGoodsServlet extends HttpServlet {

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

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		
		out.println("  <HEAD><TITLE>A Servlet</TITLE>");
		out.print("<script src='/goods/js/js.js'>  </script>");
		out.println("</HEAD>");
		out.println("  <BODY>");
		GoodsDAO goodsDAO = new GoodsDAO();
		GoodsBIZ goodsBIZ = new GoodsBIZ();
		goodsBIZ.setGoodsDAO(goodsDAO);
		List<Goods> goodsList = goodsBIZ.findAll();
		out.print("<table width='90%' border=1>");
		out.print("<tr><th>商品编号</th><th>商品名称</th><th>商品价格</th><th>商品数量</th><th>商品状态</th><th colspan='2'>商品操作</th></tr>");
		for (Goods goods : goodsList) {
			out.print("<tr>");
			out.print("<td>"+goods.getGoodsId()+"</td>");
			out.print("<td>"+goods.getGoodsName()+"</td>");
			out.print("<td>"+goods.getGoodsPrice()+"</td>");
			out.print("<td>"+goods.getGoodsNum()+"</td>");
			out.print("<td>"+(goods.getGoodsStatus()==1?"上架":"下架")+"</td>");
			out.print("<td>修改</td>");
			out.print("<td><a href='javascript:deleteGoods("+goods.getGoodsId()+")'>删除</a></td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		this.doGet(request, response);
	}

}
