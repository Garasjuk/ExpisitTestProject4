package group.exp.com.service;

import java.util.List;

import group.exp.com.dao.ServiceBookDao;
import group.exp.com.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ServiceBook")
@Transactional
public class ServiceBookImpl implements ServiceBook{

	@Autowired
	private ServiceBookDao serviceBookDao;

	public ServiceBookImpl() {
	}
	
	public List listBook() {
		// TODO Auto-generated method stub
		System.out.println("Point 2");
		return serviceBookDao.listBook();
	}

	public List<Book> listBookByID(int id_book) {
		// TODO Auto-generated method stub
		return serviceBookDao.listBookByID(id_book);
	}

	public List<Book> allListBook() {
		return serviceBookDao.allListBook();
	}
	public void addBook(Book book) {
		serviceBookDao.addBook(book);
	}

	public List listBookFilterGenre(int id_genre) {
		return serviceBookDao.listBookFilterGenre(id_genre);
	}

	public List listBookFilterAuthor(int id_author) {
		return serviceBookDao.listBookFilterAuthor(id_author);
	}

	public List listBookFilterPublishing(int id_publishing) {
		return serviceBookDao.listBookFilterPublishing(id_publishing);
	}

	public List listBookFilterNew(int new_book) {
		return serviceBookDao.listBookFilterNew(new_book);
	}
	public Book listBook(String name_book, int id_genre, int id_author,
			int id_publishing, int new_book) {
		return serviceBookDao.listBook(name_book, id_genre, id_author,
				id_publishing, new_book);
	}

	public void updataBookNew(int id_book, int count_book) {
		serviceBookDao.updataBookNew(id_book, count_book);
	}
	public void updataBook(int id_book, String name_book, int price_book, int count_book, int author_book, int genre_book, int publishing_book){
		serviceBookDao.updataBook(id_book, name_book, price_book, count_book, author_book, genre_book, publishing_book);
	}
	public List listBookSearch(String search){
		return serviceBookDao.listBookSearch(search);
	}

	public void deleteBook(int id_book){
		serviceBookDao.deleteBook(id_book);
	}
	
	
	
}
