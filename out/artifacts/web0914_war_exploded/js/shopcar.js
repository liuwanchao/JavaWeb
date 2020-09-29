//全选
$(".ckAll").click(function() {
	//获取全选按钮状态
	var ch = $(this).prop("checked");
	//更改其他按钮状态
	$(".chk").prop("checked", ch);
	total();
})
//商品选项更改全选按钮
$(".chk").click(function() {
	//默认商品全选
	var all = true;
	//遍历商品，有未选中的更改全选按钮状态
	$(".chk").each(function() {
		if (!$(this).prop("checked")) {
			all = false;
		}
	})
	//更改全选框
	$(".ckAll").prop("checked", all);
	total();
})
//加数量
$(".jia").click(function() {
	//获取数量
	var v = $(this).prev().val();
	v++;
	//更新数量
	$(this).prev().val(v);
	//获取价格
	var p = $(this).parent().prev().text();
	//计算小结
	$(this).parent().next().text(v * p);
	total();
})
//减数量
$(".jian").click(function() {
	//获取数量
	var v = $(this).next().val();
	v--;
	//数量不能小于1
	if (v < 1) {
		v = 1;
	}
	//更新数量
	$(this).next().val(v);
	//获取价格
	var p = $(this).parent().prev().text();
	//计算小结
	$(this).parent().next().text(v * p);
	total();
})
//判断购物车是够为空
function emp() {
	//长度为1时显示隐藏的内容
	if ($(".cartBody .row").length == 1) {
		$("#ep").removeClass("hidden");
	}
	total();
}
//删除
$(".cartBody a").click(function() {
	if (confirm("确定要删除吗")) {
		$(this).parents(".row").remove();
		emp();
	}
	total();
})
//批量删除
$(".cartFoot a").click(function() {
	if (confirm("确定要删除吗")) {
		//遍历复选框，被选中的执行删除操作
		$(".chk").each(function() {
			if ($(this).prop("checked")) {
				$(this).parents(".row").remove();
				emp();
			}
		})
	}
	total();
})
//计算总金额
function total() {
	//默认总金额为0
	var tt = 0;
	//遍历复选框
	$(".chk").each(function() {
		//选中的加入总价中
		if ($(this).prop("checked")) {
			var p = $(this).parents(".row").children(".price").text();
			tt += parseInt(p);
		}
	})
	$("#total").text(tt);
}