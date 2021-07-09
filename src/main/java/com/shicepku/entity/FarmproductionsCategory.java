package com.shicepku.entity;


public class FarmproductionsCategory {
  public FarmproductionsCategory() {
  }

  @Override
  public String toString() {
    return "FarmproductionsCategory{" +
            "id=" + id +
            ", parentId=" + parentId +
            ", name='" + name + '\'' +
            ", edescribe='" + edescribe + '\'' +
            ", ylut=" + ylut +
            ", growthCycle='" + growthCycle + '\'' +
            ", plantingIn=" + plantingIn +
            ", matureIn=" + matureIn +
            ", picture='" + picture + '\'' +
            ", parentIds='" + parentIds + '\'' +
            ", createDate=" + createDate +
            ", createBy='" + createBy + '\'' +
            ", sort=" + sort +
            ", status=" + status +
            ", updateBy='" + updateBy + '\'' +
            ", updateDate=" + updateDate +
            ", officeId=" + officeId +
            ", delFlag=" + delFlag +
            '}';
  }
  private long id;
  private long parentId;
  private String name;
  private String edescribe;
  private double ylut;
  private String growthCycle;
  private java.sql.Timestamp plantingIn;
  private java.sql.Timestamp matureIn;
  private String picture;
  private String parentIds;
  private java.sql.Timestamp createDate;
  private String createBy;
  private double sort;
  private double status;
  private String updateBy;
  private java.sql.Timestamp updateDate;
  private long officeId;
  private int delFlag;

  public int getDelFlag() {
    return delFlag;
  }

  public void setDelFlag(int delFlag) {
    this.delFlag = delFlag;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getEdescribe() {
    return edescribe;
  }

  public void setEdescribe(String edescribe) {
    this.edescribe = edescribe;
  }


  public double getYlut() {
    return ylut;
  }

  public void setYlut(double ylut) {
    this.ylut = ylut;
  }


  public String getGrowthCycle() {
    return growthCycle;
  }

  public void setGrowthCycle(String growthCycle) {
    this.growthCycle = growthCycle;
  }


  public java.sql.Timestamp getPlantingIn() {
    return plantingIn;
  }

  public void setPlantingIn(java.sql.Timestamp plantingIn) {
    this.plantingIn = plantingIn;
  }


  public java.sql.Timestamp getMatureIn() {
    return matureIn;
  }

  public void setMatureIn(java.sql.Timestamp matureIn) {
    this.matureIn = matureIn;
  }


  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }


  public String getParentIds() {
    return parentIds;
  }

  public void setParentIds(String parentIds) {
    this.parentIds = parentIds;
  }


  public java.sql.Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Timestamp createDate) {
    this.createDate = createDate;
  }


  public String getCreateBy() {
    return createBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy;
  }


  public double getSort() {
    return sort;
  }

  public void setSort(double sort) {
    this.sort = sort;
  }


  public double getStatus() {
    return status;
  }

  public void setStatus(double status) {
    this.status = status;
  }


  public String getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(String updateBy) {
    this.updateBy = updateBy;
  }


  public java.sql.Timestamp getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(java.sql.Timestamp updateDate) {
    this.updateDate = updateDate;
  }


  public long getOfficeId() {
    return officeId;
  }

  public void setOfficeId(long officeId) {
    this.officeId = officeId;
  }

}
