package org.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "org.example.demo.mapper.slurm", sqlSessionTemplateRef = "slurmSqlSessionTemplate")
public class SlurmDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slurm")
    public DataSource slurmDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory slurmSqlSessionFactory(@Qualifier("slurmDataSource") DataSource dataSource)
        throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/slurm/*.xml"));
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager slurmTransactionManager(@Qualifier("slurmDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate
        slurmSqlSessionTemplate(@Qualifier("slurmSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
