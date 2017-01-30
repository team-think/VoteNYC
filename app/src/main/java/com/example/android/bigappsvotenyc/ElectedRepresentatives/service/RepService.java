package com.example.android.bigappsvotenyc.ElectedRepresentatives.service;


import com.example.android.bigappsvotenyc.ElectedRepresentatives.model.Address;
import com.example.android.bigappsvotenyc.ElectedRepresentatives.model.RepResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by catwong on 1/29/17.
 */

public interface RepService {

    final String API_KEY = "AIzaSyA1G4Wrf-G7pz3l-eXh6T6WPOoshE6aQQA";


    // https://www.googleapis.com/civicinfo/v2/representatives?address=91+boerum+st&includeOffices=true&levels=country&levels=administrativeArea1&levels=administrativeArea2&levels=regional&levels=locality&levels=subLocality1&levels=subLocality2&levels=special&roles=headOfGovernment&roles=headOfState&roles=deputyHeadOfGovernment&roles=governmentOfficer&roles=executiveCouncil&roles=legislatorUpperBody&roles=legislatorLowerBody&roles=highestCourtJudge&roles=judge&roles=schoolBoard&roles=specialPurposeOfficer&key={YOUR_API_KEY}

    @GET("representatives?address=91+boerum+st&includeOffices=true&levels=country&levels=administrativeArea1&levels=administrativeArea2&levels=regional&levels=locality&levels=subLocality1&levels=subLocality2&levels=special&roles=headOfGovernment&roles=headOfState&roles=deputyHeadOfGovernment&roles=governmentOfficer&roles=executiveCouncil&roles=legislatorUpperBody&roles=legislatorLowerBody&roles=highestCourtJudge&roles=judge&roles=schoolBoard&roles=specialPurposeOfficer&key=AIzaSyA1G4Wrf-G7pz3l-eXh6T6WPOoshE6aQQA")
    Call<RepResponse> getRepresentatives();

}
