package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;

import java.util.List;

public interface ServiceAuthorDao {
	
	public List<Author> allListAuthor();
	public void addAuthor(Author author);
}
