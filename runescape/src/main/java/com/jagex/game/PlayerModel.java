package com.jagex.game;

import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.defaults.WearposDefaults;
import com.jagex.game.runetek6.config.idktype.IDKTypeList;
import com.jagex.game.runetek6.config.npctype.NPCTypeCustomisation;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.game.runetek6.config.objtype.ObjTypeCustomisation;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.seqtype.SeqType;
import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.graphics.Matrix;
import com.jagex.game.runetek6.config.bastype.BASTypeList;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import com.jagex.graphics.Mesh;
import com.jagex.graphics.Model;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ju")
public final class PlayerModel {

    @OriginalMember(owner = "client!ie", name = "g", descriptor = "[I")
    private static final int[] BASE_PART_MAP = {8, 11, 4, 6, 9, 7, 10, 0};

    @OriginalMember(owner = "client!bq", name = "t", descriptor = "Lclient!dla;")
    private static final ReferenceCache modelCache = new ReferenceCache(5);

    @OriginalMember(owner = "client!sea", name = "y", descriptor = "Lclient!dla;")
    private static final ReferenceCache recentUse = new ReferenceCache(260);

    @OriginalMember(owner = "client!kma", name = "n", descriptor = "[[[S")
    public static short[][][] recol_d;

    @OriginalMember(owner = "client!cha", name = "e", descriptor = "[[S")
    public static short[][] recol_s;

    @OriginalMember(owner = "client!jg", name = "k", descriptor = "I")
    public static int featureMask;

    @OriginalMember(owner = "client!qq", name = "a", descriptor = "(II)V")
    public static void setFeatureMask(@OriginalArg(1) int featureMask) {
        PlayerModel.featureMask = featureMask;
        @Pc(7) ReferenceCache local7 = modelCache;
        synchronized (modelCache) {
            modelCache.reset();
        }
        local7 = recentUse;
        synchronized (recentUse) {
            recentUse.reset();
        }
    }

    @OriginalMember(owner = "client!rka", name = "b", descriptor = "(ZI)V")
    public static void cacheClean() {
        @Pc(5) ReferenceCache local5 = recentUse;
        synchronized (recentUse) {
            recentUse.clean(5);
        }
        local5 = modelCache;
        synchronized (modelCache) {
            modelCache.clean(5);
        }
    }

