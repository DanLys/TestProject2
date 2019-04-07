package com.service.Query;

import com.service.Comments.CommRec;

import java.util.List;

public class QueryWithCommRec {
    private QueryRec rec;
    private List<CommRec> comments;

    public QueryWithCommRec(QueryRec rec, List<CommRec> comments){
        this.rec = rec;
        this.comments = comments;
    }

    public QueryRec getRec() {
        return rec;
    }

    public void setRec(QueryRec rec) {
        this.rec = rec;
    }

    public void setComments(List<CommRec> comments) {
        this.comments = comments;
    }

    public List<CommRec> getComments() {
        return comments;
    }
}
