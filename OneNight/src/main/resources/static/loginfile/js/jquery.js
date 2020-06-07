//登录操作
$(document).ready(function(){
if(screen.width < 780 && $(window).width() < 780)
{
	$(".content_list").hide();

}else{
	$(".content_list").show();
}
     $(window).resize(function(){	
	 $(".content_list").show();
	 });
});
//登录操作
/*var phone =/[1][3-9][0-9]{9,9}/;*/    //手机验证
var phone=new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");//邮箱验证
var validCode=true;
function cliLogin() {
	var txtUser = $.trim($("#username").val());
	var txtPwd = $("#password").val();
	
	if ($.trim(txtUser) == "") {
	
		Tip('请输入你的邮箱号');
		$("#txtUser").focus();
		return;
		
	}
	if(!phone.exec(txtUser)){
			
			Tip('邮箱输入格式不正确,请从新输入');
			$("#txtUser").focus();
		return;
		}
	
	if ($.trim(txtPwd) == "") {
		Tip('请输入密码！');
		$("#Userpwd").focus();
		return;
	}
	
	$.ajax({
		type:'post',
		url:'/doLogin/login',
		data:{loginkeys:txtUser,passwords:txtPwd},
		success:function (e) {
			Tip(e.msg);
			if(e.code==0){
				window.location.href='index.html';
			}
		},
		error:function (e) {
			Tip(e.msg);
		}
	})
}
//注册操作

function Sendpwd(sender) {
	var time=60;
	var phones = $.trim($("#phone").val());
	var phone = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");//邮箱验证
	if ($.trim(phones) == "") {
		Tip('请填写邮箱号码！');
		$("#phone").focus();
		return;
	}
	if(!phone.test(phones)){
		Tip('邮箱输入格式不正确,请从新输入');
		$("#phones").focus();
		return;
	}

		//请求后台，发送验证码
	$.ajax({
		url:"/doLogin/register",
		type:"post",
		data:{
			"registerKey":phones,
			"step":"1"
		},
		success:function (e) {
			if(e.code==0){
				Tip('验证已发送到邮箱，请注意查收');
				var code=$(sender);
				if (validCode) {
					validCode=false;
					code.addClass("msgs1").attr("disabled",true);;
					var t=setInterval(function  () {
						time--;
						code.val(time+"秒");
						if (time==0) {
							clearInterval(t);
							code.val("重新获取");
							validCode=true;
							code.removeClass("msgs1").attr("disabled",false);

						}
					},1000);
				}
			}else{
				Tip(e.msg);
			}
		},
		error:function (e) {
			Tip('邮件发送失败，请重试');
		}
	})


}

/*忘记密码*/
function forgetPwd() {
	var emails = $.trim($("#username").val());
	var email = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");//邮箱验证
	if ($.trim(emails) == "") {
		Tip('请填写邮箱号码,以便向您发送一次性登录码');
		$("#phone").focus();
		return;
	}
	if(!email.test(emails)){
		Tip('邮箱输入格式不正确,请从新输入');
		$("#phones").focus();
		return;
	}
	$.ajax({
		url:"/doLogin/forgetPwd",
		type:"post",
		data:{
			"eMailAccount":emails
		},
		success:function (e) {
			Tip(e.msg);
		}
	})
}


