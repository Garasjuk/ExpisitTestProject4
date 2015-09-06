package group.exp.com.service;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Genre;
import group.exp.com.model.Publishing;

import java.util.List;

public interface ServicePublishing {
	
	public List<Publishing> allListPublishing();
	public void addPublishing(Publishing publishing);
	
}
