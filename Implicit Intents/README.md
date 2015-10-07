# Recipe: Using Implicit Intents for Creating an Activity

Implicit intents do not specify an exact component to use. Instead, they specify the functionality
required through a filter, and the Android system must determine the best component
to utilize. An intent filter can be either an action, data, or a category.

The most commonly used intent filter is an action, and the most common action is
ACTION_VIEW.This mode requires a uniform resource identifier (URI) to be specified and
then displays the data to the user. It does the most reasonable action for the given URI.
For example, the implicit intents in case 0, 1, and 2 in the following example have the
same syntax but produce different results.

The steps for launching an activity using an implicit intent are

1. Declare the intent with the appropriate filter specified (``ACTION_VIEW``, ``ACTION_WEB_SEARCH``, and so on).
2. Attach any extra information to the intent required to run the activity.
3. Pass this intent to startActivity().