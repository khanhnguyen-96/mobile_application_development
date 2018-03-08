package interfaces;

import models.GeocodingModel;
import models.Location;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nnkti on 3/6/2018.
 */
public interface ApiInterface {
    @GET("maps/api/geocode/json")
    Call<GeocodingModel> getGeoByLatlng(@Query("latlng") Location latlng, @Query("key") String key);
}
