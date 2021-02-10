package com.telcel.dashboard.config;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 *
 * @author VG2XXAH
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.telcel.dashboard"})
public class JdbcConfig {

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = null;
        try {
            Context initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("jdbc/reporteFoliosSD");
        } catch (NamingException e) {
            Logger.getLogger(JdbcConfig.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        return namedParameterJdbcTemplate;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
