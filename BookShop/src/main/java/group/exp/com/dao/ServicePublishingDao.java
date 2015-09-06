package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Publishing;

import java.util.List;

public interface ServicePublishingDao {
		
	public List<Publishing> allListPublishing();
	public void addPublishing(Publishing publishing);
}
