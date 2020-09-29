
$(function() {
	// 读取添加数据
	var p_id=sessionStorage.id;
	// 读取数据，添加属性
	$.getJSON("json/products.json", function(data) {
		// 寻找匹配数据给页面赋值
		$.each(data, function(i, pro) {
			if(pro.id==p_id){
				$(".h-name").text(pro.name);
				$("#sp").text(pro.sp);
				$("#msgp").text(pro.msg);
				$("#price").text(pro.price);
				$("#outBox img").attr("src",pro.img);
			}
		})
		$("#json3").html(show1);
	})

	
	// 放大镜
	var sdBoxW = $('.moveBox').css('width');
	sdBoxW = parseInt(sdBoxW); //移动层的宽度
	var magBoxW = $('.magBox').css('width');
	magBoxW = parseInt(magBoxW); //图片放大层的宽度
	var normalBoxW = $('.normalBox').css('width');
	normalBoxW = parseInt(normalBoxW); //事件绑定层的宽度
	var num = 0; //存放下标
	//找出放大图片的比例(核心)
	var scale = magBoxW / sdBoxW;
	//移入normalBox盒子
	$('.normalBox').hover(function() {
		$('.moveBox').css('display', 'block');
		$('.magBox').css('display', 'block');
	}, function() {
		$('.moveBox').css('display', 'none');
		$('.magBox').css('display', 'none');
	});
	//3、移入leftBox层
	$('.leftBox').mouseover(function() {
		//给放大的图片和图片层设置宽度；
		$('.magBox ul li img').css('width', scale * normalBoxW + 'px');
		$('.magBox ul li').css({
			'width': scale * normalBoxW + 'px',
			'height': scale * normalBoxW + 'px'
		})
	});
	var n = 1;
	//1、移入缩小图关联
	$('.botBox ul li').attr('index', function(i, e) {
		return i;
	});
	$('.botBox ul li').mouseover(function() {
		if ($(this).attr('class') == 'bord') {
			return; //跳过第一个
		} else {
			$(this).attr('class', 'bord').siblings().removeAttr('class');
			var index = $(this).attr('index');
			//联动normal和magBox中的图片
			$('.normalBox .w').eq(index).attr('id', 'n').siblings().removeAttr('id');
			$('.magBox ul li').eq(index).attr('class', 'm').siblings().removeAttr('class');
			num = index;
		}
	});
	//2、鼠标在移动层移动
	$('.normalBox').mousemove(function(e) {
		var offset = $(this).offset();
		var X = e.pageX - offset.left - $('.moveBox').width() / 2;
		var Y = e.pageY - offset.top - $('.moveBox').height() / 2;
		if (X <= 0) {
			X = 0;
		} else if (X > $(this).width() - $('.moveBox').width()) {
			X = $(this).width() - $('.moveBox').width();
		}
		if (Y <= 0) {
			Y = 0;
		} else if (Y > $(this).height() - $('.moveBox').height()) {
			Y = $(this).height() - $('.moveBox').height();
		}
		$('.moveBox').css('left', X + 'px');
		$('.moveBox').css('top', Y + 'px');
		$('.magBox ul li').eq(num).css('left', -X * scale + 'px');
		$('.magBox ul li').eq(num).css('top', -Y * scale + 'px');
	});
	

})
// 切换颜色
$(".col").click(function(){
	//被单击的添加样式，其他移除样式
	$(this).addClass("becho").siblings().removeClass("becho");
})
// 切换版本
$(".ver").click(function(){
	//被单击的添加样式，其他移除样式
	$(this).addClass("becho").siblings().removeClass("becho");
})