import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static666 {

    @OriginalMember(owner = "client!vba", name = "K", descriptor = "J")
    public static long aLong301;

    @OriginalMember(owner = "client!vba", name = "M", descriptor = "Lclient!sb;")
    public static js5 aJs5_118;

    @OriginalMember(owner = "client!vba", name = "H", descriptor = "Z")
    public static boolean aBoolean766 = false;

    @OriginalMember(owner = "client!vba", name = "h", descriptor = "(I)V")
    public static void method8693(@OriginalArg(0) int arg0) {
        @Pc(5) Class83 local5 = null;
        try {
            @Pc(18) Class270 local18 = Static446.aClass390_6.method8981("");
            while (local18.anInt6789 == 0) {
                Static638.method8395(1L);
            }
            if (local18.anInt6789 == 1) {
                local5 = (Class83) local18.anObject13;
                @Pc(41) Packet local41 = Static400.instance.method5110();
                local5.method2162(local41.data, 0, local41.pos);
            }
        } catch (@Pc(51) Exception local51) {
        }
        try {
            if (local5 != null) {
                local5.method2158();
            }
        } catch (@Pc(58) Exception local58) {
        }
    }
}
