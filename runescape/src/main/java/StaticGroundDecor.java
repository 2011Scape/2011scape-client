import com.jagex.Entity;
import rs2.client.loading.library.LibraryManager;
import com.jagex.PickableEntity;
import com.jagex.core.constants.LocShapes;
import com.jagex.game.Location;
import com.jagex.game.runetek6.config.loctype.LocInteractivity;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.graphics.BoundingCylinder;
import com.jagex.graphics.Ground;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Model;
import com.jagex.graphics.ModelAndShadow;
import com.jagex.graphics.Shadow;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!cu")
public final class StaticGroundDecor extends GroundDecor implements Location {

    @OriginalMember(owner = "client!cu", name = "fb", descriptor = "Lclient!ke;")
    public BoundingCylinder cylinder;

    @OriginalMember(owner = "client!cu", name = "W", descriptor = "S")
    public short id;

    @OriginalMember(owner = "client!cu", name = "F", descriptor = "B")
    public byte rotation;

    @OriginalMember(owner = "client!cu", name = "jb", descriptor = "Z")
    public final boolean interactive;

    @OriginalMember(owner = "client!cu", name = "ab", descriptor = "Z")
    public final boolean underwater;

    @OriginalMember(owner = "client!cu", name = "U", descriptor = "Z")
    public boolean aBoolean180;

    @OriginalMember(owner = "client!cu", name = "S", descriptor = "Z")
    public boolean hardShadow;

    @OriginalMember(owner = "client!cu", name = "R", descriptor = "Lclient!r;")
    public Shadow shadow;

    @OriginalMember(owner = "client!cu", name = "bb", descriptor = "Lclient!ka;")
    public Model model;

