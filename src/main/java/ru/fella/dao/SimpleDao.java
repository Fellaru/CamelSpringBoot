package ru.fella.dao;

import ru.fella.model.Simple;

import java.util.List;

/**
 * Интерфейс для DAO
 */
public interface SimpleDao {

    /**
     * Получить все записи из базы данных
     * @return {@link List<Simple>}
     */
    List<Simple> getAllRecords();
}
