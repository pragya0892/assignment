package test;

import dataproviders.UriComparisonDP;
import org.testng.ITest;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;
import helper.ResponseComparatorHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ComparatorTest {

    ResponseComparatorHelper responseComparatorHelper;


    @BeforeClass
    public void beforeClass()
    {
        responseComparatorHelper = new ResponseComparatorHelper();

    }


    @Test(description = "Verifies the response of two api are equal or not",dataProvider = "UriComparisonDP",dataProviderClass = UriComparisonDP.class)
    public void testApiResponse(String firstUrl,String secondUrl) throws Exception {
        Boolean result = null;

        Response responseFromFirstUrl = responseComparatorHelper.getApiResponse(firstUrl);
        Response responseFromSecondUrl = responseComparatorHelper.getApiResponse(secondUrl);

        // Here i am checking the null response for the invalid uris
        // i can club this if condition in below if block but mentioned it here to give more understanding

        if (responseFromFirstUrl != null && responseFromSecondUrl != null) {

            if (responseFromFirstUrl.getStatusCode() == 200 && responseFromSecondUrl.getStatusCode() == 200) {

                // Compare method is written in ResponseComparatorHelper class
                result = responseComparatorHelper.compareResponse(responseFromFirstUrl, responseFromSecondUrl);

                if (result) {
                    System.out.println(firstUrl + " equals " + secondUrl);
                } else {
                    System.out.println(firstUrl + " not equals " + secondUrl);
                }

            } else {
                System.out.println("Response is not coming proper");
            }

        } else
        {
            // I am printing this error message in case of invalid uri like: /api/unknown/2
            System.out.println("Please check the uri in File1 and File2: "+firstUrl+", "+secondUrl);
        }
    }
}
