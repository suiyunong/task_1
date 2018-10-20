package com.syn.spring_mybatis.Pojo;

public class People {
    //ID自增，不会出现null的情况，不用包装类
    private int id;
    private String name;
    private String qq;
    private String type;
    private long entro_time;
    private String school;
    private int number;
    private String diary_link;
    private String slogan;
    private String brother;
    private long create_at;
    private long update_at;

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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getEntro_time() {
        return entro_time;
    }

    public void setEntro_time(long entro_time) {
        this.entro_time = entro_time;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDiary_link() {
        return diary_link;
    }

    public void setDiary_link(String diary_link) {
        this.diary_link = diary_link;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }

    //定义构造方法
    public People() {
        super();
    }

    //定义打印people对象方法


}
