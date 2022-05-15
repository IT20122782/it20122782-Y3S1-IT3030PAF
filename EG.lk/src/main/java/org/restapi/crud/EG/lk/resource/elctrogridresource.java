package org.restapi.crud.EG.lk.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import org.restapi.crud.EG.lk.model.elctrogridmodel;
import org.restapi.crud.EG.lk.service.elctrogridservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/PowerConsumptionService")
public class elctrogridresource {
	elctrogridservice service = new elctrogridservice();

	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public elctrogridmodel addUser(elctrogridmodel user){
		return service.insertUser(user);
		
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<elctrogridmodel> getUser() throws SQLException{
		return service.getUser();
		
	}
	
	@Path("/retrieveById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<elctrogridmodel> getUser(@PathParam("id") int id) throws SQLException{
		return service.getUserById(id);
		
	}
	
	@Path("/updateUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public elctrogridmodel updateUser(elctrogridmodel user){
		return service.updateUser(user);
		
	}
	
	@Path("/deleteUserById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteUser(@PathParam("id") int id){
		return service.deleteUser(id);
		
	}

}
