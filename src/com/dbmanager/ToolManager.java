package com.dbmanager;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mapping.DemoRequest;
import com.mapping.Suggestion;
import com.mapping.Users;

public class ToolManager {

	public static void main(String args[]) {
		// addRegistration();
	}

	/**
	 * validating logged in user details
	 * 
	 * @param inUserName
	 * @param inPassword
	 * @return
	 */
	public UserPojo validateLogin(String inUserName, String inPassword) {
		SessionFactory SessionFactory = null;
		Session session = null;
		StringBuilder StringQuery = null;
		Query LoginQuery = null;
		UserPojo UserPojo = new UserPojo();
		try {
			SessionFactory = HibernateUtil.getSessionFactory();
			session = SessionFactory.openSession();
			StringQuery = new StringBuilder();
			StringQuery.append("from Users users where 1=1 and users.username = '").append(inUserName)
					.append("' and users.password = '").append(inPassword).append("' and users.isdeleted = 0 ");
			LoginQuery = session.createQuery(StringQuery.toString());
			LoginQuery.setMaxResults(1);
			StringQuery = null;
			List<Users> TempUsers = LoginQuery.list();
			LoginQuery = null;
			if (TempUsers != null && !TempUsers.isEmpty()) {
				Users users = TempUsers.get(0);
				UserPojo = new UserPojo();
				UserPojo.setMid(users.getId());
				UserPojo.setMusername(users.getUsername());
				UserPojo.setMpassword(users.getPassword());
				UserPojo.setMfirstname(users.getFirstname());
				UserPojo.setMemail(users.getEmail());
				UserPojo.setMphonenumber(users.getPhonenumber());
				UserPojo.setMispaid(users.getIspaid());
				UserPojo.setMusertype(users.getUsertype());
				if (users.getUsertype() == 0) {
					UserPojo.setMtype("Requested for Demo");
				} else if (users.getUsertype() == 1) {
					UserPojo.setMtype("Enrolled to Free Lancing Course");
				} else if (users.getUsertype() == 2) {
					UserPojo.setMtype("Live Web Hosting");
				} else {
					UserPojo.setMtype("===");
				}
				users = null;
			}
			TempUsers = null;
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
			session = null;
			return UserPojo;
		}
	}

	/**
	 * To check the entered username is present for the particuler type
	 * 
	 * @param inUserName
	 * @param inType
	 * @param inSession
	 * @return
	 */
	public boolean commonUsersCheck(String inUserName, int inType, Session inSession) {
		boolean bIsPresent = true;
		StringBuilder StringQuery = null;
		Query CheckQuery = null;
		try {
			StringQuery = new StringBuilder();
			StringQuery.append("from Users users where 1=1 and users.username = '").append(inUserName)
					.append("' and users.usertype = ").append(inType).append(" and users.isdeleted = 0 ");
			CheckQuery = inSession.createQuery(StringQuery.toString());
			CheckQuery.setMaxResults(1);
			StringQuery = null;
			List<Users> TempUsers = CheckQuery.list();
			CheckQuery = null;
			if (TempUsers != null && !TempUsers.isEmpty()) {
				bIsPresent = false;
			}
			TempUsers = null;
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			return bIsPresent;
		}
	}

	/**
	 * Common adding method to User table
	 * 
	 * @param inUsername
	 * @param inPassword
	 * @param inEmail
	 * @param inPhone
	 * @param inType
	 * @return
	 */
	public Users commonUsers(String inUserName, String inPassword, String inEmail, String inPhone, String inFirstName,
			String inLastName, int inType, int inPaid, String inUserComments) {
		Users users = new Users();
		try {
			users = new Users();
			users.setFirstname(inFirstName);
			users.setLastname(inLastName);
			users.setEmail(inEmail);
			users.setPhonenumber(inPhone);
			users.setUsername(inUserName);
			users.setPassword(inPassword);
			users.setUsertype(inType);
			users.setUsercomments(inUserComments);
			users.setIsdeleted(0);
			users.setIspaid(inPaid);
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			return users;
		}
	}

