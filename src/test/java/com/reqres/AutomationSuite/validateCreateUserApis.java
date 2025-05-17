package com.reqres.AutomationSuite;

import com.reqres.RequestClient.CreateUserApisRequest;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.http.HttpResponse;

public class validateCreateUserApis {

    @Test(testName = "TC_05", description = "")
    public void validateCreateUserWithValidData(){
        try{
            CreateUserApisRequest createUserApisRequest = new CreateUserApisRequest();
            JSONObject jsonObject = new JSONObject();
            String name = "Abhishek Yadav";
            String job = "QA Automation";
            jsonObject.put("name",name);
            jsonObject.put("job",job);
            createUserApisRequest.setRequestBody(jsonObject);
            HttpResponse<String> response = createUserApisRequest.createUser();
            int statusCode = response.statusCode();
            JSONObject jsonResponse = new JSONObject(response.body());
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(statusCode,201);
            softAssert.assertEquals(jsonResponse.get("name"),name);
            softAssert.assertEquals(jsonResponse.get("job"),job);
            softAssert.assertAll();
        }catch (Exception e){
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

}
