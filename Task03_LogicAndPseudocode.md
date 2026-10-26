# Task 3 — Control Logic and Pseudocode

## Allocate pseudocode
```text
ALLOCATE(vehicleNo)
  FOR each floor f
    FOR each slot s on floor f
      IF slot[f][s] is empty
        slot[f][s] = vehicleNo
        RETURN (f, s)
  RETURN no-slot
```

## Release pseudocode
```text
RELEASE(floor, slot)
  IF floor is outside valid floor indexes: RETURN false
  IF slot is outside that floor's valid indexes: RETURN false
  IF slot is already empty: RETURN false
  mark slot empty
  RETURN true
```

## Fee pseudocode
```text
CALCULATE_FEE(minutes, rate)
  IF minutes < 0: report invalid duration
  billableHours = (minutes + 59) / 60 using integer arithmetic
  fee = billableHours * rate
  RETURN fee
```

The nested loops stop immediately when a free slot is found (`return`). `break` can exit a loop when a result is found; `continue` skips an unsuitable slot. If no slot is free, allocation returns `null`.

## Complexity
Let N be total slots and F floors. Allocation is O(N) worst case and O(1) extra space. Release is O(1). A stack of free coordinates can make allocation/release O(1) on average, but requires O(N) extra storage to keep available coordinates and careful synchronization with occupancy.
