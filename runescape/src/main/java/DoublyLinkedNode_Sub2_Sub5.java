import com.jagex.collect.DoublyLinkedNode;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!co")
public final class DoublyLinkedNode_Sub2_Sub5 extends DoublyLinkedNode {

    @OriginalMember(owner = "client!co", name = "z", descriptor = "I")
    public int anInt1821;

    @OriginalMember(owner = "client!co", name = "x", descriptor = "I")
    public int anInt1823;

    @OriginalMember(owner = "client!co", name = "y", descriptor = "I")
    public int anInt1824;

    @OriginalMember(owner = "client!co", name = "C", descriptor = "I")
    public int anInt1825;

    @OriginalMember(owner = "client!co", name = "D", descriptor = "I")
    public int anInt1827;

    @OriginalMember(owner = "client!co", name = "A", descriptor = "Lclient!mn;")
    public final MeshMagnet aMeshMagnet_1;

    @OriginalMember(owner = "client!co", name = "w", descriptor = "Lclient!ok;")
    public final MeshMagnetType aMeshMagnetType_1;

    @OriginalMember(owner = "client!co", name = "<init>", descriptor = "(Lclient!mn;Lclient!hv;)V")
    public DoublyLinkedNode_Sub2_Sub5(@OriginalArg(0) MeshMagnet arg0, @OriginalArg(1) Class8_Sub5 arg1) {
        this.aMeshMagnet_1 = arg0;
        this.aMeshMagnetType_1 = this.aMeshMagnet_1.type();
        this.method1707();
    }

    @OriginalMember(owner = "client!co", name = "c", descriptor = "(B)V")
    public void method1707() {
        this.anInt1827 = this.aMeshMagnet_1.anInt6252;
        this.anInt1824 = this.aMeshMagnet_1.anInt6250;
        this.anInt1821 = this.aMeshMagnet_1.anInt6249;
        if (this.aMeshMagnet_1.matrix != null) {
            this.aMeshMagnet_1.matrix.method7138(this.aMeshMagnetType_1.dirX, this.aMeshMagnetType_1.dirY, this.aMeshMagnetType_1.dirZ, Static485.anIntArray888);
        }
        this.anInt1823 = Static485.anIntArray888[2];
        this.anInt1825 = Static485.anIntArray888[0];
    }
}
