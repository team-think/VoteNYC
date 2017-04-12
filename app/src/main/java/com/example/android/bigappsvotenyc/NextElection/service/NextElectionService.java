package com.example.android.bigappsvotenyc.NextElection.service;

import com.example.android.bigappsvotenyc.NextElection.model.ElectionResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by catwong on 4/6/17.
 */

public interface NextElectionService {

    // https://www.googleapis.com/civicinfo/v2/voterinfo?address=91+boerum+st&electionId=2000&officialOnly=false&returnAllAvailableData=true&fields=contests%2Celection&key=AIzaSyA1G4Wrf-G7pz3l-eXh6T6WPOoshE6aQQA

    @GET("voterinfo")
    Call<ElectionResponse> callAllElections(
            @Query("address") String address,
            @Query("electionId") int electionId,
            @Query("officialOnly") boolean officialOnly,
            @Query("returnAllAvailableData") boolean officialData,
            @Query("fields") String contestsAndElection,
            @Query("key") String API_KEY
    );
}
