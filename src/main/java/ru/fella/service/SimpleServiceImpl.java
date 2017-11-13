package ru.fella.service;

import ru.fella.dao.SimpleDao;
import ru.fella.model.Simple;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.fella.service.SimpleService")
public class SimpleServiceImpl implements SimpleService {
	private SimpleDao dao;
	

	public SimpleServiceImpl(SimpleDao dao) {
		this.dao = dao;
	}

	

	@Override
	public String get() {
		List<Simple> simpleList = dao.getAllRecords();
		StringBuilder str = new StringBuilder();
		for(Simple simple : simpleList)
		{
			str.append(simple.toString()+"\n");
		}
		return str.toString();
	}

}
