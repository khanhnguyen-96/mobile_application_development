package presenters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import constants.Const;
import interfaces.ApiInterface;
import models.GeocodingModel;
import models.Location;
import models.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static constants.Const.BASE_URL;

/**
 * Created by nnkti on 3/6/2018.
 */
public class GetLocationInfoByLatlngPresenter {
    public ApiInterface apiService;
    private Location location;
    private Retrofit retrofit;
    private Gson gson;
    public GetLocationInfoByLatlngPresenter() {
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiService =
                retrofit.create(ApiInterface.class);
    }

    public void getInfoByLatlng(Location location) {
        System.out.println("... Retrieving info from Google Maps");
        Call<GeocodingModel> call = apiService.getGeoByLatlng(location, Const.MY_API_KEY);
        System.out.println("Result: ");
        call.enqueue(new Callback<GeocodingModel>() {
            @Override
            public void onResponse(Call<GeocodingModel> call, Response<GeocodingModel> response) {
                if (response.body().getStatus().equals("OK")) {
                    for (Result item : response.body().getResults()) {
                        System.out.println(item.getFormattedAddress());
                    }
                } else {
                    System.out.println("No results");
                }
            }

            @Override
            public void onFailure(Call<GeocodingModel> call, Throwable throwable) {
                System.out.println("***Failure***");
            }
        });
    }
}
