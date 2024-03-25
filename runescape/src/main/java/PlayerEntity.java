import com.jagex.Constants;
import com.jagex.ParticleList;
import com.jagex.core.constants.ModeWhere;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.core.util.JagException;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.Animator;
import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.bastype.BASTypeList;
import com.jagex.game.runetek6.config.defaults.GraphicsDefaults;
import com.jagex.game.runetek6.config.defaults.WearposDefaults;
import com.jagex.game.runetek6.config.enumtype.EnumType;
import com.jagex.game.runetek6.config.enumtype.EnumTypeList;
import com.jagex.game.runetek6.config.idktype.IDKTypeList;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeCustomisation;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationType;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationTypeList;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.graphics.BoundingCylinder;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Mesh;
import com.jagex.graphics.Model;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ca")
public final class PlayerEntity extends PathingEntity {

    @OriginalMember(owner = "client!fo", name = "k", descriptor = "Lclient!dla;")
    public static final ReferenceCache modelCache = new ReferenceCache(4);

    public static final int APPEARANCE_FLAG_GENDER = 0x1;

    public static final int APPEARANCE_FLAG_VORBIS = 0x2;

    public static final int APPEARANCE_FLAG_SKILL_AREA = 0x4;

    @OriginalMember(owner = "client!kw", name = "r", descriptor = "[I")
    public static int[] wornObjIds;

    @OriginalMember(owner = "client!mea", name = "i", descriptor = "I")
    public static int featureMask;

    @OriginalMember(owner = "client!naa", name = "a", descriptor = "(B)V")
    public static void initWornObjIds() {
        @Pc(9) int[] ids = new int[ObjTypeList.instance.num];

        @Pc(11) int count = 0;
        for (@Pc(13) int id = 0; id < ObjTypeList.instance.num; id++) {
            @Pc(20) ObjType objType = ObjTypeList.instance.list(id);

            if (objType.manwear >= 0 || objType.womanwear >= 0) {
                ids[count++] = id;
            }
        }

        wornObjIds = new int[count];
        for (@Pc(58) int i = 0; i < count; i++) {
            wornObjIds[i] = ids[i];
        }
    }

    @OriginalMember(owner = "client!vs", name = "a", descriptor = "(IIIIIILclient!ha;)Lclient!ka;")
    public static Model model(@OriginalArg(0) int rotateX, @OriginalArg(1) int rotateZ, @OriginalArg(3) int id, @OriginalArg(4) int translateY, @OriginalArg(5) int rotateY, @OriginalArg(6) Toolkit arg5) {
        @Pc(13) long key = id;
        @Pc(19) Model model = (Model) modelCache.get(key);
        if (model == null) {
            @Pc(29) Mesh mesh = Mesh.load(id, js5.MODELS);
            if (mesh == null) {
                return null;
            }
            if (mesh.version < 13) {
                mesh.upscale();
            }
            model = arg5.createModel(mesh, 2055, featureMask, 64, 768);
            modelCache.put(model, key);
        }

        model = model.copy((byte) 6, 2055, true);

        if (rotateY != 0) {
            model.a(rotateY);
        }
        if (rotateX != 0) {
            model.FA(rotateX);
        }
        if (rotateZ != 0) {
            model.VA(rotateZ);
        }
        if (translateY != 0) {
            model.H(0, translateY, 0);
        }
        return model;
    }

    @OriginalMember(owner = "client!kf", name = "a", descriptor = "(ILclient!ca;)I")
    public static int method4870(@OriginalArg(1) PlayerEntity arg0) {
        @Pc(6) int local6 = arg0.walkSound;
        @Pc(10) BASType local10 = arg0.getBASType();
        @Pc(15) int local15 = arg0.animator.getAnimationId();
        if (local15 == -1 || arg0.ready) {
            local6 = arg0.readySound;
        } else if (local10.run == local15 || local15 == local10.runFollowTurn180 || local10.runFollowTurnCw == local15 || local10.runFollowTurnCcw == local15) {
            local6 = arg0.runSound;
        } else if (local10.crawl == local15 || local10.crawlFollowTurn180 == local15 || local10.crawlFollowTurnCw == local15 || local10.crawlFollowTurnCcw == local15) {
            local6 = arg0.crawlSound;
        }
        return local6;
    }

    @OriginalMember(owner = "client!ema", name = "a", descriptor = "(I)V")
    public static void cacheRemoveSoftReferences() {
        modelCache.removeSoftReferences();
    }

