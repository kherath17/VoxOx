//Not using as of now
package pageFunctions;

import configReader.configRead;
import pageObjects.signUpPage;

import java.io.IOException;

public class signUpLandoCPFn {
    signUpPage sp = new signUpPage();
    configRead config = new configRead();

    public String verUserNavLando() throws IOException, InterruptedException {
        return sp.userNavCloudPhn(config.read("LandoCPURL"));
    }
}
