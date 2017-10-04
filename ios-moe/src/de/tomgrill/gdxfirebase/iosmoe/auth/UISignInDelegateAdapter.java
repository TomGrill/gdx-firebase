package de.tomgrill.gdxfirebase.iosmoe.auth;

import apple.foundation.NSError;
import apple.uikit.UIViewController;
import de.tomgrill.gdxfirebase.bindings.googlesignin.GIDSignIn;
import de.tomgrill.gdxfirebase.bindings.googlesignin.protocol.GIDSignInDelegate;
import de.tomgrill.gdxfirebase.bindings.googlesignin.protocol.GIDSignInUIDelegate;

public class UISignInDelegateAdapter implements GIDSignInUIDelegate {
    @Override
    public void signInPresentViewController(GIDSignIn signIn, UIViewController viewController) {
        if(signIn != null) {
            System.out.println(signIn.clientID());
            System.out.println(signIn.currentUser().userID());
        }
    }

    @Override
    public void signInDismissViewController(GIDSignIn signIn, UIViewController viewController) {
        if(signIn != null) {
            System.out.println(signIn.clientID());
            System.out.println(signIn.currentUser().userID());
        }
    }

    @Override
    public void signInWillDispatchError(GIDSignIn signIn, NSError error) {
        if(signIn != null) {
            System.out.println(signIn.clientID());
            System.out.println(signIn.currentUser().userID());
        }
    }
}
