package core;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class ApiClient {


        public Response performRequest(ApiRequest request) {
            RequestSpecification specification;
            RequestSpecBuilder builder = new RequestSpecBuilder();

            if (request.getBaseURL().contains("https")) {
                builder.setBaseUri(request.getBaseURL());
            }

            /*
                I am not printing error here, since its already handled in "ComparatorTest" class
            else
            {
                System.out.println("Please check the uri "+request.getBaseURL());
            }*/

            if (request.getPath() != null) {
                builder.setBasePath(request.getPath());
            }

            specification = builder.build();

            return executeRequest(specification,request.getMethodType());

        }


        public Response executeRequest(RequestSpecification specification, HttpMethods requestType) {
            Response response = null;

        try {

            switch (requestType) {
                case GET:
                    response = RestAssured.given(specification).get();
                    break;

                case PUT:
                    response = RestAssured.given(specification).put();
                    break;

                case POST:
                    response = RestAssured.given(specification).post();
                    break;

                case PATCH:
                    response = RestAssured.given(specification).patch();
                    break;

                case DELETE:
                    response = RestAssured.given(specification).delete();
                    ValidatableResponse response1 = (ValidatableResponse) RestAssured.given(specification).delete();
                    break;

                default:
                    System.out.println("Please enter a valid request type");
                }
            }
        catch (Exception e) {
         //   System.out.println("Please check the URL");
            }

            return response;
        }
    }
