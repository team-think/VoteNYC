package com.example.android.bigappsvotenyc.PollingLocations.Internet;

import com.example.android.bigappsvotenyc.PollingLocations.Model.VoterInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mathcore on 1/29/17.
 * https://www.googleapis.com/civicinfo/v2/voterinfo?address=682+Seneca+Ave+Queens+NY+11385&electionId=2000&key={YOUR_API_KEY}
 */

public interface VoterInfoService {

    @GET("voterinfo")
    Call<List<VoterInfo>> getData(
            @Query("address") String address,
            @Query("electionId") String electionId,
            @Query("key") String API_KEY);

}
