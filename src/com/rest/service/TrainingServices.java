package com.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
	public String validateLogin(@QueryParam("username") String inUsername,
			@QueryParam("password") String inPassword) {
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
			@QueryParam("lastname") String inLastName, @QueryParam("email") String inEmail,
			@QueryParam("phone") String inPhone) {
		String value = "";
		try {
			System.out.println(inUserName + "======" + inPassword + "========" + inEmail + "===" + inPhone);
			ToolManager ToolManager = new ToolManager();
			value = ToolManager.addUsers(inUserName, inPassword, inEmail, inPhone, inFirstName, inLastName, 1);
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
			@QueryParam("email") String inEmail, @QueryParam("phone") String inPhone) {
		String value = "";
		try {
			System.out.println(inUserName + "======" + inPassword + "========" + inEmail + "===" + inPhone);
			ToolManager ToolManager = new ToolManager();
			value = ToolManager.addUsers(inUserName, inPassword, inEmail, inPhone, inFirstName, inLastName, 2);
			ToolManager = null;
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			return value;
		}
	}

	@POST
	@Path("/demorequest")
	@Produces(MediaType.APPLICATION_XML)
	public String demorequest(@QueryParam("firstname") String inFirstName, @QueryParam("lastname") String inLastName,
			@QueryParam("email") String inEmail, @QueryParam("phone") String inPhone) {
		String value = "";
		try {
			System.out.println(inFirstName + "======" + inLastName + "========" + inEmail + "===" + inPhone);
			ToolManager ToolManager = new ToolManager();
			value = ToolManager.demoRequest(inFirstName, inLastName, inEmail, inPhone);
			ToolManager = null;
		} catch (Exception Ex) {
			Ex.printStackTrace();
		} finally {
			return value;
		}
	}
}
