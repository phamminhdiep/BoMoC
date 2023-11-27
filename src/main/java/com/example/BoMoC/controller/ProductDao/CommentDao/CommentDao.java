package com.example.BoMoC.controller.ProductDao.CommentDao;

import com.example.BoMoC.Model.Product.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentDao {

	public Comment add(Comment comment);

	public void delete(int id);

	public Comment update(Comment comment, int id);

	public Optional<Comment> getOne(int id);

	public List<Comment> getAll();
}