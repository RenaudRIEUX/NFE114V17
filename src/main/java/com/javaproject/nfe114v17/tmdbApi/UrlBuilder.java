package com.javaproject.nfe114v17.tmdbApi;

public class UrlBuilder {
    private String apiKey;
    private String baseUrl;
    private String route;
    private StringBuilder params= new StringBuilder();




    //String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key="+apiKey;
    //String url = "https://api.themoviedb.org/3/search/movie/?api_key="+apiKey+"&query="+query;

    public UrlBuilder(String apiKey, String baseUrl) {
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }

    public UrlBuilder route (String route){
        this.route=route;
        return this;
    }
    public UrlBuilder addParam (String name, String value){
        params.append("&"+name+"="+value);
        return this;
    }

    public String build(){
        return baseUrl+route+"?apiKey="+apiKey+params.toString();

    }

}
