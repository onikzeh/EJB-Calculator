package com.thenational.ejb;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

@Path("/calculate/")
@Consumes({ "application/xml", "application/json" })
@Produces({ "application/xml", "application/json" })
@Stateless(name = "AddServiceEJB")
public class AddBean  {

    public AddBean() {
    }

    @POST
    @Path("/add")
    public String add(String value1, String value2) {
        return value1 + value2;
    }
}
