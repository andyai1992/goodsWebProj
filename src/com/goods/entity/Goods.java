package com.goods.entity;

public class Goods {
	private int goodsId;
	private String goodsName;
	private double goodsPrice;
	private int goodsStatus;
	private String goodsImg;
	private int goodsNum;
	public Goods() {
		// TODO Auto-generated constructor stub
	}
	public Goods(int goodsId, String goodsName, double goodsPrice,
			int goodsStatus, String goodsImg, int goodsNum) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsStatus = goodsStatus;
		this.goodsImg = goodsImg;
		this.goodsNum = goodsNum;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(int goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	
	
}
