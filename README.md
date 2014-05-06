NDK-Calculator-Example
======================

This is a simple implementation of an android calculator using NDK

** HOW TO:

Prerequisite:
1. Create a jni folder in your project
2. Paste the Calculator.c, Android.mk, Application.mk files in jni
3. Replace Java_com_example_syncocard_NativeLib_add() with Java_your_package_name_NativeLib_add()
   NOTE: Do this with the subtract, divide and multiply methods too.

Compiling instructions (on OSX)
1. Download the android NDK
2. Open terminal and browse to the jni folder in your project
3. Paste the below command: 
    /Users/MacUser/Documents/Android/android-ndk-r9d/ndk-build
    NOTE: ndk-build is within the root folder of android-ndk, so you would have to browse to whatever location you have saved yours
4. Refresh project if necessary and you should see the .so files necessary to run the project.
5. Run project as Android application. 


Enjoy!
