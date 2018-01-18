package p2pfood;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import database.model.DatabaseUserModel;
import database.model.PotcastBidModel;
import database.model.PotcastModel;

/**
 * Servlet implementation class Forum
 */
@WebServlet("/p2pdetail")
public class PotcastDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PotcastDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int potcastID=0;
		if (request.getParameter("potcastID") == null) {
			response.sendRedirect("p2plist");
		}
		else{
			potcastID = Integer.parseInt(request.getParameter("potcastID"));
		}

		PrintWriter pw = response.getWriter();
		try {
			Database db = new Database(0);
			
			PotcastModel pm = db.getPotcastByID(potcastID);
			
			DatabaseUserModel dbu = db.getDatabaseUserByIGN(pm.getiGN());

			if (dbu == null){
				response.sendRedirect("p2plist");
			}
			ArrayList<PotcastBidModel> bids = db.getBidsForPotcast(pm.getPotcastID());
			pw.append(
					"<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>"
							+ "<html xmlns='http://www.w3.org/1999/xhtml' xml:lang='en' lang='en'>" + "<head>"
							+ "<meta charset='ISO-8859-1'>" + "<meta name='viewport'"
							+ "	content='width=device-width, initial-scale=1, shrink-to-fit=no'>" + "<!-- Favicon -->"
							+ "<link rel='icon' href='images/crab.gif' type='image/gif'>"
							+ "<link rel='icon' href='images/crab.png' type='image/x-icon'>" + "<!-- Page Title -->"
							+ "<title>Potcast Details</title>" + "<!-- Latest compiled and CSS -->"
							+ " <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>"
							+ "	<script src='https://code.jquery.com/jquery-3.1.1.slim.min.js'></script>"
							+ "	<script src='https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js' integrity='sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb' crossorigin='anonymous'></script>"
							+ "	<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script>"
							+ "<!-- My Own Script -->" + "<script src='script/p2pdetail.js'></script>"
							+ "<!-- Optional theme -->"
							+ "<script src='https://use.fontawesome.com/aff6d7353c.js'></script>"
							+ "<!-- My Style Sheet -->"
							+ "<link rel='stylesheet' type='text/css' href='css/p2pdetail.css' />");

			pw.append("</head>" + "<body id='babout'>" + "<!--  Navigation Bar -->" + "		<div id='header'>"
					+ "<div id='companyTitle'>" + "<h1>PotHub</h1>" + "</div>"
					+ "<div id='profilePicWrapDiv' onmouseover='showProfileDropdown()' onmouseout='hideProfileDropdown()'>"
					+ "<div id='profilePic'>" + "<img src='images/profile.png' height='50' width='50'/>"
					+ "<span id='welcomeSpan'>Welcome, [Placeholder]</span>" + "</div>"
					+ "<div id='profileDropdownDiv'>" + "<a href='html/Profile.html'>Profile</a>"
					+ "<a href='html/LoginPage.html'>Logout</a>" + "</div>" + "</div>" + "</div>"
					+ "	<div id='navigation'>" + "		<div class='container-fluid'>"
					+ "			<ul class='nav navbar-nav'>"
					+ "				<li id='lhome'><a href='html/Forum.html'>Home</a></li>"
					+ "				<li id='lprivatemessage'><a href='html/PrivateMessage.html'>Private Message</a></li>"
					+ "				<li id='levent'><a href='html/EventPage.html'>Event</a></li>"
					+ "				<li class='dropdown'>"
					+ "			        <a class='dropdown-toggle' data-toggle='dropdown' href='#'>Podcast</a>"
					+ "			        <ul class='dropdown-menu'>"
					+ "			          <li><a href='p2plist'>Active PotCasts</a></li>"
					+ "			          <li><a href='p2preg'>Start a PotCast</a></li>"
					+ "			          <li><a href='p2pmy'>My PotCast</a></li>"
					+ "			          <li><a href='p2pjoined'>Joined PotCast</a></li>" + "			        </ul>"
					+ "			      </li>"
					+ "				<li id='ldonate'><a href='html/Donation.html'>Donate</a></li>" + "			</ul>"
					+ "		</div>" + "	</div>" + "<div id='wrapper'>" + "<div id='foodAndMap'>"
					+ "		<button id='reportButton' onclick='showReportables();'><img src='images/flag.png' height=30 width=30></button>"
					+ "<div id='reportOptions'>" + "<ul id='reportList'>"
					+ "<li onclick='hideReportables();'>Vulgar</li>"
					+ "<li onclick='hideReportables();'>Inapropriate Title</li>"
					+ "<li onclick='hideReportables();'>Inapropriate Picture</li>"
					+ "<li onclick='hideReportables();'>Fraudulent Location</li>"
					+ "<li onclick='hideReportables();'>Not food</li>" + "</ul>" + "</div>"
					+ "<img height=400 width =400 src='/PotHub/Image/" + db.getImageByImageID(pm.getPicture())
					+ "' id='foodPicture'>" + "<iframe src='//www.google.com/maps/embed/v1/place?" + "&zoom=15"
					+ "&key=AIzaSyDmftQ7JHdzj22y3wlP01IH_LlTgFQ3JOE" + "&q=Singapore," + dbu.getAddress()
					+ "' id='foodPicture'></iframe>" + "</div>" + "<div id='foodText'>" + "<div id='foodTitle'>" + "<p>"
					+ pm.getTitle() + " -by "+pm.getiGN()+"</p>" + "</div>" + "<div id='foodPrice'>");

			if (pm.getMaxBids() < bids.size()) {
				pw.append("<p>" + bids.get(bids.size() - pm.getMaxBids()).getBidAmount() + "</p>" + "</div>"
						+ "<div id='foodDesc'>" + "<p>" + pm.getDescription() + "</p>" + "</div>"
						+ "<div id='foodBits'>");
				pw.append(pm.getMaxBids() + "/" + pm.getMaxBids() + " Bids, closing ");
			} else {
				pw.append("<p>" + pm.getMinBid() + "</p>" + "</div>" + "<div id='foodDesc'>" + "<p>"
						+ pm.getDescription() + "</p>" + "</div>" + "<div id='foodBits'>");
				pw.append(bids.size() + "/" + pm.getMaxBids() + " Bids, closing ");
			}

			pw.append(timestampToDateTime(pm.getBidStopTime()) + "</p>" + "</div>" + "<div id='foodBits'>"
					+ "<p>Pickup " + timestampToDateTime(pm.getPickupTime()) + "</p>" + "</div>" + "<div id='foodDesc'>"
					+ "<p>" + dbu.getUnitNo() + ", Singapore " + dbu.getAddress() + "</p>" + "</div>"
					+ "<div id='foodBuyers'>" + "<p>Buyers: </p>" + "<ul>");
			for (PotcastBidModel bid : bids) {
				pw.append("<li>" + bid.getiGN() + "</li>");
			}
			pw.append("</ul>" + "</div>" + "<div id='foodDesc'>");

					if(System.currentTimeMillis()<pm.getBidStopTime().getTime()){
					pw.append("<form method='post'><input type='hidden' name='potcastID' value='"+pm.getPotcastID()+"'></input><input type='number' id='bidNumberBox' name='amount'></input>"
					+ "<button>Bid!</button>" 
					+ "</form>");
					}
					
					pw.append("</div>"
					+ "</div>");
							
					if (request.getParameter("response") != null) {
						pw.append("<p>"+request.getParameter("response") + "</p>");
					}
					
					pw.append( "</div>" + "<div id='footer'>"
					+ "<p>Copyright &copy; 2017 &ndash; 2018 PotHub. All rights reserved. </p>" + "<p>We like food</p>"
					+ "<p>" + "<a href='#'>Terms of Service</a> | <a href='#'>Privacy</a> | <a href='#'>Support</a>"
					+ "</p>" + "</div>" + "</body>" + "</html>");
		} catch (SQLException e) {
			response.sendRedirect("p2plist");
		} catch (ClassNotFoundException e) {
			response.sendRedirect("p2plist");
		} catch (Exception e) {
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			Database db = new Database(2);
			if (session == null) {
				response.sendRedirect("Login");
			}

			PotcastBidModel pbm = new PotcastBidModel(Integer.parseInt(request.getParameter("potcastID")),
					(String) session.getAttribute("username"),
					BigDecimal.valueOf(Long.parseLong(request.getParameter("amount"))), "0");

			response.sendRedirect("p2pdetail?id=" + request.getParameter("potcastID") + "&response='" + db.addPotcastBid(pbm)+"'");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("p2pdetail?id=" + request.getParameter("potcastID"));
		}
	}

	private static String timestampToDateTime(Timestamp toChange) {
		Date date = new Date(toChange.getTime());
		DateFormat formatter = new SimpleDateFormat("MM.dd HH:mm");
		return formatter.format(date);
	}
}
