package matpat.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

@Endpoint(url = "${base_url2}/data/2.5/weather", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/users/_get/rs2.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetWeatherMethods extends AbstractApiMethodV2 {
    public GetWeatherMethods(double lat, double lon, int units, Boolean italian, String cityN, int cityId, int ZIP) {
        replaceUrlPlaceholder("base_url2", Configuration.getEnvArg("api_url2"));
        if(lat != 0){
            this.addUrlParameter("lat", String.valueOf(lat));
        }
        if(lon != 0){
            this.addUrlParameter("lon", String.valueOf(lon));
        }
        if(units == 1){
            this.addUrlParameter("units", "metric");
        }
        else if(units == 2){
            this.addUrlParameter("units", "imperial");
        }
        if(italian){
            this.addUrlParameter("lang", "it");
        }
        if(!cityN.equalsIgnoreCase("0")){
            this.addUrlParameter("q", cityN);
        }
        if(cityId != 0){
            this.addUrlParameter("id", String.valueOf(cityId));
        }
        if(ZIP != 0){
            this.addUrlParameter("zip", ZIP + ",us");
        }
        this.addUrlParameter("appid", "e6382fbf55290300073fc6f304bdd1a4"); //they have not approved me yet so I can't test it
    }

    //Values Key
    // lat lon: 0 is don't use em
    // units: 0 default, 1 metric, 2 imperial
    // italian: true use, false don't
    // cityN: 0 don't use
    // cityId: 0 don't use
    // ZIP: 0 don't use
}