package apiTest;

import apiEndpoints.UserEndPoints;
import apiPayload.User;
import apiUtilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DDTests {

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String userID, String userName, String firstName, String lastName, String userEmail,String password, String ph)
    {
        User userPayload= new User();
        userPayload.setId(Integer.parseInt(userID));
        userPayload.setUsername(userName);
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(userEmail);
        userPayload.setPassword(password);
        userPayload.setPhone(ph);

        Response response = UserEndPoints.createUser(userPayload);
                Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test(priority = 2,dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String userName)
    {
        Response response= UserEndPoints.deleteUser(userName);
        Assert.assertEquals(response.getStatusCode(), 200);
    }




}