	/**
	 * Inserting option for registered users inType = 1, for enrolling to free
	 * lancing course inTpe = 2, for enrolled to live web training
	 * 
	 * @param inUserName
	 * @param inPassword
	 * @param inEmail
	 * @param inPhone
	 * @param inFirstName
	 * @param inLastName
	 * @param inType
	 * @return
	 */
	public String addUsers(String inUserName, String inPassword, String inEmail, String inPhone, String inFirstName,
			String inLastName, int inType, String inUserComments) {
		String ReturnValue = "";
		SessionFactory SessionFactory = null;
		Session session = null;
		StringBuilder StringQuery = null;
		Query LoginQuery = null;
		Users users = null;
		Transaction Tx = null;
		StringBuilder Val = null;
		try {
			SessionFactory = HibernateUtil.getSessionFactory();
			session = SessionFactory.openSession();
			// Verify for the valid users
			boolean isValid = commonUsersCheck(inUserName, inType, session);
			// If the valid users

			if (isValid) {
				Tx = session.beginTransaction();
				users = commonUsers(inUserName, inPassword, inEmail, inPhone, inFirstName, inLastName, inType, 0,
						inUserComments);
				Integer UserId = (Integer) session.save(users);
				users = null;
				Tx.commit();
				Val = new StringBuilder();
				Val.append("Dear ").append(inFirstName).append(" ").append(inLastName)
						.append(" enrolled successfully.");
			} else {
				Val = new StringBuilder();
				Val.append("Dear ").append(inFirstName).append(" ").append(inLastName)
						.append(", the User Name already exists, please enter other user name.");
				Val = null;
			}
			ReturnValue = Val.toString();
			Tx = null;
		} catch (Exception Ex) {
			if (Tx != null) {
				Tx.rollback();
			}
			ReturnValue = "Please try again.";
			Ex.printStackTrace();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
			Tx = null;
			session = null;
			return ReturnValue;
		}
	}

	/**
	 * To add details for request for demo
	 * 
	 * @param inFirstName
	 * @param inLastName
	 * @param inEmail
	 * @param inPhone
	 * @param ininUserComments
	 * @return
	 */
	public String demoRequest(String inFirstName, String inLastName, String inEmail, String inPhone,
			String ininUserComments) {
		String ReturnValue = "";
		SessionFactory SessionFactory = null;
		Session session = null;
		DemoRequest DemoRequest = null;
		Transaction Tx = null;
		StringBuilder Val = null;
		try {
			SessionFactory = HibernateUtil.getSessionFactory();
			session = SessionFactory.openSession();
			Tx = session.beginTransaction();
			DemoRequest = new DemoRequest();
			DemoRequest.setFirstname(inFirstName);
			DemoRequest.setLastname(inLastName);
			DemoRequest.setEmail(inEmail);
			DemoRequest.setPhonenumber(inPhone);
			DemoRequest.setUsercomments(ininUserComments);
			Integer UserId = (Integer) session.save(DemoRequest);
			Val = new StringBuilder();
			Val.append("Dear ").append(inFirstName).append(" ").append(inLastName)
					.append(" thanks for requesting a demo, we will contact you soon.");
			ReturnValue = Val.toString();
			Val = null;
			DemoRequest = null;
			Tx.commit();
			Tx = null;
		} catch (Exception Ex) {
			if (Tx != null) {
				Tx.rollback();
			}
			ReturnValue = "Please try again.";
			Ex.printStackTrace();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
			Tx = null;
			session = null;
			return ReturnValue;
		}
	}

	/**
	 * 
	 * @param inFirstName
	 * @param inLastName
	 * @param inEmail
	 * @param inPhone
	 * @param ininUserComments
	 * @return
	 */
	public String suggestion(String inName, String inEmail, String inPhone, String ininUserComments) {
		String ReturnValue = "";
		SessionFactory SessionFactory = null;
		Session session = null;
		Suggestion Suggestion = null;
		Transaction Tx = null;
		StringBuilder Val = null;
		try {
			SessionFactory = HibernateUtil.getSessionFactory();
			session = SessionFactory.openSession();
			Tx = session.beginTransaction();
			Suggestion = new Suggestion();
			Suggestion.setFirstname(inName);
			Suggestion.setLastname("");
			Suggestion.setEmail(inEmail);
			Suggestion.setPhonenumber(inPhone);
			Suggestion.setUsercomments(ininUserComments);
			Integer UserId = (Integer) session.save(Suggestion);
			Val = new StringBuilder();
			Val.append("Dear ").append(inName).append(" thanks for suggesting us.");
			ReturnValue = Val.toString();
			Val = null;
			Suggestion = null;
			Tx.commit();
			Tx = null;
		} catch (Exception Ex) {
			if (Tx != null) {
				Tx.rollback();
			}
			ReturnValue = "Please try again.";
			Ex.printStackTrace();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
			Tx = null;
			session = null;
			return ReturnValue;
		}
	}

