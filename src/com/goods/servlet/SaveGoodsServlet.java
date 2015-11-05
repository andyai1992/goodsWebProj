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

@WebServlet(name = "SaveGoodsServlet", urlPatterns = { "/savegoods.servlet" })
public class SaveGoodsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String goodsName = request.getParameter("goodsName");
		Double goodsPrice = Double.valueOf(request.getParameter("goodsPrice"));
		Integer goodsNum = Integer.valueOf(request.getParameter("goodsNum"));
		Integer goodsStatus = Integer.valueOf(request.getParameter("goodsStatus"));
		String goodsImg = request.getParameter("goodsImg");
		
		Goods goods = new Goods();
		goods.setGoodsImg(goodsImg);
		goods.setGoodsName(goodsName);
		goods.setGoodsNum(goodsNum);
		goods.setGoodsPrice(goodsPrice);
		goods.setGoodsStatus(goodsStatus);
		
		GoodsDAO goodsDAO = new GoodsDAO();
		GoodsBIZ goodsBIZ = new GoodsBIZ();
		goodsBIZ.setGoodsDAO(goodsDAO);
		
		boolean bool = goodsBIZ.save(goods);
		
		if(bool){
//			System.out.println(request.getRemoteAddr()+"保存成功！");
			//自动跳转到显示所有商品的Servlet
			//请求转发。
//			request.getRequestDispatcher("/showgoods.servlet").forward(request, response);
			response.sendRedirect("/goods/showgoods.servlet");
		}else{
			response.sendRedirect("/goods/index.jsp");
		}		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//这个方法只对Post提交方式
		this.doGet(request, response);
	}

}
