package de.tomgrill.gdxfirebase.bindings.googlemobileads.struct;


import apple.coregraphics.struct.CGSize;
import org.moe.natj.c.StructObject;
import org.moe.natj.c.ann.Structure;
import org.moe.natj.c.ann.StructureField;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.ByValue;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.NUInt;

@Generated
@Structure()
public final class GADAdSize extends StructObject {
	static {
		NatJ.register();
	}
	private static long __natjCache;

	@Generated
	public GADAdSize() {
		super(GADAdSize.class);
	}

	@Generated
	protected GADAdSize(Pointer peer) {
		super(peer);
	}

	@Generated
	public GADAdSize(@ByValue CGSize size, @NUInt long flags) {
		super(GADAdSize.class);
		setSize(size);
		setFlags(flags);
	}

	@Generated
	@StructureField(order = 0, isGetter = true)
	@ByValue
	public native CGSize size();

	@Generated
	@StructureField(order = 0, isGetter = false)
	public native void setSize(@ByValue CGSize value);

	@Generated
	@StructureField(order = 1, isGetter = true)
	@NUInt
	public native long flags();

	@Generated
	@StructureField(order = 1, isGetter = false)
	public native void setFlags(@NUInt long value);
}