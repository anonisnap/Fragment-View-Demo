# Fragment-View-Demo

This is an Android Demo Application, using Fragments and a Navigation Controller.

## Navigation

The Navigation was done using the AndroidX NavController. This makes it easy to navigate between pages, and allows for a visual representation of the different pages and their possible navigation-routes.

![navigation_layout](https://user-images.githubusercontent.com/42655737/160244516-562b2ad8-87bc-40b4-ba38-3808fc6a3257.png)

*Visual Representation of [mobile_navigation.xml](https://github.com/anonisnap/Fragment-View-Demo/blob/master/app/src/main/res/navigation/mobile_navigation.xml)*

## Transfering Data with Navigations

The ability to navigate between different Fragments, and transfer data at the same time proves useful for reusing a Fragment, that may need different data shown.

### Receiving Fragment (The one you are Navigating to)

#### XML

For instance, one could have a Fragment designed, to show information about a famous Celebrity, and wished to reuse that Fragment for a host of different celebrities. Transfering an ID of the Celebrity, or a Celebrity Object itself *(This is an option, but transfering an ID and fetching the Celebrity itself is better)*, one could reuse the same Fragment for a lot of people.

To do this, the Fragment that will use the Data, as in the Fragment one would navigate to, should have an Argument Element defined, see XML below. The Argument can have one of a couple of different types, defined by `argType`. The simple Java types, `int`, `long`, `float`, and `boolean`, as well as the Java Object `String` can be passed. If needed, a `Resource Reference` and `Enum` (which are just Integer Values) can also be used. Custom Data Types are also possible, though they need to be implementing either the `Serializable` or the `Parcelable` interface.

```xml
<fragment
  android:id = "@+id/nav_sub_page_two"
  android:name = "com.github.anonisnap.fragmentviewdemo.ui.sub_page_two.SubPageTwoFragment"
  android:label = "@string/menu_sub_two"
  tools:layout = "@layout/fragment_sub_page_two">
  <argument
    android:name = "value"
    app:argType = "integer"
    android:defaultValue = "0" />
</fragment>
```
*XML taken from [mobile_navigation.xml](https://github.com/anonisnap/Fragment-View-Demo/blob/master/app/src/main/res/navigation/mobile_navigation.xml)*

#### Java

# MISSING

### Sending Fragment (The one you are Navigating from)

#### XML

This step is not strictly necessary, though I believe it can help with keeping things well defined. Defining an Action on the Sending Fragment will help keep things simple. This is also what causes the Visualisation, see image further up, to have the Arrows showing which pages will navigate to which.

```xml
<fragment
  android:id = "@+id/nav_secondary_page"
  android:name = "com.github.anonisnap.fragmentviewdemo.ui.page_two.SecondaryMainFragment"
  android:label = "@string/menu_secondary"
  tools:layout = "@layout/fragment_main_secondary">
  <action
    android:id = "@+id/action_nav_secondary_page_to_nav_sub_page_two"
    app:destination = "@id/nav_sub_page_two" />
</fragment>
```

#### Java

# MISSING
