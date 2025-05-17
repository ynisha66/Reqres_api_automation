package com.reqres.AutomationSuite;

import com.reqres.RequestClient.UpdateUserApisRequest;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.net.http.HttpResponse;

public class validateUpdateUserApis {

    @Test(testName = "TC_08", description = "")
    public void validateUpdateUserWithValidData(){
        try{
            UpdateUserApisRequest updateUserApisRequest = new UpdateUserApisRequest();
            updateUserApisRequest.setId("2");
            JSONObject jsonObject = new JSONObject();
            String name = "Abhishek Yadav";
            String job = "SDE-1";
            jsonObject.put("name",name);
            jsonObject.put("job",job);
            updateUserApisRequest.setRequestBody(jsonObject);
            HttpResponse<String> response = updateUserApisRequest.updateUser();
            int statusCode = response.statusCode();
            JSONObject jsonResponse = new JSONObject(response.body());
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(statusCode, 200);
            softAssert.assertEquals(jsonResponse.get("name"),name);
            softAssert.assertEquals(jsonResponse.get("job"),job);
            softAssert.assertAll();
        } catch (Exception e) {
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
