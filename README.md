# spring-mongo-nested-id

### Summary
Minimal implementation to reproduce issue where auto-generated interface methods cannot get a DB entity 
by a nested object id given as a String, although the entity can be obtained by its own id as a String.

### Full Description
The issue is described by [questions like this](http://stackoverflow.com/questions/25441514/how-to-find-collections-by-its-nested-objects-objectid-in-spring-data-using-rep) 
on StackOverflow. It concerns the `findByX` repository interface methods Spring generates for you. In the case of
`findById`, both `String` and `ObjectId` ids work, but in the case of `findByNestedObjectId` only ids of type `ObjectId` work.

In this reproduction, I have two DB objects, `Entity` and `NestedEntity`, and repositories for both. The repository
for `Entity` contains the following methods:
* `findById(String id)`
* `findById(ObjectId id)`
* `findByNestedEntityId(String id)`
* `findByNestedEntityId(ObjectId id)`

I aim to show that all methods except `findByNestedEntityId(String id)` work and return objects while that method returns `null`.

### Running
* Navigate to project directory
* `./gradlew bootrun`
* Each method invocation produces a log line informing us whether it returned null or not
