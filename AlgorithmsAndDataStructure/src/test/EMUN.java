package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

enum People{
	ZHANGSAN("zs",10),ZHANGSANA("zsss",10),
	ZHANGSANB("zss",10)
	;
	private final String name;
	private final int age;
	People(String name,int age){
		this.name = name;
		this.age = age;
	}
	public int get() {return ordinal() + 1;}
}
public class EMUN {
	public static void main(String[] args) {
		for(People p : People.values()) {
			System.out.println(p.ZHANGSAN);
		}
		
		Map<String,Integer> map = new HashMap<>();
		String word = "a";
		map.merge(word, 1, Integer::sum);
		map.merge(word, 1, Integer::sum);map.merge(word + "b", 1, Integer::sum);
		System.out.println(map.toString());
	}
}
