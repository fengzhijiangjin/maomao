package com.wxinnb.maomao.domain;

import com.wxinnb.maomao.domain.support.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "tb_group")
@Proxy(lazy = false)
public class Group extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private  Integer productId;

    private String productName;

    private String pic;

    //价格
    private String price;

    //单位
    private String unit;

    //目标件数
    private Integer aim;
    //当前件数
    private Integer count;

    //状态
    private int state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getAim() {
        return aim;
    }

    public void setAim(Integer aim) {
        this.aim = aim;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", pic='" + pic + '\'' +
                ", price='" + price + '\'' +
                ", unit='" + unit + '\'' +
                ", aim=" + aim +
                ", count=" + count +
                ", state=" + state +
                '}';
    }
}
