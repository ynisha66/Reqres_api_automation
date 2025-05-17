package com.reqres.AutomationSuite;

import com.reqres.RequestClient.DeleteUserApisRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.http.HttpResponse;

public class validateDeleteApis {
    @Test(testName = "TC_09", description = "")
    public void validateDeleteUserApis(){
        try {
            DeleteUserApisRequest deleteUserApisRequest = new DeleteUserApisRequest();
            deleteUserApisRequest.setId("2");
            HttpResponse<String> response = deleteUserApisRequest.deleteUser();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(response.statusCode(),204);
            softAssert.assertAll();
        }catch (Exception e){
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
