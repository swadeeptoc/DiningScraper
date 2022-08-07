package com.gradle.scraper;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import java.io.IOException;
import java.util.List;

public class DiningScraper {

    public DiningScraper() {


    }

    private static HtmlPage scraper() {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        HtmlPage page = null;
        try {
            page = webClient.getPage("https://hf-food.austin.utexas.edu/foodpro/s" +
                    "hortmenu.aspx?sName=University+Housing+and+Dining&locationNum=12&locationName=J" +
                    "2+Dining&naFlag=1");

            webClient.getCurrentWindow().getJobManager().removeAllJobs();
            webClient.close();


        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
        return page;
    }

    private static void getTitle(HtmlPage page) {
        String title = page.getTitleText();
        System.out.println("Page Title: " + title);
    }

    public static void main (String[] args) {
        HtmlPage page = scraper();
        getTitle(page);
    }
}
