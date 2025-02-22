import com.jagex.graphics.ClippingMask;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.sw.SoftwareMemoryManager;
import com.jagex.graphics.sw.SoftwareObject;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!j")
public final class j extends Sprite implements SoftwareObject {

    @OriginalMember(owner = "client!j", name = "nativeid", descriptor = "J")
    public long nativeid;

    @OriginalMember(owner = "client!j", name = "<init>", descriptor = "(Lclient!oa;II)V")
    public j(@OriginalArg(0) oa arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        this.EA(arg0, arg1, arg2);
    }

    @OriginalMember(owner = "client!j", name = "<init>", descriptor = "(Lclient!oa;[IIIIIZ)V")
    public j(@OriginalArg(0) oa arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) boolean arg6) {
        this.ua(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    @OriginalMember(owner = "client!j", name = "<init>", descriptor = "(Lclient!oa;[I[B[BIIII)V")
    public j(@OriginalArg(0) oa arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) byte[] arg2, @OriginalArg(3) byte[] arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
        this.ma(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    @OriginalMember(owner = "client!j", name = "<init>", descriptor = "(Lclient!oa;IIIIZ)V")
    public j(@OriginalArg(0) oa arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5) {
        this.h(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @OriginalMember(owner = "client!j", name = "a", descriptor = "(FFFFFFILclient!aa;II)V")
    @Override
    protected void renderParallelogramImpl(@OriginalArg(0) float centerX, @OriginalArg(1) float centerY, @OriginalArg(2) float x1, @OriginalArg(3) float y1, @OriginalArg(4) float x2, @OriginalArg(5) float y2, @OriginalArg(7) ClippingMask mask, @OriginalArg(8) int maskX, @OriginalArg(9) int maskY) {
        this.UA(this.nativeid, centerX, centerY, x1, y1, x2, y2, 1, ((na) mask).nativeid, maskX, maskY);
    }

    @OriginalMember(owner = "client!j", name = "a", descriptor = "(IIIIIIII)V")
    @Override
    protected void renderImpl(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour, @OriginalArg(6) int mode) {
        this.RA(this.nativeid, x, y, width, height, op, colour, mode, 1);
    }

    @OriginalMember(owner = "client!j", name = "d", descriptor = "()I")
    @Override
    public int getHeight() {
        return this.I(this.nativeid);
    }

    @OriginalMember(owner = "client!j", name = "A", descriptor = "(JIIII)V")
    public native void A(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4);

    @OriginalMember(owner = "client!j", name = "w", descriptor = "(Z)V")
    @Override
    public void w(@OriginalArg(0) boolean arg0) {
        this.R(this.nativeid, arg0);
    }

    @OriginalMember(owner = "client!j", name = "h", descriptor = "(Lclient!oa;IIIIZ)V")
    public native void h(@OriginalArg(0) oa arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5);

    @OriginalMember(owner = "client!j", name = "V", descriptor = "(JIIJII)V")
    public native void V(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) long arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5);

    @OriginalMember(owner = "client!j", name = "b", descriptor = "(IIIIIII)V")
    @Override
    public void renderTiled(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour, @OriginalArg(6) int mode) {
        this.P(this.nativeid, x, y, width, height, op, colour, mode);
    }

    @OriginalMember(owner = "client!j", name = "a", descriptor = "([I)V")
    @Override
    public void projectOffsets(@OriginalArg(0) int[] destination) {
        this.CA(this.nativeid, destination);
    }

    @OriginalMember(owner = "client!j", name = "RA", descriptor = "(JIIIIIIII)V")
    public native void RA(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8);

    @OriginalMember(owner = "client!j", name = "b", descriptor = "(JFFFFFFIIII)V")
    public native void b(@OriginalArg(0) long arg0, @OriginalArg(1) float arg1, @OriginalArg(2) float arg2, @OriginalArg(3) float arg3, @OriginalArg(4) float arg4, @OriginalArg(5) float arg5, @OriginalArg(6) float arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10);

    @OriginalMember(owner = "client!j", name = "JA", descriptor = "(J)I")
    public native int JA(@OriginalArg(0) long arg0);

    @OriginalMember(owner = "client!j", name = "ma", descriptor = "(Lclient!oa;[I[B[BIIII)V")
    public native void ma(@OriginalArg(0) oa arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) byte[] arg2, @OriginalArg(3) byte[] arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7);

    @OriginalMember(owner = "client!j", name = "N", descriptor = "(JIII)V")
    public native void N(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3);

    @OriginalMember(owner = "client!j", name = "M", descriptor = "(J)I")
    public native int M(@OriginalArg(0) long arg0);

    @OriginalMember(owner = "client!j", name = "c", descriptor = "()I")
    @Override
    public int getWidth() {
        return this.M(this.nativeid);
    }

    @OriginalMember(owner = "client!j", name = "finalize", descriptor = "()V")
    @Override
    public void finalize() {
        if (this.nativeid != 0L) {
            SoftwareMemoryManager.free(this);
        }
    }

    @OriginalMember(owner = "client!j", name = "a", descriptor = "(FFFFFFIIII)V")
    @Override
    protected void renderImpl(@OriginalArg(0) float x, @OriginalArg(1) float y, @OriginalArg(2) float width, @OriginalArg(3) float height, @OriginalArg(4) float op, @OriginalArg(5) float colour, @OriginalArg(6) int mode, @OriginalArg(7) int filter) {
        this.b(this.nativeid, x, y, width, height, op, colour, mode, filter, 1, 1);
    }

    @OriginalMember(owner = "client!j", name = "ua", descriptor = "(Lclient!oa;[IIIIIZ)V")
    public native void ua(@OriginalArg(0) oa arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) boolean arg6);

    @OriginalMember(owner = "client!j", name = "wa", descriptor = "(J)I")
    public native int wa(@OriginalArg(0) long arg0);

    @OriginalMember(owner = "client!j", name = "P", descriptor = "(JIIIIIII)V")
    public native void P(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7);

    @OriginalMember(owner = "client!j", name = "R", descriptor = "(JZ)V")
    public native void R(@OriginalArg(0) long arg0, @OriginalArg(1) boolean arg1);

    @OriginalMember(owner = "client!j", name = "b", descriptor = "()I")
    @Override
    public int scaleWidth() {
        return this.wa(this.nativeid);
    }

    @OriginalMember(owner = "client!j", name = "a", descriptor = "(IIIII)V")
    @Override
    public void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int op, @OriginalArg(3) int color, @OriginalArg(4) int mode) {
        this.W(this.nativeid, x, y, op, color, mode);
    }

    @OriginalMember(owner = "client!j", name = "c", descriptor = "(IIII)V")
    @Override
    public void setOffsets(@OriginalArg(0) int x1, @OriginalArg(1) int y1, @OriginalArg(2) int x2, @OriginalArg(3) int y2) {
        this.A(this.nativeid, x1, y1, x2, y2);
    }

    @OriginalMember(owner = "client!j", name = "CA", descriptor = "(J[I)V")
    public native void CA(@OriginalArg(0) long arg0, @OriginalArg(1) int[] arg1);

    @OriginalMember(owner = "client!j", name = "a", descriptor = "(IIIIII)V")
    @Override
    public void copyRect(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour) {
        this.YA(this.nativeid, x, y, width, height, op, colour);
    }

    @OriginalMember(owner = "client!j", name = "EA", descriptor = "(Lclient!oa;II)V")
    public native void EA(@OriginalArg(0) oa arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2);

    @OriginalMember(owner = "client!j", name = "UA", descriptor = "(JFFFFFFIJII)V")
    public native void UA(@OriginalArg(0) long arg0, @OriginalArg(1) float arg1, @OriginalArg(2) float arg2, @OriginalArg(3) float arg3, @OriginalArg(4) float arg4, @OriginalArg(5) float arg5, @OriginalArg(6) float arg6, @OriginalArg(7) int arg7, @OriginalArg(8) long arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10);

    @OriginalMember(owner = "client!j", name = "YA", descriptor = "(JIIIIII)V")
    public native void YA(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6);

    @OriginalMember(owner = "client!j", name = "a", descriptor = "()I")
    @Override
    public int scaleHeight() {
        return this.JA(this.nativeid);
    }

    @OriginalMember(owner = "client!j", name = "a", descriptor = "(III)V")
    @Override
    public void copyAlpha(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int channel) {
        this.N(this.nativeid, 0, 0, 3);
    }

    @OriginalMember(owner = "client!j", name = "a", descriptor = "(IILclient!aa;II)V")
    @Override
    public void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) ClippingMask mask, @OriginalArg(3) int maskX, @OriginalArg(4) int maskY) {
        this.V(this.nativeid, x, y, ((na) mask).nativeid, maskX, maskY);
    }

    @OriginalMember(owner = "client!j", name = "I", descriptor = "(J)I")
    public native int I(@OriginalArg(0) long arg0);

    @OriginalMember(owner = "client!j", name = "W", descriptor = "(JIIIII)V")
    public native void W(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5);
}
