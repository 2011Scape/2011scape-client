import com.jagex.collect.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!cja")
public final class Node_Sub12 extends Node {

    @OriginalMember(owner = "client!cja", name = "o", descriptor = "I")
    public volatile int anInt1631 = -1;

    @OriginalMember(owner = "client!cja", name = "n", descriptor = "Ljava/lang/String;")
    public final String aString14;

    @OriginalMember(owner = "client!cja", name = "<init>", descriptor = "(Ljava/lang/String;)V")
    public Node_Sub12(@OriginalArg(0) String arg0) {
        this.aString14 = arg0;
    }
}
