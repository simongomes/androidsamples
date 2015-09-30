# Recipe: Launching Another Activity from an Event
In this recipe, MainActivity.java is the main activity. It launches the
PlayGame activity. Here the trigger event is implemented as a button click using the
Button widget.
When a user clicks the button, the ```startGame()``` function runs; it launches the
PlayGame activity.When a user clicks the button in the PlayGame activity, it calls
```finish()``` to return control to the calling activity.The steps for launching an activity are

1. Declare an Intent that points to the activity to be launched.
2. Call startActivity on this intent.
3. Declare the additional activity in the AndroidManifest.
