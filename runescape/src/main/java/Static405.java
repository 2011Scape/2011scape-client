import com.jagex.graphics.skybox.SkyBoxSphere;
import com.jagex.graphics.TextureSource;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static405 {

    @OriginalMember(owner = "client!mn", name = "a", descriptor = "(Lclient!d;Lclient!sb;Z)V")
    public static void method5592(@OriginalArg(0) TextureSource arg0, @OriginalArg(1) js5 arg1) {
        SkyBoxSphere.textureSource = arg0;
        SkyBoxSphere.aJs5_80 = arg1;
    }
}
