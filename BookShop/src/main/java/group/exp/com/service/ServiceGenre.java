package group.exp.com.service;

import group.exp.com.model.Book;
import group.exp.com.model.Genre;

import java.util.List;

public interface ServiceGenre {
	
	public List<Genre> allListGenre();
	public void addGenre(Genre genre);
	
}
