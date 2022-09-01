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
        //tags= "@SignUp_Lando"
        //tags=" @SignIn"
        // tags="@addNum"
        //tags="@SignUp_Omni"
        //tags="@SignUp_Exis"
        tags="@SignUp_Indosat"
       //tags="@SignUp_Ring"
)
public class testRunner  extends AbstractTestNGCucumberTests {
        @BeforeClass
        public void fireDriver(){
                base.baseSetUp("chrome");
        }
        @AfterClass
        public void tearDown(){
// where is the driver quit ???
        }
}
