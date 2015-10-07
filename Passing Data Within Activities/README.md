# Recipe: Passing Primitive Data Types Between Activities

Sometimes data needs to be passed to a launched activity. Sometimes a launched activity
creates data that needs to be passed back to the calling activity. For example, a final score
of a game needs to be returned to a high-scores screen.The different ways to pass information
between activities are

- Declare the relevant variable in the calling activity (for example, ``public int finalScore``) and set it in the launched activity (for example, ``CallingActivity.finalScore=score``).
- Attach extras onto Bundles (demonstrated here).
- Use Preferences to store data to be retrieved later
- Use the SQLite database to store data to be retrieved later

A ``Bundle`` is a mapping from String values to various parcelable types. It can be created by
adding extras to an intent.The following example shows data being passed from the main
activity to the launched activity, where it is modified and passed back.
The variables (in this case, an ``integer`` and a ``String``) are declared in the ``StartScreen`` activity. When the intent is created to call the ``PlayGame`` class, these variables are attached
to the intent using the ``putExtra`` method.When the result is returned from the called
activity, the variables can be read using the ``getExtras`` method.