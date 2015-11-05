package com.goods.biz;

import java.sql.SQLException;
import java.util.List;

import com.goods.dao.GoodsDAO;
import com.goods.entity.Goods;
import com.goods.util.DBUtil;

public class GoodsBIZ {
	private GoodsDAO goodsDAO;

	public GoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	public boolean save(Goods goods) {
		try {
			DBUtil.getConnection().setAutoCommit(false);
			this.goodsDAO.save(goods);
			DBUtil.getConnection().commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				DBUtil.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {
			DBUtil.closeConnection();
		}
	}

	public List<Goods> findAll() {
		try {
			return this.goodsDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeConnection();
		}
	}
}
