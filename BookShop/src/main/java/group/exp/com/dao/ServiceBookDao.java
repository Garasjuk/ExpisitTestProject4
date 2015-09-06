package group.exp.com.dao;

import group.exp.com.model.Book;

import java.util.List;

public interface ServiceBookDao {
	public List listBook();
	public List<Book> listBookByID(int id_book);
	public List<Book> allListBook();
	public void addBook(Book book);
	public List listBookFilterGenre(int id_genre);
	public List listBookFilterAuthor(int id_author);
	public List listBookFilterPublishing(int id_publishing);
	public List listBookFilterNew(int new_book);
	public Book listBook(String name_book, int id_genre, int id_author, int id_publishing, int new_book);
	public void updataBookNew(int id_book, int count_book);
	public void updataBook(int id_book, String name_book, int price_book, int count_book, int author_book, int genre_book, int publishing_book);
	public List listBookSearch(String search);
	public void deleteBook(int id_book);
}
