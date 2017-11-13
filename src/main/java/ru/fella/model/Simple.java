package ru.fella.model;

import java.sql.Date;

/**
 * Класс-сущность, для работы с БД
 */
public class Simple {
	private Integer id;
	private Integer integer;
	private String string;
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer integer) {
		this.integer = integer;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString()
	{
		return "id = "+getId()+", integer = "+getInteger()+", string = "+getString()+", date = "+getDate().toString();
	}

}
