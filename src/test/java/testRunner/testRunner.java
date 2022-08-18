package testRunner;

import baseSetUp.base;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:test-output.html",
                "json:target/cucumber-report.json"
        },
        features = {"src/main/resources/"},
        glue = {
                "stepDefinitions"

        },
       //tags= "@SignUp"
        tags=" @SignIn"
        //tags="@addNum"
)
public class testRunner  extends AbstractTestNGCucumberTests {

        @BeforeClass
        public void fireDriver(){
                base.baseSetUp();
        }
        @AfterClass
        public void tearDown(){
                base.tearDown();
        }
}
