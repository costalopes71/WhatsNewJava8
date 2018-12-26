package com.pluralsight.whtasnewonjava8.newdateapi.dateandcalendar;

import java.util.Calendar;
import java.util.Date;

public class MutableDateExample {

	private Date creationDate;
	
	public MutableDateExample() {
		creationDate = Calendar.getInstance().getTime();
	}
	
	public Date getCreationDate() {
		return this.creationDate;
	}
	
	// como nao quero que ngm modifique a data de criacao em tempo de execucao eu nao exponho o metodo set, porem ele ainda eh mutavel
	// pois Date eh mutavel
	
	public static void main(String[] args) {
		
		MutableDateExample ex = new MutableDateExample();
		Date creation = ex.getCreationDate();
		creation.setTime(0L);
		
	}
	
	// para prevenir o problema acima posso usar um padrao conhecido como Copia Defensiva (defensive copy). Ex:
	public Date getImutableCreationDate() {
		return new Date(this.creationDate.getTime());
	}
	
	// problemas com esse padrao: objetos a mais para o GC coletar.
	// ou seja, toda vez que vc quiser manter uma data segura dentro de uma classe vc tera que criar uma copia defensiva se vc estiver
	//usando a API antiga Date
	
}
