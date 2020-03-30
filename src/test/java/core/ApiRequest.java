package core;

import java.util.Map;

public class ApiRequest {

    private HttpMethods methodType;
    private String baseURL;
    private String path;

    /***
     * Creating API request class based on builder pattern
     */

    public ApiRequest(RequestBuilder builder) {

        this.methodType = builder.methodType;
        this.baseURL = builder.baseURL;
        this.path = builder.path;
    }

    public HttpMethods getMethodType() {
        return methodType;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public String getPath() {
        return path;
    }

    public static class RequestBuilder {

        HttpMethods methodType;
        public String baseURL;
        public String path;

        public RequestBuilder setRequestType(HttpMethods methodType) {
            this.methodType = methodType;
            return this;
        }

        public RequestBuilder setBaseURL(String url) {
            baseURL = url;
            return this;
        }

        public ApiRequest build() {
            ApiRequest request = new ApiRequest(this);
            return request;
        }

    }

}
