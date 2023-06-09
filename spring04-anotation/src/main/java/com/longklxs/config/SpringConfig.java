package com.longklxs.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.crypto.Data;


@ComponentScan("com.longklxs")
@PropertySource("jdbc.properties")
@Import(JdbcConfig.class)
public class SpringConfig {



}
