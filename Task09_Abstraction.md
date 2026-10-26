# Task 9 — Abstraction

`Vehicle` should be abstract because a generic vehicle has shared state but should not be instantiated without a concrete category. Its constructor initializes the registration number; abstract methods require subclasses to supply behaviour. `Chargeable` is an interface because charging is a capability that may be implemented by different kinds of vehicles. A class can implement multiple interfaces.

An interface default method is useful for shared optional behaviour; a static interface method can provide a utility related to the capability.

If `Vehicle` became an interface, it could not directly hold per-object instance fields initialized by a constructor, and it could not provide constructor chaining. A class can implement multiple interfaces but extend only one class. Swapping `Chargeable` to an abstract class would restrict classes to one superclass. Method dispatch remains O(1) in both designs; per-object storage depends on actual fields, not whether the contract is an interface or abstract class.
