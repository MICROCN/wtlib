package com.wtlib.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.wtlib.pojo.User;

@Path("user")
public interface UserService {
	
	@POST
	@Path("save")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
	public void save(User user);

	public void update(User user);

	@GET
	@Path("find")
	@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
	public User find(@QueryParam("name")String user);

	public void delete(String id);

}
