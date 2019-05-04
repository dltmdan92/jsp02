package session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberDTO;

/**
 * Servlet implementation class SessionController
 */
@WebServlet("/session_servlet/*")
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		MemberDAO dao = new MemberDAO();
		if(url.indexOf("login.do") != -1) {
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			System.out.println("아이디 : " + userid);
			System.out.println("패스워드 : " + passwd);
			MemberDTO dto = new MemberDTO();
			dto.setUserid(userid);
			dto.setPasswd(passwd);
			MemberDTO resultDTO = dao.loginCheckBcrypt(dto);
			String result = "error";
			
			if(resultDTO != null) {
				result = resultDTO.getUserid() + "님 환영합니다.";
			}
			System.out.println(result);
			String page = "/ch07/session_result.jsp";
			if(!result.equals("error")) {
				HttpSession session = request.getSession();
				session.setAttribute("userid", userid);
				session.setAttribute("message", result);
				page = "/ch07/main.jsp";
				response.sendRedirect(request.getContextPath() + page);
			}
			
			response.sendRedirect(request.getContextPath() + "/ch07/session_login.jsp?message="+result);
		} else if(url.indexOf("logout.do") != -1) {
			// 세션 초기화(전체 삭제)
			// request.getSession().invalidate();
			// 세션 객체 생성
			HttpSession session = request.getSession();
			// 세션값을 모두 초기화시킴
			session.invalidate();
			
			String page = request.getContextPath() + "/ch07/session_login.jsp?"
							+ "message=logout";
			response.sendRedirect(page);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
