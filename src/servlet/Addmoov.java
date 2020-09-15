package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.moov;

//ユーザー追加機能
//GETでアクセスされた場合　登録フォームを表示
//POSTでアクセスされた場合　登録フォームから送られたデータを処理
//登録フォームから送られたデータは、DB保存候補としてsession変数に保存
@WebServlet("/addmoov")
public class Addmoov extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Addmoov() {
        super();

    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    RequestDispatcher dispatcher =
		        req.getRequestDispatcher
		            ("/WEB-INF/jsp/touroku.jsp");
		    dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		moov moov = new moov();
       moov.setBikou (req.getParameter("bikou") );
       moov.setDay 	(req.getParameter("day") );
       moov.setPlace(req.getParameter("place") );
       moov.setReason(req.getParameter("reason") );
       moov.setTime(req.getParameter("time") );
		try {
			HttpSession session = req.getSession();
			
			session.setAttribute("moovToAdd", moov);
		    
			RequestDispatcher dispatcher =
			        req.getRequestDispatcher
			            ("/WEB-INF/jsp/addMoovConfirm.jsp");
			    dispatcher.forward(req, resp);
			
	
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}

