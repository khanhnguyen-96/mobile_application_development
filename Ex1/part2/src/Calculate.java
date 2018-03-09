/**
 * Created by nnkti on 3/9/2018.
 */
import javax.ws.rs.*;

// The Java class will be hosted at the URI path "/"
@Path("/")
public class Calculate {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public double getClichedMessage(@QueryParam("lat_a") double lat_a, @QueryParam("lng_a") double lng_a,
                                    @QueryParam("lat_b") double lat_b, @QueryParam("lng_b") double lng_b) {
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat_b - lat_a);
        double lonDistance = Math.toRadians(lng_b - lng_a);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat_a)) * Math.cos(Math.toRadians(lat_b))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = 0;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }
}