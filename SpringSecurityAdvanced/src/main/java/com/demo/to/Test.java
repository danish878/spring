package com.demo.to;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

//		Container<Integer> obj = new Container<>();
//		obj.value = 5;
//		obj.demo(new ArrayList<Integer>());
//		obj.show();
//		obj.array(new Integer(5));

//		Set<Integer> values = new TreeSet<>();
//		values.add(93);
//		values.add(34);
//		values.add(55);
//		values.add(96);
//
//		Collections.sort(values);
//		for (int i : values) {
//			System.out.println(i);
//		}

//		Map<String, String> map = new TreeMap<>();
//		map.put("name", "Danish");
//		map.put("sex", "male");
//		map.put("height", "6.2");
//		Set<Map.Entry<String, String>> entrySet = map.entrySet();
//		for(Map.Entry<String, String> e : entrySet) {
//			System.out.println(e);
//		}

//		new III().show();
//		J.show();

//		List<String> names = Arrays.asList("Danish", "Beenish", "Sehrish", "Daood", "Shanila");
//		names.forEach(System.out::println);

//		StringParser sp = new StringParser();
//		String str = "Dan";
//		MyPrinter mp = new MyPrinter();
//		mp.print(str, sp::convert );

        List<Integer> values = Arrays.asList(12, 20, 35, 46, 55, 68, 75);
//		System.out.println(values.stream().map(i -> i * 2).reduce(Integer::sum).get());		
        System.out.println(values.stream().filter(Test::mod5).map(Test::mapDouble).findFirst().orElse(-1));
    }

    public static boolean mod5(Integer i) {
        System.out.println("mod5 for " + i);
        return i % 5 == 0;
    }

    public static Integer mapDouble(Integer i) {
        System.out.println("mapDouble for " + i);
        return i * 2;
    }
}

class MyPrinter {
    public void print(String str, Parser p) {
        str = p.parse(str);
        System.out.println(str);
    }
}

interface Parser {
    String parse(String str);
}

class StringParser {
    public String convert(String s) {
        s = s.length() <= 3 ? s.toUpperCase() : s.toLowerCase();
        return s;
    }
}

class III extends II {

}

class II implements I, J {

    @Override
    public void show() {
        System.out.println("Show from II");
    }

}

interface I {
    default void show() {
        System.out.println("Show from I");
    }
}

interface J {
    static void show() {
        System.out.println("Show from J");
    }
}

class Student implements Comparable<Student> {
    private int marks;
    private String name;

    public Student(int marks, String name) {
        this.marks = marks;
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Student [marks=%s, name=%s]", marks, name);
    }

    @Override
    public int compareTo(Student o) {
        return this.getMarks() > o.getMarks() ? 1 : this.getMarks() < o.getMarks() ? -1 : 0;
    }
}

class Container<T extends Number> {

    T value;

    public void show() {
        System.out.println(value.getClass().getName());
    }

    public void demo(ArrayList<? extends T> obj) {

    }

    public void array(int i) {
        System.out.println(i);
    }
}
