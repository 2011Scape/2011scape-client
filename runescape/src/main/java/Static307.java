import com.jagex.collect.key.Deque;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static307 {

    @OriginalMember(owner = "client!jo", name = "b", descriptor = "Z")
    public static boolean aBoolean380 = false;

    @OriginalMember(owner = "client!jo", name = "c", descriptor = "Lclient!sia;")
    public static final Deque A_DEQUE___28 = new Deque();

    @OriginalMember(owner = "client!jo", name = "a", descriptor = "I")
    public static int anInt4924 = 0;

    @OriginalMember(owner = "client!jo", name = "a", descriptor = "(ILclient!e;)V")
    public static synchronized void method4477(@OriginalArg(1) Interface5 arg0) {
        if (aBoolean380) {
            return;
        }
        if (anInt4924 <= 0) {
            arg0.w(false);
        } else {
            @Pc(15) Node_Sub52 local15 = new Node_Sub52();
            local15.anInterface5_1 = arg0;
            A_DEQUE___28.addLast(local15);
        }
    }

    @OriginalMember(owner = "client!jo", name = "c", descriptor = "(I)V")
    public static synchronized void method4478() {
        while (true) {
            @Pc(4) Node_Sub52 local4 = (Node_Sub52) A_DEQUE___28.removeFirst();
            if (local4 == null) {
                return;
            }
            local4.anInterface5_1.w(true);
            local4.unlink();
        }
    }

    @OriginalMember(owner = "client!jo", name = "b", descriptor = "(I)V")
    public static synchronized void method4479() {
        anInt4924++;
    }

    @OriginalMember(owner = "client!jo", name = "a", descriptor = "(ZI)V")
    public static synchronized void method4480() {
        aBoolean380 = true;
    }

    @OriginalMember(owner = "client!jo", name = "a", descriptor = "(I)V")
    public static synchronized void method4481() {
        anInt4924--;
        if (anInt4924 == 0) {
            method4478();
        }
    }
}
