# IntelliJ Project 설정

## 1. AnnotationProcessor 설정
 - Go to File - Settings - Build, Execution, Deployment - Compile - AnnotationProcessor
 - Check 'Enable annotation processing'
 - Check 'module content root'
 - Set Production sources directory : src/querydsl/java
 - Add 'com.mysema.query.apt.jpa.JPAAnnotationProcessor'and
 'lombok.launch.AnnotationProcessorHider$AnnotationProcessor' to Annotation Processors
