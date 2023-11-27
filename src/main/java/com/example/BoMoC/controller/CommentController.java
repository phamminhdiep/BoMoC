package com.example.BoMoC.controller;

import com.example.BoMoC.Model.Product.Comment;
import com.example.BoMoC.controller.ProductDao.CommentDao.CommentDao;
import com.example.BoMoC.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    private CommentDao commentDao;

    @Autowired
    public CommentController(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @GetMapping("/api/comments")
    public ResponseEntity<List<Comment>> getAll() {
        List<Comment> comments = commentDao.getAll();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/api/comment/{id}")
    public ResponseEntity<Comment> getById(@PathVariable int id) {
        Optional<Comment> comment = commentDao.getOne(id);
        return comment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/api/comment")
    public ResponseEntity<Comment> add(@RequestBody Comment comment) {
        Comment savedComment = commentDao.add(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @PutMapping("/api/comment/{id}")
    public ResponseEntity<Comment> update(@RequestBody Comment comment, @PathVariable int id) {
        return new ResponseEntity<>(commentDao.update(comment, id), HttpStatus.OK);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        commentDao.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
