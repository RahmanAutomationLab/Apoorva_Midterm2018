package design;

import org.testng.Assert;

public class UnitTestingEmployeeInfo {
    public static void main(String[] args) {
        //Write Unit Test for all the methods has been implemented in this package.
        Assert.assertEquals(EmployeeInfo.calculateEmployeeBonus(10000,8),1000.0);

        Assert.assertEquals(EmployeeInfo.calculateEmployeePension(20000),2000.0);


        Assert.assertEquals(100,100);
    }
}
