// data that simply consists of different alternative

enum CrustSize:
  case Small, Medium, Large

enum CrustType:
  case Thin, Thick, Regular

enum Topping:
  case Cheese, Pepperoni, BlackOlives, GreenOlives, Onions

// compound container of the different attributes

case class Pizza(
                  crustSize: CrustSize,
                  crustType: CrustType,
                  toppings: Seq[Topping]
                )

// operations

import CrustSize.*
import CrustType.*
import Topping.*

def crustPrice(s: CrustSize, t: CrustType): Double =
  (s, t) match
    // if the crust size is small or medium,
    // the type is not important
    case (Small | Medium, _) => 0.25
    case (Large, Thin) => 0.50
    case (Large, Regular) => 0.75
    case (Large, Thick) => 1.00

def toppingPrice(t: Topping): Double = t match
  case Cheese | Onions => 0.5
  case Pepperoni | BlackOlives | GreenOlives => 0.75

def pizzaPrice(p: Pizza): Double = p match
  case Pizza(crustSize, crustType, toppings) =>
    val base  = 6.00
    val crust = crustPrice(crustSize, crustType)
    val tops  = toppings.map(toppingPrice).sum
    base + crust + tops