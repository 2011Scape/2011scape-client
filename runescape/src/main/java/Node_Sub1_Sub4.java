import com.jagex.core.io.Packet;
import com.jagex.graphics.EnvironmentLight;
import com.jagex.graphics.MonochromeImageCache;
import com.jagex.graphics.texture.TextureOp;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bu")
public final class Node_Sub1_Sub4 extends TextureOp {

    @OriginalMember(owner = "client!bu", name = "F", descriptor = "I")
    public int anInt1169 = 1;

    @OriginalMember(owner = "client!bu", name = "N", descriptor = "I")
    public int anInt1174 = 0;

    @OriginalMember(owner = "client!bu", name = "P", descriptor = "I")
    public int anInt1173 = 0;

    @OriginalMember(owner = "client!bu", name = "<init>", descriptor = "()V")
    public Node_Sub1_Sub4() {
        super(0, true);
    }

    @OriginalMember(owner = "client!bu", name = "a", descriptor = "(II)[I")
    @Override
    public int[] monochromeOutput(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        if (arg0 <= 107) {
            this.anInt1169 = -17;
        }
        @Pc(19) int[] local19 = super.monochromeCache.get(arg1);
        if (super.monochromeCache.dirty) {
            @Pc(27) int local27 = MonochromeImageCache.anIntArray341[arg1];
            @Pc(33) int local33 = local27 - 2048 >> 1;
            for (@Pc(35) int local35 = 0; local35 < EnvironmentLight.anInt9289; local35++) {
                @Pc(41) int local41 = EnvironmentLight.anIntArray92[local35];
                @Pc(47) int local47 = local41 - 2048 >> 1;
                @Pc(58) int local58;
                if (this.anInt1174 == 0) {
                    local58 = this.anInt1169 * (local41 - local27);
                } else {
                    @Pc(70) int local70 = local47 * local47 + local33 * local33 >> 12;
                    local58 = (int) (Math.sqrt((float) local70 / 4096.0F) * 4096.0D);
                    local58 = (int) ((double) (local58 * this.anInt1169) * 3.141592653589793D);
                }
                local58 -= local58 & 0xFFFFF000;
                if (this.anInt1173 == 0) {
                    local58 = Static222.anIntArray289[local58 >> 4 & 0xFF] + 4096 >> 1;
                } else if (this.anInt1173 == 2) {
                    local58 -= 2048;
                    if (local58 < 0) {
                        local58 = -local58;
                    }
                    local58 = 2048 - local58 << 1;
                }
                local19[local35] = local58;
            }
        }
        return local19;
    }

    @OriginalMember(owner = "client!bu", name = "c", descriptor = "(I)V")
    @Override
    public void method9421() {
        Static481.method6475();
    }

    @OriginalMember(owner = "client!bu", name = "a", descriptor = "(ZLclient!ge;I)V")
    @Override
    public void method9416(@OriginalArg(0) boolean arg0, @OriginalArg(1) Packet arg1, @OriginalArg(2) int arg2) {
        if (arg0) {
            return;
        }
        if (arg2 == 0) {
            this.anInt1174 = arg1.g1();
        } else if (arg2 == 1) {
            this.anInt1173 = arg1.g1();
        } else if (arg2 == 3) {
            this.anInt1169 = arg1.g1();
        }
    }
}
