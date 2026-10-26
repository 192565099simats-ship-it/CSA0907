# Task 6 — Inheritance Hierarchy

```text
                 Vehicle (abstract)
                /        |         \
        TwoWheeler      Car      DeliveryVan
                          |
                     ElectricCar

Vehicle is the superclass. This is hierarchical inheritance for vehicle categories, and multilevel inheritance along Vehicle → Car → ElectricCar. Common fields such as registration number are inherited; subclasses supply their type and rate. `super(registrationNumber)` invokes the parent constructor before subclass initialization.

## Constructor trace
Creating `new ElectricCar("TN03C3")` executes:
1. `Vehicle` constructor
2. `Car` constructor
3. `ElectricCar` constructor

## Composition alternative
A `Vehicle` could hold a `VehicleType`/rate strategy. Adding a type then means creating a new strategy rather than a subclass. Fee computation remains O(1) for a direct strategy call. Inheritance is simple for stable categories; composition is more flexible when rates and categories change frequently. Both store O(1) state per vehicle, excluding referenced objects.
