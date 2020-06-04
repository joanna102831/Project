package project;

import javax.servlet.http.HttpSession;

public class Transfer {
//	private String id=null;
//	private String pw=null;
//	private String user=null;
//	private String gender=null;
//	private String birth=null;
//	private String tel=null;
//	private String email=null;
//	public Transfer(String id,String pw,String user,String gender,String birth,String tel,String email){
//		this.id=id;
//		this.pw=pw;
//		this.user=user;
//		this.gender=gender;
//		this.birth=birth;
//		this.tel=tel;
//		this.email=email;
//		
//	}
	
	public void getTransfer(HttpSession session){		
		String id=(String) session.getAttribute("id");
		String pw=(String) session.getAttribute("pw");
		String use=(String) session.getAttribute("user");
		String gen=(String) session.getAttribute("gender");
		String birth=(String) session.getAttribute("birth");
		String email=(String) session.getAttribute("email");
		String tel=(String) session.getAttribute("tel");
		
	}
	public void setTransfer(HttpSession session,String id,String pw,String user,String gender,String birth,String tel,String email){
	
		
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		session.setAttribute("user", user);
		session.setAttribute("gender", gender);
		session.setAttribute("email", email);
		session.setAttribute("birth", birth);
		session.setAttribute("tel", tel);
		
	}

}
