# Task Tracker

## Completed — Task 01: Task domain model

Create a `Task` domain class and a `TaskStatus` enum. `Task` should represent:

- `id`
- `title`
- `description`
- `status`

### Constraints

- Choose the types and structure yourself.
- Model `status` with the enum, not a free-form `String`.
- Do not add a controller, database configuration, repository, or API yet.
- Write the code yourself. If syntax blocks you, ask for a **nudge** or **hint**.

### Ready for review when

- The Gradle test task passes.
- You can explain why an enum is preferable here.
- You can explain which fields should be mutable and why.

Review outcome: accepted. `Task` models the required data and `TaskStatus` is correctly declared as an enum.

## Revision queue

- After Task 03: recreate a small enum and explain why its type safety is preferable to a `String`.

## Completed — Task 02: Make Task usable

Review outcome: accepted. The constructor assigns all fields correctly, getters expose the model state, and only `status` is mutable through a setter.

## Completed — Task 03: Unit test the domain model

Create a focused JUnit test class for `Task` under `src/test/java`.

- Construct one `Task` with known values.
- Assert that its getters return those values.
- Change its status using `setStatus`, then assert the updated value.
- Do not start Spring Boot for this test; it should be a plain unit test.

Review outcome: accepted. The tests verify constructed state and the allowed status change without starting Spring Boot.

## Current — Task 04: Add controlled title updates

Add a method to `Task` named `rename` that accepts a new title and updates the task title.

- Do not create a general `setTitle` method.
- Update or add a unit test that proves the title changes after calling `rename`.
- Think of `rename` as a business action rather than a raw field mutation.

Review outcome: accepted. `rename` models a title change as an explicit business action and the unit test verifies it.

## Current — Task 05: Reject blank titles

Make `rename` reject a null, empty, or whitespace-only title.

- Throw `IllegalArgumentException` when the new title is invalid.
- Preserve the original title when the rename attempt is invalid.
- Add a test that verifies the exception and confirms the original title is unchanged.
- Do not introduce Spring validation annotations yet; this is pure Java domain validation.

Ask for a **hint** when ready. Then say: **review my task 05**.

## Next checkpoint

Commit Tasks 01–03 together after running the Gradle test task locally in IntelliJ. Then start Task 04.
