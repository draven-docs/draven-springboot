package com.noxus.draven.plus.utils.enums;

/**
 * 说明
 * 在用mybatis-plus封装的updateById方法来更新数据时，想把一个字段设置为null值，
 * 但是发现更新后数据没有为null还是原来的值，
 * 这是因为mybatis-plus在更新的时候做了null判断，默认不更新为null的传参
 * demo
 *
 * @TableField(strategy = FieldStrategy.IGNORED)
 * private String userName;
 */
public enum FieldStrategy {
    /**
     * 忽略判断
     */
    IGNORED,

    /**
     * 非NULL判断
     */
    NOT_NULL,

    /**
     * 非空判断
     */
    NOT_EMPTY
}