package com.supply.services;

import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.supply.dao.MasterStockDao;
import com.supply.model.MasterStock;
@Path("/masterStock")
public class MasterStockServices {
	
	
		
		MasterStockDao msdao = new MasterStockDao();

			@POST
			@Path("/addMasterStock")
			@Consumes(MediaType.APPLICATION_JSON)
			public Response saveMasterStock(MasterStock masterStock) {
				msdao.saveMasterStock(masterStock);
				return Response.status(Status.CREATED).build();
			}
			
		
			@PUT
			@Path("updateMasterStock")
			public Response updateMasterStock( long masterStockId) {
				msdao.updateMasterStock(masterStockId);
				return Response.status(200).build();
			}
			
			@GET
			@Path("searchMasterStock/{masterStockId}")
			public Response searchMasterStock(long masterStockId) {
				msdao.searchMasterStock(masterStockId);
				return Response.status(200).build();
			}
}
