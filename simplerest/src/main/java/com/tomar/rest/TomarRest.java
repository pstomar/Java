package com.tomar.rest;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.tomar.dao.CityDAO;
import com.tomar.dao.CountryDAO;
import com.tomar.dao.StateDAO;
import com.tomar.dao.UserDAO;
import com.tomar.hibernate.dto.CityInteface;
import com.tomar.hibernate.dto.CountryInterface;
import com.tomar.hibernate.dto.StateInterface;
import com.tomar.hibernate.dto.UserInterface;

@Path("/values")
public class TomarRest {

    @GET
    @Path("/countries")
    @Produces("application/json")
    public List<CountryInterface> getCountries(){
    	System.out.println("hello");
    	return CountryDAO.get();
    }
    
    @GET
    @Path("/countries/{id}")
    @Produces("application/json")
    public CountryInterface getCountry(@PathParam("id") Integer id){
    	return CountryDAO.get(id);
    }
    
    @GET
    @Path("/states")
    @Produces("application/json")
    public List<StateInterface> getStates(){
    	return StateDAO.get();
    }
    
    @GET
    @Path("/states/{id}")
    @Produces("application/json")
    public StateInterface getState(@PathParam("id") Integer id){
    	return StateDAO.get(id);
    }
    
    @GET
    @Path("/states/getByCountryId/{countryId}")
    @Produces("application/json")
    public List<StateInterface> getStateById(@PathParam("countryId") Integer countryId) {
    	return StateDAO.getByCountryId(countryId);
    }
    
    @GET
    @Path("/cities")
    @Produces("application/json")
    public List<CityInteface> getCities(){
    	return CityDAO.get();
    }
    
    @GET
    @Path("/cities/{id}")
    @Produces("application/json")
    public CityInteface getCity(@PathParam("id") Integer id){
    	return CityDAO.get(id);
    }
    
    @GET
    @Produces("application/json")
    @Path("/cities/getByStateId/{stateId}")
    public  List<CityInteface> getCitiesByStateId(@PathParam("stateId") Integer stateId){
    	System.out.println("StateId:  "+stateId);
    	return CityDAO.getByStateId(stateId);
    }
    
    @GET
    @Produces("application/json")
    @Path("/users")
    public List<UserInterface> getUsers(){
    	return UserDAO.get();
    }
    
    @POST
    @Produces("application/json")
    @Path("/user/authenticate")
    public Object authenticateUser(@QueryParam("username") String username,@QueryParam("password") String password) {
    	System.out.println("usr  :"+username);
    	System.out.println("usr  :"+password);
    	UserInterface user = UserDAO.authenticate(username, password);
    	System.out.println(username+"/"+password+"/"+user);
    	return user;
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/user/signup")
    public Object signupUser(UserInterface user) {
    	long id = UserDAO.addUser(user);
    	if (id>0)
    		return "success";
    	else
    		return "Invalid credential";
    }
    
    @POST
    @Path("/hi")
    @Consumes("file/multi-part")
    public void uploadImage(@PathParam("file") InputStream file){
    	
    }
    
    @POST
    private boolean isUserAvailable(@Context HttpServletRequest request) {
    	System.out.println(request.getSession(true).getId());
    	if(request.getSession().getAttribute("user") == null)
    		return false;
    	return true;
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/jsonBean")
    public Response modifyJson(JsonBean input) {
    	return Response.ok().entity(CountryDAO.get()).build();
    }
    
    @GET
    @Produces("application/json")
    @Path("/hii")
    public boolean printx(){
    	return this.isUserAvailable();
    }
    
    public boolean isUserAvailable(){
    	return true;
    }
}

