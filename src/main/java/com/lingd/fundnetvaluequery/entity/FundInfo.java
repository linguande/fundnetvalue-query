package com.lingd.fundnetvaluequery.entity;

public class FundInfo extends BaseEntity {

    private static final long serialVersionUID = -4307513024997889860L;

    private String fundcode;

    private String name;

    private String jzrq;

    private String dwjz;

    private String gsz;

    private String gszzl;

    private String gztime;

    public FundInfo() {

    }

    public String getFundcode() {
        return fundcode;
    }

    public void setFundcode(String fundcode) {
        this.fundcode = fundcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJzrq() {
        return jzrq;
    }

    public void setJzrq(String jzrq) {
        this.jzrq = jzrq;
    }

    public String getDwjz() {
        return dwjz;
    }

    public void setDwjz(String dwjz) {
        this.dwjz = dwjz;
    }

    public String getGsz() {
        return gsz;
    }

    public void setGsz(String gsz) {
        this.gsz = gsz;
    }

    public String getGszzl() {
        return gszzl;
    }

    public void setGszzl(String gszzl) {
        this.gszzl = gszzl;
    }

    public String getGztime() {
        return gztime;
    }

    public void setGztime(String gztime) {
        this.gztime = gztime;
    }

    @Override
    public String toString() {
        return "FundInfo{" +
                "fundcode='" + fundcode + '\'' +
                ", name='" + name + '\'' +
                ", jzrq='" + jzrq + '\'' +
                ", dwjz='" + dwjz + '\'' +
                ", gsz='" + gsz + '\'' +
                ", gszzl='" + gszzl + '\'' +
                ", gztime='" + gztime + '\'' +
                '}';
    }
}
