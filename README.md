# gdx-firebase

Firebase extension for libGDX. 

# Expert usage only

**!!Only use this extension if you are a Firebase expert.!!** More at https://firebase.google.com/

## Updates & News
Follow me to receive updatest about this and my other projects (Promise: No BS posts)

https://twitter.com/TomGrillGames

https://www.facebook.com/tomgrillgames

I will also stream sometimes when developing at https://www.twitch.tv/tomgrill and write a blog article from time to time at http://tomgrill.de 

# Version

Current stable: none, Current snapshot: 0.0.1-SNAPSHOT

Names for classes and methods are probably gonna change a lot.

# Supported Platforms

Android 5%, Desktop (only for testing purposes) 5%

# Supported Firebase Tools

Realtime Database 5%

# Installation

Add to the corresponding dependencies section of your build.gradle:

```
compile "de.tomgrill.gdxfirebase:gdx-firebase-core:0.0.1-SNAPSHOT"
compile "de.tomgrill.gdxfirebase:gdx-firebase-android:0.0.1-SNAPSHOT"
compile "de.tomgrill.gdxfirebase:gdx-firebase-desktop:0.0.1-SNAPSHOT"
```

## Android

Edit android/build.gradle and add this line at the END of the file:

```
apply plugin: 'com.google.gms.google-services'
```

Place the `google-services.json` in the android directory of you libGDX project. If you do not know what the `google-services.json` file is then make yourself familiar with Firebase first before using this extension.

## Authentication

The following steps are only necessary if you want to make use of the Firebase Authentication feature on desktop:

On desktop authentication must either be written by you or the extension will use a default implementation. Since other platforms provide a FirebaseUser object for you, you only have to provide your own custom user when running on desktop:

```java
// Load a user from a Json file. In case you do not want to store user credentials in your VCS 
// I recommend this method and exclude the json file from VCS.
FirebaseUser firebaseUser = new FirebaseUserBuilder("/path/to/userfile/myuser.json").build();

// Alternatively you can build a user from scratch like this:
FirebaseUser firebaseUser = new FirebaseUserBuilder()
      .setUid("SUPER_SECRET_UID")
      .setName("Mike Pike")
      ....
      .built();
      
// Generate JSON:
FirebaseUser firebaseUser = new FirebaseUserBuilder()
      .setUid("SUPER_SECRET_UID")
      .setName("Mike Pike")
      ....
      .prettyPrint(); // store the output in a file for reuse like above.
```

You can also built your own user object by implementing FirebaseUser interface.

In order to use your the FirebaserUser assign it to your config:

```java
FirebaseConfiguration config = new FirebaseConfiguration();
config.desktopFirebaseUser = firebaseUser; // required on desktop
```

As mentioned above the extension comes with a desktop implementation of `FirebaseAuth`. The implementation behaves as if any sign in method will always granted access. Credentials are not validated. In case you want certain behavior (for testing) or back your app with your own `FirebaseAuth` implementation then just implement the `FirebaseAuth` interface and assign to the config:

```java
public class YourOwnFirebaseAuth implements FirebaseAuth {
..
}

config.desktopFirebaseAuth = new YourOwnFirebaseAuth(); // optional
```


## Realtime Database

**IMPORTANT:** The desktop project makes use of the Firebase server SDK which can be found here: https://firebase.google.com/docs/server/setup. This SDK is not meant to be shipped with a game project since it would require to ship sensitive private data. The desktop project is only meant for testing purposed while developing. 

For desktop testing you need to follow the steps from this page https://firebase.google.com/docs/server/setup, create a service account and download the json file for your service account. It looks similar to this: project-name-1234def56890.json. I recommend copying the file to the root directory of you project. Set your VCS to ignore this file. You do not want it in your repository.

Again, this is only for testing purposes. 


```java
// only required when using desktop
config.databaseUrl = "https://firebase-databse-url.firebaseio.com/"; // get this from Firebase console
config.serviceAccount = Gdx.files.absolute("/absolute/path/to/your/app/project-name-1234def56890.json"); // see above

```
## Let's go

After you have prepared your configuration for desktop load the extension like this:

```java

// In case you use desktop
FirebaseLoader.load(config, 
                            FirebaseFeatures.REALTIME_DATABASE, // Just pass the enum for each FirebaseFeatures you want to enable.
                            FirebaseFeatures.AUTHENTICATION
                  );

// In case you do not use Desktop, you can also pass `null`:
FirebaseLoader.load(null, 
                            FirebaseFeatures.REALTIME_DATABASE, // Just pass the enum for each FirebaseFeatures you want to enable.
                            FirebaseFeatures.AUTHENTICATION
                  );
```

# Usage

## Authentication

Register an `AuthStateListener` which will listen on user state changes. This can happen any time while the app is running. So better be prepared to handle `onAuthStateChanged` on a global place.

```java
GDXFirebase.FirebaseAuth().addAuthStateListener(new AuthStateListener() {
            @Override
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() == null) {
                    // User singed out. Do something...
                } else {
                    // User signed in. Do something...
                }
            }
        });
GDXFirebase.FirebaseAuth().signInAnonymously();
```

All class and method names are aligned to the Android Firebase syntax. So best thing would be to read at least the Android section: https://firebase.google.com/docs/auth/android/manage-users

## Realtime Database

```java
// this snippet will create an entry and the node `storetest` with key/value.
// Looks like this: -KN2zmtqCTGpPfbxRqcf:"some value"
DatabaseReference reference = GDXFirebase.FirebaseDatabase().getReference("storetest");
String key = reference.push().getKey();
reference.child(key).setValue("some value");
```

All class and method names are aligned to the Android Firebase syntax. So best thing would be to read at least the Android section: https://firebase.google.com/docs/database/android/start/

# License

The project is licensed under the Apache 2 License, meaning you can use it free of charge, without strings attached in commercial and non-commercial projects. We love to get (non-mandatory) credit in case you release a game or app using this project!
