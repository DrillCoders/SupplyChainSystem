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

import com.supply.dao.StoreStockDao;
import com.supply.model.StoreStock;
@Path("/storeStock")
public class StoreStockServices {
	
	
	StoreStockDao ssdao = new StoreStockDao();

		@POST
		@Path("/addStoreStock")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response saveStoreStock(StoreStock storeStock) {
			ssdao.saveStoreStock(storeStock);
			return Response.status(Status.CREATED).build();
		}
		
		@DELETE
		@Path("/deleteStoreStock")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response deleteStoreStock(long storeStockId) {
			ssdao.deleteStoreStock(storeStockId);
			return Response.status(Status.CREATED).build();
		}
		
		@PUT
		@Path("updateStoreStock")
		public Response updateStoreStock( long storeStockId) {
			ssdao.updateStoreStock(storeStockId);
			return Response.status(200).build();
		}
		
		@GET
		@Path("searchStoreStock/{storeStockId}")
		public Response searchStoreStock(long storeStockId) {
			ssdao.searchStoreStock(storeStockId);
			return Response.status(200).build();
		}
}
