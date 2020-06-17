package com.gj.modules.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *裸车实体
 * @author gengjian
 * @date 2020/1/1
 */
@Data
public class NakedCarEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 品牌
     */
    private String cBrand;
    /**
     * 名称
     */
    private String cName;
    /**
     * 颜色
     */
    private Integer cColor;
    /**
     * 类型
     */
    private Integer cType;
    /**
     * 价格
     */
    private Double cPrice;
    /**
     * 产地
     */
    private String cLocal;
    /**
     * 出厂日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cDate;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcBrand() {
        return cBrand;
    }

    public void setcBrand(String cBrand) {
        this.cBrand = cBrand;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getcColor() {
        return cColor;
    }

    public void setcColor(Integer cColor) {
        this.cColor = cColor;
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    public Double getcPrice() {
        return cPrice;
    }

    public void setcPrice(Double cPrice) {
        this.cPrice = cPrice;
    }

    public String getcLocal() {
        return cLocal;
    }

    public void setcLocal(String cLocal) {
        this.cLocal = cLocal;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
