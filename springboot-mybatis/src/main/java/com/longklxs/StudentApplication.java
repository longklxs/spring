package com.longklxs;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;

//@MapperScan("com.longklxs.mapper")
//@ComponentScan("com.longklxs.mapper")
@ComponentScan("com")
//@Service("serviceAlias")
//@SpringBootApplication
public class StudentApplication {
    public static void main(String[] args) {
//        SpringApplication.run(StudentApplication.class,args);
//        ComponentScan annotation = AnnotationUtils.getAnnotation(StudentApplication.class, ComponentScan.class);
//        System.out.println(annotation.value()[0]);
//        System.out.println(annotation.basePackages()[0]);
        Component component = AnnotationUtils.getAnnotation(StudentApplication.class, Component.class);
//        System.out.println(component);
//
//        Component component1 = AnnotatedElementUtils.getMergedAnnotation(StudentApplication.class, Component.class);
//        System.out.println(component1);
//        ComponentScans scans = StudentApplication.class.getAnnotation(ComponentScans.class);
//        for(ComponentScan scan : scans.value()){
//            System.out.println(scan.value()[0]);
//        }
        Annotation[] annotations = StudentApplication.class.getAnnotations();
        for(Annotation anno : annotations){
            System.out.println(anno);
        }

    }
}
