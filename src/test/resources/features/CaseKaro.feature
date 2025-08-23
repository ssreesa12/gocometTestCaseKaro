Feature: CaseKaro Mobile Cover Purchase

    Scenario: CaseKaroMobileCoverPurchase
    # Navigate to website
        Given user navigates to CaseKaro website
    # Click on Mobile covers
        When user click on Mobile Covers
    # Click on search button and type Apple
        And user click on search button and search for "Apple"
        Then user validate "Apple" brand results should be "visible"

    # Add negative validation for other brands to not be visible after search
        Then user validate "Asus" brand results should be "not-visible"
        Then user validate "Google" brand results should be "not-visible"
        Then user validate "Honor" brand results should be "not-visible"
        Then user validate "Infinix" brand results should be "not-visible"
        Then user validate "IQOO" brand results should be "not-visible"
        Then user validate "Lenovo" brand results should be "not-visible"
        Then user validate "Moto" brand results should be "not-visible"
        Then user validate "Nokia" brand results should be "not-visible"
        Then user validate "Oneplus" brand results should be "not-visible"
        Then user validate "Oppo" brand results should be "not-visible"
        Then user validate "Poco" brand results should be "not-visible"
        Then user validate "Realme" brand results should be "not-visible"
        Then user validate "Redmi" brand results should be "not-visible"
        Then user validate "Samsung" brand results should be "not-visible"
        Then user validate "Vivo" brand results should be "not-visible"

    # Click apple and search model Iphone 16 pro
        When user click "Apple" brand
        Then search model "iPhone 16 Pro"

    # Click Choose options for first item
    # Each item will have 3 materials user added those into cart
        And user Click Choose options for first item
        And user adds "Hard" material cases to cart
        And user Click Choose options for first item
        And user adds "Soft" material cases to cart
        And user Click Choose options for first item
        And user adds "Glass" material cases to cart

    # Open cart
        When user opens cart
    # Validate all 3 items are added in cart
        Then user validate "Hard" items should be present in cart
        Then user validate "Soft" items should be present in cart
        Then user validate "Glass" items should be present in cart

    # Print the price of all items with details in console [Material, Price, Link]
        And print the price of all items with details
