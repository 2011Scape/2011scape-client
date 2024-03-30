import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!cc")
public final class ScreenSizeOption extends Option {

    @OriginalMember(owner = "client!cc", name = "<init>", descriptor = "(ILclient!kv;)V")
    public ScreenSizeOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!cc", name = "<init>", descriptor = "(Lclient!kv;)V")
    public ScreenSizeOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!cc", name = "a", descriptor = "(IB)I")
    @Override
    public int canSet(@OriginalArg(0) int value) {
        return 1;
    }

    @OriginalMember(owner = "client!cc", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return super.options.getEnvironment().isArmCpu() ? 3 : 2;
    }

    @OriginalMember(owner = "client!cc", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!cc", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.value < 1 || super.value > 3) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!cc", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }
}