	/**
	 * 
	 * @return
	 */

	public List<RequestPojo> getDemoRequest() {
		String ReturnValue = "";
		SessionFactory SessionFactory = null;
		Session session = null;
		StringBuilder StringQuery = null;
		Query LoginQuery = null;
		StringBuilder Val = null;
		List<RequestPojo> RequestList = new ArrayList<RequestPojo>();
		RequestPojo RequestPojo = null;
		try {
			SessionFactory = HibernateUtil.getSessionFactory();
			session = SessionFactory.openSession();
			StringQuery = new StringBuilder();
			StringQuery.append("from DemoRequest DemoRequest order by DemoRequest.id desc ");
			LoginQuery = session.createQuery(StringQuery.toString());
			StringQuery = null;
			List<DemoRequest> TempRequests = LoginQuery.list();
			LoginQuery = null;
			int nid = 1;
			if (TempRequests != null && !TempRequests.isEmpty()) {
				for (DemoRequest DemoRequests : TempRequests) {
					RequestPojo = new RequestPojo();
					RequestPojo.setMnid(nid++);
					RequestPojo.setMid(DemoRequests.getId());
					RequestPojo.setMfirstname(DemoRequests.getFirstname());
					RequestPojo.setMemail(DemoRequests.getEmail());
					RequestPojo.setMlastname(DemoRequests.getLastname());
					RequestPojo.setMphonenumber(DemoRequests.getPhonenumber());
					String dateString = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a z")
							.format(DemoRequests.getCreatetime());
					RequestPojo.setMrequesttime(dateString);
					RequestPojo.setMusercomments(DemoRequests.getUsercomments());
					RequestPojo.setMacceptorcomments(DemoRequests.getAcceptorcomments());
					RequestList.add(RequestPojo);
					RequestPojo = null;
				}
			}
			TempRequests = null;
		} catch (Exception Ex) {
			ReturnValue = "Please try again.";
			Ex.printStackTrace();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
			session = null;
			return RequestList;
		}
	}

	/**
	 * 
	 * @return
	 */
	public List<SuggestionPojo> getSuggestionRequest() {
		String ReturnValue = "";
		SessionFactory SessionFactory = null;
		Session session = null;
		StringBuilder StringQuery = null;
		Query LoginQuery = null;
		StringBuilder Val = null;
		List<SuggestionPojo> RequestList = new ArrayList<SuggestionPojo>();
		SuggestionPojo SuggestionPojo = null;
		try {
			SessionFactory = HibernateUtil.getSessionFactory();
			session = SessionFactory.openSession();
			StringQuery = new StringBuilder();
			StringQuery.append("from Suggestion Suggestion order by Suggestion.id desc ");
			LoginQuery = session.createQuery(StringQuery.toString());
			StringQuery = null;
			List<Suggestion> TempSuggestions = LoginQuery.list();
			LoginQuery = null;
			int nid = 1;
			if (TempSuggestions != null && !TempSuggestions.isEmpty()) {
				for (Suggestion Suggestion : TempSuggestions) {
					SuggestionPojo = new SuggestionPojo();
					SuggestionPojo.setMnid(nid++);
					SuggestionPojo.setMid(Suggestion.getId());
					SuggestionPojo.setMfirstname(Suggestion.getFirstname());
					SuggestionPojo.setMemail(Suggestion.getEmail());
					SuggestionPojo.setMlastname(Suggestion.getLastname());
					SuggestionPojo.setMphonenumber(Suggestion.getPhonenumber());
					String dateString = new SimpleDateFormat("dd-MM-yyyy  hh:mm:ss a z").format(Suggestion.getCreatetime());
					SuggestionPojo.setMcreatetime(dateString);
					SuggestionPojo.setMusercomments(Suggestion.getUsercomments());
					SuggestionPojo.setMacceptorcomments(Suggestion.getAcceptorcomments());
					RequestList.add(SuggestionPojo);
					SuggestionPojo = null;
				}
			}
			TempSuggestions = null;
		} catch (Exception Ex) {
			ReturnValue = "Please try again.";
			Ex.printStackTrace();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
			session = null;
			return RequestList;
		}
	}

