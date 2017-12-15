package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import database.model.DonationModel;

/**
 * Servlet implementation class Forum
 */
@WebServlet("/AdminDonations")
public class DonationPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DonationPanel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.append("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>"
+"<html xmlns='http://www.w3.org/1999/xhtml' xml:lang='en' lang='en'>"
+"<head>"
+ "<!-- Favicon -->"
+ "<link rel='icon' href='images/crab.gif' type='image/gif'>"
+ "<link rel='icon' href='images/crab.png' type='image/x-icon'>"
+"<title>PotHub Donations</title>"
+"<meta http-equiv='content-language' content='en-us' />"
+"<meta http-equiv='content-type' content='text/html; charset=utf-8' />"
+"<link rel='stylesheet' type='text/css' media='screen' href='css/banscreen.css' />"
+"<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>"
+"<script src='//cdnjs.cloudflare.com/ajax/libs/tether/1.3.1/js/tether.min.js'></script>"
+"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css' integrity='sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ' crossorigin='anonymous'>"
+"<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js' integrity='sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn' crossorigin='anonymous'></script>"
+"</head>"
+"<body id='babout'>"
+"<div id='header'>"
  +"<h1>Admin Panel</h1>"
+"</div>"
+ "<div id='navigation'>"
+"<ul>"
+"<li>"+"<a href='AdminGeneral'>General</a>"+"</li>"
+"<li>"+"<a href='AdminBans'>Bans & Appeals</a>"+"</li>"
+"<li>"+"<a href='AdminDonations'>Donations</a>"+"</li>"
+"<li>"+"<a href='AdminForumControl'>Forum Control</a>"+"</li>"
+"<li>"+"<a href='AdminReports'>Reports</a>"+"</li>"
+"</ul>"
+"<p id='logout'><a href='AdminLogin'>Logout</a></p>"
+ "</div>"
+"<div id='wrapper'>"
  +"<div id='content-wrapper'>"
    + "<div id='tableWrapper'>"
    +"<table class='table table-striped'>"
    +"<thead>"
        +"<tr>"
            +"<th>Username</th>"
            +"<th>Date</th>"
            +"<th>Amount</th>"
            +"<th>Receipient</th>"
        +"</tr>"
    +"</thead>"
    +"<tbody>");
		Database db;
		ArrayList<DonationModel> donations = new ArrayList<DonationModel>();
		try {
			db = new Database(0);
			donations = db.getDonationModel("SELECT * FROM Donation INNER JOIN DatabaseUser ON Donation.IGN = DatabaseUser.IGN;");
			
			for(DonationModel dono:donations){
				pw.append("<tr>");
				pw.append("<td>"+dono.getiGN()+"</td>");
				pw.append("<td>"+dono.getDonation_Date()+"</td>");
				pw.append("<td>"+dono.getDonation_Amount()+"</td>");
				if(dono.getOnBehalf()!=null){
					pw.append("<td>"+dono.getOnBehalf()+"<a href='HistoryAdminDonations?user="+dono.getiGN()+"'><button>History</button></a>");
				}
				else{
					pw.append("<td><a href='HistoryAdminDonations?user="+dono.getiGN()+"'><button>History</button></a>");
				}
				pw.append("</td>");
				pw.append("</tr>");
			}
			if(donations.size()<10){
				for(int i = 0; i < (10-donations.size());i++){
				pw.append("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		if(donations.size()==0){
			for(int i = 0; i < 10;i++){
				pw.append("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
				}
		}
pw.append("</tbody>"
+"</table>"
+"</div>"
+"<div id='fourbox'>"
	+"<div id='search'>"
	+"<p>Search Username: <div id='textboxes'><input type='text' name='search'>"+"</input></div></p>"
	+"</div>"
	+"<div id='search'>"
	+"<p>Search Recipient: <div id='textboxes'><input type='text' name='search'>"+"</input></div></p>"
	+"</div>"
	+ "<div id='search'>"
	+"<p>Donation Date Between<div id='textboxes'><input type='date' name='banStart1'></input></div></p>"
	+"<p>And <div id='textboxes'><input type='date' name='banStart2'></input></div></p>"
	+"</div>"
+"</div>"
+"<div id='fourbox'>"
	+"<div id='search'>"
	+"<p>Amount between $ <div id='textboxes'><input type='number' name='search'>"+"</input></div></p>"
	+"<p>And $ <div id='textboxes'><input type='number' name='search'>"+"</input></div></p>"
	+"</div>"
+"</div>"
+"<div id='fourbox'>"
+"<div id='search'>"
+"<button><</button><button>></button>"
+"</div>"
+"<div id='search'>"
+"<button id='searchButton'>Search</button>"
+"</div>"
+"</div>"
+"</div>"
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
