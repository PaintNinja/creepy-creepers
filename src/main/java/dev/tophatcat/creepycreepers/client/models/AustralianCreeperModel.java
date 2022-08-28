/*
 * Creepy Creepers - https://github.com/tophatcats-mods/creepy-creepers
 * Copyright (C) 2016-2022 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.creepycreepers.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import dev.tophatcat.creepycreepers.entities.AustralianCreeperEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;

public class AustralianCreeperModel extends EntityModel<AustralianCreeperEntity> {

    private final ModelRenderer body;
    private final ModelRenderer backLeftLeg;
    private final ModelRenderer frontLeftLeg;
    private final ModelRenderer frontRightLeg;
    private final ModelRenderer head;
    private final ModelRenderer poweredOverlay;
    private final ModelRenderer backRightLeg;

    public AustralianCreeperModel() {
        texWidth = 64;
        texHeight = 32;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 10.0F, 0.0F);


        ModelRenderer body_r1 = new ModelRenderer(this);
        body_r1.setPos(0.0F, 14.0F, 0.0F);
        body.addChild(body_r1);
        setRotationAngle(body_r1, 0.0F, 0.0F, -3.1416F);
        body_r1.texOffs(16, 16)
            .addBox(-4.0F, 8.0F, -2.0F,
                8.0F, 12.0F, 4.0F, 0.0F, false);

        backLeftLeg = new ModelRenderer(this);
        backLeftLeg.setPos(2.0F, 4.0F, 4.0F);


        ModelRenderer backLeftLeg_r1 = new ModelRenderer(this);
        backLeftLeg_r1.setPos(0.0F, -3.0F, 0.0F);
        backLeftLeg.addChild(backLeftLeg_r1);
        setRotationAngle(backLeftLeg_r1, 0.0F, 0.0F, -3.1416F);
        backLeftLeg_r1.texOffs(0, 16)
            .addBox(-2.0F, -3.0F, -2.0F,
                4.0F, 6.0F, 4.0F, 0.0F, false);

        frontLeftLeg = new ModelRenderer(this);
        frontLeftLeg.setPos(2.0F, 4.0F, -4.0F);


        ModelRenderer frontLeftLeg_r1 = new ModelRenderer(this);
        frontLeftLeg_r1.setPos(0.0F, -3.0F, 0.0F);
        frontLeftLeg.addChild(frontLeftLeg_r1);
        setRotationAngle(frontLeftLeg_r1, 0.0F, 0.0F, -3.1416F);
        frontLeftLeg_r1.texOffs(0, 16)
            .addBox(-2.0F, -3.0F, -2.0F,
                4.0F, 6.0F, 4.0F, 0.0F, false);

        frontRightLeg = new ModelRenderer(this);
        frontRightLeg.setPos(-2.0F, 4.0F, -4.0F);


        ModelRenderer frontRightLeg_r1 = new ModelRenderer(this);
        frontRightLeg_r1.setPos(0.0F, -3.0F, 0.0F);
        frontRightLeg.addChild(frontRightLeg_r1);
        setRotationAngle(frontRightLeg_r1, 0.0F, 0.0F, -3.1416F);
        frontRightLeg_r1.texOffs(0, 16)
            .addBox(-2.0F, -3.0F, -2.0F,
                4.0F, 6.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 6.0F, 0.0F);


        ModelRenderer head_r1 = new ModelRenderer(this);
        head_r1.setPos(0.0F, 14.0F, 0.0F);
        head.addChild(head_r1);
        setRotationAngle(head_r1, 0.0F, 0.0F, -3.1416F);
        head_r1.texOffs(0, 0)
            .addBox(-4.0F, -4.0F, -4.0F,
                8.0F, 8.0F, 8.0F, 0.0F, false);

        poweredOverlay = new ModelRenderer(this);
        poweredOverlay.setPos(0.0F, 6.0F, 0.0F);


        ModelRenderer poweredOverlay_r1 = new ModelRenderer(this);
        poweredOverlay_r1.setPos(0.0F, 14.0F, 0.0F);
        poweredOverlay.addChild(poweredOverlay_r1);
        setRotationAngle(poweredOverlay_r1, 0.0F, 0.0F, -3.1416F);
        poweredOverlay_r1.texOffs(32, 0)
            .addBox(-4.0F, -4.0F, -4.0F,
                8.0F, 8.0F, 8.0F, 0.0F, false);

        backRightLeg = new ModelRenderer(this);
        backRightLeg.setPos(-2.0F, 4.0F, 4.0F);


        ModelRenderer backRightLeg_r1 = new ModelRenderer(this);
        backRightLeg_r1.setPos(0.0F, -3.0F, 0.0F);
        backRightLeg.addChild(backRightLeg_r1);
        setRotationAngle(backRightLeg_r1, 0.0F, 0.0F, -3.1416F);
        backRightLeg_r1.texOffs(0, 16)
            .addBox(-2.0F, -3.0F, -2.0F,
                4.0F, 6.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(@Nonnull AustralianCreeperEntity entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
        head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        head.xRot = headPitch * ((float) Math.PI / 180F);
        backRightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        backLeftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        frontRightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        frontLeftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void renderToBuffer(@Nonnull MatrixStack matrixStack, @Nonnull IVertexBuilder buffer, int packedLight,
                               int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        backLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        frontLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        frontRightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        poweredOverlay.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        backRightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
