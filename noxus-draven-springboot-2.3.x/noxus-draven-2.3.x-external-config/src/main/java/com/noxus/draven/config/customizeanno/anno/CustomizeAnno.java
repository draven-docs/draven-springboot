package com.noxus.draven.config.customizeanno.anno;

import org.springframework.beans.factory.annotation.Value;

import java.lang.annotation.*;


/**
 * @author draven
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Value("${customize.anno}")
public @interface CustomizeAnno {
}
