package lt.techin.vm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AplicationTest extends BaseTest {

    @Test
    void addMealName() {
        TracaloriePage page = new TracaloriePage(driver);
        page.setInputItemName("Duona");
        page.setInputItemCalories("50");
        page.setAddMealButtonClick();
        Assertions.assertEquals("Duona",page.addedResult(),"Reiksmes nesutampa");

    }

    @Test
    void addMealNameThreeTimes() {
        TracaloriePage page = new TracaloriePage(driver);
        page.setInputItemName("Duona");
        page.setInputItemCalories("50");
        page.setAddMealButtonClick();
        page.setInputItemName("Mesa");
        page.setInputItemCalories("150");
        page.setAddMealButtonClick();
        page.setInputItemName("Bananas");
        page.setInputItemCalories("35");
        page.setAddMealButtonClick();
        Assertions.assertEquals(page.getCount(),page.getNumberOfMeals(),"skaiciai nesutampa");
        //System.out.println(page.getCount());
        //System.out.println(page.getNumberOfMeals());

    }

    @Test
    void calculateTotalCalories() {
        TracaloriePage page = new TracaloriePage(driver);
        page.setInputItemName("Duona");
        page.setInputItemCalories("50");
        page.setAddMealButtonClick();
        page.setInputItemName("Mesa");
        page.setInputItemCalories("150");
        page.setAddMealButtonClick();
        page.setInputItemName("Bananas");
        page.setInputItemCalories("35");
        page.setAddMealButtonClick();
        Assertions.assertEquals(page.getSum(),Integer.parseInt(page.getTotalCalories()),"skaiciai nesutampa");
        //System.out.println(page.getSum());
        //System.out.println(page.getTotalCalories());
    }



    @Test
    void clearAllButtonTest() {
        TracaloriePage page = new TracaloriePage(driver);
        page.setInputItemName("Duona");
        page.setInputItemCalories("50");
        page.setAddMealButtonClick();
        page.setInputItemName("Mesa");
        page.setInputItemCalories("150");
        page.setAddMealButtonClick();
        page.setInputItemName("Bananas");
        page.setInputItemCalories("35");
        page.setAddMealButtonClick();
        page.setClearAllButtonClick();
        Assertions.assertEquals(0,page.getNumberOfMeals(),"skaiciai nesutampa");
        //System.out.println(page.getNumberOfMeals());

    }

    @Test
    void updateMealTest() {
        TracaloriePage page = new TracaloriePage(driver);
        page.setInputItemName("Duona");
        page.setInputItemCalories("50");
        page.setAddMealButtonClick();
        page.setInputItemName("Mesa");
        page.setInputItemCalories("150");
        page.setAddMealButtonClick();
        page.setInputItemName("Bananas");
        page.setInputItemCalories("35");
        page.setAddMealButtonClick();
        page.setEditIconClick();
        page.clearInputName();
        page.setInputItemName("Zuvys");
        page.clearInputItemCalories();
        page.setInputItemCalories("45");
        page.setUpdateMealButtonClick();

    }

    @Test
    void deleteMealTest() {
        TracaloriePage page = new TracaloriePage(driver);
        page.setInputItemName("Duona");
        page.setInputItemCalories("50");
        page.setAddMealButtonClick();
        page.setInputItemName("Mesa");
        page.setInputItemCalories("150");
        page.setAddMealButtonClick();
        page.setInputItemName("Bananas");
        page.setInputItemCalories("35");
        page.setAddMealButtonClick();
        page.getNumberOfMeals();
        System.out.println(page.getNumberOfMeals());
        page.setEditIconClick();
        page.setDeleteMealButtonClick();
        page.getNumberOfMealsAfterDelete();
        System.out.println(page.getNumberOfMealsAfterDelete());
        Assertions.assertNotEquals(page.getNumberOfMealsAfterDelete(),page.getNumberOfMeals(),"skaiciai sutampa");
    }

    @Test
    void doNotSaveUpdateTest() {
        TracaloriePage page = new TracaloriePage(driver);
        page.setInputItemName("Duona");
        page.setInputItemCalories("50");
        page.setAddMealButtonClick();
        page.setInputItemName("Mesa");
        page.setInputItemCalories("150");
        page.setAddMealButtonClick();
        page.setInputItemName("Bananas");
        page.setInputItemCalories("35");
        page.setAddMealButtonClick();
        page.setEditIconClick();
        page.clearInputName();
        page.setInputItemName("Zuvys");
        page.clearInputItemCalories();
        page.setInputItemCalories("45");
        page.setBackButtonClick();


    }
//    @ParameterizedTest
//    @CsvSource({
//            "bread ,        -1",
//            "banana,        -2",
//            "' ', 10",
//            "'   ',    -700000",
//            "apple, -3"
//    })
//    void addMealNegativeValueTest(String meal1, String calories1) {
//        TracaloriePage page = new TracaloriePage(driver);
//
//        int initialMeals= page.getNumberOfMeals();
//
//        page.setInputItemName(meal1);
//        page.setInputItemCalories(calories1);
//        page.setAddMealButtonClick();
//
//        int afterAddingMeals = page.getNumberOfMeals();
//
//        Assertions.assertEquals(initialMeals,afterAddingMeals, "Calories cant be negative");
//    }




}
