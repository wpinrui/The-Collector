# User Guide

The Collector is a desktop command-line interface (CLI) game in which players get to buy and sell cars from the new or used markets and make money to grow their empire. 

## Quick start

1. Ensure you have Java 11 or above installed in your computer. 
2. Download the latest JAR file from the releases, if any.
3. Copy the file to the folder you want to use as the home folder for the game. 
4. Double-click the file to start the game. 
5. The save file will load automatically. If this is your first time playing, you will be starting a new game. 



## Features

#### Viewing your available cash: `cash`

The Collector will print the amount of money that you have on the screen. 

#### Viewing cars for sale: `shop`

You will be brought to the shop mode, in which you can view listings of cars for sale.

#### Viewing more info about a listing: `view LISTING_NUM` when in a shop

You can view more information about any listing, including the name of the car and its price.

#### Buying a car: `buy LISTING_NUM` when in a shop

You can purchase a car from a shop for the listed price, assuming you have enough money to do so. 

#### Viewing cars in the garage: `garage`

You will be brought to the garage mode, in which you can view all of your cars and how many slots your garage has available for cars.

#### Selling a car: `sell CAR_INDEX` when in your garage

You can sell a car from your garage for a listed price.

#### Viewing more info about a car: `view CAR_INDEX` when in your garage

You can view more information about one of the cars in your garage, including the name of the car and its sale value. 

#### Advance time: `advance`

Once you are done for the current month, you can advance the game time to the next month where you can view a new set of car listings. 

#### Exiting the game: `quit`

You can quit the game at any time. The game is saved automatically.

#### Cheat code to get more money: `cheatMoney AMOUNT`

You can set your money to any amount. This is to prevent poor balancing in the games economy system from breaking the game early in its development.



## Command Summary

| Action                       | Format / usage location / Example                            |
| :--------------------------- | ------------------------------------------------------------ |
| View cash                    | `cash`<br />Usage location: anywhere                         |
| Visit shop                   | `shop`<br />Usage location: anywhere                         |
| Viewing a listing            | `view LISTING_NUM`<br />Usage location: **shop**<br />Example: `view 1` to view the first listing in the shop |
| Buy a listed car             | `buy LISTING_NUM`<br />Usage location: **shop**<br />Example: `buy 2` to buy the second listing in the shop |
| Visit garage                 | `garage`<br />Usage location: anywhere                       |
| Sell a car from the garage   | `sell CAR_INDEX`<br />Usage location: **garage**<br />Example: `sell 1` to sell the first car listed in the garage view |
| View an owned car            | `view CAR_INDEX`<br />Usage location: **garage**<br />Example: `view 2` to view the second car listed in the garage view |
| Advance time                 | `advance`<br />Usage location: anywhere                      |
| Exiting the game             | `quit`<br />Usage location: anywhere                         |
| Cheat code for setting money | `cheatMoney AMOUNT`<br />Usage location: anywhere<br />Example: `cheatMoney 10000` to set the player's money to $10 000 |

