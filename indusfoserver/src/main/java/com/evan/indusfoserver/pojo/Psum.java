package com.evan.indusfoserver.pojo;

import java.sql.Date;

public class Psum {
    String Time;
    int  Pnum;
    int  Anum;
    double  Num;

    public String getTime() {
        return Time;
    }

    public int getPnum() {
        return Pnum;
    }

    public int getAnum() {
        return Anum;
    }

    public double getNum() {
        return Num;
    }

    public void setTime(String time) {
        Time = time;
    }

    public void setPnum(int pnum) {
        Pnum = pnum;
    }

    public void setAnum(int anum) {
        Anum = anum;
    }

    public void setNum(double num) {
        Num = num;
    }
}
