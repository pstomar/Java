package com.tomar.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.tomar.dao.CountryDAO;
import com.tomar.dao.UserDAO;

@Path("/mobAuth")
public class mobAuth {
	@POST
	@Produces("application/json")
	@Path("/userauthentication")
	public Response authentication(@QueryParam("username") String username, @QueryParam("password") String password){
		return Response.ok().entity(UserDAO.authenticate(username, password)).build();
	}
	

	 @POST
	    @Produces("application/json")
	    @Consumes("application/json")
	    @Path("/jsonBean")
	    public Response modifyJson(JsonBean input) {
//		input.setVal2(input.getVal1());
		return Response.ok().entity(CountryDAO.get()).build();
	    }
}
