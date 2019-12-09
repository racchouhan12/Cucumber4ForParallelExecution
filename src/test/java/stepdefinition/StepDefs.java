package stepdefinition;


import com.test.businessflows.AppHome;
import com.test.businessflows.Result;
import com.test.businessflows.Search;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {


    @Given("^I search for \"([^\"]*)\"$")
    public void search(String text) {
        new Search().searchText(text);
    }

    @When("I click on official Selenium HQ website$")
    public void result() {
        final String searchLinkToBeclicked = "SeleniumHQ Browser Automation";
        new Result().clickOnResultsLinkByText(searchLinkToBeclicked);
    }

    @Then("I verify official website is launched$")
    public void verifyWebsite(){
        new AppHome().verifyHomeScreenIsOpen();
    }

    @Then("I signIn in Gmail$")
    public void signIn(){
        new AppHome().verifyGmailScreenIsOpen();
    }
}