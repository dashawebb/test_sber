package Test.task.config.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CreateTable {

    private JdbcTemplate jdbcTemplate;

    public CreateTable() {
    }

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createTableStatus() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS sber_test");
            jdbcTemplate.execute("CREATE TABLE public.sber_test\n" +
                    "(\n" +
                    "    \"Shelf\" integer,\n" +
                    "    \"Box\" character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "    \"Article\" character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "    \"Name\" character varying(255) COLLATE pg_catalog.\"default\"\n" +
                    ")");
            return "table_created";
        } catch (Exception e) {
            return "Table creation failed " + e;
        }
    }

    public Boolean insertIntoTableRow1(){
        jdbcTemplate.execute(("INSERT INTO sber_test (\"Article\", \"Name\", \"Shelf\", \"Box\")\n" +
                "   VALUES ('A001', 'Гайка', '1', 'A')"));
            return true;
    }

    public Boolean insertIntoTableRow2(){
        jdbcTemplate.execute(("INSERT INTO sber_test (\"Article\", \"Name\", \"Shelf\", \"Box\")\n" +
                "   VALUES ('B001', 'Болт', '2', 'B')"));
        return true;
    }

    public Boolean insertIntoTableRow3(){
        jdbcTemplate.execute(("INSERT INTO sber_test (\"Article\", \"Name\", \"Shelf\", \"Box\")\n" +
                "   VALUES ('C001', 'Шайба', '1', 'C')"));
        return true;
    }

    public List<Order> select() {
        String selectQuery = "SELECT * FROM sber_test";
        List<Order> orders = jdbcTemplate.query(selectQuery, new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                Order order = new Order(resultSet.getString("article"),
                        resultSet.getString("name"),
                        resultSet.getInt("shelf"),
                        resultSet.getString("box"));
                return order;
            }
        });
        return orders;
    }
}
