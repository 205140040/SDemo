//jsDemo
//js中的字符转义
var name = "张三\"三";
// alert("name："+name);
// 布尔值
var happy = false;
// alert("isHappy:"+happy);
// 浮点数
var num = 3.1415926;
// alert("数字："+num);
// 数组
var nameArray = Array(4);
nameArray[0] = "张三";
nameArray[1] = "李四";
nameArray[2] = "王五";
nameArray[3] = "赵六";
// alert("array[0]:"+nameArray[0]);
// alert("array[1]:"+nameArray[1]);
// alert("array[2]:"+nameArray[2]);
// alert("array[3]:"+nameArray[3]);
// 声明数组的时候并赋值
var array2 = Array("a", "b", "c", "d");
// alert("array2[0]:"+array2[0]);
// alert("array2[1]:"+array2[1]);
// alert("array2[2]:"+array2[2]);
// alert("array2[3]:"+array2[3]);
// 关联数组,用字符串名称代替数组下标
var nameIndexArray = Array();
nameIndexArray["name"] = "张三三";
nameIndexArray["sex"] = "女";
nameIndexArray["age"] = 18;
// alert("名称:" + nameIndexArray["name"]);
// alert("性别:" + nameIndexArray["sex"]);
// alert("年龄:" + nameIndexArray["age"]);
// 条件语句
if (1 < 2) {
	// alert("1<2");
}
// 循环
// var n = 0;
// while (n <= 3) {
// alert("nameArray[" + n + "]" + nameArray[n]);
// n++;
// }
// do while
// var doN=2;
// do{
// alert("dowhile："+doN);
// doN++;
// }while(doN<3);
// for循环
for (var ni = 0; ni < nameArray.length; ni++) {
	// alert("for循环nameArray:"+nameArray[ni]);
}
// 函数
function myAdd(n1, n2) {
	return n1 + n2;
}

// alert(1+"+"+2+"="+myAdd(1,2));
// 全局变量和局部变量
var allN = "我是全局变量";
function alertVar() {
	var jbN = "我是局部变量";
	// alert("局部变量:"+jbN);
	// alert("全局变量："+allN);
}
alertVar();
// 对象
function Person(name, sex, age) {
	this.name = name;
	this.sex = sex;
	this.age = age;
	this.showInfo = showInfo;// 对象方法
	return this;
}

function showInfo() {
	console.log(this);
	alert(JSON.stringify(this));
	// alert("对象姓名:" + this.name);
	// alert("对象性别:" + this.sex);
	// alert("对象年龄:" + this.age);
}

var p1 = new Person("张三三", "女", 18);
// p1.showInfo();
var p2 = new Person("李思思", "女", 18);
// p2.showInfo();
// getElementById();
// alert(typeof document.getElementById("p1"));
// getAttribute();
var p1 = document.getElementById("p1");
// alert(p1.getAttribute("title"));
// setAttribute
p1.setAttribute("title", "setAttribute");

// typeof检测数据类型,boolean,string,number,null,undefined,funciton,对象
var s1 = "我是小明";
var n1 = 3.1415;
var f1 = true;

// alert("s1的类型:" + typeof s1);
// alert("n1的类型:" + typeof n1);
// alert("f1的类型:" + typeof f1);
// alert("Person的类型:" + typeof p1);
// alert("showInfo的类型:" + typeof showInfo);
// 未定义或未经初始化的值是undefined
// alert("b的类型:" + typeof b);
// null声明一个变量可以设置为null
var nu1 = null;
// alert(nu1);
// 数值转换函数
// alert("Number()"+Number("11.2396"));
// alert("parseInt()"+parseInt("11.2396aaa"));
// alert("parseFloat()"+parseFloat("11.2396bb"));
// string类型，string不可变，每次都是销毁之前的，新建一个string
// toString()方法
var ns1 = 1.269;
var fs1 = true;
var ss1 = "哈哈哈";
// alert(typeof ns1.toString());
// alert(fs1.toString());
// alert(ss1.toString());
// String()方法
// alert(typeof String(ns1));
// alert(String(fs1));
// alert(String(ss1));

