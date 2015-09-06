package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Genre;

import java.util.List;

public interface ServiceGenreDao {
	
	public List<Genre> allListGenre();
	public void addGenre(Genre genre);
}
