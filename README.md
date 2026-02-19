# CS712AndroidApp 
## Assignment 1
=======
# CS712AndroidApp 

## Assignment 1
>>>>>>> main

This repository is used for CS712 coursework.

It contains:
- A GitHub Project (Kanban board) to track assignments and course projects
- GitHub issues (9) representing all assignments and projects for the course

The repository will be updated throughout the semester as assignments and projects are completed.
<br>
## Assignment 2

Name: Shabnaj Liaqat
Student ID: 1568382

Device Used: Samsung SM-M127G
Android Version: Android 13 (API 33)

App includes:
>>>	Main Activity with explicit intent and implicit intent
    -	displaying the student's full name and student ID
    -	Including two buttons:
      -	Start Activity Explicitly → Launches the second activity using an explicit intent
      -	Start Activity Implicitly → Launches the second activity using an implicit intent
>>> Second Activity
    -	displaying a list of at least five mobile software engineering challenges
    -	Including a button labeled Main Activity that returns to the main activity when clicked
<br>
## Assignment 3

Device Used: Samsung SM-M127G
Android Version: Android 13 (API 33)

App includes:

>>> Main Activity Changes
    - Adding a Start Service button to start the service
    - Adding a Send Broadcast button to send a custom broadcast
>>> Service
    - Create a foreground service
    - When it is started, display a notification saying: The service has started
>>> Broadcast Receiver
    - Create a broadcast receiver class (e.g., MyBroadcastReceiver)
    - Register it dynamically in the main activity using an Intent Filter for a custom action, e.g., "com.example.MY_ACTION"
    - When the broadcast is received, display a Toast message: Broadcast received!
    - Unregister the receiver in onStop() or onDestroy().

