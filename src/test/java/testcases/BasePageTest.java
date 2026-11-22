package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.BasePage;

public class BasePageTest extends BaseClass {

    @Test(groups = {"regression"})
    public void verifyBasePage() {

       BasePage page = new BasePage(getDriver());

        System.out.println("BasePage initialized successfully.");
    }
}