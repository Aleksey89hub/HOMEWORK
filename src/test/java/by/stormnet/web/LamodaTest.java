package by.stormnet.web;

import by.stormnet.automation.core.common.RetryAnalyzer;
import by.stormnet.web.helpers.BoxHelper;
import by.stormnet.web.helpers.GoodsHelper;
import by.stormnet.web.helpers.LamodaMainHelper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LamodaTest {
    private LamodaMainHelper mainHelper = new LamodaMainHelper();
    private GoodsHelper goodsHelper = new GoodsHelper();
    private BoxHelper boxHelper = new BoxHelper();

    @Test(dataProvider = "searchText", priority = 1)
    public void searchOnLamoda(String data) {
        mainHelper.openLamoda().search(data);
        Assert.assertTrue(mainHelper.resultsNumber() > 0, "Goods are NOT found");
    }

    @Test(priority = 2)
    public void paginationCheck() throws InterruptedException {
        Assert.assertTrue(mainHelper.pageOpen("pagination"), "Next page is NOT opened");
    }

    @Test(priority = 3)
    public void openGoodsItems() throws InterruptedException {
        mainHelper.openGoods();
        System.out.println("Pages are opened");
        Thread.sleep(1000);
        goodsHelper.setTabsList();
        goodsHelper.navigateToGoodsPage(goodsHelper.getInitIndex(mainHelper.getInit()) + 1);
        Assert.assertTrue(goodsHelper.checkElements(), "Not all elements");
    }

    @Test(priority = 4)
    public void addGoodsToBox() throws InterruptedException {
        goodsHelper.addAll(goodsHelper.getInitIndex(mainHelper.getInit()));
        goodsHelper.navigateToGoodsPage(goodsHelper.getInitIndex(mainHelper.getInit()));
        mainHelper.pageOpen("box");
        Assert.assertTrue(boxHelper.resultsNumber() == 5, "Box contains NOT all goods");
    }

    @Test(priority = 5)
    public void checkBoxElements() {
        Assert.assertTrue(boxHelper.checkElements(), "Not all elements");
    }

    @AfterClass
    public void tearDown() {
        mainHelper.quite();
    }

    @DataProvider(name = "searchText")
    public Object[][] providerData() {
        return new Object[][]{{"Джинсы"}, {"Пальто"}, {"Платья"}};
    }
}
