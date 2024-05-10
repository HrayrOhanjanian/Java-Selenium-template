package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class SeleniumActions {
    private static ThreadLocal<Actions> actions = new ThreadLocal<>();

    public static void setActions() {
        actions.set(new Actions(DriverFactory.getDriver()));
    }

    private static Actions getActions() {
        return actions.get();
    }

    public static void removeActions() {
        actions.remove();
    }

    public static void clickOnElement(WebElement element) {
        Waiters.waitForClickableElement(element,10);
        getActions().click(element).build().perform();
    }

    public static void typeTextOnElement(WebElement element, String textToTypeOnElement) {
        Waiters.waitForVisibilityElement(element, 10);
        getActions().sendKeys(element,textToTypeOnElement).build().perform();
    }

    public static void clearTextFromElement(WebElement element) {
        Waiters.waitForVisibilityElement(element,10);
        element.clear();
    }

    public static void clickOnElementFromList(List<WebElement> listName, int index) {
        Waiters.waitForVisibilityAllElements(listName,10);
        for (int i = 0; i < listName.size(); i++) {
            if (i == index) {
                clickOnElement(listName.get(i));
            }
        }
    }

    public static void clearElement(WebElement element) {
        Waiters.waitForVisibilityElement(element, 10);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
    }

    public static void moveToElement(WebElement element) {
        Waiters.waitForClickableElement(element,10);
        getActions().moveToElement(element).build().perform();
    }
}