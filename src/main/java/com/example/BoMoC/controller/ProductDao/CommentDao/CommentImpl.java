package com.example.BoMoC.controller.ProductDao.CommentDao;

import com.example.BoMoC.Model.Product.Comment;
import com.example.BoMoC.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentImpl implements CommentDao {
	private CommentRepository commentRepo;

	@Autowired
	public CommentImpl(CommentRepository commentRepo) {
		this.commentRepo = commentRepo;
	}

	@Override
	public Comment add(Comment comment) {
		return commentRepo.save(comment);
	}

	@Override
	public void delete(int id) {
		commentRepo.deleteById(id);
	}

	@Override
	public Comment update(Comment comment, int id) {
		if (commentRepo.existsById(id)){
			comment.setId(id);
			return commentRepo.save(comment);
		}
		return null;
	}

	@Override
	public Optional<Comment> getOne(int id) {
		return commentRepo.findById(id);
	}

	@Override
	public List<Comment> getAll() {
		return commentRepo.findAll();
	}
}