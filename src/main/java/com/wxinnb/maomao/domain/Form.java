package com.wxinnb.maomao.domain;

import com.wxinnb.maomao.domain.support.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "tb_form")
@Proxy(lazy = false)
public class Form extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer groupId;

    private String userId;

    //备注
    private String remark;

    private Integer count;

    private String groupPrice;

    private String productName;

    private String strus;

    //合计金额
    private String totalPrice;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(String groupPrice) {
        this.groupPrice = groupPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStrus() {
        return strus;
    }

    public void setStrus(String strus) {
        this.strus = strus;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", userId='" + userId + '\'' +
                ", remark='" + remark + '\'' +
                ", count=" + count +
                ", groupPrice='" + groupPrice + '\'' +
                ", productName='" + productName + '\'' +
                ", strus='" + strus + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                '}';
    }
}
