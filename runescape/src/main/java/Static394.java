import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static394 {

    @OriginalMember(owner = "client!mh", name = "a", descriptor = "(BFFIFFFF)F")
    public static float method5543(@OriginalArg(1) float arg0, @OriginalArg(2) float arg1, @OriginalArg(3) int arg2, @OriginalArg(4) float arg3, @OriginalArg(5) float arg4, @OriginalArg(6) float arg5, @OriginalArg(7) float arg6) {
        @Pc(7) float local7 = 0.0F;
        @Pc(12) float local12 = arg6 - arg0;
        @Pc(17) float local17 = arg4 - arg5;
        @Pc(37) float local37 = arg1 - arg3;
        @Pc(39) float local39 = 0.0F;
        @Pc(41) float local41 = 0.0F;
        @Pc(43) float local43 = 0.0F;
        while (local7 < 1.1F) {
            @Pc(53) float local53 = arg0 + local7 * local12;
            @Pc(59) float local59 = local17 * local7 + arg5;
            @Pc(65) float local65 = arg3 + local7 * local37;
            @Pc(70) int local70 = (int) local53 >> 9;
            @Pc(75) int local75 = (int) local65 >> 9;
            if (local70 > 0 && local75 > 0 && Static720.mapWidth > local70 && local75 < Static501.mapLength) {
                @Pc(104) int local104 = PlayerEntity.self.level;
                if (local104 < 3 && (Static280.tileFlags[1][local70][local75] & 0x2) != 0) {
                    local104++;
                }
                @Pc(135) int local135 = Static706.floor[local104].averageHeight((int) local53, (int) local65);
                if (local59 > (float) local135) {
                    if (arg2 < 2) {
                        return local7;
                    }
                    return method5543(local39, local65, arg2 - 1, local43, local59, local41, local53) * 0.1F + local7 - 0.1F;
                }
            }
            local43 = local65;
            local41 = local59;
            local7 += 0.1F;
            local39 = local53;
        }
        return -1.0F;
    }

}
