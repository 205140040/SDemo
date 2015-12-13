package com.demo.c19.enumdemo;

public class EnumDemo {
	public static void main(String[] args) {
		// 遍历枚举,通过枚举的values方法遍历
		for (Fruit f : Fruit.values()) {
			System.out.println("枚举顺序号：" + f.ordinal() + " " + "名字：" + f.name());
			System.out.println("输入名字返回值:" + f.valueOf("APPLE"));
			System.out.println("自定义方法获取值:" + f.getDescription());
			System.out.println("-------------------------------------");
		}
		// switch使用枚举
		Fruit fruit = Fruit.BANANER;
		switch (fruit) {
		case APPLE:
			System.out.println(Fruit.APPLE.name());
			break;
		case ORANGE:
			System.out.println(Fruit.ORANGE.name());

			break;
		case BANANER:
			System.out.println(Fruit.BANANER.name());

			break;
		default:
			break;
		}
	}
}