// 语句for in
for ( var propName in window) {
	// alert(propName);
}
// break，continue
for (var i = 0; i < 10; i++) {
	if (i == 5) {
		break;
	}
	// alert(i);
}
for (var i = 0; i < 10; i++) {
	if (i == 5) {
		continue;
	}
	// alert(i);
}
// switch
var sname = "张三";
switch (sname) {
case "张三":
	// alert("张三")
	break;
case "李四":
	// alert("李四")
	break;
default:
	// alert("王五");
}
// 函数，参数是一个数组，无论传递多少都不会影响
// 可以用arguments调用参数
function myFun1(name, sex, age) {
	// alert("参数个数:"+arguments.length);
	for (var i = 0; i < arguments.length; i++) {
		// alert(arguments[i]);
	}
}
// myFun1('张三', "男");
/*
 * //闭包 function bbFun(name,sex){ var age=10; sayHello=function(){
 * alert(name+"hello"); } } var bbF1=new bbFun(); alert(bbF1.sayHello()());
 */

// instanceof校验是否是某个对象
// alert("instanceof:"+(Person instanceof Object));
var array1 = new Array();
array1[0] = "张三三";
array1[1] = "酱紫";
array1[2] = "王五";

// 校验是否为数组
// alert("isArray:"+(array1 instanceof Array));
// 数组tostring(),join()方法
// alert(array1.toString());
// join（）
// alert(array1.join("&"));
// 数组的栈方法
var stackArr = new Array();
stackArr[0] = "one";
// push()方法，添加多个对象到数组中，并返回添加后的数组长度
var alength = stackArr.push("two", "three");
for (var i = 0; i < stackArr.length; i++) {
	// alert(stackArr[i]);
}
// pop方法，移除数组中最后一个，并返回移除的对象
// alert("移除的对象："+stackArr.pop());
// alert("移除后:");
for (var i = 0; i < stackArr.length; i++) {
	// alert(stackArr[i]);
}
// shift()从数组0开始移除,先进先出
// alert("移除的对象："+stackArr.shift());
// alert("移除后:");
for (var i = 0; i < stackArr.length; i++) {
	// alert(stackArr[i]);
}
// reverse和sort排序
var ns = new Array();
ns.push(1, 2, 3, 6, 4, 10);
ns.reverse();
// alert("通过reverse反转后："+ns.toString());
function compare(val1, val2) {
	if (val1 > val2) {
		return 1;
	} else if (val1 < val2) {
		return -1;
	} else {
		return 0;
	}
}
ns.sort(compare);
// alert("通过sort排序后："+ns.toString());
// splice方法，对数组进行删除，插入，替换
// 删除
ns.splice(1, 1);
// alert("使用splice删除后："+ns.toString());
// 添加
ns.splice(2, 0, 888, 666);
// alert("使用splice添加后："+ns.toString());
// 替换
ns.splice(2, 1, 999);
// alert("使用splice替换后："+ns.toString());
// 位置方法，indexof，lastindexof
// alert("ns中10的位置:"+ns.indexOf(10)+" ns的length:"+ns.length);
// filter方法
var filterRes = ns.filter(function(item, index, array) {
	return (item > 6);
});
// alert(filterRes);
// alert("forEach方法：");
// forEach方法
ns.forEach(function(item, index, array) {
	// alert("下标"+index+":"+item);
});

