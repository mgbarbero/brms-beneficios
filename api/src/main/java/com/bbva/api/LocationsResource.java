package com.bbva.api;

import com.bbva.api.beans.Location;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/locations")
public class LocationsResource {
  @GET
  @Produces("application/json")
  List<Location> generatedMethod1(){
  return new ArrayList();
}

  @POST
  @Produces("application/json")
  List<Location> generatedMethod2(){
  return null;
}