/*注册输入电话页面提示信息动态方法*/
function Tip(msg) {
	$(".tishi").show().html("<div class='prompt'><i class='tishi_icon'></i>"+msg+"</div>");
}
/*注册确认密码页面提示信息动态方法*/
function Tips(msg) {
	
	$(".tishis").show().html("<div class='prompt'><i class='tishi_icon'></i>"+msg+"</div>");
}
jQuery(function(){
	"use strict";
		$(".navList .navLi").hover(function(){
		$(this).addClass("active");
		/*slideDown()方法通过使用滑动效果，显示隐藏的被选元素。
		* stop() 方法停止当前正在运行的动画。
		*------这边就是先停止.navSub元素正在运行的动画，然后使用滑动效果显示。
		* -----一般开启元素动画是都要先调用stop方法停掉正在执行的动画，否则开启的动画不能立即执行
		* */
		$(this).find(".navSub").stop().slideDown();	
	},function(){
		$(this).removeClass("active");
		/*
		* slideUp()：使用滑动效果，隐藏被选元素，如果元素已显示出来的话
		* */
		$(this).find(".navSub").stop().slideUp();
		$(".navThrList").slideUp();
		$(".navFouList").slideUp();
	});
	function scro(){
			/*
			* scrollTop() 方法返回或设置匹配元素的滚动条的垂直位置
			* */
			if($(document).scrollTop()>50){$(".headerbg").addClass("active");}else{$(".headerbg").removeClass("active");}
		}
		scro();
	   //当用户滚动指定的元素时，会发生 scroll 事件
		$(window).scroll(function(){
			scro();
		});
			$(".benefits_name").hover(function(){
			$(this).addClass("hover");
			$(this).stop().animate({bottom: "0px", opacity:1 , height:"400px"}, "fast");
		},function(){
			$(this).removeClass("hover");
			$(this).stop().animate({bottom: "0px", opacity:1 , height:"400px"}, "fast") ; 			
		}
	);
		$(".Program_name ").hover(function() {
	    $(this).addClass("hover");
		$(this).find(".Program_title").stop()
		.animate({ opacity:1 , height:"100%"}, "fast")
		.css("display","block");

	}, function() {
	    $(this).removeClass("hover");  
		$(this).find(".Program_title").stop()
		.animate({ opacity: 1,height:"40px"}, "fast")
		.css("display","block");
	});
		$(".user_casestyle").hover(function(){
			$(this).addClass("hover");
			$(this).find(".hd a").css("display","block");
			//$(this).stop().animate({bottom: "0px", opacity:1 , height:""}, "fast")
		},function(){
			$(this).removeClass("hover");
			$(this).find(".hd a").css("display","none");
			//$(this).stop().animate({bottom: "0px", opacity:1 , height:""}, "fast")  			
		}
	);
	//置顶图标显示
$('#top-back').hide();
$(window).scroll(function(){
	 if($(this).scrollTop() > 350){
		$("#top-back").fadeIn();
	 }
	 else{
		$("#top-back").fadeOut();
	 }
  });
$(".bannerNimg").css("background-image", "url(" + $(".bannerNimg").find("img").attr("src") + ")");
//置顶事件
function topBack(){
  $('body,html').animate({scrollTop:0},300);
}
});

$.fn.countTo = function (options) {
	"use strict";
	options = options || {};	
	return $(this).each(function () {
		// set options for current element
		var settings = $.extend({}, $.fn.countTo.defaults, {
			from:            $(this).data('from'),
			to:              $(this).data('to'),
			speed:           $(this).data('speed'),
			refreshInterval: $(this).data('refresh-interval'),
			decimals:        $(this).data('decimals')
		}, options);
		
		// how many times to update the value, and how much to increment the value on each update
		var loops = Math.ceil(settings.speed / settings.refreshInterval),
			increment = (settings.to - settings.from) / loops;
		
		// references & variables that will change with each update
		var self = this,
			$self = $(this),
			loopCount = 0,
			value = settings.from,
			data = $self.data('countTo') || {};
		
		$self.data('countTo', data);
		
		// if an existing interval can be found, clear it first
		if (data.interval) {
			clearInterval(data.interval);
		}
		data.interval = setInterval(updateTimer, settings.refreshInterval);
		
		// initialize the element with the starting value
		render(value);
		
		function updateTimer() {
			value += increment;
			loopCount++;
			
			render(value);
			
			if (typeof(settings.onUpdate) == 'function') {
				settings.onUpdate.call(self, value);
			}
			
			if (loopCount >= loops) {
				// remove the interval
				$self.removeData('countTo');
				clearInterval(data.interval);
				value = settings.to;
				
				if (typeof(settings.onComplete) == 'function') {
					settings.onComplete.call(self, value);
				}
			}
		}
		
		function render(value) {
			var formattedValue = settings.formatter.call(self, value, settings);
			$self.html(formattedValue);
		}
	});
};

$.fn.countTo.defaults = {
	from: 0,               // the number the element should start at
	to: 0,                 // the number the element should end at
	speed: 300,           // how long it should take to count between the target numbers
	refreshInterval: 100,  // how often the element should be updated
	decimals: 0,           // the number of decimal places to show
	formatter: formatter,  // handler for formatting the value before rendering
	onUpdate: null,        // callback method for every time the element is updated
	onComplete: null       // callback method for when the element finishes updating
};

function formatter(value, settings) {
	return value.toFixed(settings.decimals);
}