// Date类型
// 新建一个日期
var date1 = new Date();
// alert("date1："+date1);
var startDate = Date.now();
// alert("函数运行开始时间："+startDate);
var nrry = new Array();
nrry.push(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
nrry.forEach(function(item, index, array) {
	// alert("nrry["+index+"]:"+item);
});
var endDate = Date.now();
// alert("函数运行结束时间时间："+endDate);
// getTime返回long类型的时间
// alert(date1.getTime());
// 获取年月日，时分秒
var date2 = new Date();
date2.setFullYear(2016);
date2.setMonth(9);
date2.setDate(15);
date2.setHours(10);
date2.setMinutes(10);
date2.setSeconds(10);
var year = date2.getFullYear();
var month = date2.getMonth();
var day = date2.getDate();
var hour = date2.getHours();
var minutes = date2.getMinutes();
var seconds = date2.getSeconds();
var dstr = year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":"
		+ seconds;
// alert(dstr);

// 正则表达式类型

// 函数
function call1(name, callback1, cb2) {
	alert("name:" + name);
	if (typeof callback1 == "function") {
		// 运行回调函数
		callback1();
	}
	if (typeof cb2 == "function") {
		cb2();
	}
}

function callback1() {
	// alert("回调函数1");
}

// var callback1=1;

// call1("张三",callback1);
// 函数中的arguments和length
// alert("call1函数参数的个数:"+call1.length);
// alert("callback1函数参数的个数:"+callback1.length);

// 5.6基本包装类型
// string方法
var str1 = "你好啊，我是mngmengda露露";
for (var i = 0; i < str1.length; i++) {
	// alert("charAt:"+str1.charAt(i));
}
// substring
// alert("substring:"+str1.substring(4,str1.length));
// indexof和lastindexof查找字符串的位置
// alert("indexOf:"+str1.charAt(str1.indexOf("露")));
// trim方法，删除空格
var str2 = "     哈哈哈";
// alert("trim:"+str2.trim());
// 大小写转换,toLowerCase,toUpperCase
var str3 = "abcdefg";
// alert("转换为大写:"+str3.toUpperCase());
// alert("转换为小写:"+str3.toLowerCase());
// repalce
// alert("repalce:"+str3.replace("a","ha"));
// split
var str4 = "你好啊,我是,提莫队长,哈哈哈哈";
var str4Arr = str4.split(",");
str4Arr.forEach(function(item, index, arr) {
	// alert(item);
});
// 5.7单体内置对象,如：parseInt,parseFloat,encodeURI
var url = "http://www.smm.com/logi n/haha";
var eu = encodeURI(url);
// alert("encodeUri:"+eu);
// alert("decodeURI:"+decodeURI(eu));
// math对象
var max = Math.max(5, 1, 6, 99, 158, 33);
// alert("math.max():"+max);
var min = Math.min(5, 1, 6, 99, 158, 33);
// alert("math.min():"+min);
// 四舍五入
// alert("round(3位小数):"+Math.round(3.131415926,3));
// 随机数
// alert("随机数:" + Math.random());

/**
 * 6.面向对象
 */
// 原始的创建对象的方法
var person1 = new Object();
person1.name = "哈哈哈";
person1.sex = "女哈哈哈";
person1.age = 18;
person1.sayInfo = function() {
	alert("姓名:" + this.name + "  性别:" + this.sex + "  年龄：" + this.age);
}
// person1.sayInfo();
// 对象字面量语法创建对象
var perobj = {
	name : "啦啦啦",
	sex : "男女女",
	age : 19,
	sayInfo : function() {
		alert("姓名:" + this.name + "  性别:" + this.sex + "  年龄：" + this.age);
	}
}
// perobj.sayInfo();

// 工厂模式，创建对象
function Stu(name, sex, age) {
	this.name = name;
	this.sex = sex;
	this.age = age;
	this.showInfo = function() {
		alert("name:" + this.name + " sex:" + this.sex + " age:" + this.age);
	}
}
var stu1 = new Stu("露露啊", "nn", 18);
// stu1.showInfo();

// 原型对象prototype:原型可以供多个实例共享
function StuPro() {
	this.showInfo = function() {
		alert("name:" + this.name + " sex:" + this.sex + " age:" + this.age
				+ " phone:" + this.phone + " email:" + this.email);
	}
}
var stp = new StuPro();
StuPro.prototype.name = "protypeName";
StuPro.prototype.sex = "美女";
StuPro.prototype.age = "18";
// stp.showInfo();
// 搜索对象的值，先从对象中搜索，没有则从 ：原型中搜索，对象中的属性和原型中的一样，则为对象中的属性为值
// alert("prototype:"+Stu.isPrototypeOf(stp.name));
// alert("prototype:"+Object.getPrototypeOf(stp));
// 判断属性是原型属性，还是本身的属性
// alert("hasOwnProperty:"+stp.hasOwnProperty("name"));
// in 判断对象是否含有该属性
// alert("有属性:in:" + ("name" in stp));

var nArr = new Array();
nArr.push("name", "sex", "age");
// for in 显示对象中的可枚举的属性
for (prop in stp) {
	// alert("for in:" + prop);
}
// 通过object.keys获取对象中的属性(不包含原型属性)
// alert(Object.keys(stp));
// 通过object.getOwnPropertyNames获取对象中的属性(包含原型属性)
// alert("getPropertyNames:"+Object.getPropertyNames(stp));

// 原型字面量
StuPro.prototype = {
	phone : "666688",
	email : "555@qq.com"
};
var stp2 = new StuPro();
// stp2.showInfo();

// 组合使用构造函数模式和原型模式
function ConsAndPro(name, sex, age) {
	this.name = name;
	this.sex = sex;
	this.age = age;
	this.showInfo = function() {
		alert(this.name + "-" + this.sex + "-" + this.age + "-国家："
				+ this.country + "-民族" + this.nation);
	}
	return this;
}

ConsAndPro.prototype = {
	country : "中国",
	nation : "汉族"
};
var cap1 = new ConsAndPro("露露", "哈哈", 19);
// cap1.showInfo();

// 通过原型链实现继承
function SuperType(name, sex, age) {
	this.name = "哇哈哈哈";
	// this.sex = sex;
	// this.age = age;
	this.showInfo = function() {
		alert(this.name + ":" + this.sex + ":" + this.age + "c:" + this.bir
				+ "c:" + this.ah);
	}
}

function SubType(name, sex, age, bir, ah) {
	// this.prototype = new SuperType(name, sex, age);
	// 继承了父对象
	// SuperType.call(this);
}
SubType.prototype = new SuperType();

var sub1 = new SubType("父名称", "富性别", "父年龄", "子生日", "子爱好");
// sub1.showInfo();
/**
 * 借用构造函数进行继承
 */
function SuperPerson(name, sex, age) {
	this.name = name;
	this.sex = sex;
	this.age = age;
	this.showInfo = function() {
		alert(this.name + ":" + this.sex + ":" + this.age + "学号:" + this.sno
				+ "班级:" + this.scla);
	}
	return this;
}

/**
 * 子类
 */
function SubStudent(name, sex, age, sno, scla) {
	SuperPerson.call(this, name, sex, age, sno, scla);
	this.sno = sno;
	this.scla = scla;
}
var substu1 = new SubStudent("酱紫", "呢你呢", 18, "no123", "1班");
// substu1.showInfo();

/**
 * 闭包
 */
function bb(name, sex, age) {
	var age1 = age + 1;
	var ra = function() {
		return age1;
	}
	return ra();
}

// alert(bb('a','b',17));

/**
 * window
 */
// window.open
// window.open("","aa","height=50","width:200");
// 定时函数，取消定时
var timeId = window.setTimeout(function() {
	alert("定时函数执行");
}, 1000);

// alert(timeId);
clearTimeout(timeId);

/**
 * 系统对话框
 */
// alert警告框
// alert("这是一个警告框");
// confirm 确认框
// if (confirm("确认吗?")) {
// alert("选择了确认");
// } else {
// alert("取消了");
// }
// prompt
// var res=prompt("请输入姓名：","张三");
// alert("你输入了："+res);
/**
 * location对象
 */
// location.href重定向
// window.location.href="/bbb.jsp";
// replace跳转，禁用页面后退的功能
// window.location.replace("/bbb.jsp");
// reload 重新加载
// window.location.reload(true);
/**
 * navigator对象
 */
// 检测插件
for (var i = 0; i < navigator.plugins.length; i++) {
	var item = navigator.plugins[i];
	// alert(item.name);
}
// history
// 后退两页
// alert("后退两页")
// window.history.go(-2);
// 前进3页
// alert("前进两页")

// window.history.go(2);
// 后退一页
// window.history.back();
// 前进一页
// window.history.forward();

// 通过dataset获取自定义属性
var dp = document.getElementById("p1");
// alert("自定义属性名称："+dp.dataset.name);

/**
 * 事件
 */
// 添加事件，移除事件
// addEventListener,removeEventListener
// 事件名称，事件函数，在捕获阶段执行：true，冒泡阶段执行：false
var btn1 = document.getElementById("btn1");
btn1.addEventListener("click", function() {
	alert(this.value);
}, false);

function bc2() {
	alert("添加的第二个事件:" + this.value);

}

// 添加多个事件
btn1.addEventListener("click", bc2, false);
// 移除事件,匿名函数无法移除
setTimeout(rEvent, 2000);
function rEvent() {
	btn1.removeEventListener("click", bc2, false);
}

// 事件对象
function bc3(event) {
	alert(JSON.stringify(event));
	console.log(event);
	// 事件的目标
	alert("事件的目标:" + event.target)
	alert("事件的类型:" + event.type);
}
btn1.addEventListener("click", bc3, false);

// 阻止事件的默认行为
var href1 = document.getElementById("href1");
href1.addEventListener("click", function() {
	// 阻止连接默认的跳转
	event.preventDefault();
}, false);

document.getElementById("form1").onclick = function() {
	// alert("form click");
}

// 取消冒泡
document.getElementById("fdiv1").onclick = function() {
	// alert("fdiv1 click");
	// event.stopPropagation();
}
// 事件类型

// ui事件
// load事件
document.getElementById("bd1").onload = function() {
	// alert("body on load");
	// alert(event.type);
}

document.getElementById("img1").onload = function() {
	// alert("image on load");
	// alert(event.type);
}

// unload
document.getElementById("bd1").onunload = function() {
	// alert("body unun load");
	// alert(event.type);
}

// resize
// document.getElementById("bd1").onresize=function(){
// alert("body resize");
// alert(event.type);
// }

// 焦点事件
// blur,focus

// 鼠标与滚轮事件
// document.getElementById("bd1").onmousewheel=function(){
// alert("body onmousewheel");
// alert(event.type);
// }

// 键盘与文本事件
// document.getElementById("ki1").onkeydown=function(){
// alert(" keydown");
// alert("类型"+event.type);
// alert("键码："+event.keyCode);
// }

// beforeunload
document.getElementById("bd1").onbeforeunload = function() {
	var res = "leave?";
	event.returnValue = res;
	return res;
}

// 15章使用canvas绘图
function drawImg() {
	var dra = document.getElementById("can1");
	var context = dr1.getContext("2d");

}

function tryError() {
	// 错误处理
	try {
		alert(a);
	} catch (error) {
		console.log(error);
		alert(error);
	} finally {
		alert("finally");
	}
}
//tryError();
//错误调试

//web存储机制
sessionStorage.setItem("name","张三");
	
//alert(sessionStorage.getItem("name"));

//h5 api
//file api
//file reader
document.getElementById("f1").addEventListener("change",function(event){
	console.log(event);
	var f=event.target.files;
	console.log(event.target.files);
	var freader=new FileReader();
	freader.readAsDataURL(f[0]);
	console.log(freader);

	var res=freader.result;
	var iurl=window.webkitURL.createObjectURL(f[0]);
	console.log(iurl);
	document.getElementById("fi1").src=iurl;
});
