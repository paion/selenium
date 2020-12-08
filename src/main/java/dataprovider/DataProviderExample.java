package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtils;
import utils.ExcelUtils2;
import java.io.File;

public class DataProviderExample {
    @DataProvider(name = "user")
    public Object[][] dpMethod() {
        return new Object[][]{{"Omar"}, {"Omar 2"}};
    }

    @Test(dataProvider = "user")
    public void myTest(String val) {
        System.out.println("Passed Parameter Is : " + val);
    }

    @DataProvider(name = "login")
    public static Object[][] credentials() {
        // The number of times data is repeated, test will be executed the same no. of times
        // Here it will execute two times
        return new Object[][]{{"testuser_1", "Test@123"}, {"testuser_1", "Test@123"}};
    }

// Here we are calling the Data Provider object with its Name
    @Test(dataProvider = "login")
    public void test(String sUsername, String sPassword) {
        System.out.println("Passed Parameter 1 Is : " + sUsername);
        System.out.println("Passed Parameter 2 Is : " + sPassword);
    }

    @Test(dataProvider="Authentication")
    public void Registration_data(String sUserName,String sPassword){
        System.out.println(sUserName);
        System.out.println(sPassword);
        System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
    }

    @DataProvider(name = "Authentication")
    public Object[][] Authentication() {
        Object[][] testObjArray = ExcelUtils.getTableArray
                ( new File("src/main/resources/dataProvider/users.xlsx").getAbsolutePath(),"Sheet1");
        return (testObjArray);
    }

    @DataProvider(name = "Authentication2")
    public Object[][] Authentication2() throws Exception{
        // Setting up the Test Data Excel file
        ExcelUtils2.setExcelFile(new File("src/main/resources/dataProvider/users.xlsx").getAbsolutePath(),"Sheet1");
        sTestCaseName = "scenario";
         number = number +1;
         sTestCaseName = sTestCaseName + number;
        // From above method we get long test case name including package and class name etc.
        // The below method will refine your test case name, exactly the name use have used
        //sTestCaseName = ExcelUtils2.getTestCaseName(sTestCaseName);
        // Fetching the Test Case row number from the Test Data Sheet

        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet

        iTestCaseRow = ExcelUtils2.getRowContains(sTestCaseName,0);

        Object[][] testObjArray = ExcelUtils2.getTableArray(new File
                ("src/main/resources/dataProvider/users.xlsx").getAbsolutePath(),"Sheet1", iTestCaseRow, true);
        return testObjArray;
    }

    @Test(dataProvider = "Authentication2")
    public void testsomething(String sTestCaseName,String sUserName, String sPassword) {
        System.out.println("testcase -"+sTestCaseName);
        System.out.println("name -" +sUserName);
        System.out.println("password -" +sPassword);
    }

    private  String sTestCaseName;
    private static int number;
    private int iTestCaseRow;

}


