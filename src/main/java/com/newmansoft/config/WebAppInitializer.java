package com.newmansoft.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import com.newmansoft.filter.CORSFilter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



public class WebAppInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(servletContext);
        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);


//        System.out.println("adding webapp filter");
//        servletContext.addFilter("corsFilter", CORSFilter.class);


//
//        System.out.println("Creating tables");
//        jdbcTemplate.execute("DROP TABLE IF EXISTS  `quest2`");
//        jdbcTemplate.execute("CREATE TABLE guest2(id int, first_name varchar(255), last_name varchar(255))");
//
//        String[] name = "Andy Newman".split(" ");
//        jdbcTemplate.update(
//                "INSERT INTO guest2(first_name,last_name) values(?,?)",
//                name[0], name[1]);
//
//        System.out.println("done");
    }
}