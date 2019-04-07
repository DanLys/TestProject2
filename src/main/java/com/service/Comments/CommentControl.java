package com.service.Comments;

import com.service.Query.QueryFind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentControl {

    @Autowired
    CommentFind commentFind;

    @Autowired
    QueryFind queryFind;

    @RequestMapping(method = RequestMethod.POST, path = "/comments")
    public ResponseEntity<CommRec> createNewComm(@RequestBody CommRec rec) {
        if(queryFind.existsById(rec.getQuery())) {
            rec = commentFind.save(rec);
            return new ResponseEntity<>(rec, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
