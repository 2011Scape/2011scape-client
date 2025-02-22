package rs2.client.event.keyboard;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

import java.awt.Component;

@OriginalClass("client!rg")
public abstract class KeyboardMonitor {

    @OriginalMember(owner = "client!kja", name = "b", descriptor = "Lclient!rg;")
    public static KeyboardMonitor instance;

    @OriginalMember(owner = "client!rg", name = "<init>", descriptor = "()V")
    protected KeyboardMonitor() {
    }

    @OriginalMember(owner = "client!vk", name = "a", descriptor = "(ILjava/awt/Component;)Lclient!rg;")
    public static KeyboardMonitor create(@OriginalArg(1) Component arg0) {
        return new SimpleKeyboardMonitor(arg0);
    }

    @OriginalMember(owner = "client!rg", name = "a", descriptor = "(I)Lclient!wka;")
    public abstract KeyLog removeFirstRecorded();

    @OriginalMember(owner = "client!rg", name = "a", descriptor = "(II)Z")
    public abstract boolean isPressed(@OriginalArg(1) int keyCode);

    @OriginalMember(owner = "client!rg", name = "a", descriptor = "(B)V")
    public abstract void record();

    @OriginalMember(owner = "client!rg", name = "b", descriptor = "(B)V")
    public abstract void remove();
}
