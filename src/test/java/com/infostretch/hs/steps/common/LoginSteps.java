package com.infostretch.hs.steps.common;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import static com.qmetry.qaf.automation.ui.webdriver.ElementFactory.$;
public class LoginSteps {
 
	/**
     * Login with provided username and password
     *
     * @param username
     * @param password
     */
    @QAFTestStep(description = "login to the application with {username} and {password}")
    public void login(String username, String password) {
    	
    	CommonStep.click("login.btn.signinwith.cancel");
    	if($("login.btn.email.clear").isPresent()) {
    		CommonStep.click("login.btn.email.clear");
    	}
    	CommonStep.sendKeys(username, "login.input.email");
    	CommonStep.click("login.btn.continue");
    	CommonStep.click("login.btn.via.password");
    	CommonStep.sendKeys(password,"login.input.password");
    	CommonStep.click("login.btn.submit");
    }


    /**
     * Verify user is logged in application
     */
    @QAFTestStep(description = "verify user should logged into the application")
    public void verifyLoggedIn() {
    	CommonStep.assertPresent("home.icon.profile");
    	CommonStep.assertPresent("home.link.menu");
    }
}