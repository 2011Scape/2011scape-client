import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vka")
public final class Class387 {

    @OriginalMember(owner = "client!vka", name = "j", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_223 = new ReferenceCache(128);

    @OriginalMember(owner = "client!vka", name = "d", descriptor = "Lclient!sb;")
    public final js5 aJs5_122;

    @OriginalMember(owner = "client!vka", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class387(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2) {
        this.aJs5_122 = arg2;
        if (this.aJs5_122 != null) {
            @Pc(20) int local20 = this.aJs5_122.groupSize() - 1;
            this.aJs5_122.fileLimit(local20);
        }
    }

    @OriginalMember(owner = "client!vka", name = "a", descriptor = "(II)Lclient!bt;")
    public Class53 method8925(@OriginalArg(0) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_223;
        @Pc(16) Class53 local16;
        synchronized (this.aReferenceCache_223) {
            local16 = (Class53) this.aReferenceCache_223.get((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(40) byte[] local40 = this.aJs5_122.getfile(Static61.method1313(arg0), Static188.method2857(arg0));
        local16 = new Class53();
        if (local40 != null) {
            local16.method1222(new Packet(local40));
        }
        @Pc(66) ReferenceCache local66 = this.aReferenceCache_223;
        synchronized (this.aReferenceCache_223) {
            this.aReferenceCache_223.put(local16, (long) arg0);
            return local16;
        }
    }
}
