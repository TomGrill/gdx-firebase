package de.tomgrill.gdxfirebase.bindings.googlemobileads.protocol;


import apple.uikit.UIViewController;
import de.tomgrill.gdxfirebase.bindings.googlemobileads.GADCustomEventRequest;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.MappedReturn;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("GADCustomEventInterstitial")
public interface GADCustomEventInterstitial {
	@Generated
	@Selector("delegate")
	@MappedReturn(ObjCObjectMapper.class)
	Object delegate();

	@Generated
	@Selector("presentFromRootViewController:")
	void presentFromRootViewController(UIViewController rootViewController);

	@Generated
	@Selector("requestInterstitialAdWithParameter:label:request:")
	void requestInterstitialAdWithParameterLabelRequest(String serverParameter,
			String serverLabel, GADCustomEventRequest request);

	@Generated
	@Selector("setDelegate:")
	void setDelegate(@Mapped(ObjCObjectMapper.class) Object value);
}