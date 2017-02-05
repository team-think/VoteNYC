package com.example.android.bigappsvotenyc.RecentBills.service;

import com.example.android.bigappsvotenyc.ElectedOfficials.model.RepResponse;
import com.example.android.bigappsvotenyc.RecentBills.model.Bill;
import com.example.android.bigappsvotenyc.RecentBills.model.BillResponse;
import com.example.android.bigappsvotenyc.RecentBills.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by catwong on 2/2/17.
 */

//curl "https://api.propublica.org/congress/v1/114/house/bills/introduced.json"
// -H "X-API-Key: BPm3oZBK1w9zOYQZwE66y3LK19t6MIgg8vGI522Q"


// curl "https://api.propublica.org/congress/v1/114/senate/bills/introduced.json"
// -H "X-API-Key: BPm3oZBK1w9zOYQZwE66y3LK19t6MIgg8vGI522Q"

public interface RecentBillsService {


    @Headers("X-API-Key: BPm3oZBK1w9zOYQZwE66y3LK19t6MIgg8vGI522Q")
    @GET("114/house/bills/introduced.json")
    Call<BillResponse> getRecentHouseBills();

    @Headers("X-API-Key: BPm3oZBK1w9zOYQZwE66y3LK19t6MIgg8vGI522Q")
    @GET("114/senate/bills/introduced.json")
    Call<BillResponse> getRecentSenateBills();


}
