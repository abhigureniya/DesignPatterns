package com.abhi.pattern.prototypepattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{

	private List<String> empList;
	
	public Employees() {
		empList = new ArrayList<>();
	}
	
	public Employees(List<String> list) {
		this.empList = list;
	}
	
	public void loadData() {
		empList.add("A");
		empList.add("B");
		empList.add("C");
		empList.add("D");
	}
	
	public List<String> getEmpList() {
		return empList;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<>();
		for(String s : this.getEmpList()) {
			temp.add(s);
		}
		return new Employees(temp);
	}
	
}

/*
Prototype design pattern is used when the Object creation is a costly affair and requires a 
lot of time and resources and you have a similar object already existing.

Prototype pattern provides a mechanism to copy the original object to a new object and then 
modify it according to our needs. Prototype design pattern uses java cloning to copy the object.

>Prototype Design Pattern Example
It would be easy to understand prototype design pattern with an example. Suppose we have an 
Object that loads data from database. Now we need to modify this data in our program multiple 
times, so it’s not a good idea to create the Object using new keyword and load all the data 
again from database.

The better approach would be to clone the existing object into a new object and then do the 
data manipulation.

Prototype design pattern mandates that the Object which you are copying should provide the 
copying feature. It should not be done by any other class. However whether to use shallow or 
deep copy of the Object properties depends on the requirements and its a design decision. 
 
*/