import com.jagex.Entity;
import com.jagex.math.Trig1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static398 {

    @OriginalMember(owner = "client!mj", name = "n", descriptor = "D")
    public static double aDouble20;

    @OriginalMember(owner = "client!mj", name = "y", descriptor = "[Lclient!eo;")
    public static Entity[] transparentStationaryEntities;

    @OriginalMember(owner = "client!mj", name = "a", descriptor = "(IIIII)I")
    public static int method5560(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
        @Pc(15) int local15 = 65536 - Trig1.COS[arg3 * 8192 / arg0] >> 1;
        return (local15 * arg2 >> 16) + (arg1 * (65536 - local15) >> 16);
    }

    @OriginalMember(owner = "client!mj", name = "a", descriptor = "(BII)Z")
    public static boolean method5562(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return (arg1 & 0x70000) != 0 | Static604.method7904(arg1, arg0) || Static42.method1054(arg0, arg1);
    }
}
