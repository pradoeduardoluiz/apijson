package test;

import java.util.List;

public class Person {

	private int id;
	private String name;
	private boolean news;
	private Person Father;
	private List<Person> children;

	public Person() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isNews() {
		return news;
	}

	public void setNews(boolean news) {
		this.news = news;
	}

	public Person getFather() {
		return Father;
	}

	public void setFather(Person father) {
		Father = father;
	}

	public List<Person> getChildren() {
		return children;
	}

	public void setChildren(List<Person> children) {
		this.children = children;
	}

}
