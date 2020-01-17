package com.evan.indusfoserver.pojo;

import java.sql.Date;

public class Contractordata {

     String PoId;
     String Mtype;
     String Client;
     Date   Acctime;
     int    No;
     int    Getnum;
     int    DamageNum;
     int    madeNumb;
     int    sampleNumb;
     int    samplecount;
     int    Duihua;
     int    Daoxian;
     int    Jitou;
     int    Dazou;
     int    Other;


    public String getPoId() {
        return PoId;
    }

    public String getMtype() {
        return Mtype;
    }

    public String getClient() {
        return Client;
    }

    public Date getAcctime() {
        return Acctime;
    }

    public int getNo() {
        return No;
    }

    public int getGetnum() {
        return Getnum;
    }

    public int getDamageNum() {
        return DamageNum;
    }

    public int getMadeNumb() {
        return madeNumb;
    }

    public int getSampleNumb() {
        return sampleNumb;
    }

    public int getSamplecount() {
        return samplecount;
    }

    public int getDuihua() {
        return Duihua;
    }

    public int getDaoxian() {
        return Daoxian;
    }

    public int getJitou() {
        return Jitou;
    }

    public int getDazou() {
        return Dazou;
    }

    public int getOther() {
        return Other;
    }


    public void setPoId(String poId) {
        PoId = poId;
    }

    public void setMtype(String mtype) {
        Mtype = mtype;
    }

    public void setClient(String client) {
        Client = client;
    }

    public void setAcctime(Date acctime) {
        Acctime = acctime;
    }

    public void setNo(int no) {
        No = no;
    }

    public void setGetnum(int getnum) {
        Getnum = getnum;
    }

    public void setDamageNum(int damageNum) {
        DamageNum = damageNum;
    }

    public void setMadeNumb(int madeNumb) {
        this.madeNumb = madeNumb;
    }

    public void setSampleNumb(int sampleNumb) {
        this.sampleNumb = sampleNumb;
    }

    public void setSamplecount(int samplecount) {
        this.samplecount = samplecount;
    }

    public void setDuihua(int duihua) {
        Duihua = duihua;
    }

    public void setDaoxian(int daoxian) {
        Daoxian = daoxian;
    }

    public void setJitou(int jitou) {
        Jitou = jitou;
    }

    public void setDazou(int dazou) {
        Dazou = dazou;
    }

    public void setOther(int other) {
        Other = other;
    }
}
