package com.kosta.sample.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BoardServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=euc-kr");
		String pagecode = request.getParameter("pagecode");
		
		if(pagecode.endsWith("B001"))
		{
			BoardDAO bd = new BoardDAO();
			ArrayList<BoardVO> list = bd.boardSelect();
			//테이블jsp에 ?뒤에 uid (&)그리고 upw의 값을 전송 
			//response.sendRedirect("tables.jsp?uid=kim&upw=123");
			//객체 전송에 사용
			request.setAttribute("KEY_BOARDLIST",list);
			RequestDispatcher rd =  request.getRequestDispatcher("tables.jsp");
			rd.forward(request, response);
		}
		else if(pagecode.endsWith("B002"))
		{
			int seq = Integer.parseInt(request.getParameter("seq"));
			BoardDAO bd = new BoardDAO();
			ArrayList<BoardVO> list = bd.boardReplySelect(seq);
			for(ReplyVO rv : list.get(0).getReplies())
			System.out.println(rv.getReply());
			request.setAttribute("KEY_BOARDLIST",list);
			RequestDispatcher rd =  request.getRequestDispatcher("tables_detail.jsp");
			rd.forward(request, response);
		}
		else if(pagecode.endsWith("B005"))//댓글삭제
		{
			BoardDAO bd = new BoardDAO();
			int rseq= Integer.parseInt(request.getParameter("rseq"));
			int deleteRows = bd.replyDelete(rseq);
			response.sendRedirect(request.getContextPath()+"/BoardServlet?pagecode=B002&seq="+request.getParameter("seq"));
			
		}
		else response.sendRedirect("500.html");
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=euc-kr");
		String pagecode = request.getParameter("pagecode");
		BoardDAO dao = new BoardDAO();
		if(pagecode.endsWith("B003"))
		{
			BoardVO vo = new BoardVO(request.getParameter("contents"),
					request.getParameter("title"),
					Integer.parseInt(request.getParameter("seq")),
					request.getParameter("regid"),
					request.getParameter("regdate")
					);
			int a = dao.boardUpdate(vo);
			if(a >= 1)
			{
				String url = request.getContextPath()+"/BoardServlet?seq="+request.getParameter("seq")+"&pagecode=B002";
				response.sendRedirect(url);
			}
			else response.sendRedirect("500.html");
		}
		else if(pagecode.endsWith("B004"))
		{
			System.out.println("삭제");
			int a =  dao.boardDelete(Integer.parseInt(request.getParameter("seq")));
			if(a >=1)
			{
				response.sendRedirect(request.getContextPath()+"/BoardServlet?pagecode=B001");
			}
			else response.sendRedirect("500.html");
		}
		else if(pagecode.endsWith("B006"))//댓글 등록
		{
			if(request.getParameter("replyContents").equals("")) {response.sendRedirect(request.getContextPath()+"/BoardServlet?pagecode=B002&seq="+request.getParameter("seq"));}
			else {
			dao.replyInsert(Integer.parseInt(request.getParameter("seq")),request.getParameter("replyContents"));
			response.sendRedirect(request.getContextPath()+"/BoardServlet?pagecode=B002&seq="+request.getParameter("seq"));}
		}
		response.getWriter().append("post").append(request.getContextPath());

	}

}