    @OriginalMember(owner = "client!nga", name = "a", descriptor = "(I)V")
    public static void cacheRemoveSoftReferences() {
        @Pc(1) ReferenceCache local1 = recentUse;
        synchronized (recentUse) {
            recentUse.removeSoftReferences();
        }
        local1 = modelCache;
        synchronized (modelCache) {
            modelCache.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!jw", name = "c", descriptor = "(B)V")
    public static void cacheReset() {
        @Pc(5) ReferenceCache local5 = recentUse;
        synchronized (recentUse) {
            recentUse.reset();
        }
        local5 = modelCache;
        synchronized (modelCache) {
            modelCache.reset();
        }
    }

    @OriginalMember(owner = "client!jka", name = "g", descriptor = "(I)I")
    public static int cacheHardReferenceCount() {
        @Pc(13) ReferenceCache local13 = recentUse;
        synchronized (recentUse) {
            return recentUse.hardCount();
        }
    }

    @OriginalMember(owner = "client!ju", name = "h", descriptor = "I")
    public int basId;

    @OriginalMember(owner = "client!ju", name = "e", descriptor = "[I")
    public int[] clientpalette;

    @OriginalMember(owner = "client!ju", name = "c", descriptor = "[Lclient!bs;")
    public ObjTypeCustomisation[] customisations;

    @OriginalMember(owner = "client!ju", name = "m", descriptor = "Z")
    public boolean female;

    @OriginalMember(owner = "client!ju", name = "o", descriptor = "[I")
    public int[] identikit;

    @OriginalMember(owner = "client!ju", name = "q", descriptor = "J")
    public long aLong159;

    @OriginalMember(owner = "client!ju", name = "r", descriptor = "J")
    public long hash;

    @OriginalMember(owner = "client!ju", name = "n", descriptor = "I")
    public int npcId = -1;

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(I)V")
    public void computeHash() {
        @Pc(5) long[] crc = Packet.crc64table;

        this.hash = -1L;
        this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.basId >> 8)) & 0xFFL)];
        this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.basId)) & 0xFFL)];

        for (@Pc(56) int part = 0; part < this.identikit.length; part++) {
            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.identikit[part] >> 24)) & 0xFFL)];
            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.identikit[part] >> 16)) & 0xFFL)];
            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.identikit[part] >> 8)) & 0xFFL)];
            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.identikit[part])) & 0xFFL)];
        }

        @Pc(156) int i;
        if (this.customisations != null) {
            for (i = 0; i < this.customisations.length; i++) {
                if (this.customisations[i] != null) {
                    @Pc(179) int[] wearModels;
                    @Pc(173) int[] headModels;
                    if (this.female) {
                        headModels = this.customisations[i].womanhead;
                        wearModels = this.customisations[i].womanwear;
                    } else {
                        headModels = this.customisations[i].manhead;
                        wearModels = this.customisations[i].manwear;
                    }

                    @Pc(196) int j;
                    if (wearModels != null) {
                        for (j = 0; j < wearModels.length; j++) {
                            this.hash = (this.hash >>> 8) ^ crc[(int) (((long) (wearModels[j] >> 8) ^ this.hash) & 0xFFL)];
                            this.hash = (this.hash >>> 8) ^ crc[(int) (((long) wearModels[j] ^ this.hash) & 0xFFL)];
                        }
                    }

                    if (headModels != null) {
                        for (j = 0; j < headModels.length; j++) {
                            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (headModels[j] >> 8)) & 0xFFL)];
                            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (headModels[j])) & 0xFFL)];
                        }
                    }

                    if (this.customisations[i].recol_d != null) {
                        for (j = 0; j < this.customisations[i].recol_d.length; j++) {
                            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.customisations[i].recol_d[j] >> 8)) & 0xFFL)];
                            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.customisations[i].recol_d[j])) & 0xFFL)];
                        }
                    }

                    if (this.customisations[i].retex_d != null) {
                        for (j = 0; j < this.customisations[i].retex_d.length; j++) {
                            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.customisations[i].retex_d[j] >> 8)) & 0xFFL)];
                            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.customisations[i].retex_d[j])) & 0xFFL)];
                        }
                    }
                }
            }
        }

        for (i = 0; i < 10; i++) {
            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) this.clientpalette[i]) & 0xFFL)];
        }

        this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.female ? 1 : 0)) & 0xFFL)];
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "([I[I[Lclient!bs;IIZB)V")
    public void update(@OriginalArg(0) int[] bodycol_d_palette, @OriginalArg(1) int[] identikit, @OriginalArg(2) ObjTypeCustomisation[] customisations, @OriginalArg(3) int npcId, @OriginalArg(4) int basId, @OriginalArg(5) boolean female) {
        this.customisations = customisations;
        this.clientpalette = bodycol_d_palette;
        this.female = female;
        if (this.basId != basId) {
            this.basId = basId;
        }
        this.identikit = identikit;
        this.npcId = npcId;
        this.computeHash();
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(Lclient!es;Lclient!gu;IZLclient!qp;Lclient!bp;I[ILclient!vl;Lclient!kr;Lclient!ha;Lclient!ql;[Lclient!gu;ILclient!gu;Lclient!uk;)Lclient!ka;")
    public Model bodyModel(@OriginalArg(0) ObjTypeList objTypeList, @OriginalArg(1) Animator animator, @OriginalArg(4) BASTypeList basTypeList, @OriginalArg(5) SeqTypeList arg3, @OriginalArg(6) int functionMask, @OriginalArg(7) int[] arg5, @OriginalArg(8) WearposDefaults wearposDefaults, @OriginalArg(9) IDKTypeList idkTypeList, @OriginalArg(10) Toolkit toolkit, @OriginalArg(11) NPCTypeList npcTypeList, @OriginalArg(12) Animator[] animators, @OriginalArg(13) int arg11, @OriginalArg(14) Animator arg12, @OriginalArg(15) VarDomain varDomain) {
        if (this.npcId != -1) {
            return npcTypeList.list(this.npcId).getModel(varDomain, toolkit, basTypeList, animator, arg11, arg5, (NPCTypeCustomisation) null, arg12, functionMask, animators);
        }
        @Pc(28) int newFunctionMask = functionMask;
        @Pc(31) long hash = this.hash;
        @Pc(34) int[] identikit = this.identikit;
        @Pc(36) boolean leftHand = false;
        @Pc(44) boolean rightHand = false;
        @Pc(72) int local72;
        @Pc(116) int local116;
        if (animator != null) {
            @Pc(50) SeqType animation = animator.getAnimation();
            if (animation != null && (animation.playerLeftHand >= 0 || animation.playerRightHand >= 0)) {
                identikit = new int[this.identikit.length];
                for (local72 = 0; local72 < identikit.length; local72++) {
                    identikit[local72] = this.identikit[local72];
                }

                if (animation.playerLeftHand >= 0 && wearposDefaults.leftHandSlot != -1) {
                    if (animation.playerLeftHand == 65535) {
                        identikit[wearposDefaults.leftHandSlot] = 0;
                        for (local116 = 0; local116 < wearposDefaults.animationHiddenLeftHandSlots.length; local116++) {
                            identikit[wearposDefaults.animationHiddenLeftHandSlots[local116]] = 0;
                        }
                        hash ^= 0xFFFFFFFF00000000L;
                    } else {
                        identikit[wearposDefaults.leftHandSlot] = animation.playerLeftHand | 0x40000000;
                        for (local116 = 0; local116 < wearposDefaults.animationHiddenLeftHandSlots.length; local116++) {
                            identikit[wearposDefaults.animationHiddenLeftHandSlots[local116]] = 0;
                        }
                        hash ^= (long) identikit[wearposDefaults.leftHandSlot] << 32;
                    }

                    leftHand = true;
                }

                if (animation.playerRightHand >= 0 && wearposDefaults.rightHandSlot != -1) {
                    rightHand = true;

                    if (animation.playerRightHand == 65535) {
                        identikit[wearposDefaults.rightHandSlot] = 0;
                        for (local116 = 0; local116 < wearposDefaults.animationHiddenRightHandSlots.length; local116++) {
                            identikit[wearposDefaults.animationHiddenRightHandSlots[local116]] = 0;
                        }
                        hash ^= 0xFFFFFFFFL;
                    } else {
                        identikit[wearposDefaults.rightHandSlot] = animation.playerRightHand | 0x40000000;
                        for (local116 = 0; local116 < wearposDefaults.animationHiddenRightHandSlots.length; local116++) {
                            identikit[wearposDefaults.animationHiddenRightHandSlots[local116]] = 0;
                        }
                        hash ^= (long) identikit[wearposDefaults.rightHandSlot];
                    }
                }
            }
        }

        @Pc(257) boolean animated = false;
        local72 = animators == null ? 0 : animators.length;
        for (local116 = 0; local116 < local72; local116++) {
            if (animators[local116] != null) {
                newFunctionMask |= animators[local116].functionMask();
                animated = true;
            }
        }

        if (animator != null) {
            newFunctionMask |= animator.functionMask();
            animated = true;
        }

        if (arg12 != null) {
            animated = true;
            newFunctionMask |= arg12.functionMask();
        }

        @Pc(310) boolean local310 = false;
        if (arg5 != null) {
            for (@Pc(314) int local314 = 0; local314 < arg5.length; local314++) {
                if (arg5[local314] != -1) {
                    local310 = true;
                    newFunctionMask |= 0x20;
                }
            }
        }

        @Pc(334) ReferenceCache local334 = recentUse;
        @Pc(342) Model model;
        synchronized (recentUse) {
            model = (Model) recentUse.get(hash);
        }

        @Pc(350) BASType basType = null;
        if (this.basId != -1) {
            basType = basTypeList.list(this.basId);
        }

        @Pc(390) int local390;
        @Pc(395) int local395;
        @Pc(586) int local586;
        @Pc(591) int local591;
        if (model == null || toolkit.compareFunctionMasks(model.ua(), newFunctionMask) != 0) {
            if (model != null) {
                newFunctionMask = toolkit.combineFunctionMasks(newFunctionMask, model.ua());
            }

            @Pc(388) boolean local388 = false;
            local390 = 0;
            while (true) {
                @Pc(409) int i;
                if (local390 >= identikit.length) {
                    if (local388) {
                        if (this.aLong159 != -1L) {
                            @Pc(552) ReferenceCache local552 = recentUse;
                            synchronized (recentUse) {
                                model = (Model) recentUse.get(this.aLong159);
                            }
                        }
                        if (model == null || toolkit.compareFunctionMasks(model.ua(), newFunctionMask) != 0) {
                            return null;
                        }
                    } else {
                        @Pc(584) Mesh[] meshes = new Mesh[identikit.length];
                        for (local586 = 0; local586 < identikit.length; local586++) {
                            local591 = identikit[local586];
                            @Pc(593) ObjTypeCustomisation customisation = null;
                            @Pc(614) boolean local614 = local586 == 5 && leftHand || local586 == 3 && rightHand;
                            @Pc(633) Mesh local633;
                            if ((local591 & 0x40000000) != 0) {
                                if (!local614 && this.customisations != null && this.customisations[local586] != null) {
                                    customisation = this.customisations[local586];
                                }
                                local633 = objTypeList.list(local591 & 0x3FFFFFFF).playerModel(customisation, this.female);
                                if (local633 != null) {
                                    meshes[local586] = local633;
                                }
                            } else if ((Integer.MIN_VALUE & local591) != 0) {
                                local633 = idkTypeList.list(local591 & 0x3FFFFFFF).model();
                                if (local633 != null) {
                                    meshes[local586] = local633;
                                }
                            }
                        }

                        @Pc(709) int j;
                        if (basType != null && basType.wornTransformations != null) {
                            for (local591 = 0; local591 < basType.wornTransformations.length; local591++) {
                                if (meshes[local591] != null) {
                                    i = 0;
                                    j = 0;
                                    @Pc(711) int tz = 0;
                                    @Pc(713) int rx = 0;
                                    @Pc(715) int ry = 0;
                                    @Pc(717) int rz = 0;
                                    if (basType.wornTransformations[local591] != null) {
                                        i = basType.wornTransformations[local591][0];
                                        j = basType.wornTransformations[local591][1];
                                        tz = basType.wornTransformations[local591][2];
                                        rx = basType.wornTransformations[local591][3] << 3;
                                        ry = basType.wornTransformations[local591][4] << 3;
                                        rz = basType.wornTransformations[local591][5] << 3;
                                    }
                                    if (rx != 0 || ry != 0 || rz != 0) {
                                        meshes[local591].rotate(rz, rx, ry);
                                    }
                                    if (i != 0 || j != 0 || tz != 0) {
                                        meshes[local591].translate(i, j, tz);
                                    }
                                }
                            }
                        }

                        @Pc(826) int local826 = newFunctionMask | 0x4000;
                        @Pc(833) Mesh mesh = new Mesh(meshes, meshes.length);
                        model = toolkit.createModel(mesh, local826, featureMask, 64, 850);

                        for (i = 0; i < 10; i++) {
                            for (j = 0; j < recol_s[i].length; j++) {
                                if (recol_d[i][j].length > this.clientpalette[i]) {
                                    model.ia(recol_s[i][j], recol_d[i][j][this.clientpalette[i]]);
                                }
                            }
                        }

                        model.s(newFunctionMask);

                        @Pc(903) ReferenceCache local903 = recentUse;
                        synchronized (recentUse) {
                            recentUse.put(model, hash);
                        }

                        this.aLong159 = hash;
                    }
                    break;
                }

                local395 = identikit[local390];
                @Pc(397) ObjTypeCustomisation customisation = null;

                @Pc(399) boolean local399 = false;
                if (leftHand) {
                    if (wearposDefaults.leftHandSlot == local390) {
                        local399 = true;
                    } else {
                        for (i = 0; i < wearposDefaults.animationHiddenLeftHandSlots.length; i++) {
                            if (local390 == wearposDefaults.animationHiddenLeftHandSlots[i]) {
                                local399 = true;
                                break;
                            }
                        }
                    }
                }
                if (rightHand) {
                    if (wearposDefaults.rightHandSlot == local390) {
                        local399 = true;
                    } else {
                        for (i = 0; i < wearposDefaults.animationHiddenRightHandSlots.length; i++) {
                            if (wearposDefaults.animationHiddenRightHandSlots[i] == local390) {
                                local399 = true;
                                break;
                            }
                        }
                    }
                }

                if ((local395 & 0x40000000) != 0) {
                    if (!local399 && this.customisations != null && this.customisations[local390] != null) {
                        customisation = this.customisations[local390];
                    }

                    if (!objTypeList.list(local395 & 0x3FFFFFFF).loadedModels(this.female, customisation)) {
                        local388 = true;
                    }
                } else if ((Integer.MIN_VALUE & local395) != 0 && !idkTypeList.list(local395 & 0x3FFFFFFF).isModelLoaded()) {
                    local388 = true;
                }

                local390++;
            }
        }

        @Pc(925) Model bodyModel = model.copy((byte) 4, newFunctionMask, true);
        if (!animated && !local310) {
            return bodyModel;
        }

        @Pc(936) Matrix[] matrices = null;
        if (basType != null) {
            matrices = basType.transformMatrices(toolkit);
        }

        if (local310 && matrices != null) {
            for (local390 = 0; local390 < arg5.length; local390++) {
                if (matrices[local390] != null) {
                    bodyModel.transform(matrices[local390], 0x1 << local390, true);
                }
            }
        }

        local390 = 0;
        local395 = 1;
        while (local390 < local72) {
            if (animators[local390] != null) {
                animators[local390].animatePartial(local395, bodyModel);
            }
            local390++;
            local395 <<= 0x1;
        }

        if (local310) {
            for (local586 = 0; local586 < arg5.length; local586++) {
                if (arg5[local586] != -1) {
                    local591 = arg5[local586] - arg11;
                    local591 &= 0x3FFF;
                    @Pc(1034) Matrix matrix = toolkit.createMatrix();
                    matrix.rotate(local591);
                    bodyModel.transform(matrix, 0x1 << local586, false);
                }
            }
        }

        if (local310 && matrices != null) {
            for (local586 = 0; local586 < arg5.length; local586++) {
                if (matrices[local586] != null) {
                    bodyModel.transform(matrices[local586], 0x1 << local586, false);
                }
            }
        }

        if (animator != null && arg12 != null) {
            Animator.blend(animator, bodyModel, arg12);
        } else if (animator != null) {
            animator.animate(bodyModel, 0);
        } else if (arg12 != null) {
            arg12.animate(bodyModel, 0);
        }

        return bodyModel;
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(IZ)V")
    public void setGender(@OriginalArg(1) boolean female) {
        this.female = female;
        this.computeHash();
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(IBLclient!kr;I)V")
    public void setIDKPart(@OriginalArg(0) int idkType, @OriginalArg(2) IDKTypeList idkTypeList, @OriginalArg(3) int part) {
        @Pc(7) int basePart = BASE_PART_MAP[part];
        if (idkTypeList.list(idkType) != null) {
            this.identikit[basePart] = Integer.MIN_VALUE | idkType;
            this.computeHash();
        }
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(IIB)V")
    public void method4549(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        this.clientpalette[arg0] = arg1;
        this.computeHash();
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(Lclient!gu;IILclient!bp;Lclient!ha;BLclient!kr;II)Lclient!ka;")
    public Model headModel(@OriginalArg(0) Animator animator, @OriginalArg(1) int ki1, @OriginalArg(2) int kit3, @OriginalArg(3) SeqTypeList seqTypeList, @OriginalArg(4) Toolkit toolkit, @OriginalArg(6) IDKTypeList idkTypeList, @OriginalArg(7) int kit2) {
        @Pc(16) int functionMask = animator == null ? 2048 : animator.functionMask() | 0x800;
        @Pc(29) long key = (long) ki1 | (long) kit3 << 32 | (long) (kit2 << 16);
        @Pc(31) ReferenceCache local31 = modelCache;
        @Pc(39) Model model;
        synchronized (modelCache) {
            model = (Model) modelCache.get(key);
        }

        if (model == null || toolkit.compareFunctionMasks(model.ua(), functionMask) != 0) {
            if (model != null) {
                functionMask = toolkit.combineFunctionMasks(functionMask, model.ua());
            }

            @Pc(70) Mesh[] meshes = new Mesh[3];
            @Pc(72) int local72 = 0;
            if (!idkTypeList.list(ki1).isHeadLoaded() || !idkTypeList.list(kit2).isHeadLoaded() || !idkTypeList.list(kit3).isHeadLoaded()) {
                return null;
            }

            @Pc(107) Mesh mesh = idkTypeList.list(ki1).headModel();
            if (mesh != null) {
                local72++;
                meshes[0] = mesh;
            }

            mesh = idkTypeList.list(kit2).headModel();
            if (mesh != null) {
                meshes[local72++] = mesh;
            }

            mesh = idkTypeList.list(kit3).headModel();
            if (mesh != null) {
                meshes[local72++] = mesh;
            }

            @Pc(152) int local152 = functionMask | 0x4000;
            mesh = new Mesh(meshes, local72);
            model = toolkit.createModel(mesh, local152, featureMask, 64, 768);
            for (@Pc(168) int local168 = 0; local168 < 10; local168++) {
                for (@Pc(172) int local172 = 0; local172 < recol_s[local168].length; local172++) {
                    if (this.clientpalette[local168] < recol_d[local168][local172].length) {
                        model.ia(recol_s[local168][local172], recol_d[local168][local172][this.clientpalette[local168]]);
                    }
                }
            }

            model.s(functionMask);
            @Pc(228) ReferenceCache local228 = modelCache;
            synchronized (modelCache) {
                modelCache.put(model, key);
            }
        }

        if (animator != null) {
            model = model.copy((byte) 4, functionMask, true);
            animator.animate(model, 0);
        }

        return model;
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(BIILclient!es;)V")
    public void setObj(@OriginalArg(1) int objId, @OriginalArg(2) int part, @OriginalArg(3) ObjTypeList objTypeList) {
        if (objId == -1) {
            this.identikit[part] = 0;
        } else if (objTypeList.list(objId) != null) {
            this.identikit[part] = objId | 0x40000000;
            this.computeHash();
        }
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(Lclient!kr;BLclient!bp;Lclient!uk;Lclient!gu;Lclient!es;Lclient!ql;Lclient!ha;I)Lclient!ka;")
    public Model wornHeadModel(@OriginalArg(0) IDKTypeList idkTypeList, @OriginalArg(2) SeqTypeList seqTypeList, @OriginalArg(3) VarDomain varDomain, @OriginalArg(4) Animator animator, @OriginalArg(5) ObjTypeList objTypeList, @OriginalArg(6) NPCTypeList npcTypeList, @OriginalArg(7) Toolkit toolkit, @OriginalArg(8) int functionMask) {
        if (this.npcId != -1) {
            return npcTypeList.list(this.npcId).headModel(functionMask, animator, (NPCTypeCustomisation) null, toolkit, varDomain);
        }

        @Pc(35) int newFunctionMask = animator == null ? functionMask : animator.functionMask() | 0x800;
        @Pc(37) ReferenceCache local37 = modelCache;

        @Pc(48) Model model;
        synchronized (modelCache) {
            model = (Model) modelCache.get(this.hash);
        }

        if (model == null || toolkit.compareFunctionMasks(model.ua(), newFunctionMask) != 0) {
            if (model != null) {
                newFunctionMask = toolkit.combineFunctionMasks(newFunctionMask, model.ua());
            }

            @Pc(81) boolean loading = false;
            for (@Pc(83) int part = 0; part < this.identikit.length; part++) {
                @Pc(92) int kit = this.identikit[part];
                @Pc(94) ObjTypeCustomisation customisation = null;

                if ((kit & 0x40000000) != 0) {
                    if (this.customisations != null && this.customisations[part] != null) {
                        customisation = this.customisations[part];
                    }

                    if (!objTypeList.list(kit & 0x3FFFFFFF).loadedHeadModels(customisation, this.female)) {
                        loading = true;
                    }
                } else if ((kit & Integer.MIN_VALUE) != 0 && !idkTypeList.list(kit & 0x3FFFFFFF).isHeadLoaded()) {
                    loading = true;
                }
            }

            if (loading) {
                return null;
            }

            @Pc(172) Mesh[] meshes = new Mesh[this.identikit.length];
            @Pc(174) int local174 = 0;
            for (@Pc(176) int part = 0; part < this.identikit.length; part++) {
                @Pc(185) int kit = this.identikit[part];
                @Pc(187) ObjTypeCustomisation customisation = null;
                @Pc(220) Mesh mesh;

                if ((kit & 0x40000000) != 0) {
                    if (this.customisations != null && this.customisations[part] != null) {
                        customisation = this.customisations[part];
                    }
                    mesh = objTypeList.list(kit & 0x3FFFFFFF).headModel(this.female, customisation);
                    if (mesh != null) {
                        meshes[local174++] = mesh;
                    }
                } else if ((kit & Integer.MIN_VALUE) != 0) {
                    mesh = idkTypeList.list(kit & 0x3FFFFFFF).headModel();
                    if (mesh != null) {
                        meshes[local174++] = mesh;
                    }
                }
            }

            @Pc(266) Mesh mesh = new Mesh(meshes, local174);
            @Pc(270) int local270 = newFunctionMask | 0x4000;
            model = toolkit.createModel(mesh, local270, featureMask, 64, 768);
            for (@Pc(282) int local282 = 0; local282 < 10; local282++) {
                for (@Pc(286) int local286 = 0; local286 < recol_s[local282].length; local286++) {
                    if (this.clientpalette[local282] < recol_d[local282][local286].length) {
                        model.ia(recol_s[local282][local286], recol_d[local282][local286][this.clientpalette[local282]]);
                    }
                }
            }

            model.s(newFunctionMask);

            @Pc(340) ReferenceCache local340 = modelCache;
            synchronized (modelCache) {
                modelCache.put(model, this.hash);
            }
        }

        if (animator == null) {
            return model;
        } else {
            @Pc(375) Model animatedModel = model.copy((byte) 4, newFunctionMask, true);
            animator.animate(animatedModel, 0);
            return animatedModel;
        }
    }
}
