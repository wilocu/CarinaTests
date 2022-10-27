package matpat.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import matpat.carina.demo.api.GetUserMethods;
import matpat.carina.demo.api.GetWeatherMethods;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class WeatherAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetFromCoords() {
        GetWeatherMethods getWeatherMethods = new GetWeatherMethods(44.34,10.99,0,false,"0",0,0);
        getWeatherMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethods.callAPI();
        getWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetFromOtherCoords() {
        GetWeatherMethods getWeatherMethods = new GetWeatherMethods(34.34,20.99,0,false,"0",0,0);
        getWeatherMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethods.callAPI();
        getWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetFromCoordsImperial() {
        GetWeatherMethods getWeatherMethods = new GetWeatherMethods(44.34,10.99,2,false,"0",0,0);
        getWeatherMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethods.callAPI();
        getWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetFromCoordsMetric() {
        GetWeatherMethods getWeatherMethods = new GetWeatherMethods(44.34,10.99,1,false,"0",0,0);
        getWeatherMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethods.callAPI();
        getWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetFromCoordsItalian() {
        GetWeatherMethods getWeatherMethods = new GetWeatherMethods(44.34,10.99,0,true,"0",0,0);
        getWeatherMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethods.callAPI();
        getWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetFromCity() {
        GetWeatherMethods getWeatherMethods = new GetWeatherMethods(0,0,0,false,"London",0,0);
        getWeatherMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethods.callAPI();
        getWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetFromCityId() {
        GetWeatherMethods getWeatherMethods = new GetWeatherMethods(0,0,0,false,"0",2172797,0);
        getWeatherMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethods.callAPI();
        getWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetFromCityZIP() {
        GetWeatherMethods getWeatherMethods = new GetWeatherMethods(0,0,0,false,"0",0,94040);
        getWeatherMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethods.callAPI();
        getWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetFromCityMetricItalian() {
        GetWeatherMethods getWeatherMethods = new GetWeatherMethods(0,0,1,true,"London",0,0);
        getWeatherMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethods.callAPI();
        getWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetFromCityImperialItalian() {
        GetWeatherMethods getWeatherMethods = new GetWeatherMethods(0,0,2,true,"London",0,0);
        getWeatherMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethods.callAPI();
        getWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

}
