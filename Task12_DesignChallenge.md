# Task 12 — Re-evaluate and Adapt the Design

## A. Impact analysis
The new requirements add e-bikes, delivery vans, visitor one-day passes and a five-floor facility with unequal slot counts. A fixed rectangular array assumes equal capacity per floor; a jagged `String[][]` supports different row lengths. Vehicle hierarchy, pricing logic, pass handling and tests are affected.

## B. Evaluate the original design
If every vehicle category overrides its rate, adding a vehicle can be done with a subclass. However, time-dependent pricing spread across subclasses becomes harder to maintain. A separate `PricingRule` strategy makes pricing changes easier to isolate. Existing tested allocation classes can remain unchanged if they depend on the abstract `Vehicle` API and jagged slot structure.

## C. Adaptation
- `EBike`: flat parking fee (example assumption ₹25).
- `DeliveryVan`: double car rate for the 9 AM–5 PM rule.
- `ParkingPass`: one-day pass for visitors; a valid pass makes the parking charge zero.
- `PricingRule`: interface or strategy to keep fee rules separate.
- `String[][]`: five rows, each with its own capacity.

The assignment does not specify the e-bike fee amount or the exact interpretation of a van stay crossing 9 AM or 5 PM. State your assumption clearly and confirm it with faculty if possible.

## D. Evidence-based defence
Record how many classes changed, run tests for e-bike flat fee, van during and outside the stated time window, one-day pass, unequal floor capacities, full facility and duplicate registration. Prefer composition/strategy when pricing rules are likely to change independently from vehicle categories. Include actual test output screenshots and explain trade-offs rather than claiming unrun tests passed.
