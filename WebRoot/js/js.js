function deleteGoods(goodsId){
	if(confirm("是否确认删除？")){
		location.href="/goods/delgoods.servlet?goodsId="+goodsId;
	}
}