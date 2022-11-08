package com.jenil.call_recorder;

public class CallDetails {

    private int serial;
    private String num;
    private String time;
    private String date;

    public CallDetails(){
    }

    public CallDetails(int serial,String num,String time,String date)
    {
        this.serial=serial;
        this.num=num;
        this.time=time;
        this.date=date;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
