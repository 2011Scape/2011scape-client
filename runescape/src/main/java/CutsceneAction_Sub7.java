import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gg")
public final class CutsceneAction_Sub7 extends CutsceneAction {

    @OriginalMember(owner = "client!gg", name = "h", descriptor = "I")
    public final int anInt3415;

    @OriginalMember(owner = "client!gg", name = "g", descriptor = "I")
    public final int anInt3414;

    @OriginalMember(owner = "client!gg", name = "<init>", descriptor = "(Lclient!ge;)V")
    public CutsceneAction_Sub7(@OriginalArg(0) Packet arg0) {
        super(arg0);
        this.anInt3415 = arg0.g2();
        this.anInt3414 = arg0.gSmart2or4null();
    }

    @OriginalMember(owner = "client!gg", name = "b", descriptor = "(I)V")
    @Override
    public void execute() {
        @Pc(8) Class394 local8 = Static507.aClass394Array1[this.anInt3415];
        Static198.animateLocation(local8.anInt10416, local8.anInt10419, local8.anInt10422, local8.anInt10415, local8.anInt10412, Static461.LOC_LAYERS_BY_SHAPE[local8.anInt10415], this.anInt3414);
    }
}
