package com.service.Comments;
import javax.persistence.*;

@Entity
@Table(name="comments")
public class CommRec {
    @Id
    @GeneratedValue
    private long id;

    @Column(name="query")
    private long query;

    @Column(name="text")
    private String text;

    public CommRec() {
    }

    public CommRec(long query, String text){
        this.query = query;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuery() {
        return query;
    }

    public void setQuery(long query) {
        this.query = query;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
