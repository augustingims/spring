package com.teamdev.app.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teamdev.app.domain.Personnes;
import com.teamdev.app.service.dto.PersonnesDto;
import com.teamdev.app.service.impl.PersonneServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Component
@Api(value = "Personne API")
@Path("/personne")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonneResource {

	@Autowired
	private PersonneServiceImpl personneServiceImpl;
	
	@POST
    @Path("/save")
    @Produces("application/json")
    @ApiOperation(value = "Retrieves a book based on ID.", response = Personnes.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Personnes.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
@ApiResponse(code = 500, message = "Failure")})
	public Response save(@ApiParam PersonnesDto c) {
		personneServiceImpl.save(c);
		return Response.ok().build();
	}
}
