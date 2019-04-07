package com.service.Query;

import com.service.Comments.CommRec;
import com.service.Comments.CommentFind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QueryControl {

    @Autowired
    QueryFind queryFind;

    @Autowired
    CommentFind commentFind;

    @RequestMapping(method = RequestMethod.POST, path = "/query")
    public QueryRec createNewQuery (@RequestBody String description) {
        QueryRec rec = new QueryRec(description);
        rec.setStatus(StatusEnum.NEW);
        return queryFind.save(rec);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/query")
    public ResponseEntity<QueryWithCommRec> getQueryById(@RequestParam(name="id") long id) {
        if(queryFind.existsById(id)) {
            QueryRec rec = queryFind.getById(id);
            List<CommRec> comments = commentFind.getAllByQuery(id);
            QueryWithCommRec responseQuery = new QueryWithCommRec(rec, comments);
            return new ResponseEntity<>(responseQuery, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/query")
    public QueryRec deleteQueryById(@RequestParam(name="id") long id) {
        QueryRec rec = queryFind.getById(id);
        List<CommRec> comments = commentFind.getAllByQuery(id);
        for (CommRec comment : comments) {
            commentFind.delete(comment);
        }
        queryFind.delete(rec);
        return rec;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/query")
    public ResponseEntity<QueryRec> updateStatus(@RequestBody QueryRec queryRec) {
        if(queryFind.existsById(queryRec.getId())) {
            QueryRec rec = queryFind.getById(queryRec.getId());
            rec.setStatus(queryRec.getStatus());
            return new ResponseEntity<>(queryFind.save(rec), HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}