$(function() {
	// 添加轮播图
	$.getJSON("json/viewpager.json", function(data) {
		//i:索引
		$.each(data, function(i, pic) {
			/*1,创建div元素节点,并定义一个newDiv对象*/
			var newDiv = document.createElement("div");
			/*2,将newDiv对象，添加到content中*/
			document.getElementById("content").appendChild(newDiv);
			/*3,为每次创建的div对象加Id*/
			newDiv.id = "content" + i;
			/*创建img节点元素并添加*/
			/*1，创建img节点元素*/
			var newImg = document.createElement("img");
			/*2,将刚创建的img对象,添加到上面刚创建的子div中*/
			document.getElementById("content" + i).appendChild(newImg);
			newImg.src = pic.img;
			if (i == 1) {
				document.getElementById("content" + i).hidden = false;
			} else {
				document.getElementById("content" + i).hidden = true;
			}
		})
	})
	
	// 添加轮播图上层右侧商品
	$.getJSON("json/products.json", function(data) {
		var show1="";
		//i:索引
		$.each(data, function(i, pro) {
			show1=show1+"<div class='pite col-sm-3'><div><a href='productdetails.html' data-id='"+pro.id
						+"'><img src='"+pro.img+"'><h3>"+pro.name+"</h3><p class='prc'>"+pro.price
						+"</p></a></div></div>"
		})
		$("#json2").html(show1);
	})
	// 添加商品展示右侧商品
	$.getJSON("json/products.json", function(data) {
		var show1="";
		//i:索引
		$.each(data, function(i, pro) {
			show1=show1+"<div class='pite col-sm-3' style='height: 320px;'><div><a href='productdetails.html' data-id='"+pro.id
						+"'><img src='"+pro.img+"'><h3>"+pro.name+"</h3><p class='prc'>"+pro.price
						+"</p></a></div></div>"
		})
		$("#json3").html(show1);
	})
	
	
	//点击事件显示右侧商品列表
	$(".type").mouseover(function(){
		$("#chtype").show();
	})
	$(".type").mouseout(function(){
		$("#chtype").css("display","none")
	})
	//向商品详情页传输数据
	$(document).on("click","#json2 a",function(){
		sessionStorage.id=$(this).attr("data-id");
		location.href="producdetails.html";
	})
	$(document).on("click","#json3 a",function(){
		sessionStorage.id=$(this).attr("data-id");
		location.href="producdetails.html";
	})
	// 获取登录的用户名
	var uname=sessionStorage.uname;
	$("#uname").text(uname);
		
})
// 轮播图循环
function imgNext() {
	for (var i = 1; i <= 3; i++) {
		if (document.getElementById("content" + i).hidden == false && i != 3) {
			document.getElementById("content" + i).hidden = true;
			document.getElementById("content" + (i + 1)).hidden = false;
			break;
		} else {
			if (document.getElementById("content" + i).hidden == false && i == 3) {
				document.getElementById("content" + i).hidden = true;
				document.getElementById("content" + 1).hidden = false;
				break;
			}
		}
	}
}
// 定时执行，切换轮播图
setInterval("imgNext();", 3000);
