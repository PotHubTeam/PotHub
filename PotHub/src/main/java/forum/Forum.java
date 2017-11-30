package forum;

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
@WebServlet("/Forum")
public class Forum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println(
				"<!DOCTYPE html>"
						+ "<html>"
						+ "<head>"
						+ "<meta charset='ISO-8859-1'>"
						+ "<meta name='viewport'"
						+ "	content='width=device-width, initial-scale=1, shrink-to-fit=no'>"
						+ "<!-- Page Title -->"
						+ "<title>Forum</title>"
						+ "<!-- Latest compiled and CSS -->"
						+ "<link rel='stylesheet'"
						+ "	href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'"
						+ "	integrity='sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ'"
						+ "	crossorigin='anonymous'>"
						+ "<!-- Optional theme -->"
						+ "<script src='https://use.fontawesome.com/aff6d7353c.js'></script>"
						+ "<!-- My Own Script -->"
						+ "<!-- <script src='script/'></script> -->"
						+ "<!-- My Style Sheet -->"
						+ "<link rel='stylesheet' type='text/css' href='css/Forum.css' />"
						+ "</head>"
						+ "<body>"
						+ "	<!--  Navigation Bar -->"
						+ "	<div id='header'>"
						+ "		<div id='companyTitle'>"
						+ "			<h1>PotHub</h1>"
						+ "		</div>"
						+ "		<div id='profilePic'>"
						+ "			<img src='images/cat.png' height='50' width='50' />"
						+ "		</div>"
						+ "	</div>"
						+ "	<div id='navigation'>"
						+ "		<ul>"
						+ "			<li id='lhome'><a href='#00'>Home</a></li>"
						+ "			<li id='lprivatemessage'><a href='#01'>Private Message</a></li>"
						+ "			<li id='levent'><a href='#02'>Event</a></li>"
						+ "			<li id='lpeer2peer'><a href='#03'>Peer-2-Peer</a></li>"
						+ "			<li id='ldonate'><a href='#04'>Donate</a></li>"
						+ "		</ul>"
						+ "	</div>"
						+ "	<div id='wrapper'>"
						+ "		<div id='content-wrapper'>"
						+ "			<div id='content'>"
						+ "				<div id='wholecomments'>"
						+ "					<div id='test1'>"
						+ "						<div class='voting'>"
						+ "							<p style='text-align: center;'>"
						+ "								<img src='images/up.png' height='20' width='60' />"
						+ "							</p>"
						+ "							<p style='text-align: center;'>5</p>"
						+ "							<p style='text-align: center;'>"
						+ "								<img src='images/down.png' height='20' width='60' />"
						+ "							</p>"
						+ "						</div>"
						+ "						<div class='iconpic'>"
						+ "							<img src='images/MAC.png' height='80' width='80' />"
						+ "						</div>"
						+ "						<div class='info'>"
						+ "							<div id='title'>"
						+ "								<h2 style='color: blue'>Why is MacDonalds Healthy</h2>"
						+ "							</div>"
						+ "							<div id='subDescription'>"
						+ "								<p>Between Mc Spicy and Mc Salad, which would you choose for"
						+ "									a healthy meal and more</p>"
						+ "							</div>"
						+ "							<div id='commentscount'>"
						+ "								<p style='font-family:' Comic SansMS', cursive, sans-serif;'>31"
						+ "									comments"
						+ "								<p>"
						+ "							</div>"
						+ "							<div id='reporting'>"
						+ "								<p>"
						+ "									<a href='#' style='margin-right: 2%;'>Reply</a><a href='#'>Report</a>"
						+ "								</p>"
						+ "							</div>"
						+ "						</div>"
						+ "						<div class='author'>"
						+ "							<div id='profilepic'>"
						+ "								<img src='images/tzuyu.jpg' height='70' width='70' />"
						+ "							</div>"
						+ "							<div id='name'>Chou Tzu Yu</div>"
						+ "							<div id='date'>5 hours ago</div>"
						+ "						</div>"
						+ "					</div>"
						+ "					<div id='test2'>"
						+ "						<div class='voting'>"
						+ "							<p style='text-align: center;'>"
						+ "								<img src='images/up.png' height='20' width='60' />"
						+ "							</p>"
						+ "							<p style='text-align: center;'>19</p>"
						+ "							<p style='text-align: center;'>"
						+ "								<img src='images/down.png' height='20' width='60' />"
						+ "							</p>"
						+ "						</div>"
						+ "						<div class='iconpic'>"
						+ "							<img src='images/kfc.png' height='80' width='80' />"
						+ "						</div>"
						+ "						<div class='info'>"
						+ "							<div id='title'>"
						+ "								<h2 style='color: blue'>KFC 1for1 Fried Chicken</h2>"
						+ "							</div>"
						+ "							<div id='subDescription'>"
						+ "								<p>What a rare chance for fat people to become fatter</p>"
						+ "							</div>"
						+ "							<div id='commentscount'>"
						+ "								<p style='font-family:' Comic SansMS', cursive, sans-serif;'>1292"
						+ "									comments"
						+ "								<p>"
						+ "							</div>"
						+ "							<div id='reporting'>"
						+ "								<p>"
						+ "									<a href='#' style='margin-right: 2%;'>Reply</a><a href='#'>Report</a>"
						+ "								</p>"
						+ "							</div>"
						+ "						</div>"
						+ "						<div class='author'>"
						+ "							<div id='profilepic'>"
						+ "								<img src='images/eric chou1.jpg' height='70' width='70' />"
						+ "							</div>"
						+ "							<div id='name'>Eric Chou</div>"
						+ "							<div id='date'>10 hours ago</div>"
						+ "						</div>"
						+ "					</div>"
						+ "					<div id='test3'>"
						+ "						<div class='voting'>"
						+ "							<p style='text-align: center;'>"
						+ "								<img src='images/up.png' height='20' width='60' />"
						+ "							</p>"
						+ "							<p style='text-align: center;'>1920292</p>"
						+ "							<p style='text-align: center;'>"
						+ "								<img src='images/down.png' height='20' width='60' />"
						+ "							</p>"
						+ "						</div>"
						+ "						<div class='iconpic'>"
						+ "							<img src='images/crab.jpg' height='80' width='80' />"
						+ "						</div>"
						+ "						<div class='info'>"
						+ "							<div id='title'>"
						+ "								<h2 style='color: blue'>WOOOOO Crabs I LOVE CRABS</h2>"
						+ "							</div>"
						+ "							<div id='subDescription'>"
						+ "								<p>Where to get crabs in Singapore that costs below $10,"
						+ "									find out more here!</p>"
						+ "							</div>"
						+ "							<div id='commentscount'>"
						+ "								<p style='font-family:' Comic SansMS', cursive, sans-serif;'>12231"
						+ "									comments"
						+ "								<p>"
						+ "							</div>"
						+ "							<div id='reporting'>"
						+ "								<p>"
						+ "									<a href='#' style='margin-right: 2%;'>Reply</a><a href='#'>Report</a>"
						+ "								</p>"
						+ "							</div>"
						+ "						</div>"
						+ "						<div class='author'>"
						+ "							<div id='profilepic'>"
						+ "								<img src='images/tzuyu.jpg' height='70' width='70' />"
						+ "							</div>"
						+ "							<div id='name'>Chou Tzu Yu</div>"
						+ "							<div id='date'>A year ago</div>"
						+ "						</div>"
						+ "					</div>"
						+ "				</div>"
						+ "			</div>"
						+ "			<div id='content'></div>"
						+ "		</div>"
						+ "	</div>"
						+ "	<div id='footer'>"
						+ "		<p>Copyright &copy; 2017 &ndash; 2018 PotHub. All rights reserved.</p>"
						+ "		<p>We like food</p>"
						+ "		<p>"
						+ "			<a href='#'>Terms of Service</a> | <a href='#'>Privacy</a> | <a"
						+ "				href='#'>Support</a>"
						+ "		</p>"
						+ "	</div>"
						+ "	<script src='https://code.jquery.com/jquery-3.1.1.slim.min.js'"
						+ "		integrity='sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n'"
						+ "		crossorigin='anonymous'></script>"
						+ "	<script"
						+ "		src='https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js'"
						+ "		integrity='sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb'"
						+ "		crossorigin='anonymous'></script>"
						+ "	<script"
						+ "		src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'"
						+ "		integrity='sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn'"
						+ "		crossorigin='anonymous'></script>"
						+ "</body>"
						+ "</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
