
package oop;

import java.util.Date;
import java.math.BigDecimal;

public class Substitute extends Member {
	
	public Substitute(String name, String surname, String phoneno, String inst) {
		super(name,surname,phoneno,inst);
	}

	public Substitute(Member m){
		super(m);
	}

	public boolean isAvailable(Date d){

		long DAY_IN_MS = 1000 * 60 * 60 * 24;
		Date a = new Date(d.getTime() - (7 * DAY_IN_MS));

		for(Date e:proben){
			if (e==null || e.before(a)) return false;

		}
		return true;
	}


	@Override public Member join(){
		Substitute m = new Substitute(this);
		m.Join=new Date();
		return m;
	}

	public Member leave(){
		Substitute m = new Substitute(this);
		m.Leave= new Date();
		return m;
	}
	

	public String toString(){
		return ("Substitute: " + name + " " + surname + " " + phoneno + " " + instrument);
	}

}