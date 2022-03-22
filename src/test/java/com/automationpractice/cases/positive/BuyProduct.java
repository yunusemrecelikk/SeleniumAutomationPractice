package com.automationpractice.cases.positive;

import com.automationpractice.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BuyProduct {
    Methods methods;

    private String productName;
    public BuyProduct() { methods = new Methods(); }

    public void loginToWebsite() {
        try {
            By signinButtonLocator = By.cssSelector(".header_user_info");
            methods.waitUntilElementLocated(signinButtonLocator);
            methods.clickElement(signinButtonLocator);

            By authenticationText = By.cssSelector("#center_column > .page-heading");
            Assert.assertEquals("Verification Failed: Failed to open Authentication page," +
                    " test case failed.", "AUTHENTICATION", methods.getElementsText(authenticationText));

            By emailInput = By.id("email");
            By passwordInput = By.id("passwd");
            By signInButton = By.id("SubmitLogin");

            methods.sendKeysToElement(emailInput, "pageg318086@ishop2k.com");
            methods.sendKeysToElement(passwordInput, "1q2w3e4r5t");
            Assert.assertEquals("Verification Failed: Not correct email written, " +
                    "test case failed!", "pageg318086@ishop2k.com", methods.getElementsValue(emailInput));
            Assert.assertEquals("Verification Failed: Not correct password written, " +
                    "test case failed!", "1q2w3e4r5t", methods.getElementsValue(passwordInput));

            methods.clickElement(signInButton);

            By successfullySignInLocator = By.cssSelector("#center_column > .info-account");
            methods.waitUntilElementCliclable(successfullySignInLocator);

            Assert.assertTrue("Verification Failed: Did not login successfully!," +
                    "test case failed!", methods.getElementsText(successfullySignInLocator)
                    .contains("Welcome to your account."));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openCategory() {
        try {
            By womenCategoryLocator = By.xpath("//*[@class=\"sf-with-ul\"][text()=\"Women\"]");
            methods.scrollToElement(womenCategoryLocator);
            By tshirtsCategoryLocator = By.xpath("//*[@class=\"sf-menu clearfix menu-content sf-js-enabled sf-arrows\"]" +
                    "/li/ul/li/ul/li/a[text()=\"T-shirts\"]");
            methods.waitUntilElementCliclable(tshirtsCategoryLocator);
            methods.clickElement(tshirtsCategoryLocator);

            By tShirtCategoryTextLocator = By.xpath("//*[@class=\"page-heading product-listing\"]//*" +
                    "[@class=\"cat-name\"]");
            methods.waitUntilElementLocated(tShirtCategoryTextLocator);
            String categoryName = methods.getElementsText(tShirtCategoryTextLocator);
            categoryName = categoryName.replaceAll("\\s", "");
            Assert.assertEquals("Verification Failed: T-shirts category did not opened," +
                    " test case failed.", "T-SHIRTS", categoryName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openFirstProduct() {
        try {
            By productsListLocator = By.xpath("//*[@class=\"product_list grid row\"]");
            List<WebElement> products = methods.findElements(productsListLocator);
            for (int i = 1; i < products.size() + 1; i++) {
                if (i > 1) {
                    break;
                }
                By productImage = By.xpath("//*[@class=\"product_list grid row\"]/li//*" +
                        "[@class=\"product-container\"]["+ i +"]//*[@class=\"left-block\"]//*" +
                        "[@class=\"product-image-container\"]//*[@class=\"product_img_link\"]");
                methods.scrollToElement(productImage);

                By productMoreButton = By.xpath("//*[@class=\"product_list grid row\"]/li//*" +
                        "[@class=\"product-container\"]["+ i +"]//*[@class=\"right-block\"]//*" +
                        "[@class=\"button-container\"]//*[@class=\"button lnk_view btn btn-default\"]");
                methods.waitUntilElementCliclable(productMoreButton);
                By productNameLocator = By.xpath("//*[@class=\"product_list grid row\"]/li" +
                        "//*[@class=\"product-container\"]["+ i +"]//*[@class=\"right-block\"]/h5" +
                        "//*[@class=\"product-name\"]");
                productName = methods.getElementsText(productNameLocator);
                methods.clickElement(productMoreButton);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void increaseQuantity() {
        try {
            By productDescriptionName = By.xpath("//*[@class=\"pb-center-column col-xs-12 col-sm-4\"]//*" +
                    "[@itemprop=\"name\"]");
            methods.waitUntilElementLocated(productDescriptionName);
            Assert.assertEquals("Verification Failed: Not correct product opened," +
                    " test case failed.", productName, methods.getElementsText(productDescriptionName));

            By quantity = By.id("quantity_wanted");
            methods.clearElement(quantity);
            methods.sendKeysToElement(quantity, "2");
            Assert.assertEquals("Verification Failed: Failed to increase quantity to 2," +
                    "test case failed!", "2", methods.getElementsValue(quantity));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectSize() {
        try {
            By sizeSelectLocator = By.id("group_1");
            methods.selectByText(sizeSelectLocator, "L");
            Assert.assertEquals("Verification Failed: Not correct size selected, " +
                    "test case failed.", "L", methods.getSelectedText(sizeSelectLocator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectColor() {
        try {
            By blueColorLocator = By.xpath("//*[@id=\"color_14\"][@name=\"Blue\"]");
            methods.clickElement(blueColorLocator);

            By selectedColorValueLocator = By.xpath("//*[@class=\"attribute_list\"]//*[@class=\"color_pick_hidden\"]");
            methods.waitUntilElementLocated(selectedColorValueLocator);
            Assert.assertEquals("Verification Failed: Blue color is not selected," +
                    "test case failed.", "14", methods.getElementsValue(selectedColorValueLocator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickAddToCart() {
        try {
            By addToCartButtonLocator = By.xpath("//*[@id=\"add_to_cart\"]//*" +
                    "[@type=\"submit\"]//*[text()=\"Add to cart\"]");
            methods.clickElement(addToCartButtonLocator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buyTheProduct() {
        try {
            By checkoutButtonLocator = By.xpath("//*[@id=\"layer_cart\"]//*[@class=\"clearfix\"]//*" +
                    "[@class=\"layer_cart_cart col-xs-12 col-md-6\"]//*[@class=\"button-container\"]//*" +
                    "[@title=\"Proceed to checkout\"]");
            methods.waitUntilElementCliclable(checkoutButtonLocator);


            By successfullyAddToCart = By.id("layer_cart_product_title");
            methods.waitUntilElementLocated(successfullyAddToCart);

            Assert.assertTrue("Verification Failed: Product didn't added to cart successfully," +
                    " test case failed.", methods.getElementsText(successfullyAddToCart).equals(productName));

            methods.clickElement(checkoutButtonLocator);

            By orderPageLocator = By.id("cart_title");
            methods.waitUntilElementLocated(orderPageLocator);

            By orderCheckoutButtonLocator = By.xpath("//*[@id=\"center_column\"]//*" +
                    "[@class=\"cart_navigation clearfix\"]//*[@title=\"Proceed to checkout\"]");
            methods.clickElement(orderCheckoutButtonLocator);

            By addressOrderCheckOutLocator = By.xpath("//*[@id=\"center_column\"]//*" +
                    "[@class=\"cart_navigation clearfix\"]//*[@class=\"button btn btn-default button-medium\"]" +
                    "/span[text()=\"Proceed to checkout\"]");
            methods.waitUntilElementCliclable(addressOrderCheckOutLocator);
            methods.clickElement(addressOrderCheckOutLocator);

            By termsCheckBox = By.xpath("//*[@class=\"checkbox\"]//*[@id=\"uniform-cgv\"]/span//*[@id=\"cgv\"]");
            methods.waitUntilElementLocated(termsCheckBox);

            methods.clickElement(termsCheckBox);

            Assert.assertTrue("Verification Failed: Terms is not accepted," +
                    " test case failed.", methods.isElementSelected(termsCheckBox));

            By orderCheckoutLocator = By.xpath("//*[@class=\"cart_navigation clearfix\"]/button");
            methods.clickElement(orderCheckoutLocator);

            By payByCheckLocator = By.xpath("//*[@id=\"HOOK_PAYMENT\"]//*[@class=\"row\"]//*" +
                    "[@class=\"col-xs-12 col-md-6\"]//*[@class=\"payment_module\"]//*[@class=\"cheque\"]");
            methods.waitUntilElementCliclable(payByCheckLocator);
            methods.clickElement(payByCheckLocator);

            By confirmOrderButton = By.xpath("//*[@id=\"cart_navigation\"]//*" +
                    "[@class=\"button btn btn-default button-medium\"]/span[text()=\"I confirm my order\"]");
            methods.waitUntilElementCliclable(confirmOrderButton);
            methods.clickElement(confirmOrderButton);

            By orderConfirmationLastPage = By.id("center_column");
            By successTxt = By.xpath("//*[@id=\"center_column\"]//*" +
                    "[@class=\"alert alert-success\"][text()=\"Your order on My Store is complete.\"]");
            methods.waitUntilElementLocated(orderConfirmationLastPage);
            Assert.assertTrue("Verification Failed: Failed to check confirmation success," +
                    "test case failed.", methods.isElementVisible(successTxt));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
