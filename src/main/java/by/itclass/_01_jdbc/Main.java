package by.itclass._01_jdbc;

import by.itclass._01_jdbc.entities.UserRowMapping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class Main {
    public static void main(String[] args) {
        //var datasource = new DriverManagerDataSource();
        var datasource = new SimpleDriverDataSource();
        datasource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        datasource.setUrl("jdbc:mysql://localhost:3306/po_2301");
        datasource.setUsername("root");
        datasource.setPassword("");

        var jdbcTemplate = new JdbcTemplate(datasource);

        var users = jdbcTemplate.query("SELECT * FROM user", new UserRowMapping());
        users.forEach(System.out::println);
        System.out.println("______________________");
        jdbcTemplate.query("SELECT * FROM user WHERE age > ?", new UserRowMapping(), new Object[]{30})
                .forEach(System.out::println);
        System.out.println("______________________");
        jdbcTemplate.update("UPDATE user SET name = ? WHERE age > ?", "Sidor Bulkin", 30);
        jdbcTemplate.query("SELECT * FROM user", new UserRowMapping()).forEach(System.out::println);
    }
}
