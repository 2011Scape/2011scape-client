import com.jagex.graphics.texture.Node_Sub1_Sub27;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static682 {

    @OriginalMember(owner = "client!vka", name = "i", descriptor = "[I")
    public static int[] anIntArray817 = new int[2];

    @OriginalMember(owner = "client!vka", name = "a", descriptor = "(IIIBI)V")
    public static void method8927(@OriginalArg(2) int x1, @OriginalArg(4) int x2, @OriginalArg(0) int y1, @OriginalArg(1) int y2) {
        if (Static448.anInt6796 != 1) {
            return;
        }
        @Pc(14) int local14 = x1 / Static437.horizontalAspectRatio;
        @Pc(18) int local18 = x2 / Static437.horizontalAspectRatio;
        @Pc(22) int local22 = y1 / Static714.verticalAspectRatio;
        @Pc(26) int local26 = y2 / Static714.verticalAspectRatio;
        if (local14 >= Static211.anInt5574 || local18 < 0 || local22 >= Static617.anInt9434 || local26 < 0) {
            return;
        }
        if (local14 < 0) {
            local14 = 0;
        }
        if (local22 < 0) {
            local22 = 0;
        }
        if (Static617.anInt9434 <= local26) {
            local26 = Static617.anInt9434 - 1;
        }
        if (Static211.anInt5574 <= local18) {
            local18 = Static211.anInt5574 - 1;
        }
        for (@Pc(94) int local94 = local22; local94 <= local26; local94++) {
            @Pc(105) int local105 = Node_Sub1_Sub27.method9118(local94 + Static482.anInt7265, Static617.anInt9434) * Static211.anInt5574;
            for (@Pc(107) int local107 = local14; local107 <= local18; local107++) {
                @Pc(117) int local117 = Node_Sub1_Sub27.method9118(Static632.anInt9503 + local107, Static211.anInt5574) + local105;
                Static173.anIntArray252[local117] = Static420.anInt6436;
            }
        }
    }
}
