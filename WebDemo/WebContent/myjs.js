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
	this.showInfo = showInfo;//对象方法
	return this;
}

function showInfo() {
	console.log(this);
	alert(JSON.stringify(this));
//	alert("对象姓名:" + this.name);
//	alert("对象性别:" + this.sex);
//	alert("对象年龄:" + this.age);
}

var p1 = new Person("张三三", "女", 18);
//p1.showInfo();
var p2 = new Person("李思思", "女", 18);
//p2.showInfo();
//getElementById();
alert(typeof document.getElementById("p1"));
//getAttribute();
var p1=document.getElementById("p1");
alert(p1.getAttribute("title"));
//setAttribute
p1.setAttribute("title","setAttribute");