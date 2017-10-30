package pers.marscheng.spring.dto;

public class test {

	public static void main(String[] args) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		System.out.println("currentloader====="+loader);
		System.out.println("parent====="+loader.getParent());
		System.out.println("grandpa====="+loader.getParent().getParent());
		

	}

}
