package com.gj.testpojo;

/**
 * @author gengjian
 * @date 2020/6/5
 */
public class CarDemo {

    private Integer cId;

    private Integer age;

    private String Name;

    private Integer sort;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /*public CarDemo(Integer cId, Integer age, String name) {
        this.cId = cId;
        this.age = age;
        Name = name;
    }*/


    @Override
    public String toString() {
        return "CarDemo{" +
                "cId=" + cId +
                ", age=" + age +
                ", Name='" + Name + '\'' +
                ", sort=" + sort +
                '}';
    }
}
