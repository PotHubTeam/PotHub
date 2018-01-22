package forum;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import database.model.CommentModel;
import database.model.FileTableModel;
import database.model.ForumPostModel;
import database.model.ForumVoteModel;

/**
 * Servlet implementation class Forum
 */
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = "";
		int canvote = 1;
		HttpSession session = request.getSession(false);
		if (session != null) {
			username = (String)session.getAttribute("username");
		}
		else {
			response.sendRedirect("Login");
		}
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
						+ "<script src='script/forum.js'></script>"
						+ "<!-- My Style Sheet -->"
						+ "<link rel='stylesheet' type='text/css' href='css/Forum.css' />"
						+ "</head>"
						+ "<body>"
						+ "	<!--  Navigation Bar -->"
						+ "	<div id='header'>"
						+ "		<div id='companyTitle'>"
						+ "			<h1>PotHub</h1>"
						+ "		</div>"
						
						+ "		<div id='profilePicWrapDiv' onmouseover='showProfileDropdown()' onmouseout='hideProfileDropdown()'>"
						+ "			<div id='profilePic'>"
						+ "				<img src='images/profile.png' height='50' width='50'/>"
						+ "				<span id='welcomeSpan'>Welcome, [Placeholder]</span>"
						+ "			</div>"
						+ "			<div id='profileDropdownDiv'>"
						+ "				<a href='Profile'>Profile</a>"
						+ "				<a href='LoginPage'>Logout</a>"
						+ "			</div>"
						+ "		</div>"	
						
						+ "	</div>"
						+ "	<div id='navigation'>"
						+ "		<div class='container-fluid'>"
						+ "			<ul class='nav navbar-nav'>"
						+ "				<li id='lhome'><a href='Forum'>Home</a></li>"
						+ "				<li id='lprivatemessage'><a href='PrivateMesage'>Private Message</a></li>"
						+ "				<li id='levent'><a href='EventPage'>Event</a></li>"
						+ "				<li class='dropdown'>"
						+ "			        <a class='dropdown-toggle' data-toggle='dropdown' href='#'>Podcast</a>"
						+ "			        <ul class='dropdown-menu'>"
						+ "			          <li><a href='#'>Active PotCasts</a></li>"
						+ "			          <li><a href='#'>Start a PotCast</a></li>"
						+ "			          <li><a href='#'>My PotCast</a></li>"
						+ "			          <li><a href='#'>Joined PotCast</a></li>"
						+ "			        </ul>"
						+ "			      </li>"
						+ "				<li id='ldonate'><a href='Donation'>Donate</a></li>"
						+ "			</ul>"
						+ "		</div>"
						+ "	</div>"
						+ "	<div id='wrapper'>"
						+ "		<div id='content-wrapper'>"
						+ "			<div id='content'>"
						+ "				<div id='personalinfo' style='background:url('../images/foodss.jpg'); height:20%;'>"
						+ "				<p style='font-size:50px; text-align:center;'>"
						+ "				Welcome " + username + ""
						+ "				</p>"
						+ "				<p style='text-align:right; width:98%; padding-left:2%;'>"
						+ "					<button style='font-size:25px; cursor:pointer; border:solid; border-radius: 20px 20px 2px 2px; float:left; background-color:white;' class='btn'>Forum</button>"
						+ "					<button style='font-size:25px; cursor:pointer; border:solid; border-radius: 20px 20px 2px 2px; float:left;' class='btn' onclick='gosub()'>My Subscription</button>"
						+ "					<button style='font-size:25px; cursor:pointer; border-color:blue; border-radius: 5px; background-color:red; border:solid;' id='creatingnew' onclick='gonext()' class='btn'>Create New Thread</button>		"
						+ "				</p>"
						+ "				</div>"
						+ "				<div id='wholecomments'>"
						);
						
						
						
						
						try {
							Database dbms = new Database(2);
							ArrayList<ForumPostModel> fa = dbms.getForumModel();
							ArrayList<CommentModel> cmm = dbms.getCommentModel();
							FileTableModel ftm = new FileTableModel();
							
							for(ForumPostModel qw: fa){	
								int count = 0;
								for(CommentModel df: cmm) {
									if(qw.getPostID() == df.getPostID()) {
										count ++;
									}
								}
								
								
								
								ArrayList<ForumVoteModel> fvm = new ArrayList<ForumVoteModel>();
								fvm = dbms.getForumVoteModel();
								for(ForumVoteModel f:fvm) {
									if(f.getPostID() == qw.getPostID()) {
										if(f.getiGN().equals(username)) {
											canvote = 0;
										}
										else {
											canvote = 1;
										}
									}
									else {
										canvote = 1;
									}
								}
								out.println(
						  
						  "					<div class='cb'>" );
						if(canvote == 1) {
							out.println(	
						  "						<div class='voting'>"
						+ "						<form id='gonext' action='Forum' method='Post'>"	
						+ "						<input type='hidden' name='hisname' value=' " + username +"'>"
						+ "						<input type='hidden' name='hisid' value=' " + qw.getPostID() + "'>"
						+ "							<p onclick='upfirst()' style='text-align: center;'>"
						+ "								<i class='fa fa-arrow-up fa-3x' aria-hidden='true'></i>"
						+ "							</p>"
						+ "							<p id='firstcount' style='text-align: center;'>" + qw.getUpvotes() + "</p>"
						+ "							<p onclick='downfirst()' style='text-align: center;'>"
						+ "								<i class='fa fa-arrow-down fa-3x' aria-hidden='true'></i>"
						+ "							</p>"		
						+ "						</form>"
						+ "						</div>"
						+ "						<div class='iconpic'>"
						);
							}
						else if(canvote == 0) {
							out.println("<div class='voting'>"
									+ "<p style='text-align: center;'>"
									+ "<i class='fa fa-arrow-up fa-3x' aria-hidden='true'></i>"
									+ "</p>"
									+ "<p id='firstcount' style='text-align: center;'>" + qw.getUpvotes() + "</p>"
									+ "<p style='text-align: center;'>"
									+ "<i class='fa fa-arrow-down fa-3x' aria-hidden='true'></i>"
									+ "</p>"
									+"</div>"
									+"<div class='iconpic'>"
									);
						}
						
						if(qw.getPicture() == 1) {
							out.println("<img src='images/MAC.png' height='80' width='80' />");
						}
						else {
						ftm = dbms.getFileTableByFileID(qw.getPicture());
						out.println("<img src='/PotHub/Video/" +  ftm.getFileName() + "' height='80' width='80' />");
						}
						
						
						//+ "							<img src='images/MAC.png' height='80' width='80' />"
						
						
						
						out.println(
						  "						</div>"
						+ "						<div class='info'>"
						+ "							<div class='title'>"
						+ "								<h2 style='color: blue' onclick='location.href='discussion';'>" + qw.getThread() + "</h2>"
						+ "							</div>"
						+ "							<div class='subDescription'>"
						+ "								<p>" + qw.getDescription() + "</p>"
						+ "							</div>"
						+ "							<div class='commentscount'>"
						+ "								<p onclick='location.href='discussion';' style='font-family:' Comic SansMS', cursive, sans-serif;'>" + count +""
						+ "									<i class=\'fa fa-comments-o\' style=\'font-size:24px\'></i>"
						+ "								<p>"
						+ "							</div>"
						+ "							<div class='reporting'>"
						+ "								<p>"
						+ "									<form action='discussion'><button type='submit' style='cursor:pointer' class='btn'>Reply</button>"
						+ "									<input type='hidden' name='ForumPostID' value='" + qw.getPostID() + "'></input></form>"
						+ "									<a onclick='showsth()' href='#reports' style='margin-right: 2%;'>Report</a><a href='#' >Share</a>"
						+ "								</p>"
						+ "							</div>"
						+ "						</div>"
						+ "						<div class='author'>"
						+ "							<div class='profilepic'>"
						+ "								<img src='images/tzuyu.jpg' height='70' width='70' />"
						+ "							</div>"
						+ "							<div id='name'>" + qw.getiGN() + "</div>"
						+ "							<div id='date'>" + qw.getDate() + "</div>"
						+ "						</div>"
						+ "					</div>");
							}
						}
					 catch (SQLException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
						
						
						
						
						
						
						
						
						out.println(
						  "				</div>"
						+ "			</div>"
						+ "			<div id='overlay'>"
						+ "				<div id='backgd'>"
						+ "					<p>May we know your reason for reporting?</p>"
						+ "					<form>"
						+ "				    	<div class='checkbox'>"
						+ "				      		<label><input type='checkbox' value=''>This post contains spams</label>"
						+ "				   		 </div>"
						+ "				    	<div class='checkbox'>"
						+ "				     		<label><input type='checkbox' value=''>This post contains abusive or harmful words</label>"
						+ "				    	</div>"
						+ "				    	<div class='checkbox'>"
						+ "				      		<label><input type='checkbox' value=''>This post is not relevant to food</label>"
						+ "				    	</div>"
						+ "				    	<div class='checkbox'>"
						+ "				      		<label><input type='checkbox' value=''>This post does not contains wrong informations</label>"
						+ "				   		 </div>"
						+ "				   		 <div class='form-group'>"
						+ "	     					 <label for='Other Comment'>Comment:</label>"
						+ "	      					<textarea class='form-control' rows='5' id='comment'></textarea>"
						+ "	    				</div>"
						+ "	    				<div>"
						+ "	    					<button type='button'  onclick='success()' class='btn'>Submit</button>"
						+ "	    					<button type='button' onclick='cancell()' class='btn'>Cancel</button>"
						+ "	    				</div>"
						+ "				  	</form>"
						+ "				  </div>"
						+ "			</div>"
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
						+ "</html>"
						);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String ign = request.getParameter("hisname");
		String pos = request.getParameter("hisid");
		int pid = Integer.valueOf(pos);
		System.out.println(ign + pid);
		//int pid = Integer.parseInt(pos);
		}

}