	/**
	 * 
	 * @return
	 */

	public List<UserPojo> getFreeLancingDetails() {
		String ReturnValue = "";
		SessionFactory SessionFactory = null;
		Session session = null;
		StringBuilder StringQuery = null;
		Query LoginQuery = null;
		StringBuilder Val = null;
		List<UserPojo> RequestList = new ArrayList<UserPojo>();
		UserPojo UserPojo = null;
		try {
			SessionFactory = HibernateUtil.getSessionFactory();
			session = SessionFactory.openSession();
			StringQuery = new StringBuilder();
			StringQuery.append("from Users Users where Users.usertype = 1 order by Users.id desc ");
			LoginQuery = session.createQuery(StringQuery.toString());
			StringQuery = null;
			List<Users> TempUsers = LoginQuery.list();
			LoginQuery = null;
			int nid = 1;
			if (TempUsers != null && !TempUsers.isEmpty()) {
				for (Users Users : TempUsers) {
					UserPojo = new UserPojo();
					UserPojo.setMnid(nid++);
					UserPojo.setMid(Users.getId());
					UserPojo.setMfirstname(Users.getFirstname());
					UserPojo.setMemail(Users.getEmail());
					UserPojo.setMlastname(Users.getLastname());
					UserPojo.setMphonenumber(Users.getPhonenumber());
					String dateString = new SimpleDateFormat("dd-MM-yyyy  hh:mm:ss a z").format(Users.getCreatetime());
					UserPojo.setMcreatetime(dateString);
					UserPojo.setMusercomments(Users.getUsercomments());
					UserPojo.setMacceptorcomments(Users.getAcceptorcomments());
					RequestList.add(UserPojo);
					UserPojo = null;
				}
			}
			TempUsers = null;
		} catch (Exception Ex) {
			ReturnValue = "Please try again.";
			Ex.printStackTrace();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
			session = null;
			return RequestList;
		}
	}

	/**
	 * 
	 * @return
	 */
	public List<UserPojo> getLiveWebDetails() {
		String ReturnValue = "";
		SessionFactory SessionFactory = null;
		Session session = null;
		StringBuilder StringQuery = null;
		Query LoginQuery = null;
		StringBuilder Val = null;
		List<UserPojo> RequestList = new ArrayList<UserPojo>();
		UserPojo UserPojo = null;
		try {
			SessionFactory = HibernateUtil.getSessionFactory();
			session = SessionFactory.openSession();
			StringQuery = new StringBuilder();
			StringQuery.append("from Users Users where Users.usertype = 2 order by Users.id desc ");
			LoginQuery = session.createQuery(StringQuery.toString());
			StringQuery = null;
			List<Users> TempUsers = LoginQuery.list();
			LoginQuery = null;
			int nid = 1;
			if (TempUsers != null && !TempUsers.isEmpty()) {
				for (Users Users : TempUsers) {
					UserPojo = new UserPojo();
					UserPojo.setMnid(nid++);
					UserPojo.setMid(Users.getId());
					UserPojo.setMfirstname(Users.getFirstname());
					UserPojo.setMemail(Users.getEmail());
					UserPojo.setMlastname(Users.getLastname());
					UserPojo.setMphonenumber(Users.getPhonenumber());
					String dateString = new SimpleDateFormat("dd-MM-yyyy  hh:mm:ss a z").format(Users.getCreatetime());
					UserPojo.setMcreatetime(dateString);
					UserPojo.setMusercomments(Users.getUsercomments());
					UserPojo.setMacceptorcomments(Users.getAcceptorcomments());
					RequestList.add(UserPojo);
					UserPojo = null;
				}
			}
			TempUsers = null;
		} catch (Exception Ex) {
			ReturnValue = "Please try again.";
			Ex.printStackTrace();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
			session = null;
			return RequestList;
		}
	}
}
