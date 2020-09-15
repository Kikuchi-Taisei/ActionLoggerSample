package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MoovDAO;
import dao.UserDAO;
import model.User;
import model.moov;

//ユーザーが登録するユーザー情報を確認した後、OKをクリックしたときの処理
@WebServlet("/addmoovcofirm")
public class AddmoovCofirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddmoovCofirm () {
        super();
    }


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//statusがconfirmedの場合
		//本来は正当な登録確認であることをチェックするべきであるが、とりあえずOmit
		if(req.getParameter("status").equals("confirmed")) {
			HttpSession session = req.getSession();
			//セッションスコープに保存していた、DB登録前のユーザー情報を取得
			moov moov = (moov)session.getAttribute("moovToAdd");
			MoovDAO moovDAO = new MoovDAO();
			moovDAO.save(moov);	//DBに保存
			//TODO 主キーの重複で保存できなかった場合の処理を追加
			
	}
		//DBへの保存が成功したものとして、ログインページに遷移
		resp.sendRedirect("/ActionLoggerSample/?view=user");
	}
}
