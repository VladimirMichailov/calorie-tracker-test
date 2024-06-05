package lt.techin.vm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TracaloriePage {

    WebDriver driver;

    public TracaloriePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="input#item-name")
    WebElement inputItemName;
    // private By inputItemName = By.cssSelector("input#item-name");
    @FindBy(css="input#item-calories")
    WebElement inputItemCalories;
    //private By inputItemCalories = By.cssSelector("input#item-calories");
    @FindBy(css=".add-btn.blue.btn.darken-3")
    WebElement addMealButton;
    //private By addMealButton = By.cssSelector(".add-btn.blue.btn.darken-3");
    @FindBy(css=".blue.btn.clear-btn.lighten-3")
    WebElement clearAllButton;
    // private By clearAllButton = By.cssSelector(".blue.btn.clear-btn.lighten-3");
    @FindBy(css="li:nth-of-type(2) > .secondary-content > .edit-item.fa.fa-pencil")
    WebElement editIcon;
    //private By editIconClick = By.cssSelector("li:nth-of-type(2) > .secondary-content > .edit-item.fa.fa-pencil");
    @FindBy(css=".btn.orange.update-btn")
    WebElement updateMealButton;
    //private By updateMealButtonClick = By.cssSelector(".btn.orange.update-btn");
    @FindBy(css=".btn.delete-btn.red")
    WebElement deleteMealButton;
    // private By deleteMealButtonClick = By.cssSelector(".btn.delete-btn.red");
    @FindBy(css=".back-btn.btn.grey.pull-right")
    WebElement backButton;
    @FindBy(css="body > div.container > h3 > span")
    WebElement totalCalories;
    @FindBy(css = "#item-0 > strong")
    WebElement actualItemName;
    @FindBy(css="ul#item-list li")
    private List <WebElement> meals;



    public int count = 0;
    public void setInputItemName(String itemName){
        inputItemName.sendKeys(itemName);
        count++;
    }

    public int getCount() {
        return count;
    }

    public String addedResult(){

      String s = actualItemName.getText();
     return s.replaceAll(":","");
    }
    public void clearInputName(){
        inputItemName.clear();
    }



    public int sum = 0;

    public void setInputItemCalories(String itemCalories){
        inputItemCalories.sendKeys(itemCalories);
        sum = sum + Integer.parseInt(itemCalories);
    }
    public int getSum() {
        return sum;
    }


    public void clearInputItemCalories(){
        inputItemCalories.clear();
    }
    public void setAddMealButtonClick(){
        addMealButton.click();
    }
    public void setClearAllButtonClick(){
        clearAllButton.click();
    }
    public void setEditIconClick(){
        editIcon.click();
    }
    public void setUpdateMealButtonClick(){
        updateMealButton.click();
    }
    public void setDeleteMealButtonClick(){
        deleteMealButton.click();
    }
    public void setBackButtonClick(){
        backButton.click();
    }
    public String getTotalCalories(){
        return totalCalories.getText();
    }

    public int getNumberOfMeals(){
        return meals.size();
    }
    public int getNumberOfMealsAfterDelete(){
        return meals.size();
    }


}
