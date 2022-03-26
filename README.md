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

The method, `onCreateView()`, will be called whenever the Fragment is loaded onto the screen. The upper half of the Method was autogenerated by Android Studio, and serve the purpose of getting the page mostly setup. The section outlined by `// ~~ ~~ ~~ ~~ ` is where extra page setup will be done.

To access the Bundle sent from another Fragment, the method `getArguments()` is used. This method is defined by the class Fragment. `getArguments()` returns a Bundle, which is the bundle that was sent upon navigating to this Fragment. The bundle has different methods for getting different datatypes out, and they all share the common trait of requiring a Key to identify what data is needed. What is important, is the Key used when getting data, is the same as the Key used when storing the data in the Bundle, otherwise one will not get the data they put in.

Example of a Receiving Fragment;

```java
public class SubPageTwoFragment extends Fragment {
  private FragmentSubPageTwoBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    SubPageTwoViewModel viewModel = new ViewModelProvider(this).get(SubPageTwoViewModel.class);

    binding = FragmentSubPageTwoBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    final TextView textView = binding.textHeaderSTwo;
    // INFO: This will bind the setText() method from TextView, to the LiveData present in the ViewModel. So when the LiveData changes, the setText will be called
    viewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

    // ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
    // INFO: This is where you would add more code, if you need it to be run on Page Initialisation

    // INFO: 'navigation_value' would be defined from the location, which initiates the navigation to here
    int valueSentThroughNavigation = getArguments() != null ? getArguments().getInt("navigation_value") : 0;
    // getArguments != null -> get the value, else it'll just use 0

    viewModel.showNumberSentFromOtherFragment(valueSentThroughNavigation);

    // ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
    return root;
  }
  
  // More optional code...
  
}
```

*Code taken from [SubPageTwoFragment.java](https://github.com/anonisnap/Fragment-View-Demo/blob/master/app/src/main/java/com/github/anonisnap/fragmentviewdemo/ui/sub_page_two/SubPageTwoFragment.java)*

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