    @OriginalMember(owner = "client!gca", name = "a", descriptor = "(BI)V")
    public static void cacheClean(@OriginalArg(1) int maxAge) {
        modelCache.clean(maxAge);
    }

    @OriginalMember(owner = "client!bg", name = "a", descriptor = "(BI)V")
    public static void setFeatureMask(@OriginalArg(1) int featureMask) {
        PlayerEntity.featureMask = featureMask;
        modelCache.reset();
    }

    @OriginalMember(owner = "client!sga", name = "b", descriptor = "(Z)V")
    public static void cacheReset() {
        modelCache.reset();
    }

    @OriginalMember(owner = "client!rj", name = "c", descriptor = "Lclient!ca;")
    public static PlayerEntity self;

    @OriginalMember(owner = "client!ca", name = "Sc", descriptor = "Ljava/lang/String;")
    public String displayName;

    @OriginalMember(owner = "client!ca", name = "Mc", descriptor = "Lclient!ju;")
    public PlayerModel playerModel;

    @OriginalMember(owner = "client!ca", name = "xd", descriptor = "Ljava/lang/String;")
    public String accountName;

    @OriginalMember(owner = "client!ca", name = "bd", descriptor = "I")
    public int anInt1441;

    @OriginalMember(owner = "client!ca", name = "Ec", descriptor = "I")
    public int basId;

    @OriginalMember(owner = "client!ca", name = "yd", descriptor = "I")
    public int anInt1448;

    @OriginalMember(owner = "client!ca", name = "qd", descriptor = "I")
    public int pkIcon = -1;

    @OriginalMember(owner = "client!ca", name = "Dd", descriptor = "B")
    public byte gender = 0;

    @OriginalMember(owner = "client!ca", name = "wd", descriptor = "Z")
    public boolean hideOnMap = false;

    @OriginalMember(owner = "client!ca", name = "gd", descriptor = "B")
    public byte titleKey = 0;

    @OriginalMember(owner = "client!ca", name = "rd", descriptor = "I")
    public int team = 0;

    @OriginalMember(owner = "client!ca", name = "Dc", descriptor = "Z")
    public boolean clanmate = false;

    @OriginalMember(owner = "client!ca", name = "Gc", descriptor = "I")
    public int prayerIcon = -1;

    @OriginalMember(owner = "client!ca", name = "Jc", descriptor = "Z")
    public boolean vorbis = false;

    @OriginalMember(owner = "client!ca", name = "cd", descriptor = "I")
    public int maxCombatLevel = 0;

    @OriginalMember(owner = "client!ca", name = "Ad", descriptor = "I")
    public int skillRating = 0;

    @OriginalMember(owner = "client!ca", name = "Gd", descriptor = "I")
    public int soundRange = 0;

    @OriginalMember(owner = "client!ca", name = "Lc", descriptor = "Z")
    public boolean moved = false;

    @OriginalMember(owner = "client!ca", name = "sd", descriptor = "I")
    public int readySound = -1;

    @OriginalMember(owner = "client!ca", name = "id", descriptor = "Z")
    public boolean aBoolean129 = false;

    @OriginalMember(owner = "client!ca", name = "Fd", descriptor = "I")
    public int combatLevel = 0;

    @OriginalMember(owner = "client!ca", name = "zd", descriptor = "Z")
    public boolean showPICon = false;

    @OriginalMember(owner = "client!ca", name = "pd", descriptor = "B")
    public byte titleEnum = 0;

    @OriginalMember(owner = "client!ca", name = "Bd", descriptor = "I")
    public int crawlSound = -1;

    @OriginalMember(owner = "client!ca", name = "Oc", descriptor = "I")
    public int soundVolume = 255;

    @OriginalMember(owner = "client!ca", name = "hd", descriptor = "I")
    public int walkSound = -1;

    @OriginalMember(owner = "client!ca", name = "ld", descriptor = "I")
    public int runSound = -1;

    @OriginalMember(owner = "client!ca", name = "Tc", descriptor = "I")
    public int anInt1467 = -1;

    @OriginalMember(owner = "client!ca", name = "ed", descriptor = "I")
    public int combatRange = -1;

    @OriginalMember(owner = "client!ca", name = "<init>", descriptor = "(I)V")
    public PlayerEntity(@OriginalArg(0) int arg0) {
        super(arg0);
    }

    @OriginalMember(owner = "client!ca", name = "<init>", descriptor = "()V")
    public PlayerEntity() {
    }

