import com.jagex.core.io.Packet;
import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static396 {

    @OriginalMember(owner = "client!mi", name = "a", descriptor = "(IB[B)[B")
    public static byte[] method5550(@OriginalArg(0) int arg0, @OriginalArg(2) byte[] arg1) {
        @Pc(14) byte[] local14 = new byte[arg0];
        Arrays.copy(arg1, 0, local14, 0, arg0);
        return local14;
    }

    @OriginalMember(owner = "client!mi", name = "a", descriptor = "(Lclient!ge;B)Lclient!pfa;")
    public static Class154_Sub3 method5552(@OriginalArg(0) Packet arg0) {
        return new Class154_Sub3(arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g3(), arg0.g1());
    }
}
