# Expensive.

### A janky, ugly and occasionally rude daily expenses tracker

This program will allow users to add and keep track their daily expenses, and can also 
give personalized alerts/reminders when their spending goes over a certain amount, which can be set by the user.
Reminders can range from nice, gentle reminders to roasting and PG insults, depending on what the user sets. *Expensive.* 
can be used by anyone who wants to track of their daily spending habits and may require more motivation to not
spend money unnecessarily. My motivation to make this project stemmed from how I always wondered why my bank account 
balance was so low after every month. After printing a monthly balance statement, I realized how much money I wasted on 
unnecessary, impulse driven purchases such as fast food, clothing, subscriptions or trips out with friends. 
With the cost living continuing to rise and wages not rising to meet the cost, I hope that this application
will allow people to give a second sober thought about spending money impulsively.


### User Stories

- As a user, I want to be able to add expenses to my list of expenses
- As a user, I want to be able to remove expenses from the list of expenses
- As a user, I want to be able to find certain expenses via an ID
- As a user, I want to be able to set the level of reminder 
- As a user, I want to be able to receive feedback for my spending habits
- As a user, I want to be able to see a list of all of my expenses

- As a user, I want to be able to have the application be able to save the number of expenses on the account
- As a user, I want to be able to call up a previously saved account

- As a user, I want to be able to have a GUI that will allow me to add, remove, save and load my expenses

Phase 4, task 2
- I made the remove expense method in the Account class robust, so that it would throw an expense when the customer
  tries to remove an expense that doesn't exist.
  
 Phase 4, task 3
 - I would abstract the panels of the GUI, namely Add, Remove, Show and Load Expenses, into an interface, since they
   all similar behaviours
 - I would have also liked to reduce the amount of coupling between the classes. I feel that some code in the
   model package didn't need to rely on the UI package to function.




