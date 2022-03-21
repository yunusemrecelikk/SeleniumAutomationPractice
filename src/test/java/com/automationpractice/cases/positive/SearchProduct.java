package com.automationpractice.cases.positive;

import com.automationpractice.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchProduct {
    Methods methods;

    private String firstProductName;
    private String firstProductPrice;

    public SearchProduct() { methods = new Methods(); }

    public void openWomenTshirtCategory() {
        try {
            By logoLocator = By.id("header_logo");
            methods.waitUntilElementCliclable(logoLocator);
            Assert.assertTrue("Verification Failed: Website did not " +
                    "open successfully, test case failed.", methods.isElementVisible(logoLocator));

            By womenCategoryLocator = By.xpath("//*[@id=\"block_top_menu\"]//*[@class=\"sf-menu clearfix " +
                    "menu-content sf-js-enabled sf-arrows\"]/li[not(@id)]/a[contains(text(),'Women')]");
            methods.scrollToElement(womenCategoryLocator);

            By womenTshirtCategoryLocator = By.xpath("//*[@id=\"block_top_menu\"]//*[@class=\"sf-menu clearfix" +
                    " menu-content sf-js-enabled sf-arrows\"]/li[not(@id)]/ul[@class=\"submenu-container clearfix" +
                    " first-in-line-xs\"]/li[not(@id)]/ul[not(@id)]/li/a[contains(text(),'T-shirts')]");
            methods.waitUntilElementCliclable(womenTshirtCategoryLocator);
            methods.clickElement(womenTshirtCategoryLocator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getInformationOfFirstProduct() {
        try {
            By tShirtCategoryTextLocator = By.xpath("//*[@class=\"page-heading product-listing\"]//*" +
                    "[@class=\"cat-name\"]");
            methods.waitUntilElementLocated(tShirtCategoryTextLocator);

            Assert.assertTrue("Verification Failed: T-shirts category did not opened," +
                    " test case failed.", methods.isElementVisible(tShirtCategoryTextLocator));

            String categoryName = methods.getElementsText(tShirtCategoryTextLocator);
            categoryName = categoryName.replaceAll("\\s", "");
            Assert.assertEquals("Verification Failed: T-shirts category did not opened," +
                    " test case failed.", "T-SHIRTS", categoryName);

            By productsListLocator = By.xpath("//*[@class=\"product_list grid row\"]");
            List<WebElement> products = methods.findElements(productsListLocator);
            for (int i = 1; i < products.size() + 1; i++) {
                if (i > 1) {
                    break;
                }
                By firstProductNameLocator = By.xpath("//*[@class=\"product_list grid row\"]/li" +
                        "//*[@class=\"product-container\"]["+ i +"]//*[@class=\"right-block\"]/h5" +
                        "//*[@class=\"product-name\"]");
                By firstProductPriceLocator = By.xpath("//*[@class=\"product_list grid row\"]/li//*" +
                        "[@class=\"product-container\"]["+ i +"]//*[@class=\"right-block\"]//*" +
                        "[@itemprop=\"offers\"]//*[@itemprop=\"price\"]");
                firstProductName = methods.getElementsText(firstProductNameLocator);
                firstProductPrice = methods.getElementsText(firstProductPriceLocator);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchTheProduct() {
        try {
            By searchLocator = By.id("search_query_top");
            methods.sendKeysToElement(searchLocator, firstProductName);

            By searchButtonLocator = By.xpath("//*[@id=\"searchbox\"]//*" +
                    "[@class=\"btn btn-default button-search\"]");
            methods.clickElement(searchButtonLocator);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateProduct() {
        try {
            boolean isSuccess = false;
            methods.waitUntilElementLocated(By.xpath("//*[@class=\"product_list grid row\"]"));
            firstProductName = firstProductName.replaceAll("\\s", "");
            firstProductPrice = firstProductPrice.replaceAll("\\s", "");
            List<WebElement> searchedProducts = methods.findElements(By.xpath("//*[@class=\"product_list grid row\"]"));
            int index = 1;
            for (int i = 0; i < searchedProducts.size(); i++) {
                By productNameLocator = By.xpath("//*[@class=\"product_list grid row\"]/li["+ index +"]//*" +
                        "[@class=\"product-container\"]//*" +
                        "[@class=\"right-block\"]//*[@itemprop=\"name\"]//*[@class=\"product-name\"]");
                By productPriceLocator = By.xpath("//*[@class=\"product_list grid row\"]/li["+ index +"]//*" +
                        "[@class=\"product-container\"]//*[@class=\"right-block\"]//*" +
                        "[@itemprop=\"offers\"]//*[@itemprop=\"price\"]");
                String productName = methods.getElementsText(productNameLocator)
                        .replaceAll("\\s", "");
                String productPrice = methods.getElementsText(productPriceLocator)
                        .replaceAll("\\s", "");
                if (productName.equals(firstProductName) && productPrice.equals(firstProductPrice)) {
                    isSuccess = true;
                    break;
                }
                index++;
            }

            if (isSuccess) {
                System.out.println("Verification Successful.");
                System.out.println("====================");
                System.out.println("Test successfully passed!");
                System.out.println("====================");
            } else {
                System.out.println("Verification Failed.");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Test case failed!");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
