package com.every.events.restdata;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class YelpAPI {

	  private static String API_HOST = "api.yelp.com";
	  private static int SEARCH_LIMIT = 20;
	  String SEARCH_PATH = "/v2/search";
	  String BUSINESS_PATH = "/v2/business";

	  private static final String CONSUMER_KEY = "HieeMfGB1CAMwjZ6V2rr6Q";
	  private static final String CONSUMER_SECRET = "mohbDyciL4R94IxbZx1Nfoi0t0g";
	  private static final String TOKEN = "B8lX-kExc946vWaLXfNuX-7Zp4gPQtyt";
	  private static final String TOKEN_SECRET = "nO4JZoh37bRvLgdCrjlcrmDfbyM";

	  OAuthService service;
	  Token accessToken;

	  public YelpAPI() {
	    this.service =
	        new ServiceBuilder().provider(TwoStepOAuth.class).apiKey(CONSUMER_KEY)
	            .apiSecret(CONSUMER_SECRET).build();
	    this.accessToken = new Token(TOKEN, TOKEN_SECRET);
	  }

	  public String searchForBusinessesByLocation(String term, String location) {
	    OAuthRequest request = createOAuthRequest(SEARCH_PATH);
	    request.addQuerystringParameter("term", term);
	    request.addQuerystringParameter("location", location);
	    request.addQuerystringParameter("limit", String.valueOf(SEARCH_LIMIT));
	    return sendRequestAndGetResponse(request);
	  }

	  public String searchByBusinessId(String businessID) {
	    OAuthRequest request = createOAuthRequest(BUSINESS_PATH + "/" + businessID);
	    return sendRequestAndGetResponse(request);
	  }

	  private OAuthRequest createOAuthRequest(String path) {
	    OAuthRequest request = new OAuthRequest(Verb.GET, "https://" + API_HOST + path);
	    return request;
	  }

	 
	  private String sendRequestAndGetResponse(OAuthRequest request) {
	    System.out.println("Querying " + request.getCompleteUrl() + " ...");
	    this.service.signRequest(this.accessToken, request);
	    Response response = request.send();
	    return response.getBody();
	  }


	 
}
