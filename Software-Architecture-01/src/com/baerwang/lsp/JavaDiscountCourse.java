package com.baerwang.lsp;


import com.baerwang.ocp.JavaCourse;

/**
 * @author baerwang
 * @since 2020/8/25 21:52
 */
public class JavaDiscountCourse extends JavaCourse {

    private Integer id;

    private String name;

    private Double price;

    public JavaDiscountCourse(JavaCourse javaCourse) {
        super(javaCourse.getId(), javaCourse.getName(), javaCourse.getPrice());
    }

    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getDiscountPrice() {
        return super.getPrice() * 0.61;
    }

}
