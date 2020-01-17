package com.evan.indusfoserver.pojo;

public class ProText {

    String Po;
    String Cname;
    String PrdtName;
    String Cdate;
    String Jdate;
    int    Mcount;
    int    FQTY;
    String Postatus;
    String Permark;

    public String getPo() {
        return Po;
    }

    public String getCname() {
        return Cname;
    }

    public String getPrdtName() {
        return PrdtName;
    }

    public String getCdate() {
        return Cdate;
    }

    public String getJdate() {
        return Jdate;
    }

    public int getMcount() {
        return Mcount;
    }

    public int getFQTY() {
        return FQTY;
    }

    public String getPostatus() {
        return Postatus;
    }

    public String getPermark() {
        return Permark;
    }

    public void setPo(String po) {
        Po = po;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public void setPrdtName(String prdtName) {
        PrdtName = prdtName;
    }

    public void setCdate(String cdate) {
        Cdate = cdate;
    }

    public void setJdate(String jdate) {
        Jdate = jdate;
    }

    public void setMcount(int mcount) {
        Mcount = mcount;
    }

    public void setFQTY(int FQTY) {
        this.FQTY = FQTY;
    }

    public void setPostatus(String postatus) {
        Postatus = postatus;
    }

    public void setPermark(String permark) {
        Permark = permark;
    }
}
