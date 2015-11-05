package com.goods.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goods.entity.Goods;
import com.goods.util.DBUtil;

public class GoodsDAO {
	public void save(Goods goods) throws SQLException {
		String sql = "insert into goods(goodsid,goodsname,GOODSPRICE,GOODSSTATUS,GOODSIMG,GOODSNUM) "
				+ "values(seqgoods.nextval,?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, goods.getGoodsName());
		pst.setDouble(2, goods.getGoodsPrice());
		pst.setString(3, goods.getGoodsStatus() + "");
		pst.setString(4, goods.getGoodsImg());
		pst.setInt(5, goods.getGoodsNum());
		pst.executeUpdate();
	}
	public List<Goods> findAll() throws SQLException{
		String sql ="select * from goods order by goodsid desc";
		List<Goods> goodsList = new ArrayList<Goods>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			Goods goods = new Goods();
			goods.setGoodsId(rs.getInt(1));
			goods.setGoodsName(rs.getString(2));
			goods.setGoodsPrice(rs.getDouble(3));
			goods.setGoodsStatus(rs.getInt(4));
			goods.setGoodsImg(rs.getString(5));
			goods.setGoodsNum(rs.getInt(6));
			goodsList.add(goods);
		}
		return goodsList;
	}
}
