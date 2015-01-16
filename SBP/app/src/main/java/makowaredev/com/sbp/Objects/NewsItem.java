package makowaredev.com.sbp.Objects;

import java.io.Serializable;

public class NewsItem implements Serializable{
    private String day;
    private String month;
    private String title;
    private String body;

    //Default
    public NewsItem(){}

    //Default
    public NewsItem(String day, String month, String title, String body){
        this.day = day;
        this.month = month;
        this.title = title;
        this.body = body;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
