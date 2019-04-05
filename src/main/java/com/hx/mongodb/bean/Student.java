package com.hx.mongodb.bean;

import org.bson.types.ObjectId;

/**
 * Created  on 2019/04/05.
 */
public class Student {

    private ObjectId _id;
    private String name;
    private int age;

    public Student(String s, String lucy, int age) {
    }

    public Student(ObjectId _id, String name, int age) {
        this._id = _id;
        this.name = name;
        this.age = age;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
