package com.java.practice.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO
 * <p>
 * Note:
 * @Target({ElementType.METHOD, ElementType.TYPE}) 表示可以用在 方法，类和接口
 * @Inherited   @Inherited作为java的原生注解之一，表示其标记的注解允许被继承，接口实现除外。
 * 如果父类使用的注解带有 @Inherited 标注，子类是可以获取到此注解的；
 * 如果父类使用的注解不带 @Inherited 标注，子类则无法获取到此注解。
 * 至于接口，无论接口使用的注解是否带有@Inherited标注，实现类都是无法获取到接口的注解的。
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/09/05 16:19
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    /**
     * 注解只有一个成员，则成员名必须取名为 value()，在使用时可以忽略成员名和复制号（=）
     * @return
     */
//    String value() default "";

    String desc();

    String author();
}
