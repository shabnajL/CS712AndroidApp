# CS712AndroidApp 

## Assignment 1
> This repository is used for CS712 coursework.

It contains:<br>
- A GitHub Project (Kanban board) to track assignments and course projects
- GitHub issues (9) representing all assignments and projects for the course

The repository will be updated throughout the semester as assignments and projects are completed.
<br>
## Assignment 2

Name: Shabnaj Liaqat</t>
Student ID: 1568382

Device Used: Samsung SM-M127G<br>
Android Version: Android 13 (API 33)

App includes:
>>>	Main Activity with explicit intent and implicit intent<br>
    -	displaying the student's full name and student ID<br>
    -	Including two buttons:<br>
      -	Start Activity Explicitly → Launches the second activity using an explicit intent <br>
      -	Start Activity Implicitly → Launches the second activity using an implicit intent <br>
>>> Second Activity <br>
    -	displaying a list of at least five mobile software engineering challenges <br>
    -	Including a button labeled Main Activity that returns to the main activity when clicked <br>
<br>
## Assignment 3

Device Used: Samsung SM-M127G<br>
Android Version: Android 13 (API 33)

App includes:
>>> Main Activity Changes <br>
    - Adding a Start Service button to start the service<br>
    - Adding a Send Broadcast button to send a custom broadcast<br>
>>> Service <br>
    - Create a foreground service<br>
    - When it is started, display a notification saying: The service has started<br>
>>> Broadcast Receiver<br>
    - Create a broadcast receiver class (e.g., MyBroadcastReceiver)<br>
    - Register it dynamically in the main activity using an Intent Filter for a custom action, e.g., "com.example.MY_ACTION"<br>
    - When the broadcast is received, display a Toast message: Broadcast received!<br>
    - Unregister the receiver in onStop() or onDestroy().<br>

<br> 
## Assignment 4

Device Used: Samsung SM-M127G<br>
Android Version: Android 13 (API 33)

App includes:
>>> Manifest Configuration Reuse
- Attribute Used: android:launchMode="singleTask" <br>
- Application: Added to MainActivity in AndroidManifest.xml inside the <activity> declaration. <br>
- Effect: If MainActivity is already running, launching it again reuses the existing instance rather than creating a new one. <br>
- Why it Matters: This prevents multiple copies of the same activity from stacking up, making navigation more predictable and improving overall app performance and user experience.<br>

<br>
  
