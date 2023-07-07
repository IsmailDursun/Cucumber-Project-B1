package com.loop.step_definitions;

import com.loop.pages.ProductPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
public class ProductStepDefs {

    ProductPage productPage = new ProductPage();

    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("product.url"));


    }
    @Then("Under {string} category User should be able to see the list of following products")
    public void under_category_user_should_be_able_to_see_the_list_of_following_products(String category, List<String> expectedProducts) {

        productPage.clickCategory(category);

        List<WebElement> produtcsElements = productPage.products;

        List<String> actualProductList = BrowserUtils.getElementsText(produtcsElements);

        Assert.assertEquals(expectedProducts,actualProductList);

    }



    @Then("User should be able to see expected prices in following products")
    public void user_should_be_able_to_see_expected_prices_in_following_products(List<Map<String,String>> productDetails) {

        for (Map<String, String> productDetail : productDetails) {

            System.out.println("====== Product Details====");

            System.out.println(productDetail.get("Category"));

            productPage.clickCategory(productDetail.get("Category"));  // click category

            System.out.println(productDetail.get("Product"));

            String actualPrice = productPage.getProductPrice(productDetail.get("Product")); // get me product price


            // get me expectedPrice

            System.out.println(productDetail.get("expectedPrice"));
            String expectedPrice = productDetail.get("expectedPrice");


            Assert.assertEquals(expectedPrice,actualPrice);

        }

    }



    /*if we need the key then we use map, if we dont need key (header) then we use list*/

    @Then("User should be able to see expected prices in following products with listOflist")
    public void user_should_be_able_to_see_expected_prices_in_following_products_with_list_oflist(List<List<String>> productDetails) {


        for (List<String> productDetail : productDetails) {
            System.out.println(" ======== Product Details ======== ");
            System.out.println(productDetail.get(0));  //  Category
            // click category
            productPage.clickCategory(productDetail.get(0));
            // get product price
            String actualPrice = productPage.getProductPrice(productDetail.get(1));
            System.out.println(productDetail.get(1));  // Product
            // get me expectedPrice
            String expectedPrice = productDetail.get(2);
            System.out.println(productDetail.get(2));  // price

            Assert.assertEquals(expectedPrice,actualPrice);
        }
    }

    @Then("User should be able to see following names in their groups")
    public void user_should_be_able_to_see_following_names_in_their_groups(Map<String,List<String>> mapOfList) {

        List<String> group1 = mapOfList.get("Group1");
        System.out.println(group1);

        System.out.println("============");

        List<String> group2 = mapOfList.get("Group2");
        System.out.println(group2);

        System.out.println("============");

        List<String> group3 = mapOfList.get("Group3");
        System.out.println(group3);
    }


}