package com.example.android.bigappsvotenyc.ElectedOfficials.service;


import com.example.android.bigappsvotenyc.ElectedOfficials.model.RepResponse;
import com.example.android.bigappsvotenyc.PollingLocations.Model.VoterInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by catwong on 1/29/17.
 */

public interface RepService {

    final String API_KEY = "AIzaSyA1G4Wrf-G7pz3l-eXh6T6WPOoshE6aQQA";

    // https://www.googleapis.com/civicinfo/v2/representatives?address=33+irving+pl&includeOffices=true&levels=country&levels=administrativeArea1&levels=administrativeArea2&levels=regional&levels=locality&levels=subLocality1&levels=subLocality2&levels=special&roles=headOfGovernment&roles=headOfState&roles=deputyHeadOfGovernment&roles=governmentOfficer&roles=executiveCouncil&roles=legislatorUpperBody&roles=legislatorLowerBody&roles=highestCourtJudge&roles=judge&roles=schoolBoard&roles=specialPurposeOfficer&key=AIzaSyA1G4Wrf-G7pz3l-eXh6T6WPOoshE6aQQA

    @GET("representatives")
    Call<RepResponse> getOfficials(
        @Query("address") String address,
        @Query("includeOffices") boolean includeOffices,
        @Query("levels") String country,
        @Query("levels") String administrativeArea1,
        @Query("levels") String administrativeArea2,
        @Query("levels") String regional,
        @Query("levels") String locality,
        @Query("levels") String subLocality1,
        @Query("levels") String subLocality2,
        @Query("levels") String special,
        @Query("roles") String headOfState,
        @Query("roles") String headOfGovernment,
        @Query("roles") String deputyHeadOfGovernment,
        @Query("roles") String governmentOfficer,
        @Query("roles") String executiveCouncil,
        @Query("roles") String legislatorUpperBody,
        @Query("roles") String legislatorLowerBody,
        @Query("roles") String highestCourtJudge,
        @Query("roles") String judge,
        @Query("roles") String schoolBoard,
        @Query("roles") String specialPurposeOfficer,
        @Query("key") String API_KEY);


    // https://www.googleapis.com/civicinfo/v2/representatives?address=91+boerum+st&includeOffices=true&levels=country&key={YOUR_API_KEY}

    @GET("representatives")
    Call<RepResponse> getNationalOfficials(
            @Query("address") String address,
            @Query("includeOffices") boolean includeOffices,
            @Query("levels") String country,
            @Query("key") String API_KEY);


    // https://www.googleapis.com/civicinfo/v2/representatives?address=91+boerum+st&includeOffices=true&levels=administrativeArea1&levels=administrativeArea2&key={YOUR_API_KEY}

    @GET("representatives")
    Call<RepResponse> getStateOfficials(
            @Query("address") String address,
            @Query("includeOffices") boolean includeOffices,
            @Query("levels") String administrativeArea1,
            @Query("levels") String administrativeArea2,
            @Query("levels") String regional,
            @Query("key") String API_KEY);


    // https://www.googleapis.com/civicinfo/v2/representatives?address=91+boerum+st&includeOffices=true&levels=administrativeArea1&levels=administrativeArea2&levels=regional&roles=executiveCouncil&roles=legislatorUpperBody&roles=legislatorLowerBody&roles=highestCourtJudge&key=AIzaSyA1G4Wrf-G7pz3l-eXh6T6WPOoshE6aQQA

    @GET("representatives")
    Call<RepResponse> getLocalOfficials(
            @Query("address") String address,
            @Query("includeOffices") boolean includeOffices,
            @Query("levels") String administrativeArea1,
            @Query("levels") String administrativeArea2,
            @Query("levels") String regional,
            @Query("roles") String executiveCouncil,
            @Query("roles") String legislatorUpperBody,
            @Query("roles") String legislatorLowerBody,
            @Query("roles") String highestCourtJudge,
            @Query("key") String API_KEY);



}

