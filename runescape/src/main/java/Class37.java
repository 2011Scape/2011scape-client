import com.jagex.graphics.Sprite;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nha")
public class Class37 implements Interface13 {

    @OriginalMember(owner = "client!nha", name = "i", descriptor = "Lclient!st;")
    protected Sprite aSprite_7;

    @OriginalMember(owner = "client!nha", name = "f", descriptor = "Lclient!no;")
    protected final Class160 aClass160_2;

    @OriginalMember(owner = "client!nha", name = "n", descriptor = "Lclient!sb;")
    public final js5 aJs5_8;

    @OriginalMember(owner = "client!nha", name = "<init>", descriptor = "(Lclient!sb;Lclient!no;)V")
    public Class37(@OriginalArg(0) js5 arg0, @OriginalArg(1) Class160 arg1) {
        this.aClass160_2 = arg1;
        this.aJs5_8 = arg0;
    }

    @OriginalMember(owner = "client!nha", name = "a", descriptor = "(I)V")
    @Override
    public final void method7748() {
        this.aSprite_7 = Static652.method8533(this.aClass160_2.anInt3851, this.aJs5_8);
    }

    @OriginalMember(owner = "client!nha", name = "a", descriptor = "(ZI)V")
    @Override
    public void method7749() {
        @Pc(19) int local19 = this.aClass160_2.aClass403_9.method9332(Static302.anInt4851, this.aSprite_7.scaleWidth()) + this.aClass160_2.anInt3850;
        @Pc(34) int local34 = this.aClass160_2.aClass103_9.method2416(Static479.anInt7201, this.aSprite_7.scaleHeight()) + this.aClass160_2.anInt3845;
        this.aSprite_7.render(local19, local34);
    }

    @OriginalMember(owner = "client!nha", name = "b", descriptor = "(I)Z")
    @Override
    public final boolean method7747() {
        return this.aJs5_8.method7581(this.aClass160_2.anInt3851);
    }
}
