package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forum
 */
@WebServlet("/Bans")
public class BanPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BanPanel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.append("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>"
+"<html xmlns='http://www.w3.org/1999/xhtml' xml:lang='en' lang='en'>"
+"<head>"
+"<title>PotHub Admin+</title>"
+"<meta http-equiv='content-language' content='en-us' />"
+"<meta http-equiv='content-type' content='text/html; charset=utf-8' />"
+"<link rel='stylesheet' type='text/css' media='screen' href='css/banscreen.css' />"
+"</head>"
+"<body id='babout'>"
+"<div id='header'>"
  +"<a href='adminpanel.html'>"
  +"<h1>Admin Panel</h1>"
+"</a>"
+"</div>"
+"<div id='navigation'>"
  +"<ul>"
    +"<li>"+"<a href='Admin'>User Control</a>"+"</li>"
    +"<li>"+"<a href='Bans'>Bans</a>"+"</li>"
    +"<li>"+"<a href='#02'>Appeals</a>"+"</li>"
    +"<li>"+"<a href='#03'>Donation History</a>"+"</li>"
    +"<li>"+"<a href='#04'>Forum Control</a>"+"</li>"
  +"</ul>"
+"</div>"
+"<div id='wrapper'>"
  +"<div id='content-wrapper'>"
    +"<p>Search</p>"
    +"<input type='text' name='search'>"+"</input>"
    +"<table class='scroll'>"
    +"<thead>"
        +"<tr>"
            +"<th>Username</th>"
            +"<th>Ban Reason</th>"
            +"<th>Ban Date</th>"
            +"<th>Ban End</th>"
            +"<th>Ban By</th>"
        +"</tr>"
    +"</thead>"
    +"<tbody>"
        +"<tr>"
            +"<td>Matt</td>"
            +"<td>Being Too Cool</td>"
            +"<td>30/10/2017 20:15</td>"
            +"<td>30/11/2017 20:15</td>"
            +"<td>Evil Matt<button>Pardon</button>"
            +"<button>Perm Ban</button>"+"<button>History</button>"+"</td>"
        +"</tr>"
        +"<tr>"
            +"<td>Matt</td>"
            +"<td>Being Too Cool</td>"
            +"<td>30/10/2017 20:15</td>"
            +"<td>30/11/2017 20:15</td>"
            +"<td>Evil Matt<button>Pardon</button>"
            +"<button>Perm Ban</button>"+"<button>History</button>"+"</td>"
        +"</tr>"
        +"<tr>"
            +"<td>Matt</td>"
            +"<td>Being Too Cool</td>"
            +"<td>30/10/2017 20:15</td>"
            +"<td>30/11/2017 20:15</td>"
            +"<td>Evil Matt<button>Pardon</button>"
            +"<button>Perm Ban</button>"+"<button>History</button>"+"</td>"
        +"</tr>"
        +"<tr>"
            +"<td>Matt</td>"
            +"<td>Being Too Cool</td>"
            +"<td>30/10/2017 20:15</td>"
            +"<td>30/11/2017 20:15</td>"
            +"<td>Evil Matt<button>Pardon</button>"
            +"<button>Perm Ban</button>"+"<button>History</button>"+"</td>"
        +"</tr>"
        +"<tr>"
            +"<td>Matt</td>"
            +"<td>Being Too Cool</td>"
            +"<td>30/10/2017 20:15</td>"
            +"<td>30/11/2017 20:15</td>"
            +"<td>Evil Matt<button>Pardon</button>"
            +"<button>Perm Ban</button>"+"<button>History</button>"+"</td>"
        +"</tr>"
        +"<tr>"
            +"<td>Matt</td>"
            +"<td>Being Too Cool</td>"
            +"<td>30/10/2017 20:15</td>"
            +"<td>30/11/2017 20:15</td>"
            +"<td>Evil Matt<button>Pardon</button>"
            +"<button>Perm Ban</button>"+"<button>History</button>"+"</td>"
        +"</tr>"
        +"<tr>"
            +"<td>Matt</td>"
            +"<td>Being Too Cool</td>"
            +"<td>30/10/2017 20:15</td>"
            +"<td>30/11/2017 20:15</td>"
            +"<td>Evil Matt<button>Pardon</button>"
            +"<button>Perm Ban</button>"+"<button>History</button>"+"</td>"
        +"</tr>"
        +"<tr>"
            +"<td>Matt</td>"
            +"<td>Being Too Cool</td>"
            +"<td>30/10/2017 20:15</td>"
            +"<td>30/11/2017 20:15</td>"
            +"<td>Evil Matt<button>Pardon</button>"
            +"<button>Perm Ban</button>"+"<button>History</button>"+"</td>"
        +"</tr>"
        +"<tr>"
            +"<td>Matt</td>"
            +"<td>Being Too Cool</td>"
            +"<td>30/10/2017 20:15</td>"
            +"<td>30/11/2017 20:15</td>"
            +"<td>Evil Matt<button>Pardon</button>"
            +"<button>Perm Ban</button>"+"<button>History</button>"+"</td>"
        +"</tr>"
        +"<tr>"
            +"<td>Matt</td>"
            +"<td>Being Too Cool</td>"
            +"<td>30/10/2017 20:15</td>"
            +"<td>30/11/2017 20:15</td>"
            +"<td>Evil Matt<button>Pardon</button>"
            +"<button>Perm Ban</button>"+"<button>History</button>"+"</td>"
        +"</tr>"
    +"</tbody>"
+"</table>"
+"</div>"
  +"</div>"
+"<div id='footer'>"
  +"<p>Copyright &copy; 2017 &ndash; 2018 PotHub. All rights reserved. </p>"
  +"<p>We like food</p>"
  +"<p>" +"<a href='#'>Terms of Service</a> | <a href='#'>Privacy</a> | <a href='#'>Support</a>"+"</p>"
+"</div>"
+"</body>"
+"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
