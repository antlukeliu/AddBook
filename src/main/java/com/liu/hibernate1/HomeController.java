package com.liu.hibernate1;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		//Get the list of books from DAO
		String[] filters = {};
		
		
		String filter = SearchAlg.getQueryString(filters);
		List<Book> books = DAO.getAllBooks(filter);
		//add this list to the model
		model.addAttribute("bookList", books);
		
		return "list";
	}
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(Model model, HttpServletRequest request) {
		
		Book book = new Book();
		book.setAuthor(request.getParameter("name"));
		book.setTitle(request.getParameter("title"));
		book.setPublisher(request.getParameter("publisher"));
		book.setSales(Integer.parseInt(request.getParameter("sales")));
		int num = DAO.addBook(book);
		
		
		model.addAttribute("nm", request.getParameter("name") );
		model.addAttribute("tl", request.getParameter("title") );
		model.addAttribute("pb", request.getParameter("publisher") );
		model.addAttribute("sl", request.getParameter("sales"));
		
		return "addfile";
	}
	
	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public String deleteBook(@RequestParam("rank") int rank,Model model){
		DAO.deleteBook(rank);
		List<Book> books = DAO.getAllBooks("FROM Book");
		
		model.addAttribute("bookList", books);

		
		return "list";
	} 
	
	@RequestMapping(value = "/viewBook", method = RequestMethod.GET)
	public String viewBook(@RequestParam("rank") int rank,Model model){
		
		int rankNum = rank;
		String title = "";
		String author = "";
		int sales = 0;
		String imprint = "";
		String publisher = "";
		int yearPublished = 0;
		String genre = "";
		int status = 0;
		int borrower = 0;
		
		List<Book> books = DAO.getAllBooks("FROM Book");
		
		for(Book b : books){
			if(b.getRank() == rank){
				rankNum = rank;
				title = b.getTitle();
				author = b.getAuthor();
				sales = b.getSales();
				imprint = b.getImprint();
				publisher = b.getPublisher();
				yearPublished = b.getYearPublished();
				genre = b.getGenre();
				status = b.getStatus();
				borrower = b.getBorrower();
				
			}
		}
		
		model.addAttribute("rank", rankNum);
		model.addAttribute("title", title);
		model.addAttribute("author", author);
		model.addAttribute("sales", sales);
		model.addAttribute("imprint", imprint);
		model.addAttribute("publisher", publisher);
		model.addAttribute("yearPublished", yearPublished);
		model.addAttribute("genre", genre);
		model.addAttribute("status", status);
		model.addAttribute("borrower", borrower);

		
		return "viewBook";
	}

}
