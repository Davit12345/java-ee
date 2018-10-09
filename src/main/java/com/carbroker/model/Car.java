package com.carbroker.model;

import java.util.Objects;

public class Car {
    private  int id;
    private String name,manifacturer,color;
    private  Double price;
    private  int data;
    private  Double driven;
    private  String selling;
    private  int user_id;

    public String getSelling() {
        return selling;
    }

    public void setSelling(String selling) {
        this.selling = selling;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManifacturer() {
        return manifacturer;
    }

    public void setManifacturer(String manifacturer) {
        this.manifacturer = manifacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Double getDriven() {
        return driven;
    }

    public void setDriven(Double driven) {
        this.driven = driven;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manifacturer='" + manifacturer + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", data=" + data +
                ", driven=" + driven +
                ", selling=" + selling +
                ", user_id='" + user_id + '\'' +
                '}';
    }

    public Car(int id, String name, String manifacturer, String color, Double price, int data, Double driven, String selling) {
        this.id = id;
        this.name = name;
        this.manifacturer = manifacturer;
        this.color = color;
        this.price = price;
        this.data = data;
        this.driven = driven;
        this.selling = selling;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                data == car.data &&
                user_id == car.user_id &&
                Objects.equals(name, car.name) &&
                Objects.equals(manifacturer, car.manifacturer) &&
                Objects.equals(color, car.color) &&
                Objects.equals(price, car.price) &&
                Objects.equals(driven, car.driven) &&
                Objects.equals(selling, car.selling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manifacturer, color, price, data, driven, selling, user_id);
    }

    public Car(String name, String manifacturer, String color, Double price, int data, Double driven, String selling, int user_id) {
        this.name = name;
        this.manifacturer = manifacturer;
        this.color = color;
        this.price = price;
        this.data = data;
        this.driven = driven;
        this.selling=selling;
        this.user_id = user_id;
    }
public Car(){}
}
