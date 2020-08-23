package com.baerwang.ocp;

/**
 * @author baerwang
 * @since 2020/8/23 18:54
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

    public Double getOriginPrice() {
        return super.getPrice();
    }

    @Override
    public Double getPrice() {
        return super.getPrice() * 0.61;
    }
}
