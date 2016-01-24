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
function myFun1(name,sex,age){
// alert("参数个数:"+arguments.length);
	for(var i=0;i<arguments.length;i++){
// alert(arguments[i]);
	}
}
myFun1('张三',"男");
/*
 * //闭包 function bbFun(name,sex){ var age=10; sayHello=function(){
 * alert(name+"hello"); } } var bbF1=new bbFun(); alert(bbF1.sayHello()());
 */

// instanceof校验是否是某个对象
// alert("instanceof:"+(Person instanceof Object));
var array1=new Array();
array1[0]="张三三";
array1[1]="酱紫";
array1[2]="王五";

// 校验是否为数组
// alert("isArray:"+(array1 instanceof Array));
// 数组tostring(),join()方法
// alert(array1.toString());
// join（）
// alert(array1.join("&"));
// 数组的栈方法
var stackArr=new Array();
stackArr[0]="one";
// push()方法，添加多个对象到数组中，并返回添加后的数组长度
var alength=stackArr.push("two","three");
for(var i=0;i<stackArr.length;i++){
// alert(stackArr[i]);
}
// pop方法，移除数组中最后一个，并返回移除的对象
// alert("移除的对象："+stackArr.pop());
// alert("移除后:");
for(var i=0;i<stackArr.length;i++){
// alert(stackArr[i]);
}
// shift()从数组0开始移除,先进先出
// alert("移除的对象："+stackArr.shift());
// alert("移除后:");
for(var i=0;i<stackArr.length;i++){
// alert(stackArr[i]);
}
// reverse和sort排序
var ns=new Array();
ns.push(1,2,3,6,4,10);
ns.reverse();
// alert("通过reverse反转后："+ns.toString());
function compare(val1,val2){
	if(val1>val2){
		return 1;
	}else if(val1<val2){
		return -1;
	}else{
		return 0;
	}
}
ns.sort(compare);
// alert("通过sort排序后："+ns.toString());
// splice方法，对数组进行删除，插入，替换
// 删除
ns.splice(1,1);
// alert("使用splice删除后："+ns.toString());
// 添加
ns.splice(2,0,888,666);
// alert("使用splice添加后："+ns.toString());
// 替换
ns.splice(2,1,999);
// alert("使用splice替换后："+ns.toString());
// 位置方法，indexof，lastindexof
//alert("ns中10的位置:"+ns.indexOf(10)+"  ns的length:"+ns.length);
// filter方法
var filterRes=ns.filter(function(item,index,array){
	return (item>6);
});
//alert(filterRes);
//alert("forEach方法：");
//forEach方法
ns.forEach(function(item,index,array){
//	alert("下标"+index+":"+item);
});

//Date类型
//新建一个日期
var date1=new Date();
//alert("date1："+date1);
var startDate=Date.now();
//alert("函数运行开始时间："+startDate);
var nrry=new Array();
nrry.push(1,2,3,4,5,6,7,8,9,10);
nrry.forEach(function(item,index,array){
//	alert("nrry["+index+"]:"+item);
});
var endDate=Date.now();
//alert("函数运行结束时间时间："+endDate);
//getTime返回long类型的时间
//alert(date1.getTime());
//获取年月日，时分秒
var date2=new Date();
date2.setFullYear(2016);
date2.setMonth(9);
date2.setDate(15);
date2.setHours(10);
date2.setMinutes(10);
date2.setSeconds(10);
var year=date2.getFullYear();
var month=date2.getMonth();
var day=date2.getDate();
var hour=date2.getHours();
var minutes=date2.getMinutes();
var seconds=date2.getSeconds();
var dstr=year+"-"+month+"-"+day+" "+hour+":"+minutes+":"+seconds;
alert(dstr);

//正则表达式类型


//函数
function call1(name,callback1,cb2){
	alert("name:"+name);
	if(typeof callback1=="function"){
		//运行回调函数
		callback1();
	}
	if(typeof cb2=="function"){
		cb2();
	}
}

function callback1(){
	alert("回调函数1");
}

//var callback1=1;

call1("张三",callback1);
//函数中的arguments和length
alert("call1函数参数的个数:"+call1.length);
alert("callback1函数参数的个数:"+callback1.length);

//5.6基本包装类型
