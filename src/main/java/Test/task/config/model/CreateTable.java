package Test.task.config.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
