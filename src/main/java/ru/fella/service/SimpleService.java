package ru.fella.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Интерфейс soap-сервиса
 */
@WebService
public interface SimpleService {

  /**
   * Получить все данные
   * @return {@link String}
   */
  @WebMethod
  String get();
}
