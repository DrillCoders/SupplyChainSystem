package com.supply.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.supply.dao.SuppliersDao;
import com.supply.model.Suppliers;
@Path("/supplier")
public class SuppliersService {

	SuppliersDao sdao = new SuppliersDao();

	@POST
	@Path("/addSuppliers")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveSuppliers(Suppliers suppliers) {
		sdao.saveSuppliers(suppliers);
		return Response.status(Status.CREATED).build();
	}
	
	@DELETE
	@Path("/deleteSuppliers")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteSuppliers(long suppId, String suppName) {
		sdao.deleteSuppliers(suppId, suppName);
		return Response.status(Status.CREATED).build();
	}
	
	@PUT
	@Path("updateSuppliers")
	public Response updateSuppliers( long suppId) {
		sdao.updateSuppliers(suppId);
		return Response.status(200).build();
	}
	@GET
	@Path("searchSuppliers/{suppId}")
	public Response searchSuppliers(long suppId) {
		sdao.searchSuppliers(suppId);
		return Response.status(200).build();
	}
}
