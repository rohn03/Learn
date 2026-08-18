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

Review outcome: accepted. Validation occurs before mutation, so invalid renames preserve the existing title. Add separate null and empty-string test cases during a later test-coverage revision.

## Current — Task 06: Start a task through a domain action

Add a method to `Task` named `start`.

- It changes the task status to `IN_PROGRESS`.
- It must reject starting a task whose status is already `DONE` by throwing `IllegalStateException`.
- Add tests for a successful start and for the rejected `DONE` case.
- Do not modify fields directly from the test; call the domain method.

Review outcome: accepted. `start` transitions eligible tasks to `IN_PROGRESS`, rejects `DONE` tasks, and the Gradle test suite passes.

## Next checkpoint

Checkpoint complete: Tasks 01–06 are committed and pushed.

## Completed — Task 07: First Task REST endpoint

Create a `TaskController` in a `controller` package.

- Make it a Spring REST controller.
- Add a `GET /api/tasks` endpoint.
- Return an empty `List<Task>` for now. The HTTP response should be `[]`.
- Do not add a service, database, repository, or hard-coded tasks yet.

Review outcome: accepted. The endpoint maps `GET /api/tasks` and returns an empty JSON array.

## Completed — Task 08: Introduce a service with constructor injection

Move the empty-list behaviour out of `TaskController`.

- Create a `TaskService` in a `service` package and make it a Spring service.
- Give it a method that returns an empty `List<Task>` for now.
- Inject `TaskService` into `TaskController` through the controller constructor.
- Make `getTasks()` delegate to the service method.
- Do not use field injection, a repository, or a database yet.

Run the application and verify `GET /api/tasks` still returns `[]`. Ask for a **hint** if constructor injection syntax is unclear, then say: **review my task 08**.

Review outcome: accepted. `TaskController` takes `TaskService` through constructor injection with a `private final` field, and `getTasks()` delegates to the service, which returns an empty `List<Task>`.

## Current — Task 09: Keep seeded tasks in the service

Give `TaskService` its own in-memory collection of tasks so `GET /api/tasks` returns real data instead of an empty `[]`.

- Add a private in-memory store (e.g. `List<Task>` or `Map<String, Task>`) inside `TaskService`.
- Seed it with a couple of starter `Task` objects so the endpoint has something to return.
- Change the service method to return the contents of that store.
- Leave `TaskController` unchanged — it should still just call the service method.
- Do not add a database, repository, or persistence layer yet.

### Ready for review when

- `GET /api/tasks` returns your seeded tasks as a JSON array (`id`, `title`, `description`, `status`).
- The Gradle test suite passes.
- You can explain why keeping mutable state inside a singleton `@Service` bean is only acceptable for a learning project, and what problem it creates in a real production app (hint: shared mutable state across requests and threads).

Run the application and hit `GET /api/tasks`, then say: **review my task 09**.
