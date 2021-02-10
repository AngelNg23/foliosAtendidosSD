package com.telcel.dashboard.config;


 

/**
 *
 * @author VG2XXDF
 */
//@Configuration
//@EnableTransactionManagement
//@ComponentScan({"com.telcel.dashboard"})
public class JpaConfiguration{

// 
//
//    @Bean
//    public DataSource dataSource() {
//        DataSource dataSource = null;
//        try {
//            Context initialContext = new InitialContext();
//            dataSource = (DataSource) initialContext.lookup("jdbc/dashboardttsinatencion1");
//        } catch (NamingException e) {
//            Logger.getLogger(JpaConfiguration.class.getName()).log(Level.SEVERE, e.getMessage(), e);
//        }
//        return dataSource;
//    }
//
// 
//
//    private Properties jpaProperties() {
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
//        properties.put("hibernate.show_sql", "false");
//        properties.put("hibernate.format_sql", "true");
//        properties.put("hibernate.jdbc.batch_size", 1000);
//        return properties;
//    }
//
// 
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
//        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
//        localContainerEntityManagerFactoryBean.setPackagesToScan("com.telcel.dashboard");
//        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
//        localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties());
//        return localContainerEntityManagerFactoryBean;
//    }
//
// 
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//        hibernateJpaVendorAdapter.setDatabase(Database.ORACLE);
//        return hibernateJpaVendorAdapter;
//    }
//
// 
//
//    @Bean
//    @Autowired
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//        jpaTransactionManager.setEntityManagerFactory(emf);
//        return jpaTransactionManager;
//    }
//    
//    @Bean
//    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
//        return namedParameterJdbcTemplate;
//    }
}