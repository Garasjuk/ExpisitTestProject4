package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Likes;

import java.util.List;

public interface ServiceLikesDao {
	
	public int countLikeByIDBook(int id_book);
	public void addLike (Likes likes);
	public int listLikeByIdUserBook(int id_book, int id_user);
	public void deleteLikeByIdUserBook(int id_book, int id_user);
	public List listLike(int id_user);
}
