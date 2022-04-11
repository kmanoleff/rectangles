# Rectangles
Java app to analyze rectangle relationships.  Determine if :
- the rectangles have one or more intersecting lines; or
- one rectangle is wholly contained within the other; or
- the rectangles are adjacent, meaning sharing a side

# Input
The input should be a set of 8 integers defining the two rectangles.  The first 4 represent the first rectangle, the last 4 
the second rectangle.  Each rectangle has a pair of (x,y) coordinates representing the lower left corner and the upper 
right corner.

# Build
Note : uses [Gradle](https://gradle.org/) for build / dependency management.
To build this app locally :
- clone repo to your machine
- navigate to the root of the project
- run `gradle test` - this will run the unit tests (see Unit Tests below)
- run `gradle jar` to create the build folder with the .jar file
- execute the program using `java -jar build/libs/rectangles-1.0.0.jar "0" "0" "1" "1" "2" "2" "4" "4"` where `1.0.0` is
the current version number and the 8 values describe the rectangles (see Input above)

# Unit Tests
There were several unit tests created that would help to ensure proper functionality.  Tests can be run across the app
using `gradle test` or individually using, for example, `gradle test --tests InputValidationTests.testProcessValidInput`

[**InputValidationTests**](https://github.com/kmanoleff/rectangles/blob/master/src/test/java/InputValidationTests.java)

`testProcessValidInput` a valid input would be 8 integers so this test makes sure the inputs can all be cast as such

`testNotEnoughCoordinates` verifies a scenario is addressed if less than 8 integers are provided, avoid out of bounds exception, etc

`testNonIntegerProvided` verifies a scenario is address if something other than numbers are provided, avoids operation errors, etc.

[**RectangleTests**](https://github.com/kmanoleff/rectangles/blob/master/src/test/java/RectangleTests.java)

`testRectangleCreation` verifies that a rectangle object is created and mapped to the coordinates correctly

`testNotARectangle` verifies a scenario is address where the input can't possibly represent a rectangle, for
example the upper right corner is lower than the lower left, etc.

`testContainment` test when one rectangle is wholly contained within another.  In this example rectangle 1 has lower left
coordinate of (0,0) and upper right of (8,6).  Rectangle 2 has coordinates of (1,1) and (6,4) so all points of rectangle 2 are
contained within rectangle 1.

<img src="/src/main/resources/containment.png" width="200" height="200">

`testIntersection` test when the rectangles are intersecting.  In this example rectangle 1 has coordinates of (0,0) and (8,6).
Rectangle 2 has coordinates of (4,5) and (11,8).  There are only some points of the two rectangles that intersect.

<img src="/src/main/resources/intersection.png" width="200" height="200">

`testAdjacency` test when the rectangles are not contained or intersecting but they do share a side.  In this example
rectangle 1 - (0,0) (7,3) - and rectangle 2 - (7,0) (9,6) - share the right and left sides, respectively.

<img src="/src/main/resources/adjacency.png" width="200" height="200">

`testNoCondition` - test when no conditions are met.  These two rectangles have none of the above relationships.

<img src="/src/main/resources/no-relation.png" width="200" height="200">
