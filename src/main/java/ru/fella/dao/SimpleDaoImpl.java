package ru.fella.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.fella.model.Simple;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Реализация интерфейса DAO
 */
public class SimpleDaoImpl implements SimpleDao {
	@Autowired
	@Qualifier("dataSource")
	private DriverManagerDataSource dataSource;
	private JdbcTemplate template;

	/**
	 * Инициализация с созданием таблиц в БД
	 */
	@PostConstruct
	public void init() {
		template = new JdbcTemplate(dataSource);
		template.execute(
				"CREATE TABLE IF NOT EXISTS SIMPLE(id INT PRIMARY KEY AUTO_INCREMENT, integer INT, string VARCHAR(255), date DATE)");
		template.execute("INSERT INTO SIMPLE VALUES(null, 100, 'TEST', '1111-11-11')");
		template.execute("INSERT INTO SIMPLE VALUES(null, 1000, 'TEST1', '1112-11-11')");
	}

	/**
	 * Получить все записи из базы данных
	 * @return {@link List<Simple>}
	 */
	@Override
	public List<Simple> getAllRecords() {
		return template.query("SELECT * FROM SIMPLE", mapper);
	}

	/**
	 * Маппинг объекта {@link Simple}
	 */
	private RowMapper<Simple> mapper = new RowMapper<Simple>() {

		@Override
		public Simple mapRow(ResultSet rs, int numRow) throws SQLException {
			Simple simple = new Simple();
			simple.setId(rs.getInt("id"));
			simple.setInteger(rs.getInt("integer"));
			simple.setString(rs.getString("string"));
			simple.setDate(rs.getDate("date"));
			return simple;
		}
	};

}
