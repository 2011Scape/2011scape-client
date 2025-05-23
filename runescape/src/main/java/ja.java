import com.jagex.graphics.Matrix;
import com.jagex.graphics.sw.SoftwareMemoryManager;
import com.jagex.graphics.sw.SoftwareObject;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ja")
public final class ja extends Matrix implements SoftwareObject {

    @OriginalMember(owner = "client!ja", name = "nativeid", descriptor = "J")
    public long nativeid;

    @OriginalMember(owner = "client!ja", name = "<init>", descriptor = "()V")
    public ja() {
        this.la();
    }

    @OriginalMember(owner = "client!ja", name = "XA", descriptor = "(JIII[I)V")
    public native void XA(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int[] arg4);

    @OriginalMember(owner = "client!ja", name = "a", descriptor = "(III)V")
    @Override
    public void applyTranslation(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        this.FA(this.nativeid, arg0, arg1, arg2);
    }

    @OriginalMember(owner = "client!ja", name = "a", descriptor = "(IIIIII)V")
    @Override
    public void createCamera(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int z, @OriginalArg(3) int rotateX, @OriginalArg(4) int rotateY, @OriginalArg(5) int rotateZ) {
        this.P(this.nativeid, x, y, z, rotateX, rotateY, rotateZ);
    }

    @OriginalMember(owner = "client!ja", name = "l", descriptor = "(JJ)V")
    public native void l(@OriginalArg(0) long arg0, @OriginalArg(1) long arg1);

    @OriginalMember(owner = "client!ja", name = "m", descriptor = "(JI)V")
    public native void m(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1);

    @OriginalMember(owner = "client!ja", name = "VA", descriptor = "(JI)V")
    public native void VA(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1);

    @OriginalMember(owner = "client!ja", name = "b", descriptor = "(III[I)V")
    @Override
    public void projectDirection(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int z, @OriginalArg(3) int[] destination) {
        this.XA(this.nativeid, x, y, z, destination);
    }

    @OriginalMember(owner = "client!ja", name = "a", descriptor = "(JIII)V")
    public native void a(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3);

    @OriginalMember(owner = "client!ja", name = "e", descriptor = "(I)V")
    @Override
    public void makeRotationZ(@OriginalArg(0) int arg0) {
        this.NA(this.nativeid, arg0);
    }

    @OriginalMember(owner = "client!ja", name = "w", descriptor = "(Z)V")
    @Override
    public void w(@OriginalArg(0) boolean arg0) {
        this.AA(this.nativeid, arg0);
    }

    @OriginalMember(owner = "client!ja", name = "a", descriptor = "()V")
    @Override
    public void makeIdentity() {
        this.u(this.nativeid);
    }

    @OriginalMember(owner = "client!ja", name = "J", descriptor = "(JI)V")
    public native void J(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1);

    @OriginalMember(owner = "client!ja", name = "P", descriptor = "(JIIIIII)V")
    public native void P(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6);

    @OriginalMember(owner = "client!ja", name = "b", descriptor = "(I)V")
    @Override
    public void rotateAxisZ(@OriginalArg(0) int arg0) {
        this.za(this.nativeid, arg0);
    }

    @OriginalMember(owner = "client!ja", name = "la", descriptor = "()V")
    public native void la();

    @OriginalMember(owner = "client!ja", name = "b", descriptor = "(JIII[I)V")
    public native void b(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int[] arg4);

    @OriginalMember(owner = "client!ja", name = "AA", descriptor = "(JZ)V")
    public native void AA(@OriginalArg(0) long arg0, @OriginalArg(1) boolean arg1);

    @OriginalMember(owner = "client!ja", name = "c", descriptor = "(III[I)V")
    @Override
    public void project(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int z, @OriginalArg(3) int[] destination) {
        this.b(this.nativeid, x, y, z, destination);
    }

    @OriginalMember(owner = "client!ja", name = "a", descriptor = "(I)V")
    @Override
    public void makeRotationX(@OriginalArg(0) int arg0) {
        this.VA(this.nativeid, arg0);
    }

    @OriginalMember(owner = "client!ja", name = "f", descriptor = "(I)V")
    @Override
    public void rotateAxisY(@OriginalArg(0) int arg0) {
        this.m(this.nativeid, arg0);
    }

    @OriginalMember(owner = "client!ja", name = "a", descriptor = "(Lclient!tt;)V")
    @Override
    public void apply(@OriginalArg(0) Matrix other) {
        this.l(this.nativeid, ((ja) other).nativeid);
    }

    @OriginalMember(owner = "client!ja", name = "finalize", descriptor = "()V")
    @Override
    public void finalize() {
        if (this.nativeid != 0L) {
            SoftwareMemoryManager.free(this);
        }
    }

    @OriginalMember(owner = "client!ja", name = "c", descriptor = "(I)V")
    @Override
    public void rotateAxisX(@OriginalArg(0) int arg0) {
        this.J(this.nativeid, arg0);
    }

    @OriginalMember(owner = "client!ja", name = "a", descriptor = "(III[I)V")
    @Override
    public void projectRelative(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int z, @OriginalArg(3) int[] destination) {
        this.va(this.nativeid, x, y, z, destination);
    }

    @OriginalMember(owner = "client!ja", name = "b", descriptor = "(III)V")
    @Override
    public void translate(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int z) {
        this.a(this.nativeid, x, y, z);
    }

    @OriginalMember(owner = "client!ja", name = "FA", descriptor = "(JIII)V")
    public native void FA(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3);

    @OriginalMember(owner = "client!ja", name = "b", descriptor = "()Lclient!tt;")
    @Override
    public Matrix copy() {
        @Pc(3) ja local3 = new ja();
        local3.apply(this);
        return local3;
    }

    @OriginalMember(owner = "client!ja", name = "za", descriptor = "(JI)V")
    public native void za(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1);

    @OriginalMember(owner = "client!ja", name = "g", descriptor = "(I)V")
    @Override
    public void rotate(@OriginalArg(0) int angle) {
        this.t(this.nativeid, angle);
    }

    @OriginalMember(owner = "client!ja", name = "w", descriptor = "(J[I)V")
    public native void w(@OriginalArg(0) long arg0, @OriginalArg(1) int[] arg1);

    @OriginalMember(owner = "client!ja", name = "a", descriptor = "([I)V")
    @Override
    public void project(@OriginalArg(0) int[] destination) {
        this.w(this.nativeid, destination);
    }

    @OriginalMember(owner = "client!ja", name = "va", descriptor = "(JIII[I)V")
    public native void va(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int[] arg4);

    @OriginalMember(owner = "client!ja", name = "NA", descriptor = "(JI)V")
    public native void NA(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1);

    @OriginalMember(owner = "client!ja", name = "t", descriptor = "(JI)V")
    public native void t(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1);

    @OriginalMember(owner = "client!ja", name = "u", descriptor = "(J)V")
    public native void u(@OriginalArg(0) long arg0);
}
