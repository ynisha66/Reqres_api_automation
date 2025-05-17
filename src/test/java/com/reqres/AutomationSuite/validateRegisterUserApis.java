package com.reqres.AutomationSuite;

import com.reqres.RequestClient.RegisterUserApisRequest;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.http.HttpResponse;

public class validateRegisterUserApis {

    @Test(testName = "TC_06", description = "")
    public void validateRegisterUserApisWithValidData(){
        try{
            RegisterUserApisRequest registerUserApisRequest = new RegisterUserApisRequest();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email","eve.holt@reqres.in");
            jsonObject.put("password","pistol");
            registerUserApisRequest.setRequestBody(jsonObject);
            HttpResponse<String> response = registerUserApisRequest.registerUser();
            int statusCode = response.statusCode();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(statusCode,200);
            softAssert.assertTrue(response.body().contains("token"));
            softAssert.assertAll();
        }catch (Exception e){
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
    @Test(testName = "TC_07", description = "")
    public void validateRegisterUserApisWithoutPassword() {
        try {
            RegisterUserApisRequest registerUserApisRequest = new RegisterUserApisRequest();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", "eve.holt@reqres.in");
            registerUserApisRequest.setRequestBody(jsonObject);
            HttpResponse<String> response = registerUserApisRequest.registerUser();
            int statusCode = response.statusCode();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(statusCode, 400);
            softAssert.assertTrue(response.body().contains("Missing password"));
            softAssert.assertAll();
        } catch (Exception e) {
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
