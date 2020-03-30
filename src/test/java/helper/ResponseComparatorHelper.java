package helper;

import core.ApiRequest;
import core.HttpMethods;
import io.restassured.response.Response;
import core.ApiClient;

public class ResponseComparatorHelper {

    /*
     * Creating request and hitting the api using core framework.
     */
    public Response getApiResponse(String url)
    {
        ApiRequest request = new ApiRequest
                .RequestBuilder()
                .setBaseURL(url)
                .setRequestType(HttpMethods.GET)
                .build();

        Response response = new ApiClient().performRequest(request);
        return response;
    }


    /*
     * Comparing two bodies as string after fetching the json of response as string
     */
    public boolean compareResponse(Response firstResponse,Response secondResponse) {
        String firstResponseBody = firstResponse.getBody().asString();
        String secondResponseBody = secondResponse.getBody().asString();
        return firstResponseBody.equalsIgnoreCase(secondResponseBody);
    }
}
