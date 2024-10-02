package mobile.test.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P_Page {
    private AndroidDriver<AndroidElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
    private AndroidElement productsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'productName')]")
    private List<AndroidElement> productNames;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'productAddBtn')]")
    private List<AndroidElement> addToCartButtons;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'cartBadge')]")
    private AndroidElement cartBadge;

    public P_Page(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isProductsPageLoaded() {
        return productsTitle.isDisplayed();
    }

    public void addProductToCart(String productName, int quantity) {
        int index = findProductIndexByName(productName);
        if (index != -1) {
            for (int i = 0; i < quantity; i++) {
                addToCartButtons.get(index).click();
            }
        }
    }

    public int getCartItemCount() {
        return Integer.parseInt(cartBadge.getText());
    }

    private int findProductIndexByName(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equals(productName)) {
                return i;
            }
        }
        return -1;  // Retorna -1 si no se encuentra el producto
    }
}