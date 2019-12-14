package com.example.dormi;

public class NoticeObject {
    private String num;
    private String title;
    private String detail_link;
    private String release_date;
    private String views;


    public NoticeObject(String num, String title, String link, String release_date, String views){
        this.num = num;
        this.title = title;
        this.detail_link = link;
        this.release_date = release_date;
        this.views = views;
    }

    public String getNum() {
        return num;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail_link() {
        return detail_link;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public String getViews() {
        return views;
    }

}
