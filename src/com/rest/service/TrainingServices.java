package com.rest.service;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.dbmanager.RequestPojo;
import com.dbmanager.SuggestionPojo;
import com.dbmanager.ToolManager;
import com.dbmanager.UserPojo;
import com.google.gson.Gson;

@Path("/services")
public class TrainingServices {

	/**
	 * validate user details
	 * 
	 * @param inUsername
	 * @param inPassword
	 * @return
	 */

	@POST
	@Path("/validateLogin")
	@Produces(MediaType.APPLICATION_XML)
	public String validateLogin(@QueryParam("username") String inUsername, @QueryParam("password") String inPassword) {
		UserPojo UserPojo = new UserPojo();
		String gson = "";
		try {
			System.out.println(inUsername + "======" + inPassword);
			ToolManager ToolManager = new ToolManager();
			UserPojo = ToolManager.validateLogin(inUsername, inPassword);
			ToolManager = null;
			gson = new Gson().toJson(UserPojo).toString();
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			return gson;
		}
	}

	/**
	 * adding registered users, Type 1 for enrolled to free lancing courses
	 * 
	 * @param inUsername
	 * @param inPassword
	 * @param inEmail
	 * @param inPhone
	 * @return
	 */
	@POST
	@Path("/enrollToFreeLancing")
	@Produces(MediaType.APPLICATION_XML)
	public String enrollToFreeLancing(@QueryParam("username") String inUserName,
			@QueryParam("password") String inPassword, @QueryParam("firstname") String inFirstName,
			@QueryParam("lastname") String inLastName, @QueryParam("usermail") String inEmail,
			@QueryParam("phone") String inPhone, @QueryParam("usercomments") String inUserComments) {
		String value = "";
		try {
			System.out.println(inUserName + "======" + inPassword + "========" + inEmail + "===" + inPhone);
			ToolManager ToolManager = new ToolManager();
			value = ToolManager.addUsers(inUserName, inPassword, inEmail, inPhone, inFirstName, inLastName, 1,
					inUserComments);
			ToolManager = null;
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			return value;
		}
	}

	/**
	 * adding registered users, Type 2 for enrolled to live web courses
	 * 
	 * @param inUsername
	 * @param inPassword
	 * @param inEmail
	 * @param inPhone
	 * @return
	 */
	@POST
	@Path("/enrollToLiveWeb")
	@Produces(MediaType.APPLICATION_XML)
	public String enrollToLiveWeb(@QueryParam("username") String inUserName, @QueryParam("password") String inPassword,
			@QueryParam("firstname") String inFirstName, @QueryParam("lastname") String inLastName,
			@QueryParam("usermail") String inEmail, @QueryParam("phone") String inPhone,
			@QueryParam("usercomments") String inUserComments) {
		String value = "";
		try {
			System.out.println(inUserName + "======" + inPassword + "========" + inEmail + "===" + inPhone);
			ToolManager ToolManager = new ToolManager();
			value = ToolManager.addUsers(inUserName, inPassword, inEmail, inPhone, inFirstName, inLastName, 2,
					inUserComments);
			ToolManager = null;
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			return value;
		}
	}

	/**
	 * 
	 * @param inFirstName
	 * @param inLastName
	 * @param inEmail
	 * @param inPhone
	 * @param inUserComments
	 * @return
	 */
	@POST
	@Path("/demorequest")
	@Produces(MediaType.APPLICATION_XML)
	public String demorequest(@QueryParam("firstname") String inFirstName, @QueryParam("lastname") String inLastName,
			@QueryParam("usermail") String inEmail, @QueryParam("phone") String inPhone,
			@QueryParam("usercomments") String inUserComments) {
		String value = "";
		try {
			System.out.println(inFirstName + "======" + inLastName + "========" + inEmail + "===" + inPhone);
			ToolManager ToolManager = new ToolManager();
			value = ToolManager.demoRequest(inFirstName, inLastName, inEmail, inPhone, inUserComments);
			ToolManager = null;
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			return value;
		}
	}

	/**
	 * 
	 * @param inName
	 * @param inEmail
	 * @param inPhone
	 * @param inUserComments
	 * @return
	 */
	@POST
	@Path("/addSuggestion")
	@Produces(MediaType.APPLICATION_XML)
	public String addSuggestion(@QueryParam("name") String inName, @QueryParam("usermail") String inEmail,
			@QueryParam("phone") String inPhone, @QueryParam("usercomments") String inUserComments) {
		String value = "";
		try {
			System.out.println("addSuggestion=========" + inName + "========" + inEmail + "===" + inPhone);
			ToolManager ToolManager = new ToolManager();
			value = ToolManager.suggestion(inName, inEmail, inPhone, inUserComments);
			ToolManager = null;
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			return value;
		}
	}

	/**
	 * 
	 * @return
	 */
	@POST
	@Path("/getDemoRequetDetails")
	@Produces(MediaType.APPLICATION_XML)
	public String getDemoRequetDetails() {
		String value = "";
		try {
			ToolManager ToolManager = new ToolManager();
			List<RequestPojo> ReturnList = ToolManager.getDemoRequest();
			ToolManager = null;
			value = new Gson().toJson(ReturnList).toString();
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			return value;
		}
	}

	/**
	 * 
	 * @return
	 */
	@POST
	@Path("/getSuggestionDetails")
	@Produces(MediaType.APPLICATION_XML)
	public String getSuggestionDetails() {
		String value = "";
		try {
			ToolManager ToolManager = new ToolManager();
			List<SuggestionPojo> ReturnList = ToolManager.getSuggestionRequest();
			ToolManager = null;
			value = new Gson().toJson(ReturnList).toString();
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			return value;
		}
	}

	/**
	 * 
	 * @return
	 */
	@POST
	@Path("/getFreeLancingDetails")
	@Produces(MediaType.APPLICATION_XML)
	public String getFreeLancingDetails() {
		String value = "";
		try {
			ToolManager ToolManager = new ToolManager();
			List<UserPojo> ReturnList = ToolManager.getFreeLancingDetails();
			ToolManager = null;
			value = new Gson().toJson(ReturnList).toString();
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			return value;
		}
	}

	/**
	 * 
	 * @return
	 */
	@POST
	@Path("/getLiveWevDetails")
	@Produces(MediaType.APPLICATION_XML)
	public String getLiveWevDetails() {
		String value = "";
		try {
			ToolManager ToolManager = new ToolManager();
			List<UserPojo> ReturnList = ToolManager.getLiveWebDetails();
			ToolManager = null;
			value = new Gson().toJson(ReturnList).toString();
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			return value;
		}
	}
}
