package com.teamdev.app.web.rest;

import java.awt.print.Book;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.teamdev.app.domain.Country;
import com.teamdev.app.repository.CountryRepository;
import com.teamdev.app.service.impl.CountryServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Component
@Api(value = "Country API")
@Path("/country")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CountryResource {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CountryServiceImpl countryServiceImpl;
	
	
	@POST
    @Path("/getAll")
    @Produces("application/json")
    @ApiOperation(value = "get All country.", response = Country.class,responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Country.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
@ApiResponse(code = 500, message = "Failure")})
	public Page<Country> getAll(Pageable pageable) {
		return countryServiceImpl.findAll(pageable);
	}
	
	@POST
    @Path("/save")
    @Produces("application/json")
    @ApiOperation(value = "save country.", response = Country.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Country.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
@ApiResponse(code = 500, message = "Failure")})
	public Response save(@ApiParam Country c) {
		countryRepository.save(c);
		return Response.ok().build();
	}
	
	@PUT
    @Path("/update")
    @Produces("application/json")
    @ApiOperation(value = "update country.", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Country.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
@ApiResponse(code = 500, message = "Failure")})
	public Response update(Country c) {
		countryRepository.save(c);
		return Response.ok().build();
	}
	
	@DELETE
    @Path("/delete/{id}")
    @Produces("application/json")
    @ApiOperation(value = "delete country by id.", response = Country.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Country.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
@ApiResponse(code = 500, message = "Failure")})
	public Response delete(@ApiParam @PathParam(value = "id") Integer id) {
		countryRepository.deleteById(id);
		return Response.ok().build();
	}
	
	@GET
    @Path("/findOne/{id}")
    @Produces("application/json")
    @ApiOperation(value = "get country by id", response = Country.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Country.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
@ApiResponse(code = 500, message = "Failure")})
	public Country findOne(@ApiParam @PathParam(value = "id") Integer id) {
		return countryRepository.findById(id).get();
	}
}
