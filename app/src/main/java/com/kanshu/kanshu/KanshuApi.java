package com.kanshu.kanshu;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kanshu.kanshu.model.SavedChars;

import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface KanshuApi {
    @GET("/login")
    JsonObject login(@Header("Authorization")String hash);

    @POST("/createUser")
    public void createUser(@Body SignupPacket packet, Callback<String> callback);

    //Content-Type should always be application/json
    @POST("/updateUser")
    public void updateUser(@Header("sessionid")String sessionID,@Header("Content-Type")String contentType, @Body SignupPacket packet, Callback<JsonObject> callback);

    @POST("/deleteword")
    public void deleteWord(@Header("sessionid")String token, @Body SavedChars.WordPacket wordPacket, Callback<String> callback);

    @POST("/saveword")
    public void saveWord(@Header("sessionid")String token, @Body SavedChars.WordPacket wordPacket, Callback<String> callback);

    @Headers("Cache-Control: no-cache")
    @GET("/getwords")
    public void getWords(@Header("sessionid")String token, Callback<JsonObject> wordList);
}
