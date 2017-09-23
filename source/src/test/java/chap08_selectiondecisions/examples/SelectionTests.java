package chap08_selectiondecisions.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectionTests {

    @Test
    public void moreTernary() {
        String url = "www.eviltester.com";

        url = url.startsWith("http") ? url : addHttp(url);

        Assert.assertTrue(url.startsWith("http://"));
        Assert.assertEquals("http://www.eviltester.com", url);
    }

    private String addHttp(String url) {
        return "http://" + url;
    }

    @Test
    public void ifAddHttp() {
        String url = "www.seleniumsimplified.com";
        if (!url.startsWith("http")) {
            url = addHttp(url);
        }
        Assert.assertTrue(url.startsWith("http://"));
        Assert.assertEquals("http://www.seleniumsimplified.com", url);
    }

    @Test
    public void ifElseAddHttp() {
        String url = "www.seleniumsimplified.com";
        if (url.startsWith("http")) {
            // do nothing the url is fine
        } else {
            url = addHttp(url);
        }
        Assert.assertTrue(url.startsWith("http://"));
        Assert.assertEquals("http://www.seleniumsimplified.com", url);
    }

    @Test
    public void ifElseNestedAddHttp() {
        String url = "seleniumsimplified.com";
        if (url.startsWith("http")) {
            // do nothing the url is fine
        } else {
            if (!url.startsWith("www")) {
                url = "www." + url;
            }
            url = addHttp(url);
        }
        Assert.assertTrue(url.startsWith("http://"));
        Assert.assertEquals("http://www.seleniumsimplified.com", url);
    }

    @Test
    public void ifElseNestedAddHttpReformatted() {
        String url = "seleniumsimplified.com";
        if (url.startsWith("http")) {
            // do nothing the url is fine
        } else {
            if (!url.startsWith("www")) {
                url = "www." + url;
            }
            url = addHttp(url);
        }
        Assert.assertTrue(url.startsWith("http://"));
        Assert.assertEquals("http://www.seleniumsimplified.com", url);
    }

    @Test
    public void switchExample() {
        Assert.assertEquals("M", likelyGenderIs("sir"));
        Assert.assertEquals("M", likelyGenderIs("mr"));
        Assert.assertEquals("M", likelyGenderIs("master"));
        Assert.assertEquals("F", likelyGenderIs("miss"));
        Assert.assertEquals("F", likelyGenderIs("mrs"));
        Assert.assertEquals("F", likelyGenderIs("ms"));
        Assert.assertEquals("F", likelyGenderIs("lady"));
        Assert.assertEquals("F", likelyGenderIs("madam"));
    }

    public String likelyGenderIs(String title) {
        String likelyGender;

        switch (title.toLowerCase()) {
            case "sir":
                likelyGender = "M";
                break;
            case "mr":
                likelyGender = "M";
                break;
            case "master":
                likelyGender = "M";
                break;
            default:
                likelyGender = "F";
                break;
        }
        return likelyGender;
    }

    @Test
    public void switchFallThroughExample() {
        Assert.assertEquals("M", likelyGenderFallThrough("sir"));
        Assert.assertEquals("M", likelyGenderFallThrough("mr"));
        Assert.assertEquals("M", likelyGenderFallThrough("master"));
        Assert.assertEquals("F", likelyGenderFallThrough("miss"));
        Assert.assertEquals("F", likelyGenderFallThrough("mrs"));
        Assert.assertEquals("F", likelyGenderFallThrough("ms"));
        Assert.assertEquals("F", likelyGenderFallThrough("lady"));
        Assert.assertEquals("F", likelyGenderFallThrough("madam"));
    }

    public String likelyGenderFallThrough(String title) {
        String likelyGender;

        switch (title.toLowerCase()) {
            case "sir":
            case "mr":
            case "master":
                likelyGender = "M";
                break;
            default:
                likelyGender = "F";
                break;
        }
        return likelyGender;
    }
}
