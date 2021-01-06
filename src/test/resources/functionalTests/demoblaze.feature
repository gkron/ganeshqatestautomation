Feature: Demo Online Place order

@sanity
Scenario: As a user I should be able to place order with valid card details
Given I visit the demoblaze home page
When I click on "Laptops"
And I added "Sony vaio i5" to add to cart
And I added another "Dell i7 8gb" to add to cart
And I deleted "Dell i7 8gb" from cart
And I click at Places order
And I fill all the required field
And I click at Purchase order
And I collect the purchase id and amount
Then I should see expected amount  
When I click Ok


            



