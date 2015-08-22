# StopWatch - an example Android application written in TDD
## Used test tools:
* Robolectric
* Espresso
* AssertJ
* Mockito
* Android Test Framework

## Running the unit tests in Android Studio
### Running pure JUnit4 tests
* Choose Unit Tests from the Build Variants view 
* Right click on the class name of the test class, or a test method, or a test package and choose Run
### Running Robolectric tests (which are marked with @RunWith(RobolectricGradleTestRunner.class))
* Choose Unit Tests from the Build Variants view 
* Create a JUnit Run Configuration where you set the Working directory to $MODULE_DIR$
* Run the tests with this configuration

## Running the UI tests in Android Studio
### Running Espresso tests (which are marked with @RunWith(AndroidJUnit4.class))
* Choose Android Instrumentation Tests from the Build Variants view 
* Right click on the class name of the test class, or a test method, or a test package and choose Run