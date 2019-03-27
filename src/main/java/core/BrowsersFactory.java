package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum BrowsersFactory {
    CHROME {
        public WebDriver create(){
            return new ChromeDriver();
        }
    },
    IE {
        public WebDriver create(){
            return new InternetExplorerDriver();
        }
    },
    FIREFOX {
        public WebDriver create() {
            return new FirefoxDriver();
        }
    };

    public WebDriver create(){
        return null;
    }
}
