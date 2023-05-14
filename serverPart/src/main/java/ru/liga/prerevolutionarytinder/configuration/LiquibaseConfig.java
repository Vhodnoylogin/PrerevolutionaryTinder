//package ru.liga.prerevolutionarytinder.configuration;
//
//import liquibase.integration.spring.SpringLiquibase;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class LiquibaseConfig {
//
//    @Value("${liquibase.changelog.path}")
//    private String changeLogPath;
//
//    private final DataSource dataSource;
//
//    @Autowired
//    public LiquibaseConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Bean
//    public SpringLiquibase liquibase() {
//        SpringLiquibase liquibase = new SpringLiquibase();
//        liquibase.setChangeLog(changeLogPath);
//        liquibase.setDataSource(dataSource);
//        return liquibase;
//    }
//
//    private Resource[] getResources() throws Exception {
//        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
//        return resourcePatternResolver.getResources(changeLogPath);
//    }
//}