    @OriginalMember(owner = "client!cu", name = "<init>", descriptor = "(Lclient!ha;Lclient!c;IIIIIZIZ)V")
    public StaticGroundDecor(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) LocType type, @OriginalArg(2) int level, @OriginalArg(3) int virtualLevel, @OriginalArg(4) int x, @OriginalArg(5) int y, @OriginalArg(6) int z, @OriginalArg(7) boolean underwater, @OriginalArg(8) int arg8, @OriginalArg(9) boolean arg9) {
        super(x, y, z, level, virtualLevel, type.offsetY);
        this.id = (short) type.id;
        super.z = z;
        this.rotation = (byte) arg8;
        this.interactive = type.active != LocInteractivity.NONINTERACTIVE && !underwater;
        super.x = x;
        this.underwater = underwater;
        this.aBoolean180 = arg9;
        this.hardShadow = toolkit.hardShadow() && type.hardshadow && !this.underwater && ClientOptions.instance.hardShadows.getValue() != 0;

        @Pc(68) int functionMask = 0x800;
        if (this.aBoolean180) {
            functionMask |= 0x10000;
        }

        @Pc(83) ModelAndShadow modelAndShadow = this.modelAndShadow(functionMask, toolkit, this.hardShadow);
        if (modelAndShadow != null) {
            this.shadow = modelAndShadow.shadow;
            this.model = modelAndShadow.model;

            if (this.aBoolean180) {
                this.model = this.model.copy((byte) 0, functionMask, false);
            }
        }
    }

    @OriginalMember(owner = "client!cu", name = "b", descriptor = "(B)Z")
    @Override
    public boolean isStationary() {
        if (this.model == null) {
            return true;
        } else {
            return !this.model.r();
        }
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
    @Override
    public PickableEntity render(@OriginalArg(1) Toolkit arg0) {
        if (this.model == null) {
            return null;
        }
        @Pc(20) Matrix local20 = arg0.scratchMatrix();
        local20.applyTranslation(super.x, super.y, super.z);
        @Pc(34) PickableEntity entity = Static642.method8441(this.interactive, 1);
        if (OrthoMode.enabled) {
            this.model.renderOrtho(local20, entity.pickingCylinders[0], OrthoMode.renderZoom, 0);
        } else {
            this.model.render(local20, entity.pickingCylinders[0], 0);
        }
        return entity;
    }

    @OriginalMember(owner = "client!cu", name = "k", descriptor = "(I)I")
    @Override
    public int getMinY(@OriginalArg(0) int arg0) {
        if (arg0 == 2) {
            return this.model == null ? 0 : this.model.fa();
        } else {
            return 14;
        }
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(IZLclient!ha;IBILclient!eo;)V")
    @Override
    public void shareLight(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Entity arg6) {
        if (arg4 <= 101) {
            this.modelAndShadow(-126, null, false);
        }
        if (!(arg6 instanceof StaticGroundDecor)) {
            return;
        }
        @Pc(21) StaticGroundDecor local21 = (StaticGroundDecor) arg6;
        if (this.model != null && local21.model != null) {
            this.model.method7481(local21.model, arg5, arg0, arg3, arg1);
            return;
        }
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean picked(@OriginalArg(0) int y, @OriginalArg(1) int x, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit toolkit) {
        if (arg2) {
            LibraryManager.signLink = null;
        }

        @Pc(16) Model model = this.getModel(toolkit, 0x20000);
        if (model == null) {
            return false;
        } else {
            @Pc(21) Matrix matrix = toolkit.scratchMatrix();
            matrix.applyTranslation(super.x, super.y, super.z);
            return OrthoMode.enabled ? model.pickedOrtho(x, y, matrix, false, 0, OrthoMode.renderZoom) : model.picked(x, y, matrix, false, 0);
        }
    }

    @OriginalMember(owner = "client!cu", name = "b", descriptor = "(Lclient!ha;I)V")
    @Override
    public void addShadow(@OriginalArg(0) Toolkit toolkit) {
        @Pc(33) Shadow shadow;
        if (this.shadow == null && this.hardShadow) {
            @Pc(25) ModelAndShadow modelAndShadow = this.modelAndShadow(0x40000, toolkit, true);
            shadow = modelAndShadow != null ? modelAndShadow.shadow : null;
        } else {
            shadow = this.shadow;
            this.shadow = null;
        }

        if (shadow != null) {
            Static630.method8357(shadow, super.virtualLevel, super.x, super.z, null);
        }
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(IILclient!ha;Z)Lclient!od;")
    public ModelAndShadow modelAndShadow(@OriginalArg(0) int functionMask, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) boolean arg3) {
        @Pc(13) LocType type = LocTypeList.instance.list(this.id & 0xFFFF);
        @Pc(29) Ground floor;
        @Pc(35) Ground ceiling;

        if (this.underwater) {
            floor = Static693.underwaterGround[super.virtualLevel];
            ceiling = Static706.floor[0];
        } else {
            floor = Static706.floor[super.virtualLevel];

            if (super.virtualLevel >= 3) {
                ceiling = null;
            } else {
                ceiling = Static706.floor[super.virtualLevel + 1];
            }
        }

        return type.modelAndShadow(this.rotation, super.z, super.x, floor, arg3, super.y, LocShapes.GROUNDDECOR, arg2, null, functionMask, ceiling);
    }

    @OriginalMember(owner = "client!cu", name = "h", descriptor = "(I)Z")
    @Override
    public boolean isTransparent(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.rotation = 33;
        }
        return this.model == null ? false : this.model.F();
    }

    @OriginalMember(owner = "client!cu", name = "i", descriptor = "(I)Z")
    @Override
    public boolean method9290(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.method6856();
        }
        return this.aBoolean180;
    }

    @OriginalMember(owner = "client!cu", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public BoundingCylinder getCylinder(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) int arg1) {
        if (this.cylinder == null) {
            this.cylinder = BoundingCylinder.create(super.y, super.x, this.getModel(toolkit, 0), super.z);
        }
        if (arg1 >= -93) {
            this.cylinder = null;
        }
        return this.cylinder;
    }

    @OriginalMember(owner = "client!cu", name = "c", descriptor = "(I)I")
    @Override
    public int getRotation() {
        return this.rotation;
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(Lclient!ha;I)V")
    @Override
    public void removeShadow(@OriginalArg(0) Toolkit toolkit) {
        @Pc(25) Shadow shadow;
        if (this.shadow == null && this.hardShadow) {
            @Pc(36) ModelAndShadow modelAndShadow = this.modelAndShadow(0x40000, toolkit, true);
            shadow = modelAndShadow == null ? null : modelAndShadow.shadow;
        } else {
            shadow = this.shadow;
            this.shadow = null;
        }

        if (shadow != null) {
            Static292.method4618(shadow, super.virtualLevel, super.x, super.z, null);
        }
    }

    @OriginalMember(owner = "client!cu", name = "j", descriptor = "(I)V")
    @Override
    public void stopSharingLight(@OriginalArg(0) int arg0) {
        this.aBoolean180 = false;
        if (arg0 == 27811 && this.model != null) {
            this.model.s(this.model.ua() & 0xFFFEFFFF);
        }
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(I)I")
    @Override
    public int getId() {
        return this.id & 0xFFFF;
    }

    @OriginalMember(owner = "client!cu", name = "d", descriptor = "(I)V")
    @Override
    public void method6856() {
        if (this.model != null) {
            this.model.method7479();
        }
    }

    @OriginalMember(owner = "client!cu", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 != -5) {
            LibraryManager.signLink = null;
        }
    }

    @OriginalMember(owner = "client!cu", name = "b", descriptor = "(I)I")
    @Override
    public int getShape() {
        return LocShapes.GROUNDDECOR;
    }

    @OriginalMember(owner = "client!cu", name = "e", descriptor = "(I)Z")
    @Override
    public boolean hardShadow() {
        return this.hardShadow;
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(ILclient!ha;I)Lclient!ka;")
    public Model getModel(@OriginalArg(1) Toolkit toolkit, @OriginalArg(2) int functionMask) {
        if (this.model != null && toolkit.compareFunctionMasks(this.model.ua(), functionMask) == 0) {
            return this.model;
        } else {
            @Pc(26) ModelAndShadow local26 = this.modelAndShadow(functionMask, toolkit, false);
            return local26 != null ? local26.model : null;
        }
    }

    @OriginalMember(owner = "client!cu", name = "c", descriptor = "(B)I")
    @Override
    public int getSphereRadius(@OriginalArg(0) byte arg0) {
        if (arg0 == -21) {
            return this.model == null ? 0 : this.model.ma();
        } else {
            return -86;
        }
    }
}
