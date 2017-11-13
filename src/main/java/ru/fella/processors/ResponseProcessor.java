package ru.fella.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.fella.dao.SimpleDao;
import ru.fella.service.SimpleServiceImpl;

/**
 * Процессор для формирования ответа
 */
public class ResponseProcessor implements Processor {

  @Autowired
  private SimpleDao simpleDao;

  @Override
  public void process(Exchange exchange) throws Exception {
    // Получаем данные из БД и записываем помещаем их в объект SimpleResult
    String simpleResult = new SimpleServiceImpl(simpleDao).get();
    // Записываем результат в Body, кэмеловского объекта Exchange
    exchange.getIn().setBody(simpleResult);
  }
}
