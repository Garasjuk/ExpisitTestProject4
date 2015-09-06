package group.exp.com.service;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Genre;

import java.util.List;

public interface ServiceAuthor {
	
	public List<Author> allListAuthor();
	public void addAuthor(Author author);
}
