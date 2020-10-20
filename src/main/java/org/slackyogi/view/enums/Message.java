package org.slackyogi.view.enums;

public enum Message {
    LOGGING("Please enter login (admin for employees):"),
    LOGGED_CLIENT("You are logged as client."),
    LOGGED_EMPLOYEE("You are logged as employee."),
    WELCOMING("Welcome, "),
    MENU_OPTIONS("Choose option:"),
    COLUMNS_OF_PRODUCTS_LISTING("Product:\t\tPrice:"), //TODO create method in Product class to get this string, making it not magical
    ENTER_SEARCHED_PRODUCT_NAME("Please, enter a name of product you want to find:"),
    ENTER_PRODUCT_NAME_FOR_DELETION("Please, enter a name of product you want to delete:"),
    ENTER_PRODUCT_NAME_TO_BE_UPDATED("Please, enter a name of product you want to update:"),
    SEARCHED_PRODUCT_IS_AVAILABLE("Inquired product is available"),
    ADDING_TO_ORDER_PRODUCT_NAME("Enter desired product name:"),
    ADDING_TO_ORDER_PRODUCT_QUANTITY("Enter quantity of product:"),
    CREATING_PRODUCT_AVAILABLE_TYPES("Available types of products are:"),
    CREATING_PRODUCT_OF_A_TYPE("What kind of product do you want to create? "),
    CREATING_PRODUCT_NAME("Please enter new products name:"),
    CREATING_PRODUCT_PRICE("Please enter new products price:"),
    CREATING_FOOD_MASS("Please enter new food mass:"),
    CREATING_DRINK_CAPACITY("Please enter new drink capacity:"),
    ERROR_WRONG_INPUT_PRODUCT_CREATION("Wrong input, product not added."),
    ERROR_NOT_NUMBER("You did not enter a number."),
    ERROR_ENTER_NUMBER_FROM_RANGE("Please enter a number from range of available options."),
    ERROR_MODIFYING_ORDER_WRONG_NAME("You have to enter products name."),
    ERROR_ADDING_TO_ORDER_WRONG_QUANTITY("Quantity of has to be greater than 0."),
    ERROR_NO_SUCH_PRODUCT_AVAILABLE("No such product is available in store."),
    ERROR_NO_SUCH_ITEM_IN_STORE("Store does not have item named: ");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}