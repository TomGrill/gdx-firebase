# gdx-firebase

Firebase extension for libGDX. 

# Expert usage only

**!!Only use this extension if you are a Firebase expert.!!**

# Version

Current stable: none, Current snapshot: 0.0.1-SNAPSHOT

Names for classes and methods are probably gonna change a lot.

# Supported Platforms

Android 5%, Desktop (only for testing purposes) 5%

# Supported Firebase Tools

Realtime Database 5%

# Read first

If you never worked with Firebase before, then get used to Firebase first: https://firebase.google.com/

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

## Desktop

**IMPORTANT:** The desktop project makes use of the Firebase server SDK which can be found here: https://firebase.google.com/docs/server/setup. This SDK is not meant to be shipped with a game project since it would require to ship sensitive private data. The desktop project is only meant for testing purposed while developing. 

For desktop testing you need to follow the steps from this page https://firebase.google.com/docs/server/setup, create a service account and download the json file for your service account. It looks similar to this: project-name-1234def56890.json. I recommend copying the file to the root directory of you project. Set your VCS to ignore this file. You do not want it in your repository.

Since FirebaseAuth is not yet supported by this extension you have to set your database rules for write/read access for everybody

```
{
  "rules": {
    ".read": "auth != null || true",
    ".write": "auth != null || true"
  }
}
```

Again, this is only for testing purposes. 

## Get it running

```
// only required when using desktop
FirebaseConfiguration config = new FirebaseConfiguration();
config.databaseUrl = "https://firebase-databse-url.firebaseio.com/"; // get this from Firebase console
config.serviceAccount = Gdx.files.absolute("/absolute/path/to/your/app/project-name-1234def56890.json"); // see above

FirebaseLoader.load(config);

// In case you do not use Desktop, you can also pass `null`:
FirebaseLoader.load(null);

```


# Usage

```
// this snippet will create an entry and the node `storetest` with key/value.
// Looks like this: -KN2zmtqCTGpPfbxRqcf:"some value"
DatabaseReference reference = firebaseDatabase.getReference("storetest");
String key = reference.push().getKey();
reference.child(key).setValue("some value");
```

All class and method names are aligned to the Android Firebase syntax. So best thing would be to read at least the Android section: https://firebase.google.com/docs/database/android/start/

# License

The project is licensed under the Apache 2 License, meaning you can use it free of charge, without strings attached in commercial and non-commercial projects. We love to get (non-mandatory) credit in case you release a game or app using this project!
