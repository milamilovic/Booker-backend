package booker.BookingApp.model;

import lombok.Data;

import java.util.Date;

public @Data class Notification {
    private Date time;
    private String content;
    private String title;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