    @OriginalMember(owner = "client!ca", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (this.playerModel == null || !super.aBoolean820 && !this.method1421(0, arg0)) {
            return;
        }
        @Pc(24) Matrix local24 = arg0.scratchMatrix();
        local24.rotate(super.yaw.getValue(arg1 ^ 0xFFFFC004));
        local24.translate(super.x, arg1 + super.y, super.z);
        this.method9319(arg0, super.aBoolean820, super.aModelArray3, local24);
        for (@Pc(53) int local53 = 0; local53 < super.aModelArray3.length; local53++) {
            super.aModelArray3[local53] = null;
        }
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(IILjava/lang/String;B)V")
    public void method1413(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2) {
        this.setChatLine(GameShell.speed() * GraphicsDefaults.instance.playerChatTimeout, arg2, arg1, arg0);
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(BIIILclient!ka;Lclient!tt;Lclient!ha;I)V")
    public void method1414(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int id, @OriginalArg(4) Model arg4, @OriginalArg(5) Matrix arg5, @OriginalArg(6) Toolkit toolkit, @OriginalArg(7) int arg7) {
        if (arg0 != -74) {
            this.method9289(null, 41);
        }
        @Pc(20) int local20 = arg7 * arg7 + arg1 * arg1;
        if (local20 < 262144 || local20 > arg2) {
            return;
        }
        @Pc(53) int rotateY = (int) (Math.atan2(arg1, arg7) * 2607.5945876176133D - (double) super.yaw.getValue(16383)) & 0x3FFF;
        @Pc(65) Model model = model(super.modelRotateX, super.modelRotateZ, id, super.modelTranslateY, rotateY, toolkit);
        if (model != null) {
            toolkit.C(false);
            model.render(arg5, null, 0);
            toolkit.C(true);
        }
    }

    @OriginalMember(owner = "client!ca", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public BoundingCylinder getCylinder(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) int arg1) {
        if (arg1 > -93) {
            this.getDisplayName(true, true);
        }
        return null;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean picked(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit toolkit) {
        if (this.playerModel == null || !this.method1421(131072, toolkit)) {
            return false;
        }
        @Pc(22) Matrix local22 = toolkit.scratchMatrix();
        @Pc(27) int local27 = super.yaw.getValue(16383);
        local22.rotate(local27);
        local22.translate(super.x, super.y, super.z);
        @Pc(40) boolean local40 = arg2;
        for (@Pc(42) int local42 = 0; local42 < super.aModelArray3.length; local42++) {
            if (super.aModelArray3[local42] != null && (Static504.renderOrtho ? super.aModelArray3[local42].pickedOrtho(y, x, local22, true, 0, Static582.orthoAngle) : super.aModelArray3[local42].picked(y, x, local22, true, 0))) {
                local40 = true;
                break;
            }
        }
        for (@Pc(95) int local95 = 0; local95 < super.aModelArray3.length; local95++) {
            super.aModelArray3[local95] = null;
        }
        return local40;
    }

    @OriginalMember(owner = "client!ca", name = "i", descriptor = "(I)Z")
    @Override
    public boolean method9290(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.method1414((byte) 124, 20, -110, 30, null, null, null, 15);
        }
        return false;
    }

    @OriginalMember(owner = "client!ca", name = "h", descriptor = "(B)I")
    @Override
    public int method9304(@OriginalArg(0) byte arg0) {
        if (arg0 > -48) {
            this.method9318(-126);
        }
        return -1;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(IZLclient!ha;IBILclient!eo;)V")
    @Override
    public void shareLight(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Entity arg6) {
        if (arg4 >= 101) {
            throw new IllegalStateException();
        }
    }

    @OriginalMember(owner = "client!ca", name = "m", descriptor = "(I)I")
    @Override
    protected int getBasId(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.combatLevel = -112;
        }
        return this.basId;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(Lclient!ka;IBLclient!ha;IILclient!tt;II)V")
    public void method1416(@OriginalArg(0) Model arg0, @OriginalArg(1) int arg1, @OriginalArg(3) Toolkit arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) Matrix arg5, @OriginalArg(7) int arg6, @OriginalArg(8) int arg7) {
        @Pc(12) int local12 = arg4 * arg4 + arg7 * arg7;
        if (local12 < 262144 || local12 > arg1) {
            return;
        }
        @Pc(53) int local53 = (int) (Math.atan2(arg4, arg7) * 2607.5945876176133D - (double) super.yaw.getValue(16383)) & 0x3FFF;
        @Pc(65) Model local65 = model(super.modelRotateX, super.modelRotateZ, arg3, super.modelTranslateY, local53, arg2);
        if (local65 != null) {
            arg2.C(false);
            local65.renderOrtho(arg5, null, arg6, 0);
            arg2.C(true);
        }
    }

    @OriginalMember(owner = "client!ca", name = "j", descriptor = "(B)Z")
    public boolean method1417() {
        return this.playerModel != null;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(IIIB)V")
    public void method1418(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) byte arg2) {
        if (super.pathPointer < super.pathX.length - 1) {
            super.pathPointer++;
        }
        for (@Pc(24) int local24 = super.pathPointer; local24 > 0; local24--) {
            super.pathX[local24] = super.pathX[local24 - 1];
            super.pathZ[local24] = super.pathZ[local24 - 1];
            super.pathSpeed[local24] = super.pathSpeed[local24 - 1];
        }
        super.pathX[0] = arg1;
        super.pathSpeed[0] = arg2;
        if (-24527 != -24527) {
            this.method9304((byte) -13);
        }
        super.pathZ[0] = arg0;
    }

    @OriginalMember(owner = "client!ca", name = "g", descriptor = "(B)I")
    @Override
    public int getSize() {
        if (this.playerModel == null || this.playerModel.npcId == -1) {
            return super.getSize();
        } else {
            return NPCTypeList.instance.list(this.playerModel.npcId).size;
        }
    }

    @OriginalMember(owner = "client!ca", name = "c", descriptor = "(III)V")
    public void coord(@OriginalArg(0) int x, @OriginalArg(2) int z) {
        super.pathPointer = 0;
        super.pathX[0] = x;
        super.delayedWalkingTicks = 0;
        super.animationPathPointer = 0;
        super.pathZ[0] = z;

        @Pc(26) int size = this.getSize();
        super.x = (super.pathX[0] * 512) + (size * 256);
        super.z = (super.pathZ[0] * 512) + (size * 256);

        if (self == this) {
            InterfaceManager.loginOpened();
        }

        if (super.particleSystem != null) {
            super.particleSystem.restart();
        }
    }

    @OriginalMember(owner = "client!ca", name = "j", descriptor = "(I)V")
    @Override
    public void stopSharingLight(@OriginalArg(0) int arg0) {
        if (arg0 != 27811) {
            this.moved = true;
        }
        throw new IllegalStateException();
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
    @Override
    public PickableEntity render(@OriginalArg(1) Toolkit arg0) {
        if (this.playerModel == null || !this.method1421(2048, arg0)) {
            return null;
        }
        @Pc(22) Matrix local22 = arg0.scratchMatrix();
        @Pc(27) int local27 = super.yaw.getValue(16383);
        local22.rotate(local27);
        @Pc(53) Tile local53 = Static334.activeTiles[super.level][super.x >> Static52.anInt1066][super.z >> Static52.anInt1066];
        if (local53 == null || local53.groundDecor == null) {
            super.anInt10732 = (int) ((float) super.anInt10732 - (float) super.anInt10732 / 10.0F);
        } else {
            @Pc(68) int local68 = super.anInt10732 - local53.groundDecor.offsetY;
            super.anInt10732 = (int) ((float) super.anInt10732 - (float) local68 / 10.0F);
        }
        local22.translate(super.x, -super.anInt10732 + super.y - 20, super.z);
        super.aBoolean819 = false;
        @Pc(114) PickableEntity local114 = null;
        if (ClientOptions.instance.spotShadows.getValue() == 1) {
            @Pc(126) BASType local126 = this.getBASType();
            if (local126.animateShadow && (this.playerModel.npcId == -1 || NPCTypeList.instance.list(this.playerModel.npcId).hasShadow)) {
                @Pc(166) Animator local166 = super.actionAnimator.isAnimating() && super.actionAnimator.isDelayed() ? super.actionAnimator : null;
                @Pc(186) Animator local186 = super.animator.isAnimating() && (!super.ready || local166 == null) ? super.animator : null;
                @Pc(212) Model local212 = ShadowList.model(240, super.aModelArray3[0], super.modelRotateZ, 0, super.modelTranslateY, 1, arg0, 160, local186 == null ? local166 : local186, super.modelRotateX, local27, 0);
                if (local212 != null) {
                    local114 = Static642.method8441(true, super.aModelArray3.length + 1);
                    super.aBoolean819 = true;
                    arg0.C(false);
                    if (Static504.renderOrtho) {
                        local212.renderOrtho(local22, local114.pickingCylinders[super.aModelArray3.length], Static582.orthoAngle, 0);
                    } else {
                        local212.render(local22, local114.pickingCylinders[super.aModelArray3.length], 0);
                    }
                    arg0.C(true);
                }
            }
        }
        @Pc(269) int local269;
        if (self == this) {
            for (local269 = Static527.aClass254Array1.length - 1; local269 >= 0; local269--) {
                @Pc(275) Class254 local275 = Static527.aClass254Array1[local269];
                if (local275 != null && local275.anInt6371 != -1) {
                    @Pc(310) int local310;
                    if (local275.anInt6363 == 1) {
                        @Pc(298) NPCEntityNode local298 = (NPCEntityNode) NPCList.local.get(local275.anInt6366);
                        if (local298 != null) {
                            @Pc(303) NPCEntity local303 = local298.npc;
                            local310 = local303.x - self.x;
                            @Pc(316) int local316 = local303.z - self.z;
                            if (Static504.renderOrtho) {
                                this.method1416(super.aModelArray3[0], 92160000, arg0, local275.anInt6371, local310, local22, Static582.orthoAngle, local316);
                            } else {
                                this.method1414((byte) -74, local310, 92160000, local275.anInt6371, super.aModelArray3[0], local22, arg0, local316);
                            }
                        }
                    }
                    @Pc(371) int local371;
                    if (local275.anInt6363 == 2) {
                        @Pc(364) int local364 = local275.anInt6369 - self.x;
                        local371 = local275.anInt6362 - self.z;
                        local310 = local275.anInt6364 << 9;
                        local310 *= local310;
                        if (Static504.renderOrtho) {
                            this.method1416(super.aModelArray3[0], local310, arg0, local275.anInt6371, local364, local22, Static582.orthoAngle, local371);
                        } else {
                            this.method1414((byte) -74, local364, local310, local275.anInt6371, super.aModelArray3[0], local22, arg0, local371);
                        }
                    }
                    if (local275.anInt6363 == 10 && local275.anInt6366 >= 0 && local275.anInt6366 < PlayerList.highResolutionPlayers.length) {
                        @Pc(438) PlayerEntity local438 = PlayerList.highResolutionPlayers[local275.anInt6366];
                        if (local438 != null) {
                            local371 = local438.x - self.x;
                            local310 = local438.z - self.z;
                            if (Static504.renderOrtho) {
                                this.method1416(super.aModelArray3[0], 92160000, arg0, local275.anInt6371, local371, local22, Static582.orthoAngle, local310);
                            } else {
                                this.method1414((byte) -74, local371, 92160000, local275.anInt6371, super.aModelArray3[0], local22, arg0, local310);
                            }
                        }
                    }
                }
            }
            local22.rotate(local27);
            local22.translate(super.x, super.y, super.z);
        }
        local22.rotate(local27);
        local22.translate(super.x, -super.anInt10732 + super.y - 5, super.z);
        if (local114 == null) {
            local114 = Static642.method8441(true, super.aModelArray3.length);
        }
        this.method9319(arg0, false, super.aModelArray3, local22);
        if (Static504.renderOrtho) {
            for (local269 = 0; local269 < super.aModelArray3.length; local269++) {
                if (super.aModelArray3[local269] != null) {
                    super.aModelArray3[local269].renderOrtho(local22, local114.pickingCylinders[local269], Static582.orthoAngle, self == this ? 1 : 0);
                }
            }
        } else {
            for (local269 = 0; local269 < super.aModelArray3.length; local269++) {
                if (super.aModelArray3[local269] != null) {
                    super.aModelArray3[local269].render(local22, local114.pickingCylinders[local269], self == this ? 1 : 0);
                }
            }
        }
        if (super.particleSystem != null) {
            @Pc(635) ParticleList local635 = super.particleSystem.getList();
            if (Static504.renderOrtho) {
                arg0.renderOrtho(local635, Static582.orthoAngle);
            } else {
                arg0.render(local635);
            }
        }
        for (local269 = 0; local269 < super.aModelArray3.length; local269++) {
            if (super.aModelArray3[local269] != null) {
                super.aBoolean819 |= super.aModelArray3[local269].F();
            }
            super.aModelArray3[local269] = null;
        }
        super.anInt10704 = Static198.anInt3276;
        return local114;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(Lclient!ge;I)V")
    public void decodeAppearance(@OriginalArg(0) Packet packet) {
        packet.pos = 0;

        @Pc(12) int flags = packet.g1();
        this.gender = (byte) (flags & APPEARANCE_FLAG_GENDER);
        @Pc(21) boolean vorbisBefore = this.vorbis;
        this.vorbis = (flags & APPEARANCE_FLAG_VORBIS) != 0;
        @Pc(40) boolean skillArea = (flags & APPEARANCE_FLAG_SKILL_AREA) != 0;
        @Pc(44) int sizeBefore = super.getSize();
        this.setSize((flags >> 3 & 0x7) + 1);
        this.titleEnum = (byte) (flags >> 6 & 0x3);
        super.x += (this.getSize() - sizeBefore) << 8;
        super.z += (this.getSize() - sizeBefore) << 8;
        this.titleKey = packet.g1b();
        this.pkIcon = packet.g1b();
        this.prayerIcon = packet.g1b();
        this.hideOnMap = packet.g1b() == 1;
        if (ModeWhere.LIVE == client.modeWhere && Static608.staffModLevel >= 2) {
            this.hideOnMap = false;
        }

        this.team = 0;
        @Pc(134) int npcId = -1;

        @Pc(139) int[] identikit = new int[WearposDefaults.instance.hidden.length];
        @Pc(144) ObjTypeCustomisation[] customisations = new ObjTypeCustomisation[WearposDefaults.instance.hidden.length];
        @Pc(149) ObjType[] objTypes = new ObjType[WearposDefaults.instance.hidden.length];
        for (@Pc(151) int i = 0; i < WearposDefaults.instance.hidden.length; i++) {
            if (WearposDefaults.instance.hidden[i] != 1) {
                @Pc(165) int hi = packet.g1();

                if (hi == 0) {
                    identikit[i] = 0;
                } else {
                    @Pc(184) int lo = packet.g1();
                    @Pc(191) int id = (hi << 8) + lo;

                    if (i == 0 && id == 65535) {
                        npcId = packet.g2();
                        this.team = packet.g1();
                        break;
                    }

                    if (id >= 32768) {
                        id = wornObjIds[id - 32768];
                        identikit[i] = id | 0x40000000;
                        objTypes[i] = ObjTypeList.instance.list(id);

                        @Pc(240) int team = objTypes[i].team;
                        if (team != 0) {
                            this.team = team;
                        }
                    } else {
                        identikit[i] = id - 256 | Integer.MIN_VALUE;
                    }
                }
            }
        }

        if (npcId == -1) {
            @Pc(165) int mask = packet.g2();
            @Pc(240) int bit = 0;

            for (@Pc(191) int i = 0; i < WearposDefaults.instance.hidden.length; i++) {
                if (WearposDefaults.instance.hidden[i] == 0) {
                    if ((mask & 0x1 << bit) != 0) {
                        customisations[i] = ObjTypeCustomisation.decode(packet, objTypes[i]);
                    }
                    bit++;
                }
            }
        }

        @Pc(332) int[] bodyColours = new int[10];
        for (@Pc(184) int i = 0; i < 10; i++) {
            @Pc(191) int colour = packet.g1();
            if (i >= PlayerModel.recol_d.length || colour < 0 || PlayerModel.recol_d[i][0].length <= colour) {
                colour = 0;
            }

            bodyColours[i] = colour;
        }

        this.basId = packet.g2();
        this.displayName = packet.gjstr();
        if (self == this) {
            Constants.playerDisplayName = this.displayName;
        }
        this.accountName = this.displayName;
        this.combatLevel = packet.g1();

        if (skillArea) {
            this.skillRating = packet.g2();
            this.maxCombatLevel = this.combatLevel;

            if (this.skillRating == 65535) {
                this.skillRating = -1;
            }
            this.combatRange = -1;
        } else {
            this.skillRating = 0;
            this.maxCombatLevel = packet.g1();
            this.combatRange = packet.g1();

            if (this.combatRange == 255) {
                this.combatRange = -1;
            }
        }

        @Pc(191) int soundRangeBefore = this.soundRange;
        this.soundRange = packet.g1();
        if (this.soundRange == 0) {
            Static76.method1552(this);
        } else {
            @Pc(240) int readySoundBefore = this.readySound;
            @Pc(487) int crawlSoundBefore = this.crawlSound;
            @Pc(490) int walkSoundBefore = this.walkSound;
            @Pc(493) int runSoundBefore = this.runSound;
            @Pc(496) int soundVolumeBefore = this.soundVolume;

            this.readySound = packet.g2();
            this.crawlSound = packet.g2();
            this.walkSound = packet.g2();
            this.runSound = packet.g2();
            this.soundVolume = packet.g1();

            if (this.vorbis != vorbisBefore || this.soundRange != soundRangeBefore || readySoundBefore != this.readySound || crawlSoundBefore != this.crawlSound || this.walkSound != walkSoundBefore || this.runSound != runSoundBefore || soundVolumeBefore != this.soundVolume) {
                Static247.method3523(this);
            }
        }

        if (this.playerModel == null) {
            this.playerModel = new PlayerModel();
        }

        @Pc(240) int npcIdBefore = this.playerModel.npcId;
        @Pc(603) int[] clientpaletteBefore = this.playerModel.clientpalette;
        this.playerModel.update(bodyColours, identikit, customisations, npcId, this.getBasId(0), this.gender == 1);

        if (npcId != npcIdBefore) {
            super.x = (super.pathX[0] << 9) + (this.getSize() << 8);
            super.z = (super.pathZ[0] << 9) + (this.getSize() << 8);
        }

        if (PlayerList.activePlayerSlot == super.id && clientpaletteBefore != null) {
            for (@Pc(490) int i = 0; i < bodyColours.length; i++) {
                if (bodyColours[i] != clientpaletteBefore[i]) {
                    ObjTypeList.instance.spriteCacheReset();
                    break;
                }
            }
        }

        if (super.particleSystem != null) {
            super.particleSystem.restart();
        }

        if (!super.animator.isAnimating() || !super.ready) {
            return;
        }

        @Pc(717) BASType basType = this.getBASType();
        if (!basType.isReady(super.animator.getAnimationId())) {
            super.animator.update(true, -1);
            super.ready = false;
        }
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(IILclient!ha;)Z")
    public boolean method1421(@OriginalArg(0) int arg0, @OriginalArg(2) Toolkit arg1) {
        @Pc(5) int local5 = arg0;
        @Pc(15) BASType local15 = this.getBASType();
        @Pc(33) Animator local33 = super.actionAnimator.isAnimating() && !super.actionAnimator.isDelayed() ? super.actionAnimator : null;
        @Pc(58) Animator local58 = !super.animator.isAnimating() || this.aBoolean129 || super.ready && local33 != null ? null : super.animator;
        @Pc(61) int local61 = local15.hillWidth;
        @Pc(64) int local64 = local15.hillHeight;
        if (local61 != 0 || local64 != 0 || local15.rollTargetAngle != 0 || local15.pitchTargetAngle != 0) {
            arg0 |= 0x7;
        }
        @Pc(95) int local95 = super.yaw.getValue(16383);
        @Pc(119) boolean local119 = super.recolScale != 0 && TimeUtils.clock >= super.recolStart && TimeUtils.clock < super.recolEnd;
        if (local119) {
            arg0 |= 0x80000;
        }
        @Pc(152) Model local152 = super.aModelArray3[0] = this.playerModel.bodyModel(ObjTypeList.instance, local33, BASTypeList.instance, SeqTypeList.instance, arg0, super.wornRotation, WearposDefaults.instance, IDKTypeList.instance, arg1, NPCTypeList.instance, super.wornAnimators, local95, local58, TimedVarDomain.instance);
        @Pc(155) int local155 = PlayerModel.cacheHardReferenceCount();
        if (GameShell.maxmemory < 96 && local155 > 50) {
            Static358.method9191();
        }
        if (ModeWhere.LIVE != client.modeWhere && local155 < 50) {
            @Pc(181) int local181 = 50 - local155;
            while (Static107.anInt2161 < local181) {
                Static163.aByteArrayArray36[Static107.anInt2161] = new byte[102400];
                Static107.anInt2161++;
            }
            while (local181 < Static107.anInt2161) {
                Static107.anInt2161--;
                Static163.aByteArrayArray36[Static107.anInt2161] = null;
            }
        } else if (ModeWhere.LIVE != client.modeWhere) {
            Static107.anInt2161 = 0;
            Static163.aByteArrayArray36 = new byte[50][];
        }
        if (local152 == null) {
            return false;
        }
        super.anInt10748 = local152.fa();
        super.anInt10728 = local152.ma();
        this.method9306(local152);
        if (local61 == 0 && local64 == 0) {
            this.method9314(local95, 0, 0, this.getSize() << 9, this.getSize() << 9, -81);
        } else {
            this.method9314(local95, local15.hillMaxAngleX, local15.hillMaxAngleY, local61, local64, -104);
            if (super.modelRotateX != 0) {
                local152.FA(super.modelRotateX);
            }
            if (super.modelRotateZ != 0) {
                local152.VA(super.modelRotateZ);
            }
            if (super.modelTranslateY != 0) {
                local152.H(0, super.modelTranslateY, 0);
            }
        }
        if (local119) {
            local152.adjustColours(super.recolHue, super.recolSaturation, super.recolLightness, super.recolScale & 0xFF);
        }
        if (!this.aBoolean129) {
            this.method9297(local5, local64, arg1, local15, local95, local61);
        }
        return true;
    }

    @OriginalMember(owner = "client!ca", name = "e", descriptor = "(B)Z")
    @Override
    public boolean method9311() {
        return GraphicsDefaults.instance.playerShouldDisplayChat;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(ZI)Ljava/lang/String;")
    public String getAccountName() {
        return this.accountName;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(ZZ)Ljava/lang/String;")
    public String getDisplayName(@OriginalArg(0) boolean arg0, @OriginalArg(1) boolean useDisplayName) {
        @Pc(5) String name = "";
        if (Static685.prefixTitles != null) {
            name = name + Static685.prefixTitles[this.titleEnum];
        }

        if (arg0) {
            this.method9290(106);
        }

        @Pc(40) int[] enums;
        if (this.gender == 1 && Static150.femaleTitleEnums != null) {
            enums = Static150.femaleTitleEnums;
        } else {
            enums = Static406.maleTitleEnums;
        }

        if (enums != null && enums[this.titleEnum] != -1) {
            @Pc(62) EnumType type = EnumTypeList.instance.list(enums[this.titleEnum]);

            if (type.valType == 's') {
                name += type.getString(this.titleKey & 0xFF);
            } else {
                JagException.sendTrace(new Throwable(), "gdn1");
                enums[this.titleEnum] = -1;
            }
        }

        if (useDisplayName) {
            name += this.displayName;
        } else {
            name += this.accountName;
        }

        if (Static377.suffixTitles != null) {
            name += Static377.suffixTitles[this.titleEnum];
        }

        return name;
    }

    @OriginalMember(owner = "client!ca", name = "d", descriptor = "(I)Lclient!dj;")
    @Override
    public EntityChatLine method9318(@OriginalArg(0) int arg0) {
        if (arg0 != -3109) {
            this.showPICon = false;
        }
        if (super.line != null) {
            if (super.line.text == null) {
                return null;
            }
            if (Static133.anInt2458 == 0 || Static133.anInt2458 == 3 || Static133.anInt2458 == 1 && Static362.method5241(arg0 + 3109, this.accountName)) {
                return super.line;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!ca", name = "b", descriptor = "(IIIB)V")
    public void method1425(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) byte arg2) {
        if (super.actionAnimator.isAnimating() && super.actionAnimator.getAnimation().walkingPrecedence == 1) {
            super.actionAnimations = null;
            super.actionAnimator.update(true, -1);
        }
        for (@Pc(33) int local33 = 0; local33 < super.spotAnims.length; local33++) {
            if (super.spotAnims[local33].id != -1) {
                @Pc(56) SpotAnimationType local56 = SpotAnimationTypeList.instance.list(super.spotAnims[local33].id);
                if (local56.loopSeq && local56.seq != -1 && SeqTypeList.instance.list(local56.seq).walkingPrecedence == 1) {
                    super.spotAnims[local33].animator.update(true, -1);
                    super.spotAnims[local33].id = -1;
                }
            }
        }
        if (-9380 != -9380) {
            this.getSize();
        }
        this.anInt1467 = -1;
        if (arg1 < 0 || Static720.mapWidth <= arg1 || arg0 < 0 || Static501.mapHeight <= arg0) {
            this.coord(arg1, arg0);
        } else if (super.pathX[0] >= 0 && super.pathX[0] < Static720.mapWidth && super.pathZ[0] >= 0 && Static501.mapHeight > super.pathZ[0]) {
            if (arg2 == 2) {
                Static360.method5232(this, arg1, arg0);
            }
            this.method1418(arg0, arg1, arg2);
        } else {
            this.coord(arg1, arg0);
        }
    }
}
